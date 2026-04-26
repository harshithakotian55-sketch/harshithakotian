<%@ page import="com.model.FeePayment" %>

<h2>Update Fee Payment</h2>

<form action="update" method="post">
    Payment ID: <input type="text" name="paymentId" required><br><br>
    Student ID: <input type="text" name="studentId" required><br><br>
    Name: <input type="text" name="studentName" required><br><br>
    Date: <input type="date" name="paymentDate" required><br><br>
    Amount: <input type="text" name="amount" required><br><br>

    Status:
    <select name="status">
        <option value="Paid">Paid</option>
        <option value="Overdue">Overdue</option>
    </select><br><br>

    <input type="submit" value="Update">
</form>

<br>
<a href="display"><button>Back</button></a>