<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
  <meta charset="UTF-8">
  <title>質問・相談システム(仮)|質問編集</title>
   <Script>
    'use strict';
    function check(){
	  if(window.confirm('質問内容を編集しますか？')){ // 確認ダイアログを表示
		return true; // 「OK」時は送信を実行
	  }
    }
    <!-- トップページに遷移するプログラムはservlet -->
  </script>
  </head>

  <body>
    <div class="wrapper">
    <jsp:include page="/header.jsp"/>
    <h2>質問編集</h2>

        <form method="POST" action="/D4_situmonn/QuestionEditServlet">

        <!-- question postとほぼ同じ内容 -->

        <!-- 質問タイトル -->
        <input type="text" name="question_title" placeholder="質問タイトル" ><br>

        <!-- 質問内容 -->
        <textarea name="question_contents" placeholder="質問内容"></textarea><br>

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

        <!-- 解決チェックボックスの追加 -->

        <!-- 更新ボタンはsubmit -->
        <input type="submit" name="update_button" value="更新">

        <!--  -->

        <!-- キャンセルはリンク -->
        <a href="/D4_situmonn/MypageServlet">キャンセル</a>
        <!-- ①キャンセルボタンをリンクをクリックしたときアラートを出す方法
              -->

        </form>
    <jsp:include page="/footer.jsp"/>
    </div>
  </body>
</html>