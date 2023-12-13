"use strict";
(async () => {
    // Why did I use async IIFE instead of function?

    //-- Search for Book Input
    const searchBookInput = document.getElementById("book-search-input");
    //-- Search for Book Cancel Button
    const searchBookCancelButton = document.getElementById("search-result-cancel-button");
    //-- Search Book Results
    const searchBookResultsContainer = document.getElementById("book-search-results");

    //-- Everytime the page reloads the search input value is always going to refresh
    document.addEventListener("DOMContentLoaded", () =>{
        searchBookInput.value = "";
        searchBookCancelButton.style.display = 'none';
    })

    //-- Everytime the cancel button is clicked in the input search it clears input and resets
    searchBookCancelButton.addEventListener("click", () => {
        searchBookInput.value = "";
        searchBookCancelButton.style.display = 'none';
    })

    //-- Everytime there is an input show cancel button, when enter pushed then start the search
    searchBookInput.addEventListener("keydown", (e) =>{
        searchBookCancelButton.style.display ="block";
        if (e.keyCode === 13){
            console.log("Enter Pressed")
        }
    })




})();