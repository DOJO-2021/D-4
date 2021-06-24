<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>質問・相談システム(仮)|プロフィール編集</title>
    <link rel="stylesheet" href="/D4_situmonn/css/common.css">
	<link rel="stylesheet" href="/D4_situmonn/css/profileedit.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c" rel="stylesheet">
<Script>
'use strict';
function check(){
	const password1 = document.getElementById("pass1");
	const value1 = password1.value;

	const password2 = document.getElementById("pass2");
	const value2 = password2.value;

		if (value1 != value2){
			window.alert('パスワードの値が一致していません。');
			return false;
		}
		else if(window.confirm('回答を送信してもよろしいですか？')){ // 確認ダイアログを表示
			return true; // 「OK」時は送信を実行
		}
		else{ // 「キャンセル」時の処理
			return false; // 送信を中止
		}
}


function OnLinkClick() {  //キャンセルのリンクがクリックされたとき
	if (window.confirm('編集中の項目を破棄します。')){
		return true;
	}
	else{ // 「キャンセル」時の処理
		return false; // 送信を中止
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
<c:forEach var="e" items="${cardList}" >
<form method = "POST" action = "/D4_situmonn/ProfileEditServlet" onSubmit="return check();">
<!-- value = EL式 で元々登録されている氏名・会社名・パスワードを表示 -->
<div class="iptxt">
  <label>
  <input type="text" name="name_input" value = "${e.user_name}" placeholder="氏名を入力" required><br>
  <i class="fa fa-user fa-lg fa-fw" aria-hidden="true"></i>
  </label>
</div>
<div class="iptxt">
    <label>
  <input type="text" name="company_input" value = "${e.company}" placeholder="会社名を入力"><br>
  <i class="fa fa-building a-lg fa-lg fa-fw" aria-hidden="true"></i>
  </label>
</div>
<div class="iptxt">
    <label>
  <input type="password" name="password_input" value = "${e.password}" id="pass1" placeholder="パスワードを入力" required><br>
  <i class="fa fa-lock fa-lg fa-fw" aria-hidden="true"></i>
  </label>
</div>
<div class="iptxt">
    <label>
  <input type="password" name="password_confirm" id="pass2"required placeholder="パスワードをもう一度入力してください"><br>
  <i class="fa fa-lock fa-lg fa-fw" aria-hidden="true"></i>
  </label>
</div>
  <input type = "submit" value = "更新"><br>

  <a class="cancel" href = "/D4_situmonn/MypageServlet" onclick="return OnLinkClick();">キャンセル</a>

</form>
</c:forEach>

<!-- フッター -->
<jsp:include page = "/footer.jsp"/>

</div>
</body>
</html>