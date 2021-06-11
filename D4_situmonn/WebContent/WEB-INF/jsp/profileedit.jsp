<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>質問・相談システム(仮)|プロフィール編集</title>
</head>
<body>
<div class = "wrapper">
<!-- ここからヘッダー -->
<jsp:include page = "/header.jsp"/>
<h2>プロフィール編集</h2>

<!-- ここからメイン -->
<form>
  <input type="text" name="name_input"  placeholder="氏名" required><br>
  <input type="text" name="company_input"  placeholder="会社名"><br>
  <input type="password" name="password_input"  placeholder="パスワード入力欄" required><br>
  <input type="password" name="password_confirm"  placeholder="パスワード確認入力欄" required><br>

  <input type = "submit" value = "更新">

  <a href = "/D4_situmonn/MypageServlet">キャンセル</a>
</form>
<!-- フッター -->
<jsp:include page = "/footer.jsp"/>

</div>
</body>
</html>