<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>質問・相談システム(仮)|ユーザー登録</title>

<Script>
'use strict';
function check(){
	if(window.confirm('登録完了しました。トップページへ移行します。')){ // 確認ダイアログを表示
		return true; // 「OK」時は送信を実行
	}
}

<!-- IDが被ってしまった場合は、IDを変える旨をアラートで表示し、登録画面に遷移する -->
<!-- 中岡さんに聞く？ -->
window.alert('このIDは既に使用されています。変更してください。');

</script>

</head>
<body>
<div class="wrapper">
<jsp:include page="/headernologin.jsp"/>
<h2>ユーザー登録</h2>
<form method="POST" action="/D4_situmonn/UsersRegistServlet">

<!-- 入力漏れがあった場合、required属性によるアラートが表示される -->
  <input type="text" name="id_input" placeholder="ID入力欄" required><br>
  <input type="password" name="password_input"  placeholder="パスワード入力欄" required><br>
  <input type="text" name="name_input"  placeholder="氏名" required><br>
  <input type="text" name="company_input"  placeholder="会社名"><br>
ユーザー種別<br><input type="radio" name="user_category" value="student">受講生<br>
            <input type="radio" name="user_category" value="teacher">講師<br>
            <input type="radio" name="user_category" value="admin">運営事務局<br>

<input type="submit" name="regist_button" value="登録"><br>
</form>

<jsp:include page="/footer.jsp"/>
</div>
</body>
</html>