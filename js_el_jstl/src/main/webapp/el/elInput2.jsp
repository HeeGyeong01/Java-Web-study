<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>

<form name="calcForm" method="get" action="elResult2.jsp">
  <table border="1" cellpadding="10" cellspacing="0">
    <tr>
      <td width="70" align="center">X</td>
      <td><input type="text" name="x" placeholder="x값을 입력하세요 ">
        <div id="XDiv"></div></td>
    </tr>

    <tr>
      <td width="70" align="center">Y</td>
      <td><input type="text" name="y" placeholder="y값을 입력하세요 ">
        <div id="YDiv"></div></td>
    </tr>

    <tr>
      <td colspan="2" align="center"><input type="submit" value="계산 ">
        <input type="reset" value="취소 "></td>
    </tr>

  </table>
</form>

</body>
</html>
