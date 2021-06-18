<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>質問・相談システム(仮)|トップページ</title>
	</head>
	<body>
		<div class="wrapper">
			<jsp:include page="/headernologin.jsp"/>
			<h2>検索結果</h2>
			<div class="vertical-scroll-table">
				<table class="searchresult"><!-- テーブルに罫線とスクロールバー -->
					<form method="GET" action="/D4_situmonn/AnswersDetailServlet">
						<c:forEach var="e" items="${QList}" >
							<tr>
								 <th>タイトル：</th>
								 <td><input type="submit" name="Q_TITLE" value="${e.q_title}"></td>
							</tr>
							<tr>
								<td><input type="hidden" name="Q_ID" value="${e.q_id}"></td>
								<th>質問者：</th>
								<td>${e.user_name}</td>
								<th>質問日時：</th>
								<td>${e.q_date}</td>
								<td>${e.done_tag}</td>
							</tr>
							<tr>
								<!--質問内容を先頭から100字表示する-->
								<td>${e.q_contents}</td>
							</tr>
						</c:forEach>
					</form>
				</table>
			</div>
			<jsp:include page="/footer.jsp"/>
		</div>
	</body>
</html>