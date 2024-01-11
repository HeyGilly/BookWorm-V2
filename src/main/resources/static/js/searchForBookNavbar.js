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
            console.log("Enter Pressed")
            showSearchBook()
        }
    })

    //-- Notes:
    //-- 'await' used to wait for promises to resolve before continuing with the execution of the code.
    //-- Typically, you would expect to see asynchronous operations, such as fetching data from an API, inside an asynchronous function.

    //-- Everytime called it fetches the api with book title input
    const  gatherBooks = async (bookTitle) =>{
        console.log("Gathering Information! for: "+bookTitle);
        let googleAPIURL = `https://www.googleapis.com/books/v1/volumes?q=${bookTitle}&printType=books`
        console.log("Google APU URL: "+googleAPIURL);
        let gatheringData = await fetch(googleAPIURL);
        console.log("FETCHED");
        let turningDataIntoJSON = await gatheringData.json();
        return turningDataIntoJSON;
    }

    //===== Step 2. Going to Search Our Database Bookshelf
    const searchDatabase = async (bookTitle) => {
        try {
            //-- URL for database
            let databaseSearchURL = `/book/search?title=${encodeURIComponent(bookTitle)}`;
            console.log("Database URL: "+databaseSearchURL);
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
            console.log("Response to Json: "+ JSON.stringify(data, null, 2));
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
            console.log("Box Displayed");
            //-- Step 2. Take the input value and run searchDatabases;
            //-- Returns the results from URL
            let databaseData = await searchDatabase(searchBookInput.value);
            console.log("Database Data: ", databaseData);
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
        console.log("Check for Error");
        console.log(data);
        console.log("Data Error: " + data.error);
        console.log("Data Total Items: " + data.totalItems);
        if (data.error) {
            searchBookResultsContainer.innerHTML = `<div>Network Problem</div>`
        } else if (data.totalItems === 0) {
            searchBookResultsContainer.innerHTML = `<div class='prompt'>Try a different term</div>`;
        } else if (data.totalItems === undefined) {
            searchBookResultsContainer.innerHTML = `<div class='prompt'>Network problem!</div>`;
        } else {
            console.log("No Error Move ON");
            searchBookResultsContainer.innerHTML = data.items.map( (({ volumeInfo }) => {
                console.log(volumeInfo);
                //If rating is not entered then return 1
                const ratingValue = parseFloat(volumeInfo.averageRating) || 1;
                //-- We pick the first author
                const bookAuthors = volumeInfo.authors ? volumeInfo.authors[0] : null;
                //-- Genre category cant be null
                const genreValue =  volumeInfo.categories || "not placed";
                //-- If there is book cover or not.
                let bookCover = volumeInfo.imageLinks ? volumeInfo.imageLinks.thumbnail : 'img/noImage.jpeg';
                //-- if there is ISBN or not
                let ISBN = volumeInfo.industryIdentifiers ? volumeInfo.industryIdentifiers[0].identifier : null;


                console.log("displaying all the search book container");
                console.log(volumeInfo.title);
                console.log(bookAuthors);
                console.log(ISBN);
                console.log(bookCover);
                console.log(volumeInfo.description);
                console.log(volumeInfo.pageCount);
                console.log(volumeInfo.publishedDate);
                console.log(volumeInfo.infoLink);

                return `<div class="nav-bar-search-form-container">
                            <form method="POST" action="/api/book"   th:action="@{/api/book}">
                               <input type="hidden" name="title" value="${volumeInfo.title}" />
                               <input type="hidden" name="isbn" value="${ISBN}" />
                               <input type="hidden" name="author" value="${bookAuthors}" />
                               <input type="hidden" name="cover_page" value="${bookCover}" />
                               <input type="hidden" name="rating" value="${ratingValue}" />
                               <input type="hidden" name="description" value="${volumeInfo.description}"/>
                               <input type="hidden" name="genre" value="${genreValue}" />
                               <input type="hidden" name="page_count" value="${volumeInfo.pageCount}" />
                               <input type="hidden" name="date_published" value="${volumeInfo.publishedDate}" />
                               <input type="hidden" name="google_play" value="${volumeInfo.infoLink}" />
                               <button type="submit" class="btn">
                                    <img class="search-book-results-book-cover" src="${bookCover}" th:alt="${volumeInfo.title}">
                                    <div class="nav-search-book-info-container">
                                        <h4 class="nav-search-book-result-title">
                                            <div class="nav-search-book-results">${volumeInfo.title}</div>
                                        </h4>
                                        <p class="nav-search-bar-results-authors">${bookAuthors}</p>
                                    </div>
                               </button>
                            </form>
                    </div>`
            }));
        }
    }

    //// === If there is data inside the database.
    const dataCheckForDatabase = async (data) => {
        console.log("Check for Error");
        console.log(data);
        console.log("Data Size: " + data.length);
        console.log("Data Error: " + data.error);
        console.log("Data Total Items: " + data.totalItems);

        if (data.error) {
            searchBookResultsContainer.innerHTML = `<div>Network Problem</div>`
        } else if (data.length === 0) {
            searchBookResultsContainer.innerHTML = `<div class='prompt'>Try a different term</div>`;
        } else {
            console.log("No Error");
            const bookEntries = data.map((item) => {
                // Replace 'authorProperty' and 'titleProperty' with actual property names from your data
                const author = item.author ? item.author : "Author not available";
                const title = item.title ? item.title : "Title not available";
                const bookCover = item.cover_page ? item.cover_page : "";

                return `<div class="nav-bar-search-form-container">
                            <form>
                               <button type="submit" class="btn">
                                    <img class="search-book-results-book-cover" src="${bookCover}" th:alt="${title}">
                                    <div class="nav-search-book-info-container">
                                        <h4 class="nav-search-book-result-title">
                                            <div class="nav-search-book-results">${title}</div>
                                        </h4>
                                        <p class="nav-search-bar-results-authors">${author}</p>
                                    </div>
                               </button>
                            </form>
                    </div>`
            }).join('');

            //-- Adding a new button for continuing the search
            const continueSearchButton = `<div id="continue-search-button-container">
                                            <button id="continue-search-button" type="button" class="btn">
                                                Continue Search
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