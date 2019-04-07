<%--
  Created by IntelliJ IDEA.
  User: ПК
  Date: 02.04.2019
  Time: 13:48
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
    <title>New order</title>
</head>
<body>
    <h3>Order form:</h3>
    <form action="/app/customer/send-request" method="post">
        <textarea name="descr" required="required" placeholder="Write about your problem"></textarea>
        <button type="submit"><fmt:message key="submitButtonValue"/></button>
    </form>
</body>
</html>
