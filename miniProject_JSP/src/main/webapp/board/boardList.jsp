<%@ page import="board.bean.BoardDTO" %>
<%@ page import="board.dao.BoardDAO" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.List" %>
<%@ page import="board.bean.BoardPaging" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  //데이터
  String id = (String)session.getAttribute("memId");
  String searchField = null;
  String columnName = null;
  int pg = 0;

  //그냥 접근하눈 경우 pg 파라미터만 전달됨.
  //검색 버튼 눌러서 접근하는 경우 파라미터 3개 다 전달됨.
  pg = Integer.parseInt(request.getParameter("pg"));
  searchField = request.getParameter("searchField");
  String searchWord = request.getParameter("searchWord");

  List<BoardDTO> list = null;
  int totalA = 0;
  int pageSize = 5;
  int endNum = pg * 5;
  int startNum = endNum - 4;

  if(searchField == null) { //전체 게시물 출력하는 경우

    //페이징 처리 - 1페이지당 게시물 2개씩 보여줌.
    //pg=1    RN>=1 AND RN<=2  //pg=2    RN>=3 AND RN<=4
    BoardDAO boardDAO = BoardDAO.getInstance();
    totalA = boardDAO.getTotalA();

    Map<String, Integer> map = new HashMap<String, Integer>();
    map.put("startNum", startNum);
    map.put("endNum", endNum);
    list = boardDAO.getBoardList(map);


  }else if(searchField != null){ //검색 결과 출력하는 경우
    if(searchField.equals("writer"))
      columnName = "id";
    else if(searchField.equals("subject"))
      columnName = "subject";


    Map<String, String> map = new HashMap<String, String>();
    map.put("columnName", columnName);
    map.put("value", searchWord);
    map.put("startNum", Integer.toString(startNum));
    map.put("endNum", Integer.toString(endNum));

    BoardDAO boardDAO = BoardDAO.getInstance();
    list = boardDAO.search(map);
    totalA = boardDAO.searchSize(map);

  }


  //페이징 처리
  BoardPaging boardPaging = new BoardPaging();
  boardPaging.setCurrentPage(pg);
  boardPaging.setPageBlock(3);
  boardPaging.setPageSize(pageSize);
  boardPaging.setTotalA(totalA);


%>
<html>
<head>
  <title>Title</title>
  <style>
      table, td, th{
        border-collapse: collapse;
      }
      table{margin: 10px 10px 10px 30px;}
      td{text-align: center}
      #td_subject{text-align: left}
      div {float: left; width: 20px; height: 20px; margin-left: 10px; padding: 5px; text-align: center;}
      span, .subjectA{ cursor: pointer}

      .subjectA:link{color: black;}
      .subjectA:visited{color: black;}
      .subjectA:hover{color: deeppink; text-decoration: underline;}
      .subjectA:active{color: purple; text-decoration: none;}

      #currentPaging {float: left; color: red; text-decoration: underline; border: 1px solid red;
        padding: 5px; margin: 5px;
      }
      #paging {float: left; color: gray; text-decoration: none;
        padding: 5px; margin: 5px;}
      #currentDiv {float: left; border: 1px red solid; width: 20px; height: 20px; margin-left: 10px; padding: 5px; text-align: center;}
      #pagingDiv{float: left}
  </style>
</head>
<body>
<img src="../image/winter.png" width="50" height="50" alt="겨울 이미지"
     onclick="location.href='../index.jsp'" style="cursor: pointer"> 글목록<br>

<table border="1" cellpadding="5" cellspacing="0" frame="hsides" rules="rows">
  <%--컬럼명--%>
  <tr>
    <td style=width:50px; align="center">글번호</td>
    <td style=width:250px; align="center">제목</td>
    <td style=width:100px; align="center">작성자</td>
    <td style=width:50px; align="center">조회수</td>
    <td style=width:150px; align="center">작성일</td>
    </tr>

  <%
    if(list != null){
      for(BoardDTO board: list){
  %>

  <%--게시글--%>
  <tr>
    <td> <%=board.getSeq()%></td>
    <td id="td_subject">
      <a class="subjectA"  onclick="checkLogin('<%=id%>',<%=board.getSeq()%>,<%=pg%>)"><%=board.getSubject()%></a>
    </td>
    <td> <%=board.getId()%> </td>
    <td> <%=board.getHit()%></td>
    <td> <%=new SimpleDateFormat("yyyy.MM.dd").format(board.getLogtime())%></td>
    </tr>
<%}}%>
  </table>

<%--페이징 --%>
<div style="margin-top: 15px; width: 600px; text-align: center;">
  <%=boardPaging.makePagingHTML()%>
</div>


<div>

  <select name="searchField" id="searchField">
    <option value="writer" selected>작성자</option>
    <option value="subject">제목</option>
  </select>

  <input type="text" name="searchWord" id="searchWord" size="20">

  <input type="button" value="검색" onclick="checkSearch()">

</div>




<script>
  function boardPaging(pg){
    if(<%=searchField == null%>) //전체 게시물 보기에서 페이지 전환
      location.href = "boardList.jsp?pg=" + pg;
    else if(<%=searchField != null%>)  //검색 결과에서 페이지 전환
      location.href = "boardList.jsp?searchField="+ "<%=searchField%>"+ "&searchWord=" + "<%=searchWord%>" + "&pg=" + pg;

  }

  function checkLogin(id, seq, pg){
    //로그인 되어 있을 때
    if(id != null){
      location.href = "./boardView.jsp?seq="+ seq + "&pg="+pg;
    }else{ //로그인 하지 않았을 때 %>
      alert("먼저 로그인하세요");

    }
  }

  function checkSearch(){
    if(document.getElementById("searchWord").value == "")
      location.href = "boardList.jsp?pg=1"; //검색어 입력하지 않은 경우 모든 게시물 볼 수 있게 함.
    else //검색어를 입력한 경우 parameter로 searchField, searchWord, pg 넘겨줌.
      location.href = "boardList.jsp?searchField="+ document.getElementById("searchField").value
          + "&searchWord=" +  document.getElementById("searchWord").value + "&pg=1";
  }
</script>


</body>
</html>