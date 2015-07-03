<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<html>
<head>
    <title>

    </title>
</head>
<body>
<table border="1">
  <tr>
  <td>Id</td>
    <td>First name</td>
  <td>Middle name</td>
  <td>Last name</td>
  <td>Birthday</td>
  <td>Registration date</td>
  <td>Sex</td>

  </tr>

  <tr>


          <td><c:out value="${user.id}"></c:out></td>
          <td><c:out value="${user.firstName}"></c:out></td>
          <td><c:out value="${user.middleName}"></c:out></td>
          <td><c:out value="${user.lastName}"></c:out></td>
          <td><c:out value="${user.birthday}"></c:out></td>

          <td><fmt:formatDate value="${user.registrationDate}" pattern="yyyy-dd-MM HH:mm:ss"/></td>
          <td><c:out value="${user.sex}"></c:out></td>

  </tr>
</table>
</body>
</html>
