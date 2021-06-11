<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Coreタグライブラリへのパスを書く -->
<!-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>質問相談システム(仮)|質問詳細</title>
<Script>
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
  <td><!-- 質問内容のEL式 --></td>
  <td><!-- 解決・未解決ラベルのEL式 --></td>
</tr>
<tr>
  <td><!-- 質問内容のEL式 --></td>
</tr>
<tr>
<td><!-- 質問タグのEL式 --></td>
</tr>
<tr>
<td><!-- 添付ファイルのリンク表示 --></td>
</tr>
</table>

<!-- <c:forEach> で繰り返し -->

<table class = answers>
<tr>
  <td><!-- 回答者名のEL式 --></td>
</tr>
<tr>
  <td><!-- 回答内容のEL式 --></td>
</tr>
</table>

<!-- </c:forEach>  -->

<form method = "POST" action = "/D4_situmonn/AnswerDetailServlet">
<table>
<tr>
  <th>新規回答入力</th>
  <td>
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