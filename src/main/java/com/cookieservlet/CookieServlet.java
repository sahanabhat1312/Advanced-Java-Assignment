/*Build a servlet program to  create a cookie to get your name through text box and press submit 
 button( through HTML)  to display the message by greeting Welcome back your name ! , you have visited this
 page n times ( n = number of your visit )  along with the list of cookies and its setvalues and demonstrate 
 the expiry of cookie also. */


package com.cookieservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.servlet.http.Cookie;
/**
 * Servlet implementation class CookieServlet
 */
@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    // Handle GET request
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("userName");

        // Create cookies when user submits name
        if (userName != null && !userName.isEmpty()) {

            Cookie userCookie = new Cookie("user", userName);
            userCookie.setMaxAge(30); // expires in 30 sec

            Cookie visitCookie = new Cookie("visitCount", "1");
            visitCookie.setMaxAge(30);

            response.addCookie(userCookie);
            response.addCookie(visitCookie);
        }

        // Read cookies
        Cookie[] cookies = request.getCookies();
        String existingUser = null;
        int visitCount = 0;

        if (cookies != null) {
            for (Cookie c : cookies) {

                if (c.getName().equals("user")) {
                    existingUser = c.getValue();
                }

                if (c.getName().equals("visitCount")) {
                    visitCount = Integer.parseInt(c.getValue());
                    visitCount++;

                    Cookie newVisit = new Cookie("visitCount", String.valueOf(visitCount));
                    newVisit.setMaxAge(30);
                    response.addCookie(newVisit);
                }
            }
        }

        // HTML Response
        out.println("<html><head><title>Cookie Program</title></head><body>");

        if (existingUser != null) {

            // Greeting message
            out.println("<h2 style='color:blue;'>Welcome back, " + existingUser + "!</h2>");

            // Visit count
            out.println("<h3 style='color:green;'>You have visited this page " + visitCount + " times</h3>");

            // List of cookies
            out.println("<h3>List of Cookies:</h3>");
            if (cookies != null) {
                for (Cookie c : cookies) {
                    out.println("Name: " + c.getName() + " | Value: " + c.getValue() + "<br>");
                }
            }

            // Expiry message
            out.println("<p><b>Note:</b> Cookie expires in 30 seconds</p>");

            // Logout button
            out.println("<br><form action='CookieServlet' method='post'>");
            out.println("<input type='submit' value='Logout'>");
            out.println("</form>");
        }

        else {
            // First-time user
            out.println("<h2 style='color:red;'>Enter your name</h2>");
            out.println("<form action='CookieServlet' method='get'>");
            out.println("Name: <input type='text' name='userName'>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
        }

        out.println("</body></html>");
    }

    // Handle POST (Logout)
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cookie userCookie = new Cookie("user", "");
        userCookie.setMaxAge(0);

        Cookie visitCookie = new Cookie("visitCount", "");
        visitCookie.setMaxAge(0);

        response.addCookie(userCookie);
        response.addCookie(visitCookie);

        response.sendRedirect("CookieServlet");
    }
}