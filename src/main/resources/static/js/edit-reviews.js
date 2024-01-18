document.addEventListener("DOMContentLoaded", () => {

    document.querySelectorAll(".user-review-edit-button").forEach((button, index) => {
        // Assuming each button corresponds to the respective containers by index
        let reviewContainer = document.querySelectorAll(".review-rating-body-container")[index];
        let editForm = document.querySelectorAll(".edit-review-form-container")[index];
        button.addEventListener("click", () => {
            console.log("edit Button Pushed")
            // Toggle visibility
            reviewContainer.style.display = reviewContainer.style.display === "none" ? "block" : "none";
            editForm.style.display = editForm.style.display === "block" ? "none" : "block";
        });
    });


    document.querySelectorAll(".edit-review-cancel-button").forEach((button, index) => {
        // Assuming each button corresponds to the respective containers by index
        let reviewContainer = document.querySelectorAll(".review-rating-body-container")[index];
        let editForm = document.querySelectorAll(".edit-review-form-container")[index];
        button.addEventListener("click", () => {
            console.log("edit Button Pushed")
            // Toggle visibility
            reviewContainer.style.display = reviewContainer.style.display === "none" ? "block" : "none";
            editForm.style.display = editForm.style.display === "block" ? "none" : "block";
        });
    });


    document.querySelectorAll(".edit-review-delete-button").forEach((button, index) => {
        let verifyDeleteModal = document.querySelectorAll(".modal-container")[index];
        let editReviewForm = document.querySelectorAll(".edit-review-form")[index];
        let cancelDeleteButton = document.querySelectorAll(".cancel-delete-button")[index];
        let editReviewDeleteButton = document.querySelectorAll(".edit-review-delete-button")[index];

        button.addEventListener("click", ()=>{
            verifyDeleteModal.style.display = "block";
            editReviewForm.style.display = "none";
            editReviewDeleteButton.style.display = "none";
        })
        cancelDeleteButton.addEventListener("click", () =>{
            verifyDeleteModal.style.display = "none";
            editReviewForm.style.display = "block";
            editReviewDeleteButton.style.display = "block"
        })
    });


});

