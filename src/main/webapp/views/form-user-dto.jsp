<%--
  Created by IntelliJ IDEA.
  User: ПК
  Date: 22.03.2019
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<jsp:useBean id="userDTO" class="com.cources.finalProject.models.dto.UserDTO" scope="request" />
<jsp:setProperty name="userDTO" property="*" />

<jsp:forward page="/app/register" />