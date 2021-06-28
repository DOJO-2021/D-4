<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Qbox|質問詳細</title>
		    <link rel="stylesheet" href="/D4_situmonn/css/common.css">
	<link rel="stylesheet" href="/D4_situmonn/css/answersdetail.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c" rel="stylesheet">
		<script>
		'use strict';
		function check(){
			if(window.confirm('回答を送信してもよろしいですか？')){ // 確認ダイアログを表示
				return true; // 「OK」時は送信を実行
			}
			else{ // 「キャンセル」時の処理
				return false; // 送信を中止
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
						<td class="title"colspan="3" align="left">${e.q_title}</td>
						<td class="done_tag">
                          <c:if test="${e.done_tag == 0}">未解決</c:if>
						  <c:if test="${e.done_tag == 1}">解決</c:if>
                        </td>
					</tr>
					<tr class="contents" align="left">
						<td colspan="5">${e.q_contents}</td>
					</tr>
                    <tr class="q_tag">
	                  <td align="left"><c:if test="${!empty e.q_tag01}">#${e.q_tag01}</c:if></td>
	                  <td align="left"><c:if test="${!empty e.q_tag02}">#${e.q_tag02}</c:if></td>
	                  <td align="left"><c:if test="${!empty e.q_tag03}">#${e.q_tag03}</c:if></td>
	                  <td align="left"><c:if test="${!empty e.q_tag04}">#${e.q_tag04}</c:if></td>
	                  <td align="left"><c:if test="${!empty e.q_tag05}">#${e.q_tag05}</c:if></td>
                    </tr>
					<tr>
						<th class="file">添付ファイル</th>
					<tr>
						<td colspan="5" align="left"><a href="${e.q_file}">${e.q_file}</a></td>
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
						<td colspan="5" align="left">${e.ans_contents}</td>
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