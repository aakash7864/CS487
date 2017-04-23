<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<title>Manage Books</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="assets/css/main.css" />
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
</head>
<style type="text/css">
    .itemWithPadding {
       margin-top: 10px;
    }
    th {
       text-align:left;
       font-weight:bold;
    }
</style>
<body class="homepage">
	<div id="page-wrapper">

		<div id="features-wrapper">

			<!-- Nav -->
			<nav id="nav">
				<ul>
					<li><a class="icon fa-home" href="/admin/account"><span>My
								Account</span></a></li>
					<li><a href="/admin" class="icon fa-cog"><span>Manage
								Book</span></a></li>
					<li><a class="icon fa-cog" href="/admin/users"><span>Manage
								User</span></a></li>
					<li><a class="icon fa-retweet" href="/logout"><span>Logout</span></a></li>
				</ul>
			</nav>

		</div>
		<div>

			<section id="features" class="container">
				<header>
					<h2>
						Welcome <strong><c:out value="${user.userId}" /></strong>!
					</h2>
				</header>
				<div>
				<table class="table">
				<tr>
				<th>
				<form action="/admin/searchBook" method="post">
				 <input name="bookName" type="text" class="form-control" placeholder="Book Name..."
                   autofocus="true"/>
					<button class="btn btn-lg btn-block itemWithPadding" type="submit">Search</button>
				</form>
				</th>
				<th>
				<form action="/admin/addBook" method="get">
					<button class="btn btn-lg btn-primary btn-block" style="margin-left:10px" type="submit">Add
						Book</button>
				</form>
				</th>
				</tr>
				</table>
				</div>
				<table class="table">
					<thead>
					<tr>
						<th>Book ID</th>
						<th>Book Name</th>
						<th>Author</th>
						<th>Book Price</th>
						<th>Available Quantity</th>
						<th></th>
						<th></th>
					</tr>
					</thead>
					<c:forEach var="book" items="${books}">
						<tr>
							<td>${book.bookNumber}</td>
							<td>${book.bookName}</td>
							<td>${book.bookAuthor}</td>
							<td>${book.bookPrice}</td>
							<td>${book.avilableQuanity}</td>
							<td>
								<form method="get" action="/admin/updateBook"
									class="form-signin">
									<input name=bookNumber type="hidden" placeholder="bookNumber"
										value="${book.bookNumber}" />
									<button class="btn btn-lg btn-primary btn-block itemWithPadding" type="submit">Update</button>
								</form>
							</td>
							<td>
								<form method="POST" action="/admin/deleteBook"
									class="form-signin">
									<input name=bookNumber type="hidden" placeholder="bookNumber"
										value="${book.bookNumber}" />
									<button class="btn btn-lg btn-primary btn-block itemWithPadding" type="submit">Delete</button>
								</form>
							</td>
						</tr>
					</c:forEach>
				</table>
			</section>
		</div>
	</div>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.dropotron.min.js"></script>
	<script src="assets/js/skel.min.js"></script>
	<script src="assets/js/skel-viewport.min.js"></script>
	<script src="assets/js/util.js"></script>
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="assets/js/main.js"></script>

</body>

</html>
