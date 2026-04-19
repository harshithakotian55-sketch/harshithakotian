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

        // 🔹 Create / Update cookies
        Cookie nameCookie = null;
        Cookie countCookie = null;

        Cookie[] cookies = request.getCookies();

        int count = 0;

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

        // 🔹 If first time
        if (nameCookie == null && username != null) {
            nameCookie = new Cookie("username", username);
            count = 1;
        } else {
            count++;
        }

        // 🔹 Create / update count cookie
        countCookie = new Cookie("count", String.valueOf(count));

        // 🔹 Set expiry (1 minute)
        nameCookie.setMaxAge(60);
        countCookie.setMaxAge(60);

        response.addCookie(nameCookie);
        response.addCookie(countCookie);

        // 🔹 Output
        out.println("<html><body>");

        if (nameCookie != null) {
            out.println("<h2>Welcome back " + nameCookie.getValue() + "!</h2>");
            out.println("<h3>You have visited this page " + count + " times</h3>");
        }

        // 🔹 Display all cookies
        out.println("<h3>Cookie List:</h3>");

        Cookie[] allCookies = request.getCookies();

        if (allCookies != null) {
            for (Cookie c : allCookies) {
                out.println("<p>" + c.getName() + " = " + c.getValue() + "</p>");
            }
        }

        // 🔹 Show expiry info
        out.println("<p><b>Cookies will expire in 60 seconds</b></p>");

        out.println("</body></html>");
    }
}