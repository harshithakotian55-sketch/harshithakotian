package com.cookie;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.PrintWriter;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");

        Cookie nameCookie = null;
        Cookie countCookie = null;

        int count = 0;

        // 🔹 Read existing cookies
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("username")) {
                    nameCookie = c;
                }
                if (c.getName().equals("count")) {
                    count = Integer.parseInt(c.getValue());
                }
            }
        }

        // 🔹 First visit
        if (nameCookie == null && username != null) {
            nameCookie = new Cookie("username", username);
            count = 1;
        } 
        else if (nameCookie != null) {
            count++; // next visits
        }

        // 🔹 Create/update count cookie
        countCookie = new Cookie("count", String.valueOf(count));

        // 🔹 Set expiry (1 minute)
        nameCookie.setMaxAge(60);
        countCookie.setMaxAge(60);

        // 🔹 Add cookies to response
        response.addCookie(nameCookie);
        response.addCookie(countCookie);

        // 🔹 Output HTML
        out.println("<html><body>");

        if (nameCookie != null) {
            out.println("<h2>Welcome back " + nameCookie.getValue() + "!</h2>");
            out.println("<h3>You have visited this page " + count + " times</h3>");
        }

        // 🔹 Display all cookies with values
        out.println("<h3>Active Cookies:</h3>");

        if (cookies != null) {
            for (Cookie c : cookies) {
                out.println("<p>Name: " + c.getName() + 
                            " | Value: " + c.getValue() + "</p>");
            }
        }

        // 🔹 Expiry info
        out.println("<p><b>Note:</b> Cookies will expire in 60 seconds.</p>");

        out.println("</body></html>");
    }
}