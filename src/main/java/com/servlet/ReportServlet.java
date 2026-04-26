package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;

@WebServlet("/report")
public class ReportServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        List<String[]> list = new ArrayList<>();
        Double total = null;

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college", "root", "harshitha");

            String type = req.getParameter("type");

            // 🔷 OVERDUE STUDENTS WITH DATE RANGE
            if ("overdue".equals(type)) {

                String from = req.getParameter("fromDate");
                String to = req.getParameter("toDate");

                if (from != null && !from.isEmpty() && to != null && !to.isEmpty()) {

                    PreparedStatement ps = con.prepareStatement(
                            "SELECT * FROM FeePayments WHERE Status=? AND PaymentDate BETWEEN ? AND ?");

                    ps.setString(1, "Overdue");
                    ps.setDate(2, java.sql.Date.valueOf(from));
                    ps.setDate(3, java.sql.Date.valueOf(to));

                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
                        String[] row = {
                                rs.getString("PaymentID"),
                                rs.getString("StudentName"),
                                rs.getString("PaymentDate"),
                                rs.getString("Amount"),
                                rs.getString("Status")
                        };
                        list.add(row);
                    }

                } else {
                    req.setAttribute("error", "Please select both dates!");
                }
            }

            // 🔷 TOTAL COLLECTION WITH DATE RANGE
            else if ("total".equals(type)) {

                String from = req.getParameter("fromDate");
                String to = req.getParameter("toDate");

                if (from != null && !from.isEmpty() && to != null && !to.isEmpty()) {

                    PreparedStatement ps = con.prepareStatement(
                            "SELECT SUM(Amount) FROM FeePayments WHERE PaymentDate BETWEEN ? AND ?");

                    ps.setDate(1, java.sql.Date.valueOf(from));
                    ps.setDate(2, java.sql.Date.valueOf(to));

                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        total = rs.getDouble(1);
                    }

                } else {
                    req.setAttribute("error", "Please select both dates!");
                }
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 🔷 Send data to JSP
        req.setAttribute("list", list);
        req.setAttribute("total", total);

        req.getRequestDispatcher("report_result.jsp").forward(req, res);
    }
}