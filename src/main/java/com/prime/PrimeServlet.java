package com.prime;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/PrimeServlet")
public class PrimeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String numStr = request.getParameter("number");

        try {
            int num = Integer.parseInt(numStr);

            // Error condition
            if (num < 2) {
                out.println("<h3>Error: Number must be greater than 1</h3>");
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }

            boolean isPrime = true;

            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            // Output result
            if (isPrime)
                out.println("<h3>" + num + " is a Prime Number</h3>");
            else
                out.println("<h3>" + num + " is NOT a Prime Number</h3>");

        } catch (NumberFormatException e) {
            // Invalid input error
            out.println("<h3>Error: Invalid input! Enter a valid number.</h3>");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}