package com.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

import com.dao.FeePaymentDAO;

@WebServlet("/delete")
public class DeleteFeePaymentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        try {
            int id = Integer.parseInt(req.getParameter("id"));
            new FeePaymentDAO().delete(id);

            res.sendRedirect("display");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}