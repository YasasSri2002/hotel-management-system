document.addEventListener("DOMContentLoaded", () => {
  const loginBtn = document.getElementById("login-button");

  loginBtn.addEventListener('click', (e) => {


    const usernameInput = document.getElementById("username");
    const passwordInput = document.getElementById("password");
    const usernameValue = usernameInput.value.trim();
    const passwordValue = passwordInput.value.trim();

    // animation
    loginBtn.style.transition = 'transform 0.1s ease';
    loginBtn.style.transform = 'translateY(10px) scale(0.8)';
    setTimeout(() => {
      loginBtn.style.transform = 'translateY(0) scale(1)';
    }, 300);

    // validation
    if (usernameValue === "" && passwordValue === "") {
      usernameInput.style.border = '1px solid red';
      passwordInput.style.border = '1px solid red';
    } else {
      usernameInput.style.border = '';
      passwordInput.style.border = '';
    }
  });
});
