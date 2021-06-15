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

<table class = "ansdetail">
<tr>
  <td>質問内容<br>${QEdit.q_contents}
  </td>
  <td>${QEdit.done_tag}</td>
</tr>
<tr>
  <td>質問内容<br>${QEdit.q_contents}</td>
</tr>
<tr>
<td>質問タグ<br>${QEdit.q_tag01}・${QEdit.q_tag02}・${QEdit.q_tag03}・${QEdit.q_tag04}・${QEdit.q_tag05}</td>
</tr>
<tr>
<td>${QEdit.q_file}</td>
</tr>
</table>

<c:forEach var="e" items="${AnswerList}">

<table class = answers>
<tr>
  <td>回答者名<br></td>
</tr>
<tr>
  <td>回答内容<br></td>
</tr>
</table>

</c:forEach>

<form method = "POST" action = "/D4_situmonn/AnswerDetailServlet" onSubmit = "return check()">
<table>
<tr>
  <td>新規回答入力<br>
    <label><textarea name = "newanswer">
    </textarea></label>
  </td>
</tr>
<tr>
  <td>
    <input type = "submit" name = "submit" value = "回答">
  </td>
</tr>
</table>
</form>

<!-- フッター -->
<jsp:include page = "/footer.jsp"/>
</div>
</body>
</html>