<%@ page import="board.dao.BoardDAO" %>
<%@ page import="board.bean.BoardDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  int seq = Integer.parseInt(request.getParameter("seq"));
  int pg = Integer.parseInt(request.getParameter("pg"));

  BoardDAO boardDAO = BoardDAO.getInstance();
  BoardDTO boardDTO = boardDAO.getBoard(seq);

%>
<html>
<head>
  <title>게시글</title>
</head>
<style>
  body{
    margin: 30px 100px 30px 100px;
  }
  td{
    padding: 10px 10px 10px 20px;
    width: 500px;
  }
  #subject{
    font-size: 1.2em;
    font-weight: bold;
  }
</style>


<body>
<%if(boardDTO != null){ %>
<h3><img src="../image/winter.png" width="70px" height="70px" alt="바다요정 쿠키"
     onclick="location.href='../index.jsp'" style="cursor: pointer"> 작성한 글 확인</h3>

<form name="boardViewForm" id="loginForm" method="post" action="boardList.jsp">
  <table border="1" cellpadding="5" cellspacing="0" frame="hsides" rules="rows">
    <!--1번째 행-->
    <tr>
      <td id="subject" colspan="3">
        제목: <%=boardDTO.getSubject()%> </td>

    </tr>

    <!--2번째 행-->
    <tr>
      <td>
        글번호 :<span name="seq" id="seq" size="50"> <%=boardDTO.getSeq()%></span>
      </td>

      <td>
        작성자 :<span name="id" id="id" size="50"> <%=boardDTO.getId()%></span>
      </td>

      <td>
        조회수 :<span name="hit" id="hit" size="50"> <%=boardDTO.getHit()%></span>
      </td>
    </tr>

    <!--3번째 행-->
    <tr>
      <td colspan="3"  height="500px" valign="top" style="padding-top: 10px">
        <div style="width: 100%; height: 100%; overflow: auto;">
<%--        <%=boardDTO.getContent().replace("\r\n", "<br>")%>--%>
          <pre style="white-space: pre-wrap;"><%=boardDTO.getContent()%></pre>
        </div>
      </td>
    </tr>

    <!--4번째 행-->
    <tr>
      <td colspan="3">
<%--        <input type="button" value="목록" onclick="">--%>
        <input type="button"  value="목록" form="loginForm" onclick="history.go(-1)"/>
      </td>
    </tr>
  </table>
</form>
<%} %>

<script>
  function checkLogin(){
    document.getElementById("id").innerText == ""
    document.getElementById("pwd").innerText == ""

    if(document.getElementById("id").value == "")
      document.getElementById("idDiv").innerText="아이디을 입력하세요";
    else if(document.getElementById("pwd").value == "")
      document.getElementById("pwdDiv").innerText="비밀번호를 입력하세요";
    else
      document.loginForm.submit();
  }</script>




</body>
</html>
