package com.param;

import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebServlet(name = "paramServlet", value = "/paramServlet")
@WebServlet("/paramServlet")
public class paramServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void init(){

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        //데이터 받음
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));

        //응답
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter(); //출력 스트림 생성
        out.println("<html>");
        out.println("<body>");
        out.println("나의 이름은 "+ name + "이고" + "나이는 " + age + "살 이므로");

        if(age >=20) out.println("성인입니다");
        else out.println("청소년입니다");
        out.println("</body>");
        out.println("</html>");


    }

    public void destroy(){

    }


}
