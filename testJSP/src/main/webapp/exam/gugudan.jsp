<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>구구단</title>
</head>
<body>

<table border="1">
<% for(int i=2; i <=9; i++){%>
    <tr>
    <%for(int j=1; j<=9; j++){ %>

       <td> <%=i + "*" + j + "=" + i*j + "  "%></td>
   <% } %>
    </tr>
<%}%>
</table>




</body>
</html>
