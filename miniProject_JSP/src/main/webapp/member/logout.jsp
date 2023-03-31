<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  session.removeAttribute("memName");
  session.removeAttribute("memId");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3> 로그아웃 </h3>

<script>
  window.onload = function(){
    alert("로그아웃");
    location.href = "../index.jsp";
  }
</script>

</body>
</html>
