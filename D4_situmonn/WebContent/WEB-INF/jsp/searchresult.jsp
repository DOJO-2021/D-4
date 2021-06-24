<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>質問・相談システム(仮)|トップページ</title>
<link rel="stylesheet" href="/D4_situmonn/css/common.css">
<link rel="stylesheet" href="/D4_situmonn/css/searchresult.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c" rel="stylesheet">
	</head>
	<body>
		<div class="wrapper">
		<!-- ここからヘッダー -->
			<jsp:include page="/header.jsp"/>
		<!-- ここからメイン -->
		<h2>検索結果</h2>
			<div class="vertical-scroll-table">
			<c:forEach var="e" items="${QList}" >
				<form method="POST" action="/D4_situmonn/SearchResultServlet">
						<table class="searchresult"><!-- テーブルに罫線とスクロールバー -->
							<tr>
								 <td><input type="submit" name="Q_TITLE" value="タイトル：${e.q_title}"></td>
							</tr>
							<tr class="u_data">
								<td><input type="hidden" name="Q_ID" value="${e.q_id}"></td>
								<td>質問者：${e.user_name}</td>
								<td>質問日時：${e.q_date}</td>
								<td>
									<c:if test="${e.done_tag == 0}">未解決</c:if>
	  								<c:if test="${e.done_tag == 1}">解決</c:if>
	  							</td>
							</tr>
							<tr class="contents">
								<!--質問内容を先頭から100字表示する-->
								<td colspan="4">${e.q_contents}</td>
							</tr>
						</table>
					</form>
				</c:forEach>
			</div>
			<!-- ここからフッター -->
			<jsp:include page="/footer.jsp"/>
		</div>
	</body>
</html>