<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title> Sign Up</title>
</head>
<body>
  <div class="login-container">
    <h1>Sign Up</h1>

    <#if message?has_content>
      <#if message.type = 'error'>
        <div class="error-message">
          ${message.summary}
        </div>
      <#elseif message.type = 'success'>
        <div class="success-message">
          ${message.summary}
        </div>
      <#elseif message.type = 'warning'>
        <div class="warning-message">
          ${message.summary}
        </div>
      </#if>
    </#if>

    <!-- Social Registration -->
    <#if social.providers??>
      <div class="social-login-section">
        <div class="social-buttons">
          <#list social.providers as provider>
            <a href="${provider.loginUrl}" class="social-btn social-btn-${provider.alias}">
              Sign up with ${provider.displayName!provider.alias}
            </a>
          </#list>
        </div>

      </div>
    </#if>

    <!-- Registration Form -->
    <form action="${url.registrationAction}" method="post">

      <#if !realm.registrationEmailAsUsername>
        <div class="input-style">
          <label>Username *</label>
          <input type="text" name="username" value="${(register.formData.username!'')}" autofocus required>
        </div>
      </#if>

      <div class="input-style">
        <label>Email *</label>
        <input type="email" name="email" value="${(register.formData.email!'')}" required>
      </div>

      <div class="input-style">
        <label>First Name</label>
        <input type="text" name="firstName" value="${(register.formData.firstName!'')}">
      </div>

      <div class="input-style">
        <label>Last Name</label>
        <input type="text" name="lastName" value="${(register.formData.lastName!'')}">
      </div>

      <div class="input-style">
        <label>Password *</label>
        <input type="password" name="password" required>
      </div>

      <div class="input-style">
        <label>Confirm Password *</label>
        <input type="password" name="password-confirm" required>
      </div>

      <#if recaptchaRequired?? && recaptchaRequired>
        <div class="input-style">
          <div class="g-recaptcha" data-sitekey="${recaptchaSiteKey}"></div>
        </div>
      </#if>

      <button type="submit">Create Account</button>
    </form>

    <!-- Back to login -->
    <div class="login-link">
      <a href="${url.loginUrl}">Already have an account? Sign in</a>
    </div>
  </div>

  <#if recaptchaRequired?? && recaptchaRequired>
    <script src="https://www.google.com/recaptcha/api.js" async defer></script>
  </#if>
</body>
</html>