<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //데이터
    String name = null;
    String id = null;

    name = (String)session.getAttribute("memName");
    id = (String)session.getAttribute("memId");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<img src="../image/winter.png" width="50" height="50" alt="겨울 이미지"
     onclick="location.href='../index.jsp'" style="cursor: pointer">

<h3><%=name%> 로그인</h3>
<button onClick="location.href='logout.jsp'">로그아웃</button>
<button onClick="location.href='updateForm.jsp'">회원정보 수정</button>
<button onClick="location.href='deleteForm.jsp'">회원 탈퇴</button>

</body>
</html>
