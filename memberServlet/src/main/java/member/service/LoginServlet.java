package member.service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import member.dao.MemberDAO;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //데이터
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");


        //DB
        //싱글톤 스타일
        MemberDAO memberDAO = MemberDAO.getInstance(); //new MemberDAO() 대신
        String name = memberDAO.memberLogin(id, pwd); //호출

        //응답
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter(); //스트림 생성
        out.println("<html><body>");
        if(name == null)
            out.println("<h3>아이디 또는 비밀번호가 맞지 않습니다</h3>");
        else out.printf("<h3> %s 로그인</h3>", name);
        out.println("</body></html>");

    }
}
