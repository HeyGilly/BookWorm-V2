//--- To update without refreshing the page.
// When user Press the like button then it won't refresh the whole page.


document.addEventListener("DOMContentLoaded", function () {
    const likeButton = document.getElementById("likeButton");

    likeButton.addEventListener("click", function () {
        const reviewId = likeButton.getAttribute("data-review-id");

        fetch(`/likedReview/${reviewId}`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
        })
            .then((response) => {
                if (!response.ok) {
                    throw new Error("Network response was not ok");
                }
                // Optionally, you can handle the response here if needed
                return response.json(); // assuming your controller returns JSON data
            })
            .then((data) => {
                // Optionally, you can update the UI here if needed
                console.log(data);
            })
            .catch((error) => {
                console.error("There was a problem with the fetch operation:", error);
            });
    });
});