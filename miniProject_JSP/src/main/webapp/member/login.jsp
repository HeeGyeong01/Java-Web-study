<%@ page import="member.dao.MemberDAO" %>
<%@ page import="java.util.Map" %>
<%@ page import="member.bean.MemberDTO" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  request.setCharacterEncoding("UTF-8");

  //데이터
  String id = request.getParameter("id");
  String pwd = request.getParameter("pwd");

  Map<String, String> map = new HashMap<>();
  map.put("id", id);
  map.put("pwd", pwd);

  //DB
  MemberDAO memberDAO = MemberDAO.getInstance(); //new MemberDAO() 대신
  MemberDTO memberDTO = memberDAO.memberLogin(map); //호출


%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
  if(memberDTO == null){
    //페이지 이동
    response.sendRedirect("loginFail.jsp");

  }else{

    session.setAttribute("memId", id);
    session.setAttribute("memName", memberDTO.getName());
    session.setAttribute("memEmail", memberDTO.getEmail1() + "@" + memberDTO.getEmail2());


    //페이지 이동
    response.sendRedirect("loginOk.jsp");

  }
%>
</body>
</html>
