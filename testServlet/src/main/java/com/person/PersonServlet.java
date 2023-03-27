package com.person;

import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PersonServlet", value = "/PersonServlet")
public class PersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        //데이터
        String name = request.getParameter("name");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String color = request.getParameter("color");
        String[] hobby = request.getParameterValues("hobby");
        String[] subject = request.getParameterValues("subject");

        //응답
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); //객체 생성
        out.println("<html><body><h3><ul style='color: " + color + "'>");
        out.printf("<li>이름 : %s </li><br>", name);
        if(gender == 0) out.printf("<li>성별 : 여성 </li><br>");
        else if(gender == 1) out.printf("<li>성별 : 여성 </li><br>");
        out.printf("<li>색깔 : %s </li><br>", color);

        out.println("<li>취미 : ");
        for(int i = 0; i < hobby.length; i++) {
            out.println(hobby[i]);
        }
        out.println("</li><br>");

        out.println("<li>과목 : ");
        for(String data : subject) {
            out.println(data);
        }
        out.println("</li><br>");
        out.println("</ul></h3></body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    }
}
