<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Qbox|トップページ</title>
<link rel="stylesheet" href="/D4_situmonn/css/common.css">
<link rel="stylesheet" href="/D4_situmonn/css/top.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c" rel="stylesheet">

<script>
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
</script>
</head>

<body bgcolor="#35a0d9">
<div class = "wrapper">
<!-- ヘッダー -->
<jsp:include page = "/header.jsp"/>

<!-- メイン -->
<main>
<h2>トップページ</h2>
	<p>※質問タグもしくはキーワードのどちらかは必ず入力してください</p>
	<form method = "POST" action = "/D4_situmonn/TopServlet" class="search_form">
	<table class="search">
		    <tr>
		      <td>
			<input type="checkbox" name="questions_tag1" id="q1" class="checkboxes" value ="パーソナルコース"><label class="q_tag" for="q1">パーソナルコース</label><br>
		      </td>
		      <td>
			<input type="checkbox" name="questions_tag6" id="q6" class="checkboxes" value="エラー対応"><label class="q_tag" for="q6">エラー対応</label><br>
		      </td>
		    </tr>

		    <tr>
		      <td>
			<input type="checkbox" name="questions_tag2" id="q2" class="checkboxes"value="IT基礎コース"><label class="q_tag" for="q2">IT基礎コース</label><br>
		      </td>
		      <td>
			<input type="checkbox" name="questions_tag7" id="q7" class="checkboxes" value="機器トラブル"><label class="q_tag" for="q7">機器トラブル</label><br>
		      </td>
		    </tr>

		    <tr>
		      <td>
			<input type="checkbox" name="questions_tag3" id="q3" class="checkboxes" value = "Java基礎コース"><label class="q_tag" for="q3">Java基礎コース</label><br>
		      </td>
		      <td>
			<input type ="checkbox" name="questions_tag8" id="q8" class="checkboxes" value="ネットワークトラブル"><label class="q_tag" for="q8">ネットワークトラブル</label><br>
		      </td>
		    </tr>

		    <tr>
		      <td>
			<input type="checkbox" name="questions_tag4" id="q4" class="checkboxes" value="Webアプリ開発"><label class="q_tag" for="q4">Webアプリ開発</label><br>
		      </td>
		      <td>
			<input type="checkbox" name="questions_tag9" id="q9" class="checkboxes" value = "IT知識"><label class="q_tag" for="q9">IT知識</label><br>
		      </td>
		    </tr>

		    <tr>
		      <td>
			<input type="checkbox" name="questions_tag5" id="q5" class="checkboxes" value="人生相談"><label class="q_tag" for="q5">人生相談</label><br>
		      </td>
		      <td>
			<input type="checkbox" name="questions_tag10" id="q10" class="checkboxes" value="運営事務局宛て"><label class="q_tag" for="q10">運営事務局宛て</label><br>
		      </td>
		    </tr>
		    <tr>
		      <td>
			<input type="checkbox" name="questions_tag11" id="q11" class="checkboxes" value="その他"><label class="q_tag" for="q11">その他</label><br>
		      </td>
		    </tr>

			<tr>
		      <td colspan="2" class = "iptxt">
			  <input type = "text" name = "keyword" id = "key" placeholder="キーワードを入力してください。">
		      </td>
		    </tr>

			<tr>
		      <td>
			  <input type="radio" id="s1" name="solution_label" value="1" checked required><label class="solution" for="s1">解決済</label>
		      </td>
		      <td>
			  <input type="radio" id="s2" name="solution_label" value="0"><label class="solution" for="s2">未解決</label>
		      </td>
			</tr>
			<tr>
		      <td colspan="2">
		      <input type = "submit" name = "search" value = "検索" onClick="return isCheck()">
		      </td>
		    </tr>
	</table>
	</form>
</main>
<!-- フッター -->
<jsp:include page = "/footer.jsp"/>
</div>
</body>
</html>