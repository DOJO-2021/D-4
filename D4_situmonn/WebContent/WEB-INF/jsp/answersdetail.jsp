<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>質問相談システム(仮)|質問詳細</title>
		    <link rel="stylesheet" href="/D4_situmonn/css/common.css">
	<link rel="stylesheet" href="/D4_situmonn/css/questionspost.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c" rel="stylesheet">
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
            <form method = "POST" action = "/D4_situmonn/AnswersDetailServlet" onSubmit = "return check()">
			<c:forEach var="e" items="${QEdit}">
				<table class = "ansdetail">
					<tr>
						<td><input type="hidden" name="Q_ID" value="${e.q_id}"></td>
					</tr>
					<tr>
						<td class="title"colspan="4">${e.q_title}</td>
						<td class="done_tag">
                          <c:if test="${e.done_tag == 0}">未解決</c:if>
						  <c:if test="${e.done_tag == 1}">解決</c:if>
                        </td>
					</tr>
					<tr class="contents">
						<td colspan="5">${e.q_contents}</td>
					</tr>
					<tr>
						<th class="tag">質問タグ</th>
					</tr>
					<tr>
						<td>${e.q_tag01}</td>
						<td>${e.q_tag02}</td>
						<td>${e.q_tag03}</td>
						<td>${e.q_tag04}</td>
						<td>${e.q_tag05}</td>
					</tr>
					<tr>
						<th class="file">添付ファイル</th>
					<tr>
						<td>${e.q_file}</td>
					</tr>
				</table>
			</c:forEach>

                     <div class="scroll">
			<c:forEach var="e" items="${AnswerList}">

				<table class = answers>
					<tr>
						<td class="a_name">回答者名:${e.user_name}</td>
					</tr>
					<tr>
						<td class="a_contents">回答内容</td>
                                        </tr>
                                        <tr>
						<td colspan="5">${e.ans_contents}</td>
					</tr>
                                </table>
			</c:forEach>
                       </div>

				<table>
					<tr>
						<td class="ans">新規回答入力</td>
                                        </tr>
					<tr>
							<td><label><textarea name = "newanswer" placeholder="回答内容を入力してください。" rows="10" cols="150" required></textarea>
							    </label>
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