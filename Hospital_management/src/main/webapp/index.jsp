<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Document</title>
</head>
<body>
    <div id="login-form">
        <h2>Login</h2>
        <form action="login" method="post">
          <div>
            <label for="login-username">Username/Email:</label>
            <input type="text" id="login-username" name="login-username">
          </div>
          <div>
            <label for="login-password">Password:</label>
            <input type="password" id="login-password" name="login-password">
          </div>
          <button type="submit">Submit</button>
        </form>
        <button id="toggle-register">Register</button>
        <script>
        $(document).ready(function() {
  $("#registration-form").on("submit", function(event) {
    event.preventDefault();
    var username = $("#username").val();
    var email = $("#email").val();
    var password = generatePassword();
    $.ajax({
      url: "/check-username-email",
      method: "post",
      data: {
        username: username,
        email: email
      },
      success: function(data) {
        if (data.available) {
          $("#password").val(password);
        } else {
          alert("Username or email is already taken");
        }
      }
    });
  });
});
        </script>
      </div>
      <div id="register-form" style="display:none;">
        <h2>Register</h2>
        <form action="Register" method="post">
          <div>
            <label for="register-username">Username:</label>
            <input type="text" id="register-username" name="register-username">
          </div>
          <div>
            <label for="register-email">Email:</label>
            <input type="email" id="register-email" name="register-email">
          </div>
          <div>
            <label for="register-password">Password:</label>
            <input type="password" id="register-password" name="register-password">
          </div>
          <button type="submit">Submit</button>
        </form>
        <button id="toggle-login">Login</button>
      </div>
      <script>
        $(document).ready(function() {
  $("#toggle-register").on("click", function() {
    $("#login-form").hide();
    $("#register-form").show();
  });
  $("#toggle-login").on("click", function() {
    $("#register-form").hide();
    $("#login-form").show();
  });
});

      </script> 
</body>
</html>



