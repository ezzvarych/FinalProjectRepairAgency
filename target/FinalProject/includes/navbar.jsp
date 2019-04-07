<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages" />
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="${pageContext.request.contextPath}">Repair agency</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/app/customer/get-orders">My orders</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">About us</a>
            </li>
        </ul>
        <ul class="navbar-nav">
        <c:if test="${empty sessionScope.sessionUser}">
            <li class="nav-item">
                <a class="nav-link text-white text-uppercase" href="${pageContext.request.contextPath}/app/login">Login</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white text-uppercase" href="${pageContext.request.contextPath}/app/registration">Register</a>
            </li>
        </c:if>
        <c:if test="${not empty sessionScope.sessionUser}">
            <c:set var="role" value="${fn:toLowerCase(sessionScope.sessionUser.role)}" />
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle"
                    href="#" id="userInfo" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        ${sessionScope.sessionUser.login}
                </a>
                <div class="dropdown-menu" aria-labelledby="userInfo">
                    <a class="dropdown-item" href="${pageContext.request.contextPath += '/app/' += role}/main">Main page</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/app/logout">Logout</a>
                </div>

            </li>
        </c:if>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="dropdownLang" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Lang
                </a>
                <div class="dropdown-menu" aria-labelledby="dropdownLang">
                    <a class="dropdown-item" href="${pageContext.request.requestURI}?locale=uk">
                        <img src="https://lipis.github.io/flag-icon-css/flags/4x3/ua.svg" alt="Ukraine" width="15"> UKR
                    </a>
                    <a class="dropdown-item" href="${pageContext.request.requestURI}?locale=en">
                        <img src="https://lipis.github.io/flag-icon-css/flags/4x3/gb.svg" width="15" alt="English"> ENG
                    </a>
                </div>
            </li>
        </ul>
    </div>
</nav>
