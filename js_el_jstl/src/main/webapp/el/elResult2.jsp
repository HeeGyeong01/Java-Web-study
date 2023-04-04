<<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="angel" uri="tld"%>
<html>
<head>
  <title>Title</title>
</head>
<body>

<h3>
  ${param['x']} + ${param['y']} = ${angel:sum(param['x'], param['y'])} <br>
  ${param['x']} * ${param['y']} = ${angel:mul(param['x'], param['y'])} <br>

</h3>

</body>
</html>
