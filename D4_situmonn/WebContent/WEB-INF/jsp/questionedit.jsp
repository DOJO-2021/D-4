<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>質問・相談システム(仮)|質問編集</title>
	<Script>
	'use strict';

    function check(){
    	const q_tag1 = document.getElementById("question_tag1");
    	const question_tag1 = q_tag1.value;
    	const q_tag2 = document.getElementById("question_tag2");
    	const question_tag2 = q_tag2.value;
    	const q_tag3 = document.getElementById("question_tag3");
    	const question_tag3 = q_tag3.value;
    	const q_tag4 = document.getElementById("question_tag4");
    	const question_tag4 = q_tag4.value;
    	const q_tag5 = document.getElementById("question_tag5");
    	const question_tag5 = q_tag5.value;
    	if(question_tag1 != "" || question_tag2 != "" || question_tag3 != "" || question_tag4 != "" || question_tag5 != ""){
    		if(window.confirm('質問内容を投稿しますか？')){ // 確認ダイアログを表示
        		return true; // 「OK」時は送信を実行
        	}
        	else {
        		return false;
        	}
        }
        else{
        	window.alert('質問タグを最低1つ選択してください。');
        	return false;
        }
    }
    <!-- トップページに遷移するプログラムはservlet -->

	function OnLinkClick() {  //キャンセルのリンクがクリックされたとき
		if (window.confirm('編集中の項目を破棄します。')){
        	return true;
        }
        else {
  		  return false;
        }
	}
	</script>
	</head>

	<body>
		<div class="wrapper">
			<jsp:include page="/header.jsp"/>
			<h2>質問編集</h2>

			<form method="POST" enctype="multipart/form-data" action="/D4_situmonn/QuestionEditServlet" onSubmit="return check()">
				<c:forEach var="e" items="${QEdit}" >

					<input type="hidden" name="q_id" value="${e.q_id}">
					<!-- question postとほぼ同じ内容 -->

					<!-- 質問タイトル -->
					<input type="text" name="question_title" value="${e.q_title}" placeholder="質問タイトル" required><br>

					<!-- 質問内容 -->
					<textarea name="question_contents" placeholder="質問内容"required>${e.q_contents}</textarea><br>

					<!-- 質問タグを選択。プルダウンであらかじめ用意された質問タグから選択する。 -->
					質問タグ<br>
					<select name="question_tag1" id="question_tag1">
					<option value="">-----</option>
					<option value="パーソナルコース">パーソナルコース</option>
					<option value="IT基礎コース">IT基礎コース</option>
					<option value="Java基礎コース">Java基礎コース</option>
					<option value="Webアプリ開発">Webアプリ開発</option>
					<option value="人生相談">人生相談</option>
					<option value="エラー対応">エラー対応</option>
					<option value="機器トラブル">機器トラブル</option>
					<option value="ネットワークトラブル">ネットワークトラブル</option>
					<option value="IT知識">IT知識</option>
					<option value="運営事務局宛て">運営事務局宛て</option>
					<option value="その他">その他</option>
					</select>

					<select name="question_tag2" id="question_tag2">
					<option value="">-----</option>
					<option value="パーソナルコース">パーソナルコース</option>
					<option value="IT基礎コース">IT基礎コース</option>
					<option value="Java基礎コース">Java基礎コース</option>
					<option value="Webアプリ開発">Webアプリ開発</option>
					<option value="人生相談">人生相談</option>
					<option value="エラー対応">エラー対応</option>
					<option value="機器トラブル">機器トラブル</option>
					<option value="ネットワークトラブル">ネットワークトラブル</option>
					<option value="IT知識">IT知識</option>
					<option value="運営事務局宛て">運営事務局宛て</option>
					<option value="その他">その他</option>
					</select>

					<select name="question_tag3" id="question_tag3">
					<option value="">-----</option>
					<option value="パーソナルコース">パーソナルコース</option>
					<option value="IT基礎コース">IT基礎コース</option>
					<option value="Java基礎コース">Java基礎コース</option>
					<option value="Webアプリ開発">Webアプリ開発</option>
					<option value="人生相談">人生相談</option>
					<option value="エラー対応">エラー対応</option>
					<option value="機器トラブル">機器トラブル</option>
					<option value="ネットワークトラブル">ネットワークトラブル</option>
					<option value="IT知識">IT知識</option>
					<option value="運営事務局宛て">運営事務局宛て</option>
					<option value="その他">その他</option>
					</select>

					<select name="question_tag4" id="question_tag4">
					<option value="">-----</option>
					<option value="パーソナルコース">パーソナルコース</option>
					<option value="IT基礎コース">IT基礎コース</option>
					<option value="Java基礎コース">Java基礎コース</option>
					<option value="Webアプリ開発">Webアプリ開発</option>
					<option value="人生相談">人生相談</option>
					<option value="エラー対応">エラー対応</option>
					<option value="機器トラブル">機器トラブル</option>
					<option value="ネットワークトラブル">ネットワークトラブル</option>
					<option value="IT知識">IT知識</option>
					<option value="運営事務局宛て">運営事務局宛て</option>
					<option value="その他">その他</option>
					</select>

					<select name="question_tag5" id="question_tag5">
					<option value="">-----</option>
					<option value="パーソナルコース">パーソナルコース</option>
					<option value="IT基礎コース">IT基礎コース</option>
					<option value="Java基礎コース">Java基礎コース</option>
					<option value="Webアプリ開発">Webアプリ開発</option>
					<option value="人生相談">人生相談</option>
					<option value="エラー対応">エラー対応</option>
					<option value="機器トラブル">機器トラブル</option>
					<option value="ネットワークトラブル">ネットワークトラブル</option>
					<option value="IT知識">IT知識</option>
					<option value="運営事務局宛て">運営事務局宛て</option>
					<option value="その他">その他</option>
					</select><br>

					<!-- 添付ファイルボタン -->
					<input type="file" name="q_file" value="ファイル選択"><br>

					<!-- 解決チェックボックスの追加 -->
					解決チェックボックス<br>
					<input type="checkbox" name="solution_button" value="1">解決<br>

					<!-- 更新ボタンはsubmit -->
					<input type="submit" name="update_button" value="更新">

					<!-- キャンセルのリンク部分にonclick="OnLinkClick();"と書き加える -->
					<!-- onclicをおすとJavaScriptに飛ぶ -->
					<a href = "/D4_situmonn/MypageServlet" onclick="return OnLinkClick();">キャンセル</a>

				</c:forEach>
			</form>
			<jsp:include page="/footer.jsp"/>
		</div>
	</body>
</html>