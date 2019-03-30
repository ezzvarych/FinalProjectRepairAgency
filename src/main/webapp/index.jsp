<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages" />
<html>
<head>
    <link rel="stylesheet" href="/webjars/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
<div class="jumbotron text-center">
    <h1>My First Bootstrap Page</h1>
    <p><fmt:message key="welcome" /></p>
    <p><a href="/app/registration">Sign up</a></p>
    <p><a href="/app/login">Sign in</a></p>
</div>

<div class="container">
    <div class="row">
        <div class="col-sm-4">
            <h3>Column 1</h3>
            <p>Lorem ipsum dolor..</p>
            <p>Ut enim ad..</p>
        </div>
        <div class="col-sm-4">
            <h3>Column 2</h3>
            <p>Lorem ipsum dolor..</p>
            <p>Ut enim ad..</p>
        </div>
        <div class="col-sm-4">
            <h3>Column 3</h3>
            <p>Lorem ipsum dolor..</p>
            <p>Ut enim ad..</p>
        </div>
    </div>
</div>
</body>
</html>
