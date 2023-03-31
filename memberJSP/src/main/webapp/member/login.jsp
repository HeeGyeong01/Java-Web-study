<%@ page import="member.dao.MemberDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  request.setCharacterEncoding("UTF-8");

  //데이터
  String id = request.getParameter("id");
  String pwd = request.getParameter("pwd");


  //DB
  MemberDAO memberDAO = MemberDAO.getInstance(); //new MemberDAO() 대신
  String name = memberDAO.memberLogin(id, pwd); //호출


%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
  if(name == null){
    //페이지 이동
    response.sendRedirect("loginFail.jsp");

  }else{

    //세션 - 서버(톰캣)에 저장
    //HttpSession session = request.getSession();
    //HttpSession은 인터페이스라 new로 생성할 수 없다.
    //세션은 JSP의 내장객체로 이미 존재한다.-> 객체 생성하지 않아도 됨.

    session.setAttribute("memName", name);
    session.setAttribute("memId", id);


    //페이지 이동
    response.sendRedirect("loginOk.jsp");

  }
%>
</body>
</html>
