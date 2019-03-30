<%--
  Created by IntelliJ IDEA.
  User: ПК
  Date: 22.03.2019
  Time: 11:23
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
    <title>Registration</title>
</head>
<body>
    <h1>Registration form</h1>
    <form action="/views/form-user-dto.jsp" method="post">
        <c:out value="${badRegister}" />
        <p><fmt:message key="registration.inputLogin" /> <input type="text" name="login" /></p>
        <p><fmt:message key="registration.emailOrPhone" /> <input type="text" name="emailOrPhone"></p>
        <p><fmt:message key="registration.inputPassword" /> <input type="password" name="password" /></p>
        <button type="submit"><fmt:message key="submitButtonValue" /></button>
    </form>
</body>
</html>
