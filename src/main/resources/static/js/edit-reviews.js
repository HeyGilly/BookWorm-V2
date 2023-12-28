(() => {

document.addEventListener("DOMContentLoaded", () => {
    let editForm = document.querySelectorAll(".edit-review-form-container");
    editForm.forEach((element) =>{
        element.style.display = "none";
    })

    document.querySelectorAll(".user-review-edit-button").forEach((button, index) => {
        // Assuming each button corresponds to the respective containers by index
        let reviewContainer = document.querySelectorAll(".review-user-wrote-container")[index];
        let editForm = document.querySelectorAll(".edit-review-form-container")[index];


        button.addEventListener("click", () => {
            console.log("edit Button Pushed")
            // Toggle visibility
            reviewContainer.style.display = reviewContainer.style.display === "none" ? "block" : "none";
            editForm.style.display = editForm.style.display === "none" ? "block" : "none";
        });
    });
    document.querySelectorAll(".edit-review-cancel-button").forEach((button, index) => {
        // Assuming each button corresponds to the respective containers by index
        let reviewContainer = document.querySelectorAll(".review-user-wrote-container")[index];
        let editForm = document.querySelectorAll(".edit-review-form-container")[index];
        let editReviewForm = document.querySelectorAll(".edit-review-form")[index];

        button.addEventListener("click", () => {
            // Toggle visibility
            editForm.style.display = editForm.style.display === "none" ? "block" : "none";
            reviewContainer.style.display = reviewContainer.style.display  === "none" ? "block" : "none";
            editReviewForm.reset();
        });
    });
    //-- Creating modal
    document.querySelectorAll(".edit-review-delete-button").forEach((button, index) => {
        let verifyDeleteModal = document.querySelectorAll(".modal-container")[index];
        let editReviewForm = document.querySelectorAll(".edit-review-form")[index];
        let cancelDeleteButton = document.querySelectorAll(".cancel-delete-button")[index];
        let editReviewDeleteButton = document.querySelectorAll(".edit-review-delete-button")[index];

        verifyDeleteModal.style.display = "none";
        editReviewForm.style.display = "block";

        button.addEventListener("click",  () => {
            console.log("This could be deleted!!")
            verifyDeleteModal.style.display = "block";
            editReviewForm.style.display = "none";
            editReviewDeleteButton.style.display = "none";
        })

        cancelDeleteButton.addEventListener("click", ()=>{
            console.log("working")
            verifyDeleteModal.style.display = "none";
            editReviewForm.style.display = "block";
            editReviewDeleteButton.style.display = "block"
        })

    });

});

})();