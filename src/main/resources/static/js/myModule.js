    // Wait for the DOM to be ready
    document.addEventListener('DOMContentLoaded', function() {
    // Select the search input by its ID
    var searchInput = document.getElementById('searchInput');

    // Attach an event listener for the input event
    searchInput.addEventListener('input', function() {
    // Submit the form when the input changes
    document.getElementById('searchForm').submit();
});
});
