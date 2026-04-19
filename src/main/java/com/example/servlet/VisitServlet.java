package com.example.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class VisitServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String name = request.getParameter("username");
        int visitCount = 1;

        Cookie[] cookies = request.getCookies();
        boolean found = false;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("visitCount")) {
                    visitCount = Integer.parseInt(c.getValue());
                    visitCount++;
                    found = true;
                }
                if (c.getName().equals("username")) {
                    name = c.getValue();
                }
            }
        }

        // Create/Update cookies
        Cookie nameCookie = new Cookie("username", name);
        Cookie visitCookie = new Cookie("visitCount", String.valueOf(visitCount));

        // Set expiry time (10 seconds for demo)
        nameCookie.setMaxAge(10);
        visitCookie.setMaxAge(10);

        response.addCookie(nameCookie);
        response.addCookie(visitCookie);

        response.getWriter().println("<html><body>");

        if (found) {
            response.getWriter().println("<h2>Welcome back " + name + "!</h2>");
            response.getWriter().println("<p>You have visited this page " + visitCount + " times.</p>");
        } else {
            response.getWriter().println("<h2>Welcome " + name + "!</h2>");
            response.getWriter().println("<p>This is your first visit.</p>");
        }

        response.getWriter().println("<p><b>Note:</b> Cookie expires in 10 seconds. Refresh after that to see reset.</p>");

        response.getWriter().println("</body></html>");
    }
}