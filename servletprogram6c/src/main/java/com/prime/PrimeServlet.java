package com.prime;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/prime")
public class PrimeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            int number = Integer.parseInt(request.getParameter("number"));

            // Validation
            if (number < 0) {
                throw new IllegalArgumentException("Number cannot be negative");
            }

            boolean isPrime = true;

            if (number == 0 || number == 1) {
                isPrime = false;
            } else {
                for (int i = 2; i <= number / 2; i++) {
                    if (number % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            // HTML Output
            out.println("<html><body>");
            out.println("<div style='margin:20px;'>");
            out.println("<h2>Prime Number Result</h2>");
            out.println("<p>Entered Number: " + number + "</p>");

            if (isPrime) {
                out.println("<p style='color:green;'>It is a PRIME number</p>");
            } else {
                out.println("<p style='color:red;'>It is NOT a prime number</p>");
            }

            out.println("<a href='index.html'>Check Another Number</a>");
            out.println("</div>");
            out.println("</body></html>");

        } catch (NumberFormatException e) {
            displayError(out, "Please enter a valid number");
        } catch (IllegalArgumentException e) {
            displayError(out, e.getMessage());
        }
    }

    private void displayError(PrintWriter out, String message) {
        out.println("<html><body>");
        out.println("<div style='margin:20px; color:red;'>");
        out.println("<h2>Error</h2>");
        out.println("<p>" + message + "</p>");
        out.println("<a href='index.html'>Try Again</a>");
        out.println("</div>");
        out.println("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.html");
    }
}