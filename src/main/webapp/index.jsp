<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Form</title>

<script>
function validateForm() {
    let roll = document.forms["f"]["rollno"].value;
    let name = document.forms["f"]["name"].value;
    let marks = ["sub1","sub2","sub3","sub4","sub5"];

    if (roll == "" || name == "") {
        alert("All fields are required");
        return false;
    }

    for (let i = 0; i < marks.length; i++) {
        let m = document.forms["f"][marks[i]].value;
        if (m == "" || m < 0 || m > 100) {
            alert("Marks must be between 0 and 100");
            return false;
        }
    }
    return true;
}
</script>

</head>
<body>

<h2>Student Details</h2>

<form name="f" action="ResultServlet" method="post" onsubmit="return validateForm()">

Roll No: <input type="text" name="rollno"><br><br>
Name: <input type="text" name="name"><br><br>

Sub1: <input type="number" name="sub1"><br><br>
Sub2: <input type="number" name="sub2"><br><br>
Sub3: <input type="number" name="sub3"><br><br>
Sub4: <input type="number" name="sub4"><br><br>
Sub5: <input type="number" name="sub5"><br><br>

<input type="submit" value="Submit">

</form>

</body>
</html>