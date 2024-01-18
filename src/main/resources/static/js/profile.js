//== Cancels the enter key being pressed.
document.addEventListener('DOMContentLoaded', function () {
    window.addEventListener('keydown', function (event) {
        if (event.keyCode === 13) {
            event.preventDefault();
            return false;
        }
    });
});




// Whole Container of all settings.
const settingFormContainer = document.getElementById("setting-form-container");
// Whole userinfo container
const userInformationContainer = document.getElementById("user-information");
// Section Container for profile picture
const userProfilePicture = document.getElementById("user-photoImage");
// The Edit Button
const settingButton = document.getElementById("setting-button")
// The Cancel Button
const cancelButton = document.getElementById("cancelEditProfileButton")


//--  Start of page, hide setting form, show profile pictures
document.addEventListener("DOMContentLoaded", ()=>{
    settingFormContainer.style.display = "none"
    userProfilePicture.style.display = "flex"
})
//--  When Setting Button Clicked, profile and info hide, settings form appears
settingButton.addEventListener("click", ()=>{
    settingFormContainer.style.display = "block"
    userInformationContainer.style.display = "none"
    userProfilePicture.style.display = "none"
})
//--  When Cancel Button Clicked, profile and info Show, settings form hides
cancelButton.addEventListener("click", ()=>{
    settingFormContainer.style.display = "none"
    userInformationContainer.style.display = "flex"
    userProfilePicture.style.display = "flex"
})
