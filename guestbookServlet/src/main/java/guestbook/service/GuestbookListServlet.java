package guestbook.service;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GuestbookListServlet", value = "/GuestbookListServlet")
public class GuestbookListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //html에서 받는 데이터 없음

        //데이터
        int pg = Integer.parseInt(request.getParameter("pg"));

        //페이징 처리 - 1페이지당 게시물 2개씩 보여줌.
        //pg=1    RN>=1 AND RN<=2
        //pg=2    RN>=3 AND RN<=4
        int endNum = pg*2;
        int startNum = endNum - 1;

        //DB
        GuestbookDAO guestbookDAO = GuestbookDAO.getInstance(); //new MemberDAO() 대신
        ArrayList<GuestbookDTO> list = guestbookDAO.guestbookList(startNum, endNum); //호출

        //총 게시글 수 계산
        int totalA = guestbookDAO.getTotalA();
        int totalPage = (totalA +1) /2;     // 2로 나눈 후 올림하는 것과 같은 결과.

        //응답
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter(); //스트림 생성


        out.println("<html><head>\n"
            + "  <title>writeForm</title>\n"
            + "  <style type=\"text/css\">\n"
            + "    table, td, th{\n"
            + "      border: 1px solid black;\n"
            + "      border-collapse: collapse;\n"
            + "    } "
            + "table{margin: 10px 10px 10px 30px;}"
            + "div {float: left; width: 20px height: 20px; margin-left: 10px; padding: 5px; text-align: center;}"
            + "#currentDiv {float: left; border: 1px red solid; width: 20px height: 20px; margin-left: 10px; padding: 5px; text-align: center;}"
            + "#paging {color: gray; text-decoration: none;}"
            + "#currentPaging {color: red; text-decoration: none;}"
            + "</style></head>");
        out.println("<body>");


        if(list != null){
            for(GuestbookDTO guestbookDTO: list){

                out.println("<table cellpadding=\"5\" cellspacing=\"0\">");
                //작성자
                out.println("<tr>");
                out.println("<td style='width:100px;' align='center'>작성자</td>");
                out.println("<td style='width:150px;'>" + guestbookDTO.getName() + "</td>");
                out.println("<td style='width:100px;' align ='center'>작성일</td>");
                out.println("<td style='width:150px;'>" + guestbookDTO.getLogtime() + "</td>");
                out.println("</tr>");
                //이메일
                out.println("<tr>");
                out.println("<td align='center'>이메일</td>");
                out.println("<td colspan='3'>" + guestbookDTO.getEmail() + "</td>");
                out.println("</tr>");
                //홈페이지
                out.println("<tr>");
                out.println("<td align='center'>홈페이지</td>");
                out.println("<td colspan='3'>" + guestbookDTO.getHomepage() + "</td>");
                out.println("</tr>");
                //제목
                out.println("<tr>");
                out.println("<td align='center'>제목</td>");
                out.println("<td colspan='3'>" + guestbookDTO.getSubject() + "</td>");
                out.println("</tr>");
                //내용
                out.println("<tr>");
                out.println(
                    "<td style='width:500px; height:80px; word_wrap:break-word;  word-break: break-all; 'colspan='4'>"
                        + guestbookDTO.getContent().replace("\r\n", "<br>") + "</td>");
                out.println("</tr>");
                out.println("</table>");
            }
            out.println("<div>");

            //페이지 번호
            for(int i = 1; i <= totalPage; i++) {
                if(i == pg) //선택된 페이지
                    out.printf("<div id='currentDiv'> <a id='currentPaging' href='/GuestbookListServlet?pg=%d'>%d </a></div>", i, i);
                else
                    out.printf("<div> <a id='paging' href='/GuestbookListServlet?pg=%d'>%d </a></div>", i, i);

            }
            out.println("</div>");
            out.println("</body></html>");
        }

    }


}
