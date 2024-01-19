"use strict";
(async () => {

    //-- Search for Book Input
    let searchBookInput = document.getElementById("book-search-input");
    //-- Search for Book Cancel Button
    let searchBookCancelButton = document.getElementById("search-result-cancel-button");
    //-- Search Book Results
    let searchBookResultsContainer = document.getElementById("book-search-results");

    //-- Everytime the page reloads the search input value is always going to refresh
    document.addEventListener("DOMContentLoaded", () =>{
        searchBookInput.value = "";
        searchBookCancelButton.style.display = 'none';
        searchBookResultsContainer.style.display ="none";
    })

    //-- Everytime the cancel button is clicked in the input search it clears input and resets
    searchBookCancelButton.addEventListener("click", () => {
        searchBookInput.value = "";
        searchBookCancelButton.style.display = 'none';
        searchBookResultsContainer.style.display ="none";
    })

    //-- Everytime there is an input show cancel button, when enter pushed then start the search
    searchBookInput.addEventListener("keydown", (e) =>{
        //-- Show Cancel Button
        searchBookCancelButton.style.display ="block";

        //-- When user press enter
        if (e.keyCode === 13){
            showSearchBook()
        }
    })

    //-- Notes:
    //-- 'await' used to wait for promises to resolve before continuing with the execution of the code.
    //-- Typically, you would expect to see asynchronous operations, such as fetching data from an API, inside an asynchronous function.

    //-- Everytime called it fetches the api with book title input
    const  gatherBooks = async (bookTitle) =>{
        let googleAPIURL = `https://www.googleapis.com/books/v1/volumes?q=${bookTitle}&printType=books`
        let gatheringData = await fetch(googleAPIURL);
        let turningDataIntoJSON = await gatheringData.json();
        return turningDataIntoJSON;
    }

    //===== Step 2. Going to Search Our Database Bookshelf
    const searchDatabase = async (bookTitle) => {
        try {
            //-- URL for database
            let databaseSearchURL = `/book/search?title=${encodeURIComponent(bookTitle)}`;
            //-- Calls the Database
            let response = await fetch(databaseSearchURL);
            //-- Checks for Error with data
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            let data = await response.json();
            //-- Go Back to Step 1
            // It is an object, so you have to call like this.
            // console.log("Response to Json: ", data);
            return data;
        } catch (error) {
            console.error('Error searching database:', error);
            return null; // or you could return an empty array depending on how you want to handle errors
        }
    };

    //===== Step 1, After pressing enter
    const showSearchBook = async () => {
        //-- If there is a value
        if (searchBookInput.value !== "") {
            //-- Display Whole search Book Container to show results
            searchBookResultsContainer.style.display = "flex";
            //-- Step 2. Take the input value and run searchDatabases;
            //-- Returns the results from URL
            let databaseData = await searchDatabase(searchBookInput.value);
            //-- Check if database search returned results
            if (databaseData && databaseData.length > 0) {
                //--(Step 3, if in our database)  Use database data into the buttons.
                await dataCheckForDatabase(databaseData);
            } else {
                //-- If no results from database, then search the external API
                let apiData = await gatherBooks(`${searchBookInput.value}&maxResults=10`);
                await dataCheck(apiData);
            }

        } else {
            searchBookResultsContainer.style.display = "none";
        }
    }

    //// === If you have to call the API, instead of database.
    const dataCheck = async (data) => {
        if (data.error) {
            searchBookResultsContainer.innerHTML = `<div>Network Problem</div>`
        } else if (data.totalItems === 0) {
            searchBookResultsContainer.innerHTML = `<div class='prompt'>Try a different term</div>`;
        } else if (data.totalItems === undefined) {
            searchBookResultsContainer.innerHTML = `<div class='prompt'>Network problem!</div>`;
        } else {
            searchBookResultsContainer.innerHTML = data.items.map( (({ volumeInfo }) => {
                //-- Check if there is a title
                const title =  volumeInfo.title;
                //-- We pick the first author
                const bookAuthors = volumeInfo.authors ? volumeInfo.authors[0] : null;
                //If rating is not entered then return 1
                const ratingValue = parseFloat(volumeInfo.averageRating) || 1;
                //-- Genre category cant be null
                const genreValue =  volumeInfo.categories || null;
                //-- If there is book cover or not.
                const bookCover = volumeInfo.imageLinks ? volumeInfo.imageLinks.thumbnail : 'img/noImage.jpeg';
                //-- Description
                const description = volumeInfo.description|| null;
                //-- Page Count
                const pageCount = volumeInfo.pageCount || 0;
                //-- Published Date
                const publishedDate = volumeInfo.publishedDate || null;
                //-- If there is book cover or not.
                const googlePlay = volumeInfo.infoLink || null;
                //-- if there is ISBN or not
                const ISBN = volumeInfo.industryIdentifiers ? volumeInfo.industryIdentifiers[0].identifier : null;

                return `<div class="nav-bar-search-form-container">
                            <form class="form-addingBookData" method="POST" action="/api/book" th:action="@{/api/book}">
                               <input type="hidden" name="title" value="${title}" />
                               <input type="hidden" name="isbn" value="${ISBN}" />
                               <input type="hidden" name="author" value="${bookAuthors}" />
                               <input type="hidden" name="cover_page" value="${bookCover}" />
                               <input type="hidden" name="rating" value="${ratingValue}" />
                               <input type="hidden" name="description" value="${description}"/>
                               <input type="hidden" name="genre" value="${genreValue}" />
                               <input type="hidden" name="page_count" value="${pageCount}" />
                               <input type="hidden" name="date_published" value="${publishedDate}" />
                               <input type="hidden" name="google_play" value="${googlePlay}" />
                               <button type="submit" class="btn">
                                     <section class="book-container">
                                        <!-- Book Cover -->
                                        <img src="${bookCover}" alt="${title}" class="book-cover">
                                        <p>
                                            <!-- Book Title -->
                                            <span class="book-title">${title}</span><br/>
                                            <small>
                                                <!-- Book Author -->
                                                By <span>${bookAuthors}</span>
                                            </small>
                                        </p>
                                    </section>
                               </button>
                            </form>
                    </div>`
            }));
        }
    }

    //// === If there is data inside the database.
    const dataCheckForDatabase = async (data) => {
        if (data.error) {
            searchBookResultsContainer.innerHTML = `<div>Network Problem</div>`
        } else if (data.length === 0) {
            searchBookResultsContainer.innerHTML = `<div class='prompt'>Try a different term</div>`;
        } else {
            const bookEntries = data.map((item) => {
                const author = item.author ? item.author : "Author not available";
                const title = item.title ? item.title : "Title not available";
                const bookCover = item.cover_page ? item.cover_page : 'img/noImage.jpeg';

                return `<div class="nav-bar-search-database-container">
                            <a href="/single/${item.id}" title="${title}" class="search-database-anchor">
                               <button class="btn">
                                    <section class="book-container">
                                        <!-- Book Cover -->
                                        <img src="${bookCover}" alt="${title}" class="book-cover">
                                        <p>
                                            <!-- Book Title -->
                                            <span class="book-title">${title}</span><br/>
                                            <small>
                                                <!-- Book Author -->
                                                By <span>${author}</span>
                                            </small>
                                        </p>
                                    </section>
                               </button>
                            </a>
                    </div>`
                 }).join('');


            //-- Adding a new button for continuing the search
            const continueSearchButton = `<div id="continue-search-button-container">
                                            <button id="continue-search-button" type="button" class="btn">
                                                <strong>Continue Search</strong>
                                            </button>
                                          </div>`;

            //-- Combining the book entries and the new button
            searchBookResultsContainer.innerHTML = bookEntries + continueSearchButton;
        }

        //-- Continue Search Button
        let continueSearchButton = document.getElementById("continue-search-button");
        //-- Everytime continue search button clicked
        continueSearchButton.addEventListener("click", async (e) => {
            e.preventDefault()
            //-- If no results from database, then search the external API
            let apiData = await gatherBooks(`${searchBookInput.value}&maxResults=15`);
            await dataCheck(apiData);
        })
    }



})();