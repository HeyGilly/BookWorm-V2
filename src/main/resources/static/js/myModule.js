    //== Show the loading spinner and hide the books
    function showLoadingSpinner() {
    document.getElementById('searchResultsFragment').style.display = 'none';
    document.getElementById('loading-spinner').style.display = 'flex';
    document.getElementById('loading-spinner').style.justifyContent = 'center';
    document.getElementById('loading-spinner').style.alignItems = 'center';
    document.getElementById('loading-spinner').style.height = '20vh';

}

    //== Hide the loading spinner and show the books
    function hideLoadingSpinner() {
    document.getElementById('loading-spinner').style.display = 'none';
    document.getElementById('searchResultsFragment').style.display = 'block';
}

    //== Wait for the DOM to be fully loaded
    document.addEventListener('DOMContentLoaded', function () {
    //== Add an event listener to the search input
    document.getElementById('searchInput').addEventListener('keydown', function (event) {
        //== When the Enter key is pressed, call showLoadingSpinner()
        if (event.key === 'Enter') {
            showLoadingSpinner();

        }
    });
});

    //== Run the function that hides the spinner and show books
    hideLoadingSpinner();