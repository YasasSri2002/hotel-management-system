<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Urbanite</title>
  <link rel="stylesheet" href="${url.resourcesPath}/css/styles.css">
  <script src="${url.resourcesPath}/js/script.js"> </script>
</head>
<body>
  <div class="login-section">
    <h1>Login</h1>

    <form action="${url.loginAction}" method="post" class="input-container">
      <div class="input-style">
        <label>Username</label>
        <input type="text" name="username" autofocus>
      </div>

      <div class="input-style">
        <label>Password</label>
        <input type="password" name="password">
      </div>

      <button id="login-button" type="submit">${msg("Log In")!''}</button>
    </form>

    <#-- Registration Link -->
    <div style="margin-top: 10px">
    <#if realm.registrationAllowed?? && realm.registrationAllowed >
          <p>Don't have an account?
            <a href="${url.registrationUrl}" class="text-red-400" >Sign up</a>
          </p>
        </#if>
    </div>

    <#-- Social Login Section -->
    <#if social.providers?? && social.providers?size gt 0>
      <div class="social-login">
        <h3>Or sign in with</h3>
        <#list social.providers as provider>
          <form action="${provider.loginUrl}" method="post">
            <button type="submit">
              ${provider.displayName}
            </button>
          </form>
        </#list>
      </div>
    </#if>
  </div>
</body>
</html>
