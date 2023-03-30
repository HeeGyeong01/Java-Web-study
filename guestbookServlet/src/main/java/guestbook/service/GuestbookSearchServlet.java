package guestbook.service;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GuestbookSearchServlet", value = "/GuestbookSearchServlet")
public class GuestbookSearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        //데이터
        int seq= Integer.parseInt(request.getParameter("seq"));


        //DB
        //싱글톤 스타일
        GuestbookDAO guestbookDAO = GuestbookDAO.getInstance(); //new MemberDAO() 대신
        GuestbookDTO guestbookDTO = guestbookDAO.guestbookSearch(seq); //호출


        String name;
        String email;
        String homepage;
        String subject;
        String content;
        String logtime;

        name = guestbookDTO.getName();
        email = guestbookDTO.getEmail();
        homepage = guestbookDTO.getSubject();
        subject = guestbookDTO.getSubject();
        content = guestbookDTO.getContent();
        logtime = guestbookDTO.getLogtime();

        //응답
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter(); //스트림 생성

        out.println("<html><head>\n"
            + "  <title>writeForm</title>\n"
            + "  <style type=\"text/css\">\n"
            + "    table, td, th{\n"
            + "      border: 1px solid black;\n"
            + "      border-collapse: collapse;\n"
            + "    } </style>");
        out.println("<body>");

        if(guestbookDAO != null) { //seq 값에 해당하는 DB의 레코드가 존재하는 경우.
            out.println("<table cellpadding=\"5\" cellspacing=\"0\">");
            //작성자
            out.println("<tr>");
            out.println("<td style='width:100px;' align='center'>작성자</td>");
            out.println("<td style='width:150px;'>" + name + "</td>");
            out.println("<td style='width:100px;' align ='center'>작성일</td>");
            out.println("<td style='width:150px;'>" + logtime + "</td>");
            out.println("</tr>");
            //이메일
            out.println("<tr>");
            out.println("<td align='center'>이메일</td>");
            out.println("<td colspan='3'>" + email + "</td>");
            out.println("</tr>");
            //홈페이지
            out.println("<tr>");
            out.println("<td align='center'>홈페이지</td>");
            out.println("<td colspan='3'>" + homepage + "</td>");
            out.println("</tr>");
            //제목
            out.println("<tr>");
            out.println("<td align='center'>제목</td>");
            out.println("<td colspan='3'>" + subject + "</td>");
            out.println("</tr>");
            //내용
            out.println("<tr>");
            out.println(
                "<td style='width:500px; height:80px; word_wrap:break-word;  word-break: break-all; 'colspan='4'>"
                    + content.replace("\r\n", "<br>") + "</td>");
            out.println("</tr>");
            out.println("</table>");
        }else{
            out.println("<h3>글번호가 없습니다</h3>");
        }
        out.println("</body></html>");

    }
}
