<%@ page import="javax.servlet.http.*" %>

<!DOCTYPE html>
<html>
<head>
<title>Session Check</title>
</head>
<body>

<h2>Session Status</h2>

<%
    if (session != null && session.getAttribute("user") != null) {
%>
        <h3>Hello <%= session.getAttribute("user") %>!</h3>
        <p>Session is still active.</p>
<%
    } else {
%>
        <h3 style="color:red;">Session Expired!</h3>
<%
    }
%>

<br>
<a href="index.jsp">Go Back</a>

</body>
</html>