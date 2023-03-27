package com.hello;

import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebServlet(name = "HelloServlet", value = "/HelloServlet", urlPatterns = "/HelloServlet")
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void init(){
        System.out.println("init()");

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        System.out.println("doGet()");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); //객체 생성
        out.println("<html>");
        out.println("<body>");
        out.println("ssi <br>");
        out.println("ssi");
        out.println("</body>");
        out.println("</html>");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    }

    public void destroy(){
        System.out.println("destroy()");

    }

}
