package com.session;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.Date;

@WebServlet("/session")   // 🔥 THIS IS THE KEY (URL mapping)
public class SessionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(true);

        // Set session timeout to 1 minute
        session.setMaxInactiveInterval(60);

        Integer count = (Integer) session.getAttribute("count");

        if (count == null) {
            count = 1;
        } else {
            count++;
        }

        session.setAttribute("count", count);

        out.println("<h2>Session Tracking Information</h2>");
        out.println("Session ID: " + session.getId() + "<br>");
        out.println("Creation Time: " + new Date(session.getCreationTime()) + "<br>");
        out.println("Last Access Time: " + new Date(session.getLastAccessedTime()) + "<br>");
        out.println("Visit Count: " + count);
    }
}