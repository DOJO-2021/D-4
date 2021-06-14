<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>質問・相談システム(仮)|マイページ</title>
</head>
<body>
<div class="wrapper">
<jsp:include page="/headernologin.jsp"/>
<h2>マイページ</h2>

<table><!-- テーブルに罫線(タグで指定) -->
 <caption>プロフィール</caption>
  <tr>
    <th>${ID}</th>
    <th>${氏名}</th>
  </tr>
  <tr>
    <th>${会社名}</th>
    <th>${ユーザー種別}</th>
  </tr>
</table>
<a href="/D4_situmonn/ProfileEditServlet">プロフィール編集</a>


<table class=scroll><!-- テーブルに罫線(タグで指定)とスクロールバー -->
 <caption>自分のした質問</caption>
 <!--<c:forEach var="" items="${}" >　←DAOができたら　-->
  <tr>
    <th>${タイトル}</th>
    <th><a href="/D4_situmonn/QeustionEditServlet">編集</a></th>
  </tr>
  <tr>
    <th>${質問日時}</th>
    <th>${解決/未解決}</th>
  </tr>
  <tr>
    <th>${タグ1}</th>
    <th>${タグ2}</th>
    <th>${タグ3}</th>
    <th>${タグ4}</th>
    <th>${タグ5}</th>
  </tr>
  <tr>
    <th>${質問内容}</th>
  </tr>
 <!--</c:forEach>-->
</table>

<jsp:include page="/footer.jsp"/>
</div>
</body>
</html>