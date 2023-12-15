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
        console.log("Gathering Information! for:"+bookTitle);
        let googleAPIURL = `https://www.googleapis.com/books/v1/volumes?q=${bookTitle}&printType=books`
        let gatheringData = await fetch(googleAPIURL);
        let turningDataIntoJSON = await gatheringData.json();
        return turningDataIntoJSON;
    }


    const showSearchBook = async () => {
        if (searchBookInput.value !== "") {
            //-- Whole search Book Container
            searchBookResultsContainer.style.display = "flex";
            //-- Data is going to call the function to get the books
            let searchData = await gatherBooks(`${searchBookInput.value}&maxResults=10`);
            //-- Pass data into dataCheck function, if correct display info
            await dataCheck(searchData);

        } else {
            searchBookResultsContainer.style.display = "none";
        }
    }

    const dataCheck = async (data) => {
        console.log("Check for Error");
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
                console.log("displaying all the search book container");
                console.log(volumeInfo.title);
                console.log(volumeInfo.industryIdentifiers[0].identifier);
                console.log(volumeInfo.imageLinks.thumbnail);
                console.log(volumeInfo.description);
                console.log(volumeInfo.pageCount);
                console.log(volumeInfo.publishedDate);
                console.log(volumeInfo.infoLink);
                //If rating is not entered then return 1
                const ratingValue = parseFloat(volumeInfo.averageRating) || 1;
                //-- We pick the first author
                const bookAuthors = volumeInfo.authors[0] || "";
                //-- Genre category cant be null
                const genreValue =  volumeInfo.categories || "not placed";
                const bookCover =  volumeInfo.imageLinks.thumbnail;

                return `<div class="nav-bar-search-form-container">
                            <form method="POST" action="/api/book"   th:action="@{/api/book}">
                               <input type="hidden" name="title" value="${volumeInfo.title}" />
                               <input type="hidden" name="isbn" value="${volumeInfo.industryIdentifiers[0].identifier}" />
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



})();