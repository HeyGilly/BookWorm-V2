const settingContainerButton = document.getElementById("setting-button-container")
const userProfileInfo = document.getElementById("user-profile-info");
const settingFormContainer = document.getElementById("setting-form-container");
const settingCancelButton = document.getElementById("setting-cancel-button");


settingFormContainer.style.display = "none";


settingContainerButton.addEventListener("click", function(){
    userProfileInfo.style.display = "none";
    settingFormContainer.style.display = "block";
})


settingCancelButton.addEventListener("click", function (){
    userProfileInfo.style.display = "block";
    settingFormContainer.style.display = "none";
})














//== Cancels the enter key being pressed.
document.addEventListener('DOMContentLoaded', function () {
    window.addEventListener('keydown', function (event) {
        if (event.keyCode === 13) {
            event.preventDefault();
            return false;
        }
    });
});