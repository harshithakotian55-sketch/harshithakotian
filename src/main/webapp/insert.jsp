<%@ page import="java.sql.*" %>

<%
String empno = request.getParameter("empno");
String name = request.getParameter("empname");
String salary = request.getParameter("salary");

try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
    		  "jdbc:mysql://localhost:3306/Employee?useSSL=false&serverTimezone=UTC",
    	        "root",
    	        "harshitha");

    PreparedStatement ps = con.prepareStatement(
        "INSERT INTO Emp VALUES (?, ?, ?)");

    ps.setInt(1, Integer.parseInt(empno));
    ps.setString(2, name);
    ps.setInt(3, Integer.parseInt(salary));

    int i = ps.executeUpdate();

    if(i > 0) {
        out.println("Employee Added Successfully!");
    }

    out.println("<br><a href='index.jsp'>Back</a>");

    con.close();

} catch(Exception e) {
    out.println("Error: " + e);
}
%>
