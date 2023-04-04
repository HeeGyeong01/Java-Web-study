<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core %>
<html>
<head>
  <title>Title</title>
</head>
<body>
결과 = ${requestScope.list} <br><br>
세번째 항목 = ${requestScope.list[2]} <br><br>

결과 = ${requestScope.list2} <br><br>

<c:forEach var="personDTO" items="${list2}">
  이름 = ${personDTO.getName()} &emsp;
  나이 = ${personDTO.getAge()}
</c:forEach>


</body>
</html>
