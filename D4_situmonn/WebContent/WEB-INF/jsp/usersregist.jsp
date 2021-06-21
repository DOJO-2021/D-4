<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>質問・相談システム(仮)|ユーザー登録</title>

<script>
'use strict';
function check(){
	if(window.confirm('登録完了しました。トップページへ移行します。')){ // 確認ダイアログを表示
		return true; // 「OK」時は送信を実行
	}
}
</script>
<link rel="stylesheet" href="css/usersregist.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
<div class="wrapper">
<jsp:include page="/headernologin.jsp"/>
  <h2>ユーザー登録</h2>
    <form method="POST" action="/D4_situmonn/UsersRegistServlet">
	<div class="iptxt">
	  <input type="text" name="id_input" placeholder="ID入力欄" class="ef" required>
	  <i class="fa fa-id-badge fa-lg fa-fw" aria-hidden="true"></i>
	</div>
	<br>

	<div class="iptxt">
	  <input type="password" name="password_input"  placeholder="パスワード入力欄" class="ef" required>
	  <i class="fa fa-lock fa-lg fa-fw" aria-hidden="true"></i>
	</div>
	<br>

	<div class="iptxt">
	  <input type="text" name="name_input"  placeholder="氏名" class="ef" required>
	  <i class="fa fa-user fa-lg fa-fw" aria-hidden="true"></i>
	</div>
	<br>

	<div class="iptxt">
	  <input type="text" name="company_input"  placeholder="会社名" class="ef">
	  <i class="fa fa-building a-lg fa-lg fa-fw" aria-hidden="true"></i>
	</div>
	<br>
	<div class = "user_category">
	  <p>当てはまるものを1つ選んでください</p>
	  <input type="radio" id="u1" name="user_category" value="student" required><label class="user_c" for="u1">受講生</label>
	  <input type="radio" id="u2" name="user_category" value="teacher"><label class="user_c" for="u2">講師</label>
	  <input type="radio" id="u3" name="user_category" value="admin"><label class="user_c" for="u3">運営事務局</label><br>
	</div>
	<input type="submit" name="regist_button" value="サインアップ"><br>
    </form>
   <p><c:out value="${result.message}" /></p>
</div>
</body>
  <jsp:include page="/footer.jsp"/>

</html>