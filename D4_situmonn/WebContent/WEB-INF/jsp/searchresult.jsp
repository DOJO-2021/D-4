<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>質問・相談システム(仮)|トップページ</title>
<link rel="stylesheet" href="/D4_situmonn/WEB-INF/css/common.css">
<link rel="stylesheet" href="/D4_situmonn/WEB-INF/css/searchresult.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c" rel="stylesheet">
	</head>
	<body>
		<div class="wrapper">
<header class = "header">
<h1>
   <div>
        <a href="/D4_situmonn/TopServlet"><img class="logo" src ="images/logo.png" alt="<!-- 商品名 -->"></a>
   </div>
</h1>
<nav class="gnav">
<img>
<ul class="gnav_inner">
    <li><a href="/D4_situmonn/Topservlet"><span>トップページ</span></a></li>
    <li><a href="/D4_situmonn/QuestionsPostServlet"><span>質問投稿ページ</span></a></li>
    <li><a href="/D4_situmonn/MypageServlet"><span>マイページ</span></a></li>
    <li><a href="/D4_situmonn/LoginServlet"><span>ログアウト</span></a></li>
</ul>
</nav>
</header>
			<jsp:include page="/headernologin.jsp"/>
			<h2>検索結果</h2>
			<div class="vertical-scroll-table">
				<table class="searchresult"><!-- テーブルに罫線とスクロールバー -->
					<c:forEach var="e" items="${QList}" >
						<form method="POST" action="/D4_situmonn/SearchResultServlet">
							<tr>
								 <td><input type="submit" name="Q_TITLE" value="タイトル：${e.q_title}"></td>
							</tr>
							<tr class="u_data">
								<td><input type="text" name="Q_ID" value="${e.q_id}"></td>
								<td>質問者：${e.user_name}</td>
								<td>質問日時：${e.q_date}</td>
								<td>${e.done_tag}</td>
							</tr>
							<tr class="contents">
								<!--質問内容を先頭から100字表示する-->
								<td colspan="4">${e.q_contents}</td>
							</tr>
						</form>

					</c:forEach>
				</table>
			</div>
			<jsp:include page="/footer.jsp"/>
		</div>
	</body>
</html>