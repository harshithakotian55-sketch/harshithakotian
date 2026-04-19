<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Result</title>
</head>
<body>

<h2>Result</h2>

<p style="color:green;">
<%= request.getAttribute("message") %>
</p>

<%
if(request.getAttribute("username") != null){
%>

Username: <%= request.getAttribute("username") %><br>
Email: <%= request.getAttribute("email") %><br>
Designation: <%= request.getAttribute("designation") %><br>

<%
}
%>

<br>
<a href="index.jsp">Go Back</a>

</body>
</html>