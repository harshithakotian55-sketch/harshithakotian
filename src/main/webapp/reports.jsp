<h2>Reports</h2>

<!-- 🔷 Overdue Report -->
<form action="report_form.jsp" method="get">
    <input type="hidden" name="type" value="overdue">
    <input type="submit" value="Overdue Students Report">
</form>

<br>

<!-- 🔷 Total Collection Report -->
<form action="report_form.jsp" method="get">
    <input type="hidden" name="type" value="total">
    <input type="submit" value="Total Collection Report">
</form>

<br><br>

<!-- 🔷 Back to Home -->
<a href="index.jsp">
    <button>Back to Home</button>
</a>