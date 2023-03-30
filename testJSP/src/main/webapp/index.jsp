<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%! //선언문 -전역, 1번만 실행
    String name = "이희경";

    int age = 25;
%>
<% //스크립트릿 -지역, 호출시마다(F5 누를 때마다) 실행
    age++;

%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP - Hello World</title>
</head>
<body>
<%-- 이건 JSP 주석이다 --%>
<h1><%= "Hello World!" %></h1>

나의 이름은 <%=name%> 입니다<br>
내 나이는 <%=age%>살 입니다<br>





<a href="hello-servlet">Hello Servlet</a>
</body>
</html>