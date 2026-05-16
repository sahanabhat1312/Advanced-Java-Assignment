//10.b Build an Application to get Rollno, Studentname, Sub1, Sub2, Sub3, Sub4 and Sub5  through JSP called index.jsp with client sided validation and
// submit to the servlet called ResultServlet and process all the fields with server sided validation and display all the data along with result 
//( Pass if all subjects greater than 40%) and Average marks through result.jsp with a link to move to the client side


package com.HTTP_REQ_RES;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/processResult")
public class ResultServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get parameters
        String rollno = request.getParameter("rollno");
        String studentname = request.getParameter("studentname");

        String s1 = request.getParameter("sub1");
        String s2 = request.getParameter("sub2");
        String s3 = request.getParameter("sub3");
        String s4 = request.getParameter("sub4");
        String s5 = request.getParameter("sub5");

        String message;

        // Server side validation
        if (rollno == null || rollno.trim().isEmpty() ||
            studentname == null || studentname.trim().isEmpty()) {

            message = "All fields are required";

        } else {

            int sub1 = Integer.parseInt(s1);
            int sub2 = Integer.parseInt(s2);
            int sub3 = Integer.parseInt(s3);
            int sub4 = Integer.parseInt(s4);
            int sub5 = Integer.parseInt(s5);

            // Calculate total and average
            int total = sub1 + sub2 + sub3 + sub4 + sub5;
            double average = total / 5.0;

            // Check pass/fail
            String result;
            if (sub1 >= 40 && sub2 >= 40 && sub3 >= 40 &&
                sub4 >= 40 && sub5 >= 40) {

                result = "PASS";
            } else {
                result = "FAIL";
            }

            message = "Student Result Processed Successfully";

            // Set attributes
            request.setAttribute("rollno", rollno);
            request.setAttribute("studentname", studentname);

            request.setAttribute("sub1", sub1);
            request.setAttribute("sub2", sub2);
            request.setAttribute("sub3", sub3);
            request.setAttribute("sub4", sub4);
            request.setAttribute("sub5", sub5);

            request.setAttribute("average", average);
            request.setAttribute("result", result);
        }

        request.setAttribute("message", message);

        // Forward to JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("index.jsp");
    }
}
