<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>

<body>
<table border="1" width="50%">
  <tr>
    <th width="50%">표현식</th>
    <th>값</th>
  </tr>

  <tr>
    <td align="center">\${25+3}</td>
    <td align="center">${25+3}</td>
  </tr>

  <tr>
    <td align="center">\${25/3}</td>
    <td align="center">${25/3}</td>
  </tr>

  <tr>
    <td align="center">\${25 div 3}</td>
    <td align="center">${25 div 3}</td>
  </tr>

  <tr>
    <td align="center">\${header.host}</td>
    <td align="center">${header.host}</td>
  </tr>


</table>

</body>
</html>
