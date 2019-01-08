package com.fmz.learn.spring.controller;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SimpleServletController extends GenericServlet{

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        PrintWriter pwriter=servletResponse.getWriter();
        pwriter.print("<html>");
        pwriter.print("<body>");
        pwriter.print("<h2>Generic Servlet Example</h2>");
        pwriter.print("<p>Hello BeginnersBook Readers!</p>");
        pwriter.print("</body>");
        pwriter.print("</html>");
    }
}
