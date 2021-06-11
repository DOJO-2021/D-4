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
<h2>検索結果</h2>
プロフィール<br>
<table><!-- テーブルに罫線 -->

 <tr>
   <th>ID</th>
   <th>氏名</th>
 </tr>
 <tr>
   <th>会社名</th>
   <th>ユーザー種別</th>
 </tr>
</table>



<table class=scroll><!-- テーブルに罫線とスクロールバー -->
<!--<c:forEach var="" items="${}" >　←DAOができたら　-->
 <tr>
   <th>タイトル</th>
 </tr>
 <tr>
   <th></th>
   <th></th>
   <th>質問者の名前</th>
   <th>質問日時</th>
   <th>解決/未解決</th>
 </tr>
 <tr>
   <th>質問内容を先頭から100字表示する</th>
 </tr>
 <!--</c:forEach>-->
</table>

<jsp:include page="/footer.jsp"/>
</div>
</body>
</html>