<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<title>Student</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="assets/css/main.css" />
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
</head>
<style type="text/css">

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
					<li><a class="icon fa-home" href="/student"><span>Home</span></a></li>
					<li><a href="/student/account" class="icon fa-cog"><span>My Account</span></a></li>
					<li><a class="icon fa-retweet" href="/logout"><span>Logout</span></a></li>
				</ul>
			</nav>
		</div>

		<div>

			<section id="features" class="container">
				<header>
					<h2>Request for Book</h2>
				</header>
				<table class="table">
					<tr>
						<th>Course Id</th>
						<th>Course Name</th>
						<th>Book Name</th>
						
					</tr>
					<c:forEach var="studentBook" items="${studentBook}">
						<tr>
							<td>${studentBook.courseId}</td>
							<td>${studentBook.courseName}</td>
							<td>
								<table class="table">
									<c:forEach var="book" items="${studentBook.books}">
										<tr>
											<td>${book.bookName}</td>
											<td>
												<form method="POST" action="/student/requestBook"
													class="form-signin">
													<input name=bookNumber type="hidden"
														placeholder="bookNumber" value="${book.bookNumber}" />
													<button class="btn btn-lg btn-primary btn-block"
														type="submit">Request Book</button>
												</form>
											</td>
										</tr>
									</c:forEach>
								</table>
							</td>
						</tr>
					</c:forEach>
				</table>
			</section>
			
			<section id="features" class="container">
				<header>
					<h2>Checked-out Books</h2>
				</header>
				<table class="table">
					<tr>
						<th>Book Name</th>
						<th>Allocation Date </th>
						<th>Due Date </th>
						<th>Fine($) </th>
					</tr>
					<c:forEach var="allocatedBook" items="${allocatedBook}">
						<tr>
							<td>${allocatedBook.bookName}</td>
							<td>${allocatedBook.allocationDate}</td>	
							<td>${allocatedBook.dueDate}</td>
							<td>${allocatedBook.fine}</td>												
						</tr>
					</c:forEach>
				</table>
			</section>
			
			<section id="features" class="container">
				<header>
					<h2>Pending Requests</h2>
				</header>
				<table class="table">
					<tr>
						<th>Book Name</th>
						<th>Request Date </th>
					</tr>
					<c:forEach var="requestedBook" items="${requestedBook}">
						<tr>
							<td>${requestedBook.bookName}</td>
							<td>${requestedBook.requestedDate}</td>						
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
