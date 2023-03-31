<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form name="loginForm" id="loginForm" method="post" action="login.jsp">
  <table border="1" cellpadding="5">
    <!--첫번째 행-->
    <tr>
      <th width="80px">아이디</th>
      <td><input type="text" name="id" id="id" placeholder="아이디 입력" size="15">
        <div id="idDiv"></div>
      </td>
    </tr>
    <!--2번째 행-->
    <tr>
      <th>비밀번호</th>
      <td><input  type="text" name="pwd" id="pwd" placeholder="비밀번호 입력" size="15">
        <div id="pwdDiv"></div>
      </td>
    </tr>
    <!--3번째 행-->
    <tr>
      <td colspan="2" align="center">
        <button type="button" form="loginForm" onclick="checkLogin()">로그인</button>
        <input type="button" value="회원가입" onClick="location.href='./writeForm.jsp'">
      </td>
    </tr>
  </table>
</form>

<script>
  function checkLogin(){
    document.getElementById("id").innerText == ""
    document.getElementById("pwd").innerText == ""

    if(document.getElementById("id").value == "")
      document.getElementById("idDiv").innerText="아이디을 입력하세요";
    else if(document.getElementById("pwd").value == "")
      document.getElementById("pwdDiv").innerText="비밀번호를 입력하세요";
    else
      document.loginForm.submit();
  }</script>

</body>
</html>
