<%@ page import="java.sql.*" %>

<%
String empno = request.getParameter("empno");
String name = request.getParameter("empname");
String salary = request.getParameter("salary");

try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/employee", "root", "harshitha");

    PreparedStatement ps = con.prepareStatement(
        "UPDATE Emp SET Emp_Name=?, Basicsalary=? WHERE Emp_NO=?");

    ps.setString(1, name);
    ps.setInt(2, Integer.parseInt(salary));
    ps.setInt(3, Integer.parseInt(empno));

    int i = ps.executeUpdate();

    if(i > 0) {
        out.println("<h3>Employee Updated Successfully!</h3>");
    } else {
        out.println("<h3>Employee Not Found!</h3>");
    }

    out.println("<br><a href='index.jsp'>Back</a>");

    con.close();

} catch(Exception e) {
    out.println("Error: " + e);
}
%>