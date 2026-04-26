<%
String type = request.getParameter("type");
%>

<h2>Generate Report</h2>

<form action="reportCriteria" method="post">

    <!-- IMPORTANT: pass report type -->
    <input type="hidden" name="type" value="<%=type%>">

    From Date:<br>
    <input type="date" name="fromDate"><br><br>

    To Date:<br>
    <input type="date" name="toDate"><br><br>

    <input type="submit" value="Generate Report">
</form>

<br>
<a href="reports.jsp"><button>Back</button></a>