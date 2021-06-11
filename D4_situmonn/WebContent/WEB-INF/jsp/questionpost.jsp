<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>質問・相談システム(仮)|質問投稿</title>
  </head>
<body>
  <div class="wrapper">
  <jsp:include page="/headernologin.jsp"/>
  <h2>質問を投稿する</h2>
    <!-- 質問タグを選択。プルダウンであらかじめ用意された質問タグから選択する。 -->
    質問タグ<br>
    <select name="question_tag1">
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

    <!-- 最低1個、最大5個まで。←これはJava Servletでやる？ -->

    <!-- 「6.ファイル選択（添付ファイル）」をクリック。ファイル選択ダイアログ -->

    <!-- 「7.投稿ボタン」をクリック。
    「投稿確認メッセージ」を表示した後、「OK」が選択された場合トップページに遷移する。 -->














</body>
</html>