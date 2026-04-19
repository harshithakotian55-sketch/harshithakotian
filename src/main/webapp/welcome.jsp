<%@ page import="javax.servlet.http.*" %>

<%
    String name = request.getParameter("username");
    int time = Integer.parseInt(request.getParameter("time"));

    // use implicit session
    session.setAttribute("user", name);
    session.setMaxInactiveInterval(time);
%>

<!DOCTYPE html>
<html>
<head>
<title>Welcome</title>
</head>
<body>

<h2>Hello <%= name %>!</h2>

<p>Session will expire in <%= time %> seconds.</p>

<br>
<a href="check.jsp">Click here to check session</a>

</body>
</html>