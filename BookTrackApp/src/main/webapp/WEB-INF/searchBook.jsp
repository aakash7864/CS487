<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<title>Strongly Typed by HTML5 UP</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="../assets/css/main.css" />
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
</head>
<body class="homepage">
	<div id="page-wrapper">

		<div id="features-wrapper">

			<!-- Nav -->
			<nav id="nav">
				<ul>
					<li><a class="icon fa-home" href="/admin"><span>My
								Account</span></a></li>
					<li><a href="#" class="icon fa-cog"><span>Manage
								Book</span></a></li>
					<li><a class="icon fa-cog" href="#"><span>Manage
								User</span></a></li>
					<li><a class="icon fa-retweet" href="/logout"><span>Logout</span></a></li>
				</ul>
			</nav>

		</div>
		<div>

			<section id="features" class="container">
				<div>
				<table class="table">
				<tr>
				<th>
				<form action="/admin/searchBook" method="post">
				 <input name="bookName" type="text" class="form-control" placeholder="Book Name..."
                   autofocus="true"/>
					<button class="btn btn-lg btn-block" type="submit">Search</button>
				</form>
				</th>
				<th>
				<form action="/admin/addBook" method="get">
					<button class="btn btn-lg btn-primary btn-block" type="submit">Add
						Book</button>
				</form>
				</th>
				</tr>
				</table>
				</div>
				<table class="table">
					<tr>
						<th>Book ID</th>
						<th>Book Name</th>
						<th>Author</th>
						<th>Book Price</th>
						<th>Book Publication</th>
						<th></th>
						<th></th>
					</tr>
					<c:forEach var="book" items="${books}">
						<tr>
							<td>${book.bookNumber}</td>
							<td>${book.bookName}</td>
							<td>${book.bookAuthor}</td>
							<td>${book.bookPrice}</td>
							<td>${book.bookPublication}</td>
						</tr>
					</c:forEach>
				</table>
			</section>
		</div>
	</div>

	<!-- Scripts -->
	<script src="../assets/js/jquery.min.js"></script>
	<script src="../assets/js/jquery.dropotron.min.js"></script>
	<script src="../assets/js/skel.min.js"></script>
	<script src="../assets/js/skel-viewport.min.js"></script>
	<script src="../assets/js/util.js"></script>
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="../assets/js/main.js"></script>

</body>

</html>
