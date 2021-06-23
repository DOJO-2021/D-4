<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>質問投稿</title>
    <link rel="stylesheet" href="/D4_situmonn/css/common.css">
	<link rel="stylesheet" href="/D4_situmonn/css/questionspost.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c" rel="stylesheet">
    <Script>
     'use strict';
     function Template(){
    	 const tem = document.getElementById("tem").value;
    	 document.getElementById("text").value = tem;
     }

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
    </script>
  </head>
  <body>
    <jsp:include page="/header.jsp"/>
    <div class="wrapper">
    <h2>質問投稿</h2>
    <div id="question">
    <!-- テンプレート挿入ボタン -->
    <div id="tem">
    <c:forEach var="e" items="${Template}">
      <input type="hidden" id="tem" value="${e.temp_contents}">
    </c:forEach>
      <input type="submit" name="template_button" value="テンプレートの挿入"  onclick="Template()"><br>
      </div>
    <form method="POST" action="/D4_situmonn/QuestionsPostServlet" onSubmit="return check()">
      <input type="hidden" name="user_id" value="${id}">
      <!-- 質問タイトル -->
      <div class="iptxt">
        <input type="text" name="question_title" placeholder="質問タイトル" required class="ef">
        <i class="fa fa-lock fa-lg fa-fw" aria-hidden="true"></i>
      </div>
      <!-- 質問内容 -->
      <textarea id="text" name="question_contents"  placeholder="質問内容"  rows="6" cols="70" required></textarea><br>

      <!-- 「テンプレート挿入ボタン」をクリックすると、以下のメッセージが「5.質問内容」に挿入される。
      全文、変更/削除可能である。 -->

      <!-- テンプレートを挿入する処理はservlet→servlet内でdaoを呼び出す→jspでel式のinputタグに入れる
      → -->
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
        </select><br><br>
      <!-- 最低1個、最大5個まで。←これはServletでやる -->
      <!-- 「6.ファイル選択（添付ファイル）」をクリック。ファイル選択ダイアログ
       JSPはどこまで書けばいいか？全部javascriptか？
       中岡さんに聞く-->
      <!-- ファイル添付ボタン -->
      <input type="file" name="file_select"><br><br>
      </div>
      <!-- 「7.投稿ボタン」をクリック。
      「投稿確認メッセージ」を表示した後、「OK」が選択された場合トップページに遷移する。 -->
      <!-- 投稿ボタン -->
      <input type="submit" name="postbutton" value="投稿">
      <!-- 質問タグが1つも入力されていなかった場合、アラートを表示←servlet
       データ送信されずに元の入力画面(questionpost?)に戻る。
       入力内容は保持されるか？ -->
    </form>
    <jsp:include page="/footer.jsp"/>
   </div>
  </body>
</html>