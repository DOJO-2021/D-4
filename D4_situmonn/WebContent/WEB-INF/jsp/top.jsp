<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>質問・相談システム(仮)|トップページ</title>
<Script>
'use strict'
function isCheck() {

	const keyword = document.getElementById("key");
	const keyValue = keyword.value;
	let keyflag = 0;
	if (keyValue === ""){
		keyflag = 1;
	}

				var arr_checkBoxes = document.getElementsByClassName("checkboxes");
				var arr = Array.from(arr_checkBoxes);
				let count = 0;
				for (let i = 0; i < arr_checkBoxes.length; i++) {
					if (arr_checkBoxes[i].checked) {
						count++;
					}
				}
				if (count >= 1 || keyflag != 1) {
					return true;
				} else{
					window.alert("項目を1つ以上選択してください。");
					return false;
				}
}
</Script>

</head>
<body>
<div class = "wrapper">
<!-- ヘッダー -->
<jsp:include page = "/header.jsp"/>

<!-- メイン -->
<h2>トップページ</h2>
	<form method = "POST" action = "/D4_situmonn/TopServlet" name = "search_form">
	<p>※質問タグもしくはキーワードのどちらかは必ず入力してください</p>
		<div>
			質問タグ<br>
			<input class="checkboxes" type = "checkbox" name = "questions_tag1" value = "パーソナルコース">パーソナルコース
			<input class="checkboxes" type = "checkbox" name = "questions_tag2" value = "IT基礎コース">IT基礎コース
			<input class="checkboxes" type = "checkbox" name = "questions_tag3" value = "Java基礎コース">Java基礎コース
			<input class="checkboxes" type = "checkbox" name = "questions_tag4" value = "Webアプリ開発">Webアプリ開発<br>

			<input class="checkboxes" type = "checkbox" name = "questions_tag5" value = "人生相談">人生相談
			<input class="checkboxes" type = "checkbox" name = "questions_tag6" value = "エラー対応">エラー対応
			<input class="checkboxes" type = "checkbox" name = "questions_tag7" value = "機器トラブル">機器トラブル
			<input class="checkboxes" type = "checkbox" name = "questions_tag8" value = "ネットワークトラブル">ネットワークトラブル<br>

			<input class="checkboxes" type = "checkbox" name = "questions_tag9" value = "IT知識">IT知識
			<input class="checkboxes" type = "checkbox" name = "questions_tag10" value = "運営事務局宛て">運営事務局宛て
			<input class="checkboxes" type = "checkbox" name = "questions_tag11" value = "その他">その他
		</div>
		<div>
			<label>キーワード<br>
			<input type = "text" name = "keyword" id = "key"></label>
		</div>
		<div>
			<input type = "radio" name = "solution_label" value = "1" checked required>解決済
			<input type = "radio" name = "solution_label" value = "0">未解決
		</div>
		<input type = "submit" name = "search" value = "検索" onClick="return isCheck()">
	</form>

<!-- フッター -->
<jsp:include page = "/footer.jsp"/>
</div>
</body>
</html>