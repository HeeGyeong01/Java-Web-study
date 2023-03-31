<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="member.bean.MemberDTO"%>
<%@ page import="member.dao.MemberDAO"%>

<%
    request.setCharacterEncoding("UTF-8");

    //데이터
    MemberDTO memberDTO = new MemberDTO();
    memberDTO.setName(request.getParameter("name"));
    memberDTO.setId(request.getParameter("id"));
    memberDTO.setPwd(request.getParameter("pwd"));
    memberDTO.setGender(request.getParameter("gender"));
    memberDTO.setEmail1(request.getParameter("email1"));
    memberDTO.setEmail2(request.getParameter("email2"));
    memberDTO.setTel1(request.getParameter("tel1"));
    memberDTO.setTel2(request.getParameter("tel2"));
    memberDTO.setTel3(request.getParameter("tel3"));
    memberDTO.setZipcode(request.getParameter("zipcode"));
    memberDTO.setAddr1(request.getParameter("addr1"));
    memberDTO.setAddr2(request.getParameter("addr2"));

    //DB
    MemberDAO memberDAO = MemberDAO.getInstance(); //new MemberDAO() 대신
    int updateCount = memberDAO.memberUpdate(memberDTO); //호출

%>
<html>
<head>
    <title>update</title>
</head>
<body>


<% if(updateCount == 0) { %>
    <h3>회원정보 수정 실패</h3>
    <input type='button' value='뒤로가기' onclick='history.go(-1)'>
<%}else {%>
    <h3>회원정보 수정 완료</h3>
    <input type='button' value='로그인' onclick=location.href='loginForm.jsp'>
<%}%>

<script>
    window.onload = function(){
      alert("회원정보 수정 완료!");
      location.href = "loginForm.jsp";
    }
</script>

</body>
</html>
