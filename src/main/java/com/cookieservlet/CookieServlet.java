/*8a.example Build a servlet program to  create a cookie to get your name through text box and press submit button to display the message by greeting Welcome back your name ! , you have visited this page n times ( n = number of your visit ) and demonstrate the expiry of cookie also. 
*/

package com.cookieservlet;
 
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.servlet.http.Cookie;
//Step 2: Create servlet class and use WebServlet annotation
@WebServlet("/CookieServlet")

public class CookieServlet extends HttpServlet {
	  private static final long serialVersionUID = 1L;

	    // Step 3: Handle GET requests
	    public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        // Step 4: Create or retrieve cookies
	        String userName = request.getParameter("userName");

	        // Step 7: Read existing cookies
	        Cookie[] cookies = request.getCookies();
	        String existingUser = null;
	        int count = 0;   // ✅ FIX: moved inside method

	        if (cookies != null) {
	            for (Cookie cookie : cookies) {
	                if (cookie.getName().equals("user")) {
	                    existingUser = cookie.getValue();
	                }
	                if (cookie.getName().equals("count")) {
	                    count = Integer.parseInt(cookie.getValue());
	                }
	            }
	        }

	        // If user enters name first time
	        if (userName != null && !userName.isEmpty()) {

	            existingUser = userName;

	            Cookie userCookie = new Cookie("user", userName);
	            userCookie.setMaxAge(30); // expiry 30 sec

	            Cookie countCookie = new Cookie("count", "1"); // ✅ FIX: create count cookie
	            countCookie.setMaxAge(30);

	            response.addCookie(userCookie);
	            response.addCookie(countCookie);

	            count = 1;
	        }

	        // Step 8: Generate HTML response
	        out.println("<html>");
	        out.println("<head><title>Cookie Example</title></head>");
	        out.println("<body>");

	        if (existingUser != null) {

	            count += 1;

	            // ✅ FIX: update count cookie
	            Cookie countCookie = new Cookie("count", String.valueOf(count));
	            countCookie.setMaxAge(30);
	            response.addCookie(countCookie);

	            out.println("<font color=blue><h2>Welcome back, " + existingUser + "!</h2></font>");
	            out.println("<font color=magenta><h2>You have visited this page " + count + " times!</h2></font>");

	        } else {

	            out.println("<h2 style='color:red;'>Welcome Guest! you have been logged out or kindly login first time</h2>");
	            out.println("<form action='CookieServlet' method='get'>"); // ✅ FIX: changed post → get
	            out.println("Enter your name: <input type='text' name='userName'>");
	            out.println("<input type='submit' value='Submit'>");
	            out.println("</form>");
	        }

	        out.println("</body></html>");
	    }

	    // Step 10: Handle POST requests (for logout)
	    public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        // Delete cookies
	        Cookie user = new Cookie("user", "");
	        user.setMaxAge(0);

	        Cookie count = new Cookie("count", ""); // ✅ FIX: delete count also
	        count.setMaxAge(0);

	        response.addCookie(user);
	        response.addCookie(count);

	        // Redirect back to the servlet
	        response.sendRedirect("CookieServlet");
	    }
	}