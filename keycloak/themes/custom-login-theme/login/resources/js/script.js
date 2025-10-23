document.addEventListener('DOMContentLoaded', function() {
    const loginBtn = document.getElementById("login-button");

    if (loginBtn) {
        loginBtn.addEventListener('click', function() {
            console.log("Button clicked!");
        });
    } else {
        console.error("Login button not found!");
    }
});

const loginBtn = document.getElementById("login-button");