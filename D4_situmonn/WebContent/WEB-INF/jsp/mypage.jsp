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

<form method="GET" action="/D4_situmonn/QuestionEditServlet">
<table class=scroll><!-- テーブルに罫線(タグで指定)とスクロールバー -->
 <caption>自分のした質問</caption>
 <c:forEach var="e" items="${QList}" >
  <tr>
    <th>${e.q_title}</th>
    <th><input type="submit" name="editbutton" value="編集"></th>
  </tr>
  <tr>
  	<td><input type="hidden" name="q_id" value="${e.q_id}"></td>
    <th>${e.q_date}</th>
    <th><c:if test="${e.done_tag == 0}">未解決</c:if>
		<c:if test="${e.done_tag == 1}">解決</c:if>
	</th>
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
</form>
			<table class=scroll><!-- テーブルに罫線(タグで指定)とスクロールバー -->
				<caption>自分のした質問</caption>
				<c:forEach var="e" items="${QList}" >
					<form method="GET" action="/D4_situmonn/QuestionEditServlet">
						<tr>
							<th>${e.q_title}</th>
							<th><input type="submit" name="editbutton" value="編集"></th>
						</tr>
						<tr>
							<td><input type="hidden" name="q_id" value="${e.q_id}"></td>
							<th>${e.q_date}</th>
							<th>
							<c:if test="${e.done_tag == 0}">未解決</c:if>
							<c:if test="${e.done_tag == 1}">解決</c:if>
							</th>
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
					</form>
				</c:forEach>
			</table>
			<jsp:include page="/footer.jsp"/>
		</div>
	</body>
</html>