<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>質問・相談システム(仮)|質問投稿</title>
    <Script>
     'use strict';
      function check(){
	    if(window.confirm('質問内容を投稿しますか？')){ // 確認ダイアログを表示
		return true; // 「OK」時は送信を実行
	    }
	    else {
			  return false;
	      }
      }
    <!-- トップページに遷移するプログラムはservlet -->
    </script>
  </head>

  <body>
    <div class="wrapper">
    <jsp:include page="/header.jsp"/>
    <h2>質問を投稿する</h2>

    <form method="POST" action="/D4_situmonn/QuestionPostServlet" onSubmit="return check()">

      <!-- 質問タイトル -->
      <input type="text" name="question_title" placeholder="質問タイトル" required><br>

      <!-- 質問内容 -->
      <textarea name="question_contents" placeholder="質問内容" required></textarea><br>

      <!-- 「テンプレート挿入ボタン」をクリックすると、以下のメッセージが「5.質問内容」に挿入される。
      全文、変更/削除可能である。 -->

      <!-- テンプレート挿入ボタン -->
      <input type="submit" name="template_button" value="テンプレートの挿入"><br>

      <!-- テンプレートを挿入する処理はservlet→servlet内でdaoを呼び出す→jspでel式のinputタグに入れる
      → -->


      <!-- 質問タグを選択。プルダウンであらかじめ用意された質問タグから選択する。 -->
        質問タグ<br>
        <select name="question_tag1">
        <option value="">-----</option>
        <option value="Personal">パーソナルコース</option>
        <option value="ITBasic">IT基礎コース</option>
        <option value="JavaBasic">Java基礎コース</option>
        <option value="WebAppDev">Webアプリ開発</option>
        <option value="LifeCounseling">人生相談</option>
        <option value="Error">エラー対応</option>
        <option value="ComTrouble">機器トラブル</option>
        <option value="NetTrouble">ネットワークトラブル</option>
        <option value="ITKnowledge">IT知識</option>
        <option value="ToAdmin">運営事務局宛て</option>
        <option value="Others">その他</option>
        </select>

        <select name="question_tag2">
        <option value="">-----</option>
        <option value="Personal">パーソナルコース</option>
        <option value="ITBasic">IT基礎コース</option>
        <option value="JavaBasic">Java基礎コース</option>
        <option value="WebAppDev">Webアプリ開発</option>
        <option value="LifeCounseling">人生相談</option>
        <option value="Error">エラー対応</option>
        <option value="ComTrouble">機器トラブル</option>
        <option value="NetTrouble">ネットワークトラブル</option>
        <option value="ITKnowledge">IT知識</option>
        <option value="ToAdmin">運営事務局宛て</option>
        <option value="Others">その他</option>
        </select>

        <select name="question_tag3">
        <option value="">-----</option>
        <option value="Personal">パーソナルコース</option>
        <option value="ITBasic">IT基礎コース</option>
        <option value="JavaBasic">Java基礎コース</option>
        <option value="WebAppDev">Webアプリ開発</option>
        <option value="LifeCounseling">人生相談</option>
        <option value="Error">エラー対応</option>
        <option value="ComTrouble">機器トラブル</option>
        <option value="NetTrouble">ネットワークトラブル</option>
        <option value="ITKnowledge">IT知識</option>
        <option value="ToAdmin">運営事務局宛て</option>
        <option value="Others">その他</option>
        </select>

        <select name="question_tag4">
        <option value="">-----</option>
        <option value="Personal">パーソナルコース</option>
        <option value="ITBasic">IT基礎コース</option>
        <option value="JavaBasic">Java基礎コース</option>
        <option value="WebAppDev">Webアプリ開発</option>
        <option value="LifeCounseling">人生相談</option>
        <option value="Error">エラー対応</option>
        <option value="ComTrouble">機器トラブル</option>
        <option value="NetTrouble">ネットワークトラブル</option>
        <option value="ITKnowledge">IT知識</option>
        <option value="ToAdmin">運営事務局宛て</option>
        <option value="Others">その他</option>
        </select>

        <select name="question_tag5">
        <option value="">-----</option>
        <option value="Personal">パーソナルコース</option>
        <option value="ITBasic">IT基礎コース</option>
        <option value="JavaBasic">Java基礎コース</option>
        <option value="WebAppDev">Webアプリ開発</option>
        <option value="LifeCounseling">人生相談</option>
        <option value="Error">エラー対応</option>
        <option value="ComTrouble">機器トラブル</option>
        <option value="NetTrouble">ネットワークトラブル</option>
        <option value="ITKnowledge">IT知識</option>
        <option value="ToAdmin">運営事務局宛て</option>
        <option value="Others">その他</option>
        </select><br>

      <!-- 最低1個、最大5個まで。←これはServletでやる -->

      <!-- 「6.ファイル選択（添付ファイル）」をクリック。ファイル選択ダイアログ
       JSPはどこまで書けばいいか？全部javascriptか？
       中岡さんに聞く-->

      <!-- ファイル添付ボタン -->
      <input type="submit" name="file_select" value="ファイル選択"><br>

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