<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
  <title>Title</title>
</head>


<body>
<fmt:requestEncoding value="UTF-8"/>
<ul>
  <li>이름: ${param.name}</li><br>
  <li>나이: ${param.age}살
    <c:if test="${param.age>=19}"><strong>성인</strong></c:if>
    <c:if test="${param.age<19}"><strong>청소년</strong></c:if>
  </li><br>

  <li>
    색깔 :
    <c:choose>
      <c:when test="${param.color == 'red'}">빨강</c:when>
      <c:when test="${param.color == 'green'}">초록</c:when>
      <c:when test="${param.color == 'blue'}">파랑</c:when>
      <c:when test="${param.color == 'magenta'}">보라</c:when>
      <c:otherwise>하늘</c:otherwise>
    </c:choose>
  </li><br>

  <li>
    취미 : ${paramValues.hobby[0]}, ${paramValues.hobby[1]},
    ${paramValues.hobby[2]}, ${paramValues.hobby[3]}, ${paramValues.hobby[4]}
    없으면 안찍힘
  </li>

  <li>
    취미:
    <c:forEach var="data" items="${paramValues.hobby}">
      ${data}
    </c:forEach>
  </li>
</ul>

</body>
</html>
