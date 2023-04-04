<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jstl.PersonDTO" %>

<%
    List<String> list = new ArrayList<String>();
    list.add("호랑이");
    list.add("사자");
    list.add("기린");
    list.add("여우");
    list.add("늑대");

    PersonDTO aa = new PersonDTO("홍길동", 25);
    PersonDTO bb = new PersonDTO("라이언", 23);
    PersonDTO cc= new PersonDTO("프로도", 30);

    List<PersonDTO> list2 = new ArrayList<PersonDTO>();
    list2.add(aa);
    list2.add(bb);
    list2.add(cc);

//객체는 주소로 넘길 수 없다.
    request.setAttribute("list", list);

//페이지 이동
    RequestDispatcher dispatcher = request.getRequestDispatcher("forwardResult.jsp");//상대번지
    dispatcher.forward(request, response); //제어권 넘기기

%>
<%--이제 아래와 같이 태그로 작성 안함--%>
<%--<jsp:forward page="forwardResult.jsp"/>--%>