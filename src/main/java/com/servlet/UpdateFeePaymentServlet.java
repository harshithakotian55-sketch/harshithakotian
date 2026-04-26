package com.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;

import com.dao.FeePaymentDAO;
import com.model.FeePayment;

@WebServlet("/update")
public class UpdateFeePaymentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        try {
            int pid = Integer.parseInt(req.getParameter("paymentId"));
            int sid = Integer.parseInt(req.getParameter("studentId"));
            String name = req.getParameter("studentName");
            Date date = Date.valueOf(req.getParameter("paymentDate"));
            double amount = Double.parseDouble(req.getParameter("amount"));
            String status = req.getParameter("status");

            FeePayment f = new FeePayment(sid, name, date, amount, status);
            f.setPaymentId(pid);

            new FeePaymentDAO().update(f);

            res.sendRedirect("display");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}