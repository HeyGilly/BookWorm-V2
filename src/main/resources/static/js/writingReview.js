/**
 *
    Hides and shows Writing the Review
 */

let reviewContainer = document.getElementById("writeAReviewContainer");
let writeReviewButton = document.getElementById("write-review-button");
let writeReviewCancelButton = document.getElementById("write-review-cancel-button");
let reviewForm = document.getElementById("writing-review-form");

document.addEventListener("DOMContentLoaded", ()=>{
    reviewContainer.style.display="none";
    reviewForm.reset();
})

writeReviewCancelButton.addEventListener("click",(e) =>{
    e.preventDefault();
    reviewContainer.style.display="none";
    reviewForm.reset();
})

writeReviewButton.addEventListener("click", (e) => {
    e.preventDefault();
    reviewContainer.style.display="block";
})


/**
 *
    Showcase of the value for the rating.
 */
const rangeInput = document.getElementById('reviewRate');
const valueDisplay = document.getElementById('rateValue');
// Set initial value
valueDisplay.textContent = rangeInput.value;
// Update value on input change
rangeInput.addEventListener('input', function() {
    valueDisplay.textContent = this.value;
});