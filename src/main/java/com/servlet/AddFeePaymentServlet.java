package com.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Date;

import com.dao.FeePaymentDAO;
import com.model.FeePayment;

@WebServlet("/add")
public class AddFeePaymentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        try {
            int sid = Integer.parseInt(req.getParameter("studentId"));
            String name = req.getParameter("studentName");
            Date date = Date.valueOf(req.getParameter("paymentDate"));
            double amount = Double.parseDouble(req.getParameter("amount"));

            // Automatic overdue logic
            Date deadline = Date.valueOf("2026-03-31");
            String status = (date.after(deadline)) ? "Overdue" : "Paid";

            FeePayment f = new FeePayment(sid, name, date, amount, status);
            new FeePaymentDAO().insert(f);

            res.sendRedirect("display");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}