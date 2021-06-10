<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>質問・相談システム(仮)|ユーザー登録</title>
</head>
<body>
<div class="wrapper">
<jsp:include page="/WEB-INF/jsp/headernologin.jsp"/>
<h2>ユーザー登録</h2>
<form method="POST" action="/D4_situmonn/UsersRegistServlet">
<input type="text" name="id_input" placeholder="ID入力欄">
<input type="password" name="password_input"  placeholder="パスワード入力欄">
<input type="text" name="name_input"  placeholder="氏名">
<input type="text" name="company_input"  placeholder="会社名"><br>
ユーザー種別<br><input type="radio" name="user_category" value="student">受講生<br>
            <input type="radio" name="user_category" value="teacher">講師<br>
            <input type="radio" name="user_category" value="management office">運営事務局<br>

<br><input type="submit" name="regist_button" value="登録"><br>
</form>
<jsp:include page="/WEB-INF/jsp/footer.jsp"/>
</div>
</body>
</html>