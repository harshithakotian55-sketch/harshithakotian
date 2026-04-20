<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<body>

<pre>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Salary Report
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
</pre>

<%
try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
    		"jdbc:mysql://localhost:3306/Employee?useSSL=false&serverTimezone=UTC",
            "root",
            "harshitha");

    Statement st = con.createStatement();

    ResultSet rs = st.executeQuery(
        "SELECT * FROM Emp WHERE Emp_Name LIKE 'R%'");

    while(rs.next()) {
%>

<pre>
Emp_No     : <%= rs.getInt("Emp_NO") %>
Emp_Name   : <%= rs.getString("Emp_Name") %>
Basic      : <%= rs.getInt("Basicsalary") %>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
</pre>

<%
    }

    con.close();

} catch(Exception e) {
    out.println(e);
}
%>

<br>
<a href="index.jsp">Back</a>

</body>
</html>