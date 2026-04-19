<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>User Form</title>

<script>
function validateForm() {
    let name = document.forms["f"]["username"].value;
    let email = document.forms["f"]["email"].value;
    let desig = document.forms["f"]["designation"].value;

    if (name == "" || email == "" || desig == "") {
        alert("All fields are required");
        return false;
    }

    let emailPattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
    if (!email.match(emailPattern)) {
        alert("Invalid Email");
        return false;
    }

    return true;
}
</script>

</head>
<body>

<h2>User Details</h2>

<form name="f" action="UserDataServlet" method="post" onsubmit="return validateForm()">

Username: <input type="text" name="username"><br><br>
Email: <input type="text" name="email"><br><br>
Designation: <input type="text" name="designation"><br><br>

<input type="submit" value="Submit">

</form>

</body>
</html>