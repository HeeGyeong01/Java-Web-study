<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <title>Title</title>
</head>

<body>
<h3>***변수 설정***</h3>
<c:set var="name" value="홍길동"/>
<c:set var="age">25</c:set>

나의 이름은 <c:out value="${name}"/>입니다.<br>
내 나이는 ${age}살 입니다.<br>

<h3>*** forEach ***</h3>
<c:set var="sum">0</c:set>
<c:forEach var="i" begin="1" end="10" step="1">
  ${i }&nbsp; &emsp;
  <c:set var= "sum" value="${sum + i}"/>
</c:forEach>
<br>
총 합은 ${sum}입니다.
<br><br>

<c:set var="nowNum" value="10"/>
<c:forEach var="i" begin="0" end="${nowNum-1}" step="1">
  ${nowNum - i}&nbsp; &emsp;
</c:forEach>


<h3>*** forToken ***</h3>
<c:forTokens var="car" items="소나타,아우디,벤츠,페라리, 포르쉐" delims=",">
  ${car}<br>
</c:forTokens>


</body>
</html>
