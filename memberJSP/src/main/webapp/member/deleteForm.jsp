<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="member.dao.MemberDAO"%>
<%
  request.setCharacterEncoding("UTF-8");

  //데이터
  String pwd = request.getParameter("pwd");
  //세션
  String id = (String)session.getAttribute("memId");
  boolean exist = false;

  //DB
  //싱글톤 스타일
  if(pwd != null) { //검색버튼을 눌렀을 때 (처음에 떴을 때에는 pwd=null이다)
    MemberDAO memberDAO = MemberDAO.getInstance(); //new MemberDAO() 대신
    exist = memberDAO.isExistPwd(id, pwd); //pwd가 존재하면 true 리턴함.
  }
  //pwd가 입력되고 다시 이 페이지를 띄웠을 때.
  if(exist) response.sendRedirect("delete.jsp");
%>
<html>
<head>
    <title>DeleteForm</title>
  <style>
    #pwdDiv{
      color: red;
      font-weight: bold;
    }
  </style>
</head>
<body>

<form name="deleteForm" method="post" action="deleteForm.jsp" >

  <label>비밀번호 입력:
    <input type="password" name="pwd" id="pwd" size="15">
    <input type="button" value="검색" onClick="checkDelete()">
  </label>
  <div id="pwdDiv">
    <% if(pwd != null && !exist){ %>
      비밀번호가 맞지 않습니다.
      <%}%>
  </div>

</form>

<script>
  function checkDelete(){
    if(document.getElementById("pwd").value == "")
      document.getElementById("pwdDiv").innerText="비밀번호를 입력하세요";

    else
      document.deleteForm.submit();
  }
</script>

</body>
</html>
