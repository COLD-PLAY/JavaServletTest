package com.myorg;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by coldplay on 17-4-15.
 */
public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private String message = "";

    public void init() {
        message = "hello servlet";
    }
    public MyServlet(String m) {
        super();
        message = "hello " + m;
    }
    public MyServlet() {
        super();
    }

    public String get_message() {
        return message.isEmpty()?"nothing here":message;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.print("<h1>" + message + "</h1>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        doGet(request, response);
    }

    public void destroy() {
        // nothing
    }
}
