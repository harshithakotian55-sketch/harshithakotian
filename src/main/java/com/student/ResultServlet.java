package com.student;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String roll = request.getParameter("rollno");
        String name = request.getParameter("name");

        int s1=0,s2=0,s3=0,s4=0,s5=0;

        String message = "";

        try {
            s1 = Integer.parseInt(request.getParameter("sub1"));
            s2 = Integer.parseInt(request.getParameter("sub2"));
            s3 = Integer.parseInt(request.getParameter("sub3"));
            s4 = Integer.parseInt(request.getParameter("sub4"));
            s5 = Integer.parseInt(request.getParameter("sub5"));

            // Server-side validation
            if (roll.isEmpty() || name.isEmpty()) {
                message = "Error: All fields required";
            } else {
                int total = s1+s2+s3+s4+s5;
                double avg = total / 5.0;

                String result;

                if (s1>=40 && s2>=40 && s3>=40 && s4>=40 && s5>=40) {
                    result = "PASS";
                } else {
                    result = "FAIL";
                }

                // Set attributes
                request.setAttribute("roll", roll);
                request.setAttribute("name", name);
                request.setAttribute("s1", s1);
                request.setAttribute("s2", s2);
                request.setAttribute("s3", s3);
                request.setAttribute("s4", s4);
                request.setAttribute("s5", s5);
                request.setAttribute("avg", avg);
                request.setAttribute("result", result);
                request.setAttribute("message", "Success");

                // Forward
                request.getRequestDispatcher("result.jsp").forward(request, response);
                return;
            }

        } catch (Exception e) {
            message = "Invalid Input!";
        }

        request.setAttribute("message", message);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}