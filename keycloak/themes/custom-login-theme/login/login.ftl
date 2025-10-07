<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Urbanite</title>
  <link rel="stylesheet" href="${url.resourcesPath}/css/styles.css">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script src="${url.resourcesPath}/js/script.js"></script>
</head>
<body>
  <div class="login-section">
    <div id="login-heading-section">
        <div> </div>
        <h1 class="headings">Welcome Back</h1>
        <h2 class="sub-headings">  Sign in to your Luxury Hotel account</h2>
    </div>

    <form action="${url.loginAction}" method="post" class="form-container">
      <div class="input-container">
        <div class="input-style">
          <label>Username</label>
          <input type="text" name="username" autofocus>
        </div>

        <div class="input-style">
          <label>Password</label>
          <input type="password" name="password">
        </div>

        <!-- Remember Me + Forgot Password -->
        <div class="options-row">
          <#if realm.rememberMe == true>
            <label class="remember-me">
              <input type="checkbox" name="rememberMe"
                     <#if login.rememberMe?? && login.rememberMe>checked</#if>>
              Remember me
            </label>
          </#if>

          <#if realm.resetPasswordAllowed?? && realm.resetPasswordAllowed>
            <a href="${url.loginResetCredentialsUrl}" class="forgot-password">Forgot password?</a>
          </#if>
        </div>
      </div>

      <button id="login-button" type="submit">${msg("Log In")!''}</button>
    </form>

    <!-- Registration Link -->
    <div style="margin-top: 10px">
      <#if realm.registrationAllowed?? && realm.registrationAllowed>
        <p>Don't have an account?
          <a href="${url.registrationUrl}" class="text-red-400">Sign up</a>
        </p>
      </#if>
    </div>

    <!-- Social Login Section -->
    <#if social.providers?? && social.providers?size gt 0>
      <div class="social-login">
        <h3>Or sign in with</h3>
        <#list social.providers as provider>
          <form action="${provider.loginUrl}" method="post">
            <button type="submit">${provider.displayName}</button>
          </form>
        </#list>
      </div>
    </#if>
  </div>
</body>
</html>
