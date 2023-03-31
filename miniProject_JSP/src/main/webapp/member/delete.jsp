<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="member.dao.MemberDAO"%>

<%
    request.setCharacterEncoding("UTF-8");

    //데이터
    String id = (String)session.getAttribute("memId");

    //세션
    session.removeAttribute("memName");
    session.removeAttribute("memId");
    //session.invalidate(); -> 무효화(모든 세션 제거함)

    //DB
    MemberDAO memberDAO = MemberDAO.getInstance();
    memberDAO.memberDelete(id); //id 값에 해당하는 회원 레코드 삭제



%>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<script>
  window.onload = function(){
    alert("회원 탈퇴 완료!");
    location.href = "loginForm.jsp";
  }
</script>


</body>
</html>
