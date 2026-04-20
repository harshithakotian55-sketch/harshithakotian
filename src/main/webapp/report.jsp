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
Connection con = null;
Statement st = null;
ResultSet rs = null;

try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/Employee?useSSL=false&serverTimezone=UTC",
        "root",
        "harshitha"
    );

    st = con.createStatement();
    rs = st.executeQuery("SELECT * FROM Emp");

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

} catch(Exception e) {
    out.println("<h3>Error: " + e + "</h3>");
} finally {
    if(rs != null) rs.close();
    if(st != null) st.close();
    if(con != null) con.close();
}
%>

<br>
<a href="index.jsp">Back</a>

</body>
</html>