<%--
  Created by IntelliJ IDEA.
  User: ПК
  Date: 01.04.2019
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages" />

<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Login form</h1>
    <form action="/app/check-login" method="post">
        <p><fmt:message key="registration.inputLoginOrEmail"/> <input type="text" name="loginOrEmail" required="required"/></p>
        <p><fmt:message key="registration.inputPassword"/> <input type="password" name="password" required="required"/></p>
        <button type="submit"><fmt:message key="submitButtonValue"/></button>
    </form>
</body>
</html>
