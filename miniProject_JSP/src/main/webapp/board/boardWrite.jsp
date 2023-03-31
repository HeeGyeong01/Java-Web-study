<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="board.bean.BoardDTO" %>
<%@ page import="board.dao.BoardDAO" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>

<%
  request.setCharacterEncoding("UTF-8");

  //데이터
  String subject = request.getParameter("subject");
  String content = request.getParameter("content");
  //세션
  String id = (String)session.getAttribute("memId");
  String name = (String)session.getAttribute("memName");
  String email = (String)session.getAttribute("memEmail");

  Map<String, String> map = new HashMap<String, String>();
  map.put("id", id);
  map.put("name", name);
  map.put("email", email);
  map.put("subject", subject);
  map.put("content", content);


  //DB
  //싱글톤 스타일
  BoardDAO boardDAO = BoardDAO.getInstance(); //new MemberDAO() 대신
  int updateCount = boardDAO.boardWrite(map); //호출



%>
<html>
<head>
  <title>Title</title>
</head>
<body>

<script>
  <% if(updateCount == 0) { %>
    window.onload = function(){
    alert("글 작성 실패");
    location.href = "./boardWriteForm.jsp";
  }
  <%}else {%>
    window.onload = function(){
    alert("글작성 완료");
    location.href = "../index.jsp?pg=1";
  }
  <%}%>
</script>


</body>
</html>
