

//== Cancels the enter key being pressed.
document.addEventListener('DOMContentLoaded', function () {
    window.addEventListener('keydown', function (event) {
        if (event.keyCode === 13) {
            event.preventDefault();
            return false;
        }
    });
});

//=== Password & Verify Password
const password = document.getElementById("password");
const passwordVerify = document.getElementById("password-verify");
//== Submit Button
const submitButton = document.getElementById("register-submit-btn");


//== Changes when there is an input in the password field
password.addEventListener('input', function () {
    //== Password Value
    const passwordValue = password.value;

//===== Patterns for Regular Expression
    // Check if at least 2 special characters are present
    const pattern2SpecialCharacters = /.*[!@#$%^&*()_+{}:;<>,.?\/~`[\]\\|-].*[!@#$%^&*()_+{}:;<>,.?\/~`[\]\\|-]/;
    // Check if at least 2 uppercase and 2 lowercase letters are present
    const uppercaseCount = (passwordValue.match(/[A-Z]/g) || []).length;
    const lowercaseCount = (passwordValue.match(/[a-z]/g) || []).length;
    // Check if at least 2 Numbers are present
    const pattern2numbers = /^(?=.*\d.*\d)/;

    //== Requirements for password text
    const minLengthPassword = document.getElementById("length-password");
    const upperLowerPassword = document.getElementById("upper-lower-password");
    const minNumPassword = document.getElementById("min-numbers-password");
    const minSpecialPassword = document.getElementById("min-special-password");
    //== This is open Verify Password if all requirements met.
    let openVerify = true;

    //== Check to see if password value is equal to or greater than 5
    if (passwordValue.length >= 8 && passwordValue.length <= 20) {
        minLengthPassword.classList.add("text-success");
        minLengthPassword.classList.remove("text-danger");
    } else {
        openVerify = false;
        minLengthPassword.classList.add("text-danger");
        minLengthPassword.classList.remove("text-success");
    }

    //== Check if password value has a min of uppercase and lowercase
    const isUppercaseLowercaseValid = uppercaseCount >= 2 && lowercaseCount >= 2;
    if (isUppercaseLowercaseValid) {
        upperLowerPassword.classList.add("text-success");
        upperLowerPassword.classList.remove("text-danger");
    } else {
        openVerify = false;
        upperLowerPassword.classList.add("text-danger");
        upperLowerPassword.classList.remove("text-success");
    }

    //== Check if password value contains 2 digits
    const isPattern2numbersValid = pattern2numbers.test(passwordValue);
    if (isPattern2numbersValid) {
        minNumPassword.classList.add("text-success");
        minNumPassword.classList.remove("text-danger");
    } else {
        openVerify = false;
        minNumPassword.classList.add("text-danger");
        minNumPassword.classList.remove("text-success");
    }

    //== Check if password value contains 2 special characters
    const isPattern2SpecialCharactersValid = pattern2SpecialCharacters.test(passwordValue);
    if (isPattern2SpecialCharactersValid) {
        minSpecialPassword.classList.add("text-success");
        minSpecialPassword.classList.remove("text-danger");
    } else {
        openVerify = false;
        minSpecialPassword.classList.add("text-danger");
        minSpecialPassword.classList.remove("text-success");
    }

    //== If all checks are met, Verify Password will open
    passwordVerify.disabled = !openVerify;
});



//========== Changes when there is an input in the verify password field
passwordVerify.addEventListener('input', function () {
    //== Verify Password Value
    const passwordVerifyValue = passwordVerify.value;
    //== Verify Password Title
    const verifyPasswordTitle = document.getElementById("verify-password-title")
    // Check if passwords match, will disable submit button
    if (password.value === passwordVerifyValue){
        verifyPasswordTitle.classList.remove("text-danger");
        submitButton.classList.remove("disabled");
    }else{
        verifyPasswordTitle.classList.add("text-danger");
        submitButton.classList.add("disabled");
    }
});

//========== The Close Button, For when the controller send the error message
const close = document.getElementsByClassName("close-btn");
let i;

for (i = 0; i < close.length; i++) {
    close[i].onclick = function(){
        const div = this.parentElement;
        div.style.opacity = "0";
        setTimeout(function(){ div.style.display = "none"; }, 600);
    }
}