<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <style>
    div{
      font-size: 8pt;
      color: red;
      font-weight: bold;
    }
  </style>
</head>
<body>
<img src="../image/winter.png" width="50" height="50" alt="겨울 이미지"
     onclick="location.href='../index.jsp'" style="cursor: pointer"> 글쓰기<br>


<form name="boardWriteForm" id="boardWriteForm" method="post" action="boardWrite.jsp">
  <table border="1" cellpadding="5" cellspacing="0">
    <!--첫번째 행-->
    <tr>
      <th width="80px">제목</th>
      <td>
        <input type="text" name="subject" id="subject" size="15">
        <div id="subjectDiv"></div>
      </td>
    </tr>
    <!--2번째 행-->
    <tr>
      <th>내용</th>
      <td>
        <textarea name="content" id="content" rows="15" cols="50"></textarea>
        <div id="contentDiv"></div>
      </td>
    </tr>
    <!--3번째 행-->
    <tr>
      <td colspan="2" align="center">
        <button type="button" onclick="checkBoardWrite()">글쓰기</button>
        <button type="reset">다시작성</button>
      </td>
    </tr>
  </table>
</form>

<script>
  function checkBoardWrite(){
    document.getElementById("subjectDiv").innerText == ""
    document.getElementById("contentDiv").innerText == ""

    if(document.getElementById("subject").value == "") {
      document.getElementById("subjectDiv").innerText = "제목을 입력하세요";
      document.getElementById("subject").focus();
    }
    else if(document.getElementById("content").value == "") {
      document.getElementById("contentDiv").innerText = "내용을 입력하세요";
      document.getElementById("content").focus();
    }
    else
      document.boardWriteForm.submit();
  }</script>

</body>
</html>
