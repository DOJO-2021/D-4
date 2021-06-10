<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>質問・相談システム(仮)|トップページ</title>
<Script>
'use strict'
function check(){

	var flag = 0;


	// 設定開始（必須にする項目を設定してください）
	// 「質問タグ」の入力をチェック
	if(document.search_form.Personal.value == "" ||
	   document.search_form.ITBasic.value == "" ||
	   document.search_form.JavaBasic.value == "" ||
	   document.search_form.WebAppDev.value == "" ||
	   document.search_form.LifeCounseling.value == "" ||
	   document.search_form.Error.value == "" ||
	   document.search_form.ComTrouble.value == "" ||
	   document.search_form.NetTrouble.value == "" ||
	   document.search_form.ITKnowledge.value == "" ||
	   document.search_form.ToAdmin.value == "" ||
	   document.search_form.Others.value == "" ||){

		flag = 1;

	}
	// 「キーワード」の入力をチェック
	else if(document.search_form.keyword.value == ""){

		flag = 1;

	}

	// 設定終了


	if(flag){

		window.alert('質問タグかキーワードを入力してください。'); // 入力漏れがあれば警告ダイアログを表示
		return false; // 送信を中止

	}
	else{

		return true; // 送信を実行

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
	<form method = "POST" action = "/D4_situmonn/TopServlet" name = "search_form" onSubmit = "return check()">
	<p>※質問タグもしくはキーワードのどちらかを入力してください</p>
		<div>
			質問タグ<br>
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

<!-- フッター -->
<jsp:include page = "/footer.jsp"/>
</div>
</body>
</html>