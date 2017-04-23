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
					<li><a class="icon fa-home" href="/teacher"><span>Home</span></a></li>
					<li><a href="/teacher/account" class="icon fa-cog"><span>My Account</span></a></li>				
					<li><a class="icon fa-retweet" href="/logout"><span>Logout</span></a></li>
				</ul>
			</nav>
		</div>
		<!-- Features -->
		<div>
			<section id="features" class="container">
				<header>
					<h2>
						Welcome <strong><c:out value="${user.userId}" /></strong>!
					</h2>
				</header>
				<section>
					<header>
						<h3>Your Account Details</h3>
					</header>
					<ul>
						<li class="icon fa-home">Address - <c:out value="${user.address}" /><br />
							<c:out value="${user.city}" /><br /> USA</li>
						<li class="icon fa-phone">Contact Number - <c:out value="${user.phoneNo}" /></li>
						<li class="icon fa-envelope">Email ID - <c:out value="${user.email}" />
						</li>
					</ul>

				</section>

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
