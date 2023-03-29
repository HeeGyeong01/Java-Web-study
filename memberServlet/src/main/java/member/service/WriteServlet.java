package member.service;

import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import member.bean.MemberDTO;
import member.dao.MemberDAO;

@WebServlet(name = "WriteServlet", value = "/WriteServlet")
public class WriteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //get은 url로 명시적으로 넘어오므로 자동적으로 처리해주나
        //post는 url로 넘어오지 않으므로 request도 인코딩을 해줘야 한다.

        //데이터
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String gender = request.getParameter("gender");

        String email1 = request.getParameter("email1");
        String email2 = request.getParameter("email2");
        String tel1 = request.getParameter("tel1");
        String tel2 = request.getParameter("tel2");
        String tel3 = request.getParameter("tel3");

        String zipcode = request.getParameter("zipcode");
        String addr1 = request.getParameter("addr1");
        String addr2 = request.getParameter("addr2");

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName(name);
        memberDTO.setId(id);
        memberDTO.setPwd(pwd);
        memberDTO.setGender(gender);
        memberDTO.setEmail1(email1);
        memberDTO.setEmail2(email2);
        memberDTO.setTel1(tel1);
        memberDTO.setTel2(tel2);
        memberDTO.setTel3(tel3);
        memberDTO.setZipcode(zipcode);
        memberDTO.setAddr1(addr1);
        memberDTO.setAddr2(addr2);

        //DB
        //싱글톤 스타일
        MemberDAO memberDAO = MemberDAO.getInstance(); //new MemberDAO() 대신
        int su = memberDAO.memberWrite(memberDTO); //호출

        //응답
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter(); //스트림 생성
        out.println("<html><body>");
        if(su == 0) {
            out.println("<h3>회원가입 실패</h3>");
            out.println("<input type='button' value='뒤로가기' onclick='history.back(-1)'>");
        }else {
            out.println("<h3>회원가입 성공</h3>");
            out.println("<input type='button' value='로그인' onclick=location.href='http://localhost:8080/member/loginForm.html'>");
        }
        out.println("</body></html>");

    }
}
