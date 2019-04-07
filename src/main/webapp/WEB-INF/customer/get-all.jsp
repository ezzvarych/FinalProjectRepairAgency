<%--
  Created by IntelliJ IDEA.
  User: ПК
  Date: 06.04.2019
  Time: 12:33
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
    <title>Get all requests</title>
</head>
<body>
    <c:forEach items="${reqs}" var="req">
        <h3>${req}</h3>
    </c:forEach>
</body>
</html>
