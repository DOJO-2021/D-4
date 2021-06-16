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
					<form method="POST" action="/D-4/SearchResultServlet">
						<c:forEach var="e" items="${QList}" >
							<tr>
								 <th>タイトル：</th>
								 <td><input type="submit" name="Q_TITLE" value="${e.q_title}"></td>
							</tr>
							<tr>
								<td><input type="hidden" name="Q_ID" value="${e.q_id}"></td>
								<th>質問者：</th>
								<td><input type="text" name="Q_NAME" value="${e.q_name}" readonly></td>
								<th>質問日時：</th>
								<td><input type="text" name="Q_DATE" value="${e.q_date}" readonly></td>
								<td><input type="text" name="DONE_TAG" value="${e.done_tag}" readonly></td>
							</tr>
							<tr>
								<!--<th>質問内容を先頭から100字表示する</th>-->
								<td><input type="text" name="Q_CONTENTS" value="${e.q_contents}" readonly></td>
							</tr>
						</c:forEach>
					</form>
				</table>
			</div>
			<jsp:include page="/footer.jsp"/>
		</div>
	</body>
</html>