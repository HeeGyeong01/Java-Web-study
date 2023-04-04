<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  //데이터
  int x = Integer.parseInt(request.getParameter("x"));
  int y = Integer.parseInt(request.getParameter("y"));
%>

<html>
<head>
  <title>Title</title>
</head>
<body>

<h3>
  ${param['x']} + ${param['y']} = ${param['x'] + param['y']} <br>
  ${param['x']} - ${param['y']} = ${param['x'] - param['y']}<br>
  ${param.x} * ${param.y} = ${param.x * param.y}<br>
  ${param['x']} / ${param['y']} = ${param['x'] / param['y']}<br>
</h3>

</body>
</html>
