<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>質問・相談システム(仮)|プロフィール編集</title>
<Script>
'use strict';
function check(){
	if(window.confirm('回答を送信してもよろしいですか？')){ // 確認ダイアログを表示
		return true; // 「OK」時は送信を実行
	}
}


</script>
</head>
<body>
<div class = "wrapper">
<!-- ここからヘッダー -->
<jsp:include page = "/header.jsp"/>
<h2>プロフィール編集</h2>

<!-- ここからメイン -->
<form method = "POST" action = "/D4_situmonn/ProfileEditServlet">
<!-- value = EL式 で元々登録されている氏名・会社名・パスワードを表示 -->
  <label>
  氏名<br>
  <input type="text" name="name_input" required><br>
  </label>
    <label>
  会社名<br>
  <input type="text" name="company_input"><br>
  </label>
    <label>
  パスワード<br>
  <input type="password" name="password_input" required><br>
  </label>
    <label>
  パスワード確認<br>
  <input type="password" name="password_confirm" required><br>
  </label>

  <input type = "submit" value = "更新">

  <a href = "/D4_situmonn/MypageServlet">キャンセル</a>

</form>
<!-- フッター -->
<jsp:include page = "/footer.jsp"/>

</div>
</body>
</html>