<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>質問・相談システム｜ログイン</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/headernologin.jsp">
<h2>ログイン</h2>
<form method="POST" action="/D4_situmonn/LoginServlet" >
  <input type="text" name="ID" required  placeholder="ID"><br>
  <input type="password" name="ID" required  placeholder="password">
  <input type="submit" value="ligin" >
</form>
<jsp:include page="/WEB-INF/jsp/footer.jsp">
</body>
</html>