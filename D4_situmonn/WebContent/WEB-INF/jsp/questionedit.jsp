<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>質問・相談システム(仮)|質問編集</title>
	    <link rel="stylesheet" href="/D4_situmonn/css/common.css">
	<link rel="stylesheet" href="/D4_situmonn/css/questionedit.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c" rel="stylesheet">
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

	function setValue() {

		var check = document.getElementById("check");
		let done_tag = document.getElementById("done_tag");
		if (done_tag.value == 1) {
			check.checked = true;
		}

		let i = 1;
		while(i <= 5) {
			var select = document.getElementById("question_tag" + i);
			var q_tag = document.getElementById("q_tag0" + i);
			console.log(q_tag.value);
			select.options[0].selected = true;
			if (q_tag.value === 'パーソナルコース') {
				select.options[1].selected = true;
			}
			if (q_tag.value === 'IT基礎コース') {
				select.options[2].selected = true;
			}
			if (q_tag.value === 'Java基礎コース') {
				select.options[3].selected = true;
			}
			if (q_tag.value === 'Webアプリ開発') {
				select.options[4].selected = true;
			}
			if (q_tag.value === '人生相談') {
				select.options[5].selected = true;
			}
			if (q_tag.value === 'エラー対応') {
				select.options[6].selected = true;
			}
			if (q_tag.value === '機器トラブル') {
				select.options[7].selected = true;
			}
			if (q_tag.value === 'ネットワークトラブル') {
				select.options[8].selected = true;
			}
			if (q_tag.value === 'IT知識') {
				select.options[9].selected = true;
			}
			if (q_tag.value === '運営事務局宛て') {
				select.options[10].selected = true;
			}
			if (q_tag.value === 'その他') {
				select.options[11].selected = true;
			}
			i += 1;
		}

	}
	</script>
	</head>

	<body onload="setValue();">
		<div class="wrapper">
			<jsp:include page="/header.jsp"/>
			<h2>質問編集</h2>

			<form method="POST" enctype="multipart/form-data" action="/D4_situmonn/QuestionEditServlet" onSubmit="return check()">
				<c:forEach var="e" items="${QEdit}" >
				       <div class="question">
					<input type="hidden" name="q_id" value="${e.q_id}">
					<!-- question postとほぼ同じ内容 -->

					<!-- 質問タイトル -->
                                       <div class="title">
					<input type="text" class="q_title" name="question_title" value="${e.q_title}" placeholder="質問タイトル" required><br>
                                       </div>
                                       <div class="contents">
					<!-- 質問内容 -->
					<textarea class="q_contents" name="question_contents" placeholder="質問内容"required rows="10" cols="140">${e.q_contents}</textarea><br>
                                       </div>
					<!-- 質問タグを選択。プルダウンであらかじめ用意された質問タグから選択する。 -->
					<div class="tag">
                                        質問タグ<br>
                    </div>
					<div class="tag_name">
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

					<input type="hidden" name="q_tag01" value="${e.q_tag01}" id="q_tag01">
					<input type="hidden" name="q_tag02" value="${e.q_tag02}" id="q_tag02">
					<input type="hidden" name="q_tag03" value="${e.q_tag03}" id="q_tag03">
					<input type="hidden" name="q_tag04" value="${e.q_tag04}" id="q_tag04">
					<input type="hidden" name="q_tag05" value="${e.q_tag05}" id="q_tag05">
                                       </div>
					<!-- 添付ファイルボタン -->
					<div class="file">
					<input type="file" name="q_file" value="ファイル選択"><br>
					</div>
					<!-- 解決チェックボックスの追加 -->
                    <div class="checkbox">
					解決チェックボックス
					</div>
					<div class="q_checkbox">
					<input type="checkbox" name="solution_button" value="1" id="check">解決<br>
					<input type="hidden" name="done_tag" value="${e.done_tag}" id="done_tag">
                    </div>
                        </div>
					<!-- 更新ボタンはsubmit -->
					<input type="submit" name="update_button" value="更新">

					<!-- キャンセルのリンク部分にonclick="OnLinkClick();"と書き加える -->
					<!-- onclicをおすとJavaScriptに飛ぶ -->
					<a class="cancel" href = "/D4_situmonn/MypageServlet" onclick="return OnLinkClick();">キャンセル</a>

				</c:forEach>
			</form>
			<jsp:include page="/footer.jsp"/>
		</div>
	</body>
</html>