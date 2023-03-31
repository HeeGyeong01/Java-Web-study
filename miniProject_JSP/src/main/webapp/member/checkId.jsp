<%@ page import="member.dao.MemberDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  //데이터
  String id = request.getParameter("id");

  //DB
  MemberDAO memberDAO = MemberDAO.getInstance();
  boolean existId = memberDAO.isExistId(id); //기존에 회원가입한 해당 id가 있는 경우 true 반환

%>
<html>
<head>
  <title>Title</title>
</head>

<body>
<% if(existId){%> <%--기존에 회원가입한 아이디가 존재한다.--%>
  <form action="checkId.jsp">
  <h3><%=id%>는 사용 불가능</h3>
  <br>
  아이디 <input type="text" name="id"> <input type="submit" value="중복체크">
  </form>
<%}else{ %>
  <h3><%=id%>는 사용 가능</h3>
<input type="button" value="사용하기" onclick="checkIdClose('<%=id%>')">
<%}%>

<script>
  function checkIdClose(id){
    opener.writeForm.id.value = id; //부모창의 id값 전달해서 띄움
    opener.writeForm.idDuplication.value = "idCheck";
    opener.writeForm.pwd.focus(); //id 다음 칸인 pwd입력 창에 커서 놓아줌
    window.close() //자식창 닫음
  }
</script>
</body>
</html>
