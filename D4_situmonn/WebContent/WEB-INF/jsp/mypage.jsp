<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>質問・相談システム(仮)|マイページ</title>
</head>
<body>
<div class="wrapper">
<jsp:include page="/headernologin.jsp"/>
<h2>マイページ</h2>

<table><!-- テーブルに罫線(タグで指定) -->
 <caption>プロフィール</caption>
 <c:forEach var="e" items="${cardList}" >
  <tr>
    <th>${e.user_id}</th>
    <th>${e.user_name}</th>
  </tr>
  <tr>
    <th>${e.company}</th>
    <th>${e.user_category}</th>
  </tr>
  </c:forEach>
</table>
<a href="/D4_situmonn/ProfileEditServlet">プロフィール編集</a>


<table class=scroll><!-- テーブルに罫線(タグで指定)とスクロールバー -->
 <caption>自分のした質問</caption>
 <c:forEach var="e" items="${QList}" >
  <tr>
    <th>${e.q_title}</th>
    <th><a href="/D4_situmonn/QeustionEditServlet">編集</a></th>
  </tr>
  <tr>
    <th>${e.q_date}</th>
    <th>${e.done_tag}</th>
  </tr>
  <tr>
    <th>${e.q_tag01}</th>
    <th>${e.q_tag02}</th>
    <th>${e.q_tag03}</th>
    <th>${e.q_tag04}</th>
    <th>${e.q_tag05}</th>
  </tr>
  <tr>
    <th>${e.q_contents}</th>
  </tr>
</c:forEach>
</table>

<jsp:include page="/footer.jsp"/>
</div>
</body>
</html>