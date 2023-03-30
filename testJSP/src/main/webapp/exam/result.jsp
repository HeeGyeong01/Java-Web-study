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
    <%=x%> + <%=y%> = <%=x+y%><br>
    <%=x%> - <%=y%> = <%=x-y%><br>
    <%=x%> * <%=y%> = <%=x*y%><br>
    <%=x%> / <%=y%> = <%=(double)x/y%><br>
</h3>

</body>
</html>
