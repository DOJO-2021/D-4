<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>質問・相談システム(仮) | トップページ</title>
</head>
<body>
<div class = "wrapper">
<jsp:include page = "/header.jsp"/>
<h2>トップページ</h2>
	<form method = "POST" action = "/D4_situmonn/TopServlet">
		<div>
			質問種別<br>
			<input type = "checkbox" name = "questions_tag" value = "Personal">パーソナルコース
			<input type = "checkbox" name = "questions_tag" value = "ITBasic">IT基礎コース
			<input type = "checkbox" name = "questions_tag" value = "JavaBasic">Java基礎コース
			<input type = "checkbox" name = "questions_tag" value = "WebAppDev">Webアプリ開発<br>

			<input type = "checkbox" name = "questions_tag" value = "LifeCounseling">人生相談
			<input type = "checkbox" name = "questions_tag" value = "Error">エラー対応
			<input type = "checkbox" name = "questions_tag" value = "ComTrouble">機器トラブル
			<input type = "checkbox" name = "questions_tag" value = "NetTrouble">ネットワークトラブル<br>

			<input type = "checkbox" name = "questions_tag" value = "ITKnowledge">IT知識
			<input type = "checkbox" name = "questions_tag" value = "ToAdmin">運営事務局宛て
			<input type = "checkbox" name = "questions_tag" value = "Others">その他
		</div>
		<div>
			<label>キーワード<br>
			<input type = "text" name = "keyword"></label>
		</div>
		<div>
			<input type = "radio" name = "solution_label" value = "solved" checked>解決済
			<input type = "radio" name = "solution_label" value = "unsolved">未解決
		</div>
		<input type = "submit" name = "search" value = "検索">
	</form>
<jsp:include page = "/footer.jsp"/>
</div>
</body>
</html>