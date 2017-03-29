package org.alvin.boot.servlet.demo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by tangzhichao on 2017/3/29.
 */
@WebServlet(urlPatterns = "/an/*" ,description = "注解方式的测试")
public class DemoServletForAnnotation extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello1");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(">>>>>>>>>>doPost1()<<<<<<<<<<<");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>222222222222222</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>大家好，2222222222222222222222</h1>");
        out.println("</body>");
        out.println("</html>");
    }

}
