<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Teachers</title>
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

					<nav id="nav">
				<ul>
					<li><a class="icon fa-home" href="/teacher"><span>Home</span></a></li>
					<li><a href="/teacher/account" class="icon fa-cog"><span>My Account</span></a></li>				
					<li><a class="icon fa-retweet" href="/logout"><span>Logout</span></a></li>
				</ul>
			</nav>
</div>


<div>

			<section id="features" class="container">
				<header>
					<h2>Pending Book Requests</h2>
				</header>
				<table class="table">
					<tr>
						<th>Book Name</th>
						<th>Student Id</th>
						<th>Request Date</th>
					</tr>
					<c:forEach var="requestedBook" items="${requestedBook}">
						<tr>
							<td>${requestedBook.bookName}</td>
							<td>${requestedBook.studentId}</td>
							<td>${requestedBook.requestedDate}</td>
							<td>
								<form method="POST" action="/teacher/checkoutBook"
									class="form-signin">
									<input name=bookNumber type="hidden" placeholder="bookNumber"
										value="${requestedBook.bookId}" />
										<input name=studentId type="hidden" placeholder="studentId"
										value="${requestedBook.studentId}" />
									<button class="btn btn-lg btn-primary btn-block itemWithPadding" type="submit">Checkout</button>
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
