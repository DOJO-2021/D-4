<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>質問・相談システム(仮)｜サインイン</title>
<link rel="stylesheet" href="D4_situmonn/WEB-INF/css/login.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c" rel="stylesheet">

</head>
<body>
<div class="wrapper">
<jsp:include page="/headernologin.jsp"/>
<h2>サインイン</h2>
<form method="POST" action="/D4_situmonn/LoginServlet" class="IDPW">
<div class="iptxt">
  <input type="text" name="ID" required  placeholder="ID" class="ef">
  <i class="fa fa-id-badge fa-lg fa-fw" aria-hidden="true"></i>
</div>
<br>
<div class="iptxt">
  <input type="password" name="PW" required  placeholder="パスワード" class="ef">
  <i class="fa fa-lock fa-lg fa-fw" aria-hidden="true"></i>
</div>
<br>
  <input type="submit" value="サインイン" ><br>
  <a href="/D4_situmonn/UsersRegistServlet" class="signup">サインアップ</a>
  <p><c:out value="${result.message}" /></p>
</form>
<jsp:include page="/footer.jsp"/>
</div>
</body>
</html>