<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="member.dao.MemberDAO" %>
<%@ page import="member.bean.MemberDTO" %>
<%
  request.setCharacterEncoding("UTF-8");

//데이터
  //세션으로부터 id 가져오기.
  String id = (String)session.getAttribute("memId");


//DB
//싱글톤 스타일
  MemberDAO memberDAO = MemberDAO.getInstance(); //new MemberDAO() 대신
  MemberDTO member = memberDAO.getMember(id); //호출

  String name =  member.getName();
  //String id =  member.getId();
  String pwd =  member.getPwd();
  String gender =  member.getGender();
  String email1 =  member.getEmail1();
  String email2 =  member.getEmail2();
  String tel1 =  member.getTel1();
  String tel2 =  member.getTel2();
  String tel3 =  member.getTel3();
  String zipcode =  member.getZipcode();
  String addr1 =  member.getAddr1();
  String addr2 =  member.getAddr2();

%>

<html>
<head>
  <title>회원정보 수정</title>
  <meta charset="UTF-8">
  <style>
    td {
      color: black;
    }

    div{
      color: red;
      font-size: 8pt;
      font-weight: bold;
    }
  </style>
</head>
<body onload="pick()">

<form name="updateForm" method="post" action="update.jsp">
  <br>
  <table border="1" cellpadding="5" cellspacing="0">
    <!--첫번째 행-->
    <tr>
      <th width="80px">이름</th>
      <td><input type="text" name="name" id="name" value = "<%=name%>" placeholder="이름 입력" style="width: 40%">
        <div id="nameDiv"></div>
      </td>
    </tr>
    <!--2번째 행-->
    <tr>
      <th>아이디</th>
      <td><input  type="text" name="id" id="id" value = "<%=id%>" placeholder="아이디 입력" readonly style="width: 50%">
        <div id="idDiv"></div>
      </td>
    </tr>
    <!--3번째 행-->
    <tr>
      <th>비밀번호</th>
      <td><input type="password" name="pwd" id="pwd" value = "<%=pwd%>" style="width: 60%">
        <div id="pwdDiv"></div>
      </td>
    </tr>
    <!--4번째 행-->
    <tr>
      <th>재확인</th>
      <td><input type="password" name="repwd" id="repwd" value = "<%=pwd%>" style="width: 60%">
      </td>
    </tr>

    <!--5번째 행-->
    <tr>
      <th>성별</th>
      <td>
        <label for="gender_w">여성<input type="radio" name="gender" id="gender_w" value="0"
          <%=gender.equals("0") ? "checked" : "" %>>
        </label>
        &nbsp;
        <label for="gender_m">남성<input type="radio" name="gender" id="gender_m" value="1"
          <%=gender.equals("1") ? "checked" : "" %>>
        </label>
        <div id="ageDiv"></div>
      </td>
    </tr>

    <!--6번째 행-->
    <tr>
      <th>이메일</th>
      <td><input type="text" name="email1" value = "<%=email1%>" style="width: 30%">&nbsp;@
        <input type="text" name="email2" id="email2" value = "<%=email2%>" style="width: 30%">
        <select name="email3" id="email3" style="width:25%" onchange="select()">
          <option value="">직접입력</option>
          <option value="naver.com">naver.com</option>
          <option value="gmail.com">gmail.com</option>
          <option value="nate.com">nate.com</option>
        </select>
      </td>
    </tr>

    <!--7번째 행-->
    <tr>
      <th>휴대폰</th>
      <td>
        <select name="tel1" style="width:15%">
          <option value="010" <%=tel1.equals("010") ? "selected" : "" %>>010</option>
          <option value="011" <%=tel1.equals("011") ? "selected" : "" %>>011</option>
          <option value="016" <%=tel1.equals("016") ? "selected" : "" %>>016</option>
        </select>&nbsp;-&nbsp;
        <input type="text" name="tel2" value = "<%=tel2%>" style="width:15%">&nbsp;-&nbsp;
        <input type="text" name="tel3" value = "<%=tel3%>" style="width:15%">

      </td>
    </tr>

    <!--8번째 행-->
    <tr>
      <th>주소</th>
      <td>
        <input type="text" name="zipcode" id="zipcode" value = "<%=zipcode%>" style="width:40%; margin:2px" readonly>&nbsp;
        <input type="button" value="우편번호 검색" style="width:25%" onclick="execDaumPostcode()"><br>
        <input type="text" name="addr1" id="addr1" value = "<%=addr1%>" placeholder="주소" style="width:90%; margin:2px" readonly><br>
        <input type="text" name="addr2" id="addr2"  value = "<%=addr2%>" placeholder="상세주소" style="width:90%; margin:2px">
      </td>
    </tr>


    <!--9번째 행-->
    <tr>
      <td colspan="2" align="center">
        <input type="button" value="회원정보 수정" onclick="checkUpdate()">
        <input type="reset" value="다시작성">
      </td>
    </tr>

  </table>
</form>


<script type="text/javascript" src="../js/member.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
  function pick(){
    document.updateForm.gender[<%=member.getGender()%>].checked = true;
    //document.updateForm.tel1.value = '<%=member.getTel1()%>';
    //document.getElementById("email2").value = <%=member.getEmail2()%>

  }
</script>

</body>
</html>
