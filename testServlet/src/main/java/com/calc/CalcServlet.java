package com.calc;

import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalcServlet", value = "/CalcServlet")
public class CalcServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        //데이터
        int x = Integer.parseInt(request.getParameter("x"));
        int y = Integer.parseInt(request.getParameter("y"));

        //응답
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); //객체 생성
        out.println("<html><body><h3>");

        out.printf("%d + %d = %d<br>", x, y, x+y);
        out.printf("%d - %d = %d<br>", x, y, x-y);
        out.printf("%d * %d = %d<br>", x, y, x*y);
        out.printf("%d / %d = %f<br>", x, y, (double)x/y);
        out.println("</h3><input type='button' value='뒤로' onclick='history.go(-1)'></h3>");
        out.println("<input type='button' value='연령제한' onclick=location.href='http://localhost:8080/param.html'>");
        out.println("</body></html>");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    }
}
