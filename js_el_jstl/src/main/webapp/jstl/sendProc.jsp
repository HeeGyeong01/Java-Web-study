<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<%
  List<String> list = new ArrayList<String>();
  list.add("호랑이");
  list.add("사자");
  list.add("기린");
  list.add("여우");
  list.add("늑대");

//객체는 주소로 넘길 수 없다.
  request.setAttribute("list", list);

response.sendRedirect("sendResult.jsp");
%>