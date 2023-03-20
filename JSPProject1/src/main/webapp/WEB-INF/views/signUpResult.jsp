
<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입 결과 </title>
</head>
<body>



<%

String inputId = request.getParameter("inputId");
String inputName = request.getParameter("inputName");
String inputEmail = request.getParameter("inputEmail");
String inputPw[] = request.getParameterValues("inputPw");

String hobby[] = request.getParameterValues("hobby");


%>

<%  if(!inputPw[0].equals(inputPw[1])) { %>
<h3>비밀번호가 일치하지 않습니다</h3>
<% } else{  %>



<ul>
<li>아이디 : <%= inputId %></li>
<li>비밀번호 : <%=inputPw[0] %></li>
<li>이름 : <%= inputName %></li>
<li>이메일 : <%= inputEmail %></li>
<li>취미 : 
<% for(String h : hobby ){ %>
<%= h %>
<% } %>

</li>
</ul>

<h3><%= inputName  %> 의 회원가입이 완료되었습니다</h3>
<%} %>
</body>
</html>