<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>質問・相談システム(仮)｜ログイン</title>

<!-- id・passwordが一致する人がいない場合アラートを表示 -->
<!-- 中岡さんに確認 -->
<!--<script>
'use strict'
window.alert('IDが違います。');
window.alert('パスワードが違います。');
</script>-->

</head>
<body>
<div class="wrapper">
<jsp:include page="/headernologin.jsp"/>
<h2>ログイン</h2>
<form method="POST" action="/D4_situmonn/LoginServlet" >
  <input type="text" name="ID" required  placeholder="ID"><br>
  <input type="password" name="PW" required  placeholder="パスワード"><br>
  <input type="submit" value="ログイン" ><br>
  <a href="/D4_situmonn/UsersRegistServlet">新規登録はこちらから</a>
  <p><c:out value="${result.message}" /></p>
</form>
<jsp:include page="/footer.jsp"/>
</div>
</body>
</html>