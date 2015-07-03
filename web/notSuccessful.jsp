<%--
  Created by IntelliJ IDEA.
  User: Lil Wayne
  Date: 02.07.2015
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Not successful</title>
</head>
<body>
<p><c:out value="${user.firstName}"></c:out> <c:out value="${user.middleName}"></c:out> <c:out value="${user.lastName}"></c:out> was not delete
</p>
</body>
</html>
