<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>${realm.displayName!''} Login</title>
  <link rel="stylesheet" href="${url.resourcesPath}/css/styles.css">
</head>
<body>
  <div class="login-section">
  <h1>Login to ${realm.displayName!''}</h1>
        <form action="${url.loginAction}" method="post" class="input-container">

            <div class="input-style">
                <label>Username</label>
                <input type="text" name="username" autofocus>
            </div>

            <div class="input-style">
                <label>Password</label>
                <input type="password" name="password">
            </div>

            <button type="submit">${msg("doSignIn")!''}</button>
          </form>
  </div>
</body>
</html>
