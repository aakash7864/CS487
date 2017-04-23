<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<title>Add Student</title>
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
		<div style="margin:0px 50px">
			<h2><a style="float:right" href="/admin/users">Back</a></h2>
		</div>
		<div class="container">

			<form:form method="POST" modelAttribute="userForm"
				class="form-signin" action="/admin/addUser">
				<h2 class="form-signin-heading">Add Student</h2>
				<spring:bind path="firstName">
					<form:input type="text" path="firstName" class="form-control"
						placeholder="First Name"></form:input>
				</spring:bind>

				<spring:bind path="lastName">
					<form:input type="text" path="lastName" class="form-control"
						placeholder="Last Name"></form:input>
				</spring:bind>
				<spring:bind path="userId">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:input type="text" path="userId" class="form-control"
							placeholder="userId" autofocus="true"></form:input>
					</div>
				</spring:bind>

				<spring:bind path="passowrd">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:input type="password" path="passowrd" class="form-control"
							placeholder="passowrd"></form:input>
					</div>
				</spring:bind>

				<spring:bind path="role">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:select path="role" class="form-control">
							<form:options items="${userRole}" path="role" />
						</form:select>
					</div>
				</spring:bind>

				<spring:bind path="courseId">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:select path="courseId" class="form-control">
							<form:options items="${courseIds}" path="courseId" />
						</form:select>
					</div>
				</spring:bind>

				<spring:bind path="email">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:input type="text" path="email" class="form-control"
							placeholder="Email Address"></form:input>
					</div>
				</spring:bind>

				<spring:bind path="phoneNo">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:input type="text" path="phoneNo" class="form-control"
							placeholder="Phone No."></form:input>
					</div>
				</spring:bind>

				<spring:bind path="address">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:input type="text" path="address" class="form-control"
							placeholder="Address"></form:input>
					</div>
				</spring:bind>

				<spring:bind path="city">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:input type="text" path="city" class="form-control"
							placeholder="City"></form:input>
					</div>
				</spring:bind>

				<spring:bind path="country">
					<form:input type="text" path="country" class="form-control"
						placeholder="Country"></form:input>
				</spring:bind>

				<spring:bind path="parentsnName">
					<form:input type="text" path="parentsnName" class="form-control"
						placeholder="Parent Name"></form:input>
				</spring:bind>

				<spring:bind path="parentsAdd">
					<form:input type="text" path="parentsAdd" class="form-control"
						placeholder="Parents Address"></form:input>
				</spring:bind>

				<spring:bind path="parentsContant">
					<form:input type="text" path="parentsContant" class="form-control"
						placeholder="Parents Phone No"></form:input>
				</spring:bind>
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
