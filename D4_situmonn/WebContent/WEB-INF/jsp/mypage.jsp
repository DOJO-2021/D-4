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
<jsp:include page="/header.jsp"/>
<h2>マイページ</h2>

<div class="profile">
<c:forEach var="e" items="${cardList}" >
  <table>
    <tr>
	<td colspan="10">${e.user_name}</td>
    </tr>
    <tr>
	<td colspan="10">${e.user_id}</td>
    </tr>
    <tr>
	<td colspan="5">${e.company}</td>
	<td colspan="5">${e.user_category}</td>
    </tr>
   </table>
</c:forEach>
</div>
	<div  class="profileedit">
	<a href="/D4_situmonn/ProfileEditServlet">プロフィール編集</a>
	</div>



<div class="scrollbar">
<c:forEach var="e" items="${QList}" >
<form method="GET" action="/D4_situmonn/QuestionEditServlet">
  <table class="scroll"><!-- テーブルに罫線(タグで指定)とスクロールバー -->
    <tr>
	<td colspan="5" class="title" align="left">${e.q_title}</td>
	<td><input type="submit" name="editbutton" value="編集"></td>
    </tr>
    <tr>
	<td class="q_data" align="left">${e.q_date}</td>
	<td class="q_data" align="left">
	  <c:if test="${e.done_tag == 0}">未解決</c:if>
	  <c:if test="${e.done_tag == 1}">解決</c:if>
	</td>
	<td  class="q_data"><input type="hidden" name="q_id" value="${e.q_id}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr class="q_tag">
	<td align="left"><c:if test="${!empty e.q_tag01}">#${e.q_tag01}</c:if></td>
	<td align="left"><c:if test="${!empty e.q_tag02}">#${e.q_tag02}</c:if></td>
	<td align="left"><c:if test="${!empty e.q_tag03}">#${e.q_tag03}</c:if></td>
	<td align="left"><c:if test="${!empty e.q_tag04}">#${e.q_tag04}</c:if></td>
	<td align="left"><c:if test="${!empty e.q_tag05}">#${e.q_tag05}</c:if></td>
    </tr>
    <tr>
	<td class="q_data" colspan="5" class="contents" align="left">${e.q_contents}</td>
    </tr>
  </table>
</form>
</c:forEach>
</div>

<jsp:include page="/footer.jsp"/>
</div>
</body>
</html>