package com.cookieservlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class cookieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("userName");

        String name = null;
        int count = 0;

        // Get existing cookies
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("user")) {
                    name = c.getValue();
                }
                if (c.getName().equals("visitCount")) {
                    count = Integer.parseInt(c.getValue());
                }
            }
        }

        // If user enters name (first time)
        if (userName != null && !userName.isEmpty()) {
            name = userName;
            count = 0;

            Cookie userCookie = new Cookie("user", name);
            userCookie.setMaxAge(30); // expires in 30 sec

            Cookie countCookie = new Cookie("visitCount", String.valueOf(count));
            countCookie.setMaxAge(30);

            response.addCookie(userCookie);
            response.addCookie(countCookie);
        }

        out.println("<html><body>");

        if (name != null) {
            count++;

            // Update visit count cookie
            Cookie countCookie = new Cookie("visitCount", String.valueOf(count));
            countCookie.setMaxAge(30);
            response.addCookie(countCookie);

            out.println("<h2 style='color:blue'>Welcome back, " + name + "!</h2>");
            out.println("<h2 style='color:green'>You have visited this page " + count + " times</h2>");

            // Display all cookies
            out.println("<h3>List of Cookies:</h3>");
            if (cookies != null) {
                for (Cookie c : cookies) {
                    out.println("Name: " + c.getName() + " | Value: " + c.getValue() + "<br>");
                }
            }

            out.println("<br><a href='logout'>Logout</a>");
        } else {
            out.println("<h3>Enter your name:</h3>");
            out.println("<form action='CookieServlet' method='get'>");
            out.println("<input type='text' name='userName'>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
        }

        out.println("</body></html>");
    }
}