<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>質問相談システム(仮)|質問詳細</title>
		<script>
		'use strict';
		function check(){
			if(window.confirm('回答を送信してもよろしいですか？')){ // 確認ダイアログを表示
				return true; // 「OK」時は送信を実行
			}
		}
		</script>
	</head>

	<body>
		<div class = "wrapper">
			<!-- ここからヘッダー -->
			<jsp:include page = "/header.jsp"/>
			<h2>質問詳細ページ</h2>

			<!-- ここからメイン -->

			<c:forEach var="e" items="${QList}">
				<table class = "ansdetail">
					<tr>
						<td>${e.q_id}</td>
					</tr>
					<tr>
						<th>質問内容<th>
						<td><input type="hidden" name="Q_ID" value="${e.q_title}"></td>
						<td>${e.done_tag}</td>
					</tr>
					<tr>
						<th>質問内容</th>
						<td>${e.q_contents}</td>
					</tr>
					<tr>
						<th>質問タグ</th>
					</tr>
					<tr>
						<td>${e.q_tag01}</td>
						<td>${e.q_tag02}</td>
						<td>${e.q_tag03}</td>
						<td>${e.q_tag04}</td>
						<td>${e.q_tag05}</td>
					</tr>
					<tr>
						<th>添付ファイル</th>
					<tr>
						<td>${e.q_file}</td>
					</tr>
				</table>
			</c:forEach>

			<c:forEach var="e" items="${AnswerList}">

				<table class = answers>
					<tr>
						<th>回答者名</th>
						<td>${e.user_name}</td>
					</tr>
					<tr>
						<th>回答内容</th>
						<td>${e.ans_contents}</td>
					</tr>
				</table>
			</c:forEach>

			<form method = "POST" action = "/D4_situmonn/AnswerDetailServlet" onSubmit = "return check()">
				<table>
					<tr>
						<th>新規回答入力</th>
						<td>
							<label><textarea name = "newanswer">
							</textarea></label>
						</td>
					</tr>
				</table>
				<input type = "submit" name = "submit" value = "回答">
			</form>

			<!-- フッター -->
			<jsp:include page = "/footer.jsp"/>
		</div>
	</body>
</html>