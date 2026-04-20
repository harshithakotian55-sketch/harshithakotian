<%@ page import="java.sql.*" %>

<%
Connection con = null;
PreparedStatement ps = null;

try {
    // Load Driver
    Class.forName("com.mysql.cj.jdbc.Driver");

    // Create Connection (change port if needed)
    con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/Employee?useSSL=false&serverTimezone=UTC",
        "root",
        "harshitha"
    );

    // Delete Query
    ps = con.prepareStatement("DELETE FROM Emp WHERE Emp_Name LIKE ?");
    ps.setString(1, "S%");

    int rows = ps.executeUpdate();

    // Redirect to report page
    response.sendRedirect("report.jsp");

} catch(Exception e) {
    out.println("<h3>Error: " + e + "</h3>");
} finally {
    if(ps != null) ps.close();
    if(con != null) con.close();
}
%>