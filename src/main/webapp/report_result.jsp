<%@ page import="java.util.*" %>

<h2>Report Result</h2>

<a href="reports.jsp"><button>Back</button></a>

<br><br>

<%
List<String[]> list = (List<String[]>)request.getAttribute("list");
Double total = (Double)request.getAttribute("total");
String error = (String)request.getAttribute("error");
%>

<!-- 🔴 SHOW ERROR -->
<% if(error != null){ %>
    <h3 style="color:red;"><%=error%></h3>
<% } %>

<!-- 🔷 OVERDUE TABLE -->
<% if(list != null && !list.isEmpty()) { %>

<table border="1" cellpadding="10">
<tr>
<th>Payment ID</th>
<th>Student Name</th>
<th>Payment Date</th>
<th>Amount</th>
<th>Status</th>
</tr>

<% for(String[] row : list){ %>
<tr>
<td><%=row[0]%></td>
<td><%=row[1]%></td>
<td><%=row[2]%></td>
<td><%=row[3]%></td>
<td><%=row[4]%></td>
</tr>
<% } %>

</table>

<% } %>

<!-- 🔷 TOTAL COLLECTION -->
<% if(total != null){ %>
    <h3>Total Collection: <%=total%></h3>
<% } %>