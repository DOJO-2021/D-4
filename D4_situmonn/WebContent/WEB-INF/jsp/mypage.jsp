<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Qbox|マイページ</title>
<link rel="stylesheet" href="/D4_situmonn/css/common.css">
<link rel="stylesheet" href="/D4_situmonn/css/mypage.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c" rel="stylesheet">


</head>
<body bgcolor="#35a0d9">
<div class="wrapper">
<jsp:include page="/headernologin.jsp"/>
<h2>マイページ</h2>


<c:forEach var="e" items="${cardList}" >
  <table class="profile">
    <tr>
	<td colspan="2">${e.user_name}</td>
    </tr>
    <tr>
	<td colspan="2">${e.user_id}</td>
    </tr>
    <tr>
	<td>${e.company}</td>
	<td>${e.user_category}</td>
    </tr>
    <tr>
	<td colspan="2">
	<a href="/D4_situmonn/ProfileEditServlet" class="profileedit">プロフィール編集</a>
	</td>
    </tr>
  </table>
</c:forEach>


<c:forEach var="e" items="${QList}" >
<form method="GET" action="/D4_situmonn/QuestionEditServlet">
<div class="scrollbar">
  <table class="scroll"><!-- テーブルに罫線(タグで指定)とスクロールバー -->
    <tr>
	<td colspan="5" bgcolor="#0067c0" class="left" id="title">${e.q_title}</td>
	<td><input type="submit" name="editbutton" value="編集"></td>
    </tr>
    <tr>
	<td bgcolor="#0067c0">${e.q_date}</td>
	<td bgcolor="#0067c0">
	  <c:if test="${e.done_tag == 0}">未解決</c:if>
	  <c:if test="${e.done_tag == 1}">解決</c:if>
	</td>
	<td><input type="hidden" name="q_id" value="${e.q_id}"></td>
    </tr>
    <tr>
	<td>${e.q_tag01}</td>
	<td>${e.q_tag02}</td>
	<td>${e.q_tag03}</td>
	<td>${e.q_tag04}</td>
	<td>${e.q_tag05}</td>
    </tr>
    <tr>
	<td colspan="5" class="left">${e.q_contents}</td>
    </tr>
  </table>
</div>
</form>
</c:forEach>

<jsp:include page="/footer.jsp"/>
</div>
</body>
</html>