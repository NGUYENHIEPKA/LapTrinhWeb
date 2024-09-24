<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home Page Sách KT</title>
<!-- Liên kết tới file CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/views/css/HomePage.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<a href="" class="logo"> <img alt="" src="img/series.png">
			</a>
			<div id="menu">
				<div class="item">
					<a href="">Trang chủ</a>
				</div>
				<div class="item">
					<a href="">Sản phẩm</a>
				</div>
				<div class="item">
					<a href="">Blog</a>
				</div>
				<div class="item">
					<a href="">Liên hệ</a>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<h1>Welcome to My Bookstore</h1>
		<p>This is the homepage of the bookstore.</p>
		<a href="/books">See all books</a>
	</div>

</body>
</html>