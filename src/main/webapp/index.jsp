<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages" />
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/font-awesome/5.4.1/css/all.min.css">

</head>
<body>
<c:import url="${pageContext.request.contextPath}/includes/navbar.jsp" />
<div class="jumbotron text-center">
    <h1>Welcome to our car repair agency</h1>
</div>
<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img class="d-block mx-auto w-100 h-75" src="http://chitwoodsautorepair.com/wp-content/uploads/2015/04/chit1.jpg" alt="First slide">
        </div>
        <div class="carousel-item">
            <img class="d-block mx-auto w-100 h-75" src="http://chitwoodsautorepair.com/wp-content/uploads/2015/04/chit2.jpg" alt="Second slide">
        </div>
        <div class="carousel-item">
            <img class="d-block mx-auto w-100 h-75" src="http://chitwoodsautorepair.com/wp-content/uploads/2015/04/chit4.jpg" alt="Third slide">
        </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<br />
<div class="container mt-2">
    <h2 class="text-center">What do we offer</h2>
    <div class="row mt-5 mb-5">
        <div class="col-sm-4">
            <h3>Professional service</h3>
            <p>Our team is dedicated to providing you and your
                vehicle with professional service and exceptional customer care.</p>
        </div>
        <div class="col-sm-4">
            <h3>Cheap prices</h3>
            <p>A large repair could put you back $2,000 – $5,000 or more. </p>
        </div>
        <div class="col-sm-4">
            <h3>Personalize Coverage</h3>
            <p>We help you personalize the best options for your vehicle and budget.</p>
        </div>
    </div>
</div>
<c:import url="${pageContext.request.contextPath}/includes/footer.jsp" />
<script src="${pageContext.request.contextPath}/webjars/jquery/3.0.0/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/popper.js/1.14.3/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>
