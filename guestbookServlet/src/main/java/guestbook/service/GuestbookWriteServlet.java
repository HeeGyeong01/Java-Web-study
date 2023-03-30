package guestbook.service;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GuestbookWriteServlet", value = "/GuestbookWriteServlet")
public class GuestbookWriteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        //데이터
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String homepage = request.getParameter("homepage");
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");


        GuestbookDTO guestbookDTO = new GuestbookDTO();
        guestbookDTO.setName(name);
        guestbookDTO.setEmail(email);
        guestbookDTO.setHomepage(homepage);
        guestbookDTO.setSubject(subject);
        guestbookDTO.setContent(content);


        //DB
        //싱글톤 스타일
        GuestbookDAO guestbookDAO = GuestbookDAO.getInstance(); //new MemberDAO() 대신
        guestbookDAO.guestbookWrite(guestbookDTO); //호출

        //응답
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter(); //스트림 생성
        out.println("<html><body>");
        out.println("<h3>작성하신 글을 저장하였습니다.</h3>");
        out.println("<button onClick='location.href=\"/GuestbookListServlet?pg=1\"'>글목록</button>");

        out.println("</body></html>");

    }
}
