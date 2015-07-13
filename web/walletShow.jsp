<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<c:set var="name" scope="session" value="${wallet.name}"></c:set>
<c:set var="id" scope="session" value="${wallet.id}"></c:set>
<c:set var="userId" scope="session" value="${wallet.userId}"></c:set>
<c:set var="amount" scope="session" value="${wallet.amount}"></c:set>


<h1 align="center"><c:out value="${name}"></c:out></h1>
<table border="1">
  <tr>
    <td>id</td>
    <td>user_id</td>
    <td>amount</td>
  </tr>
  <td><c:out value="${id}"></c:out></td>
  <td><c:out value="${userId}"></c:out></td>
  <td><c:out value="${amount}"></c:out></td>

</table>



<table border="1">
  <tr>
    <td>


      <c:choose>
        <c:when test="${name.equals(\"Bitcoin\")}">
          <form action="/DeleteBitcoin" method="post">
            <input type="hidden" value="${userId}" name="userId">
            <input type="submit" value="Delete wallet">
            </form>
        </c:when>
        <c:when test="${name.equals(\"Yandex Money\")}">
          <form action="/DeleteYandex" method="post">
            <input type="hidden" value="${userId}" name="userId">
            <input type="submit" value="Delete wallet">
          </form>
        </c:when>
        <c:when test="${name.equals(\"WebMoneyEUR\")}">
          <form action="/DeleteWebMoneyEUR" method="post">
            <input type="hidden" value="${userId}" name="userId">
            <input type="submit" value="Delete wallet">
          </form>
        </c:when>
        <c:when test="${name.equals(\"WebMoneyUSD\")}">
          <form action="/DeleteWebMoneyUSD" method="post">
            <input type="hidden" value="${userId}" name="userId">
            <input type="submit" value="Delete wallet">
          </form>
        </c:when>
        <c:when test="${name.equals(\"WebMoneyUAH\")}">
          <form action="/DeleteWebMoneyUAH" method="post">
            <input type="hidden" value="${userId}" name="userId">
            <input type="submit" value="Delete wallet">
          </form>
        </c:when>
        <c:when test="${name.equals(\"WebMoneyRUR\")}">
          <form action="/DeleteWebMoneyRUR" method="post">
            <input type="hidden" value="${userId}" name="userId">
            <input type="submit" value="Delete wallet">
          </form>
        </c:when>
      </c:choose>

    </td>
  </tr>
</table>
</body>
</html>
