package com.example.servlets;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        try {

            PrintWriter out = response.getWriter();
            Date today = new Date();

            out.println("<html> " +
                    "<body>" +
                    "<h1 align=center>Main Servlet</h1>" +
                    "<br>" + today +
                    "</body>" +
                    "</html>");

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}