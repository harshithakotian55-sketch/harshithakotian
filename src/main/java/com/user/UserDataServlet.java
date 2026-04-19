package com.user;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/UserDataServlet")
public class UserDataServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String designation = request.getParameter("designation");

        String message;

        // Server-side validation
        if (username == null || username.isEmpty() ||
            email == null || email.isEmpty() ||
            designation == null || designation.isEmpty()) {

            message = "Error: All fields are required";
        } 
        else if (!email.contains("@")) {
            message = "Error: Invalid Email";
        } 
        else {
            message = "Data processed successfully";

            request.setAttribute("username", username);
            request.setAttribute("email", email);
            request.setAttribute("designation", designation);
        }

        request.setAttribute("message", message);

        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}