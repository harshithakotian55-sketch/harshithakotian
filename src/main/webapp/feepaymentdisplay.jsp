<%@ page import="java.util.*,com.model.FeePayment" %>

<h2>Fee Payment Records</h2>

<a href="index.jsp"><button>Home</button></a>
<a href="feepaymentadd.jsp"><button>Add</button></a>

<br><br>

<table border="1">
<tr>
<th>ID</th>
<th>Name</th>
<th>Date</th>
<th>Amount</th>
<th>Status</th>
<th>Action</th>
</tr>

<%
List<FeePayment> list = (List<FeePayment>)request.getAttribute("list");

for(FeePayment f : list){
%>

<tr>
<td><%=f.getPaymentId()%></td>
<td><%=f.getStudentName()%></td>
<td><%=f.getPaymentDate()%></td>
<td><%=f.getAmount()%></td>
<td><%=f.getStatus()%></td>

<td>
<a href="delete?id=<%=f.getPaymentId()%>">Delete</a>
</td>

</tr>

<% } %>
</table>