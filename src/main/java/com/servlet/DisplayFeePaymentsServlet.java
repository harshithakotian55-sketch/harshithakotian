package com.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

import com.dao.FeePaymentDAO;
import com.model.FeePayment;

@WebServlet("/display")
public class DisplayFeePaymentsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            FeePaymentDAO dao = new FeePaymentDAO();

            // ✅ Correct method call
            List<FeePayment> list = dao.getAll();

            req.setAttribute("list", list);
            req.getRequestDispatcher("feepaymentdisplay.jsp").forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}