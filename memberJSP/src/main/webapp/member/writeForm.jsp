<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>writeForm</title>

    <style type="text/css">
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
<body>


<form name="writeForm" method="post" action="write.jsp">
    <br>
    <table border="1" cellpadding="5">
        <!--첫번째 행-->
        <tr>
            <th width="80px">이름</th>
            <td><input type="text" name="name" id="name" placeholder="이름 입력" style="width: 40%">
                <div id="nameDiv"></div>
            </td>
        </tr>
        <!--2번째 행-->
        <tr>
            <th>아이디</th>
            <td><input  type="text" name="id" id="id" placeholder="아이디 입력" style="width: 50%">
                <div id="idDiv"></div>
            </td>
        </tr>
        <!--3번째 행-->
        <tr>
            <th>비밀번호</th>
            <td><input type="password" name="pwd" id="pwd" style="width: 60%">
                <div id="pwdDiv"></div>
            </td>
        </tr>
        <!--4번째 행-->
        <tr>
            <th>재확인</th>
            <td><input type="password" name="repwd" id="repwd" style="width: 60%">
            </td>
        </tr>

        <!--5번째 행-->
        <tr>
            <th>성별</th>
            <td>
                <input type="radio" name="gender" id="gender_w" value="0" checked="checked">
                <label for="gender_w">여성</label>
                &nbsp;
                <input type="radio" name="gender" id="gender_m" value="1">
                <label for="gender_m">남성</label>
                <div id="ageDiv"></div>
            </td>
        </tr>

        <!--6번째 행-->
        <tr>
            <th>이메일</th>
            <td><input type="text" name="email1" style="width: 30%">&nbsp;@
                <input type="text" name="email2" id="email2" style="width: 30%">
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
                    <option value="010" selected>010</option>
                    <option value="011">011</option>
                    <option value="016">016</option>
                </select>&nbsp;-&nbsp;
                <input type="text" name="tel2" style="width:15%">&nbsp;-&nbsp;
                <input type="text" name="tel3" style="width:15%">

            </td>
        </tr>

        <!--8번째 행-->
        <tr>
            <th>주소</th>
            <td>
                <input type="text" name="zipcode" id="zipcode" style="width:40%" readonly>&nbsp;
                <input type="button" value="우편번호 검색" style="width:25%" onclick="execDaumPostcode()"><br>
                <input type="text" name="addr1" id="addr1" placeholder="주소" style="width:90%" readonly><br>
                <input type="text" name="addr2" id="addr2"  placeholder="상세주소" style="width:90%">
            </td>
        </tr>


        <!--9번째 행-->
        <tr>
            <td colspan="2" align="center">
                <input type="button" value="회원가입" onclick="checkWrite()">
                <input type="reset" value="다시작성">
            </td>
        </tr>

    </table>
</form>


<!--절대주소: src="http://localhost:8080/js/member.js" -->
<script type="text/javascript" src="../js/member.js"></script>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>


</body>
</html>
