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
		<div style="margin:0px 50px">
			<h2><a style="float:right" href="/admin">Back</a></h2>
		</div>
		<div class="container">
			<form:form method="POST" modelAttribute="bookForm"
				class="form-signin" action="/admin/addBook">
				<h2 class="form-signin-heading">Add Book</h2>
				<spring:bind path="bookNumber">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						
						<form:input type="text" path="bookNumber" class="form-control"
							placeholder="Book Number" autofocus="true"></form:input>
					</div>
				</spring:bind>

				<spring:bind path="bookName">
					<div class="form-group ${status.error ? 'has-error' : ''}">
					
						<form:input type="text" path="bookName" class="form-control"
							placeholder="Book Name"></form:input>
					</div>
				</spring:bind>



				<spring:bind path="bookAuthor">
					<div class="form-group ${status.error ? 'has-error' : ''}">
					
						<form:input type="text" path="bookAuthor" class="form-control"
							placeholder="Book Author"></form:input>
					</div>
				</spring:bind>

				<spring:bind path="bookPrice">
					<div class="form-group ${status.error ? 'has-error' : ''}">
					
						<form:input type="text" path="bookPrice" class="form-control"
							placeholder="Book Price"></form:input>
					</div>
				</spring:bind>

				<spring:bind path="bookPublication">
					<div class="form-group ${status.error ? 'has-error' : ''}">
					
						<form:input type="text" path="bookPublication"
							class="form-control" placeholder="Book Publication" ></form:input>
					</div>
				</spring:bind>

				<div>
					<label></label>
				</div>
				
				<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
			</form:form>
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
