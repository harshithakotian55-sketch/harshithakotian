<%@ page import="java.sql.*" %>

<html>
<body>

<h2>Salary Report</h2>

<pre>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
</pre>

<%
int total = 0;

try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
    		 "jdbc:mysql://localhost:3306/Employee?useSSL=false&serverTimezone=UTC",
 	        "root",
 	        "harshitha");

    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM Emp");

    while(rs.next()) {

        int id = rs.getInt("Emp_NO");
        String name = rs.getString("Emp_Name");
        int sal = rs.getInt("Basicsalary");

        total += sal;
%>

<pre>
Emp_No     : <%=id%>
Emp_Name   : <%=name%>
Basic      : <%=sal%>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
</pre>

<%
    }

    con.close();

} catch(Exception e) {
    out.println(e);
}
%>

<pre>
Grand Salary : <%=total%>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
</pre>

</body>
</html>
