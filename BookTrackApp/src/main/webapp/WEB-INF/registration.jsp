<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create an account</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container">

    <form:form method="POST" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signin-heading">Create your account</h2>
        <spring:bind path="userId">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="userId" class="form-control" placeholder="userId"
                            autofocus="true"></form:input>
            </div>
        </spring:bind>

        <spring:bind path="passowrd">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="passowrd" class="form-control" placeholder="passowrd"></form:input>            </div>
        </spring:bind>
        
           <spring:bind path="role">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            	<form:select path="role"  class="form-control">
                      <form:options items="${userRole}" path="role" />
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
        

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
