<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<html>
<head>
    <title>

    </title>
</head>
<body>
<c:set var="userId" scope="session" value="${user.id}"></c:set>
<c:set var="isBitcoin" scope="session" value="${user.isBitcoin}"></c:set>
<c:set var="isYandexMoney" scope="session" value="${user.isYandexMoney}"></c:set>
<c:set var="isWebMoneyEUR" scope="session" value="${user.isWebMoneyEUR}"></c:set>
<c:set var="isWebMoneyUSD" scope="session" value="${user.isWebMoneyUSD}"></c:set>
<c:set var="isWebMoneyUAH" scope="session" value="${user.isWebMoneyUAH}"></c:set>
<c:set var="isWebMoneyRUR" scope="session" value="${user.isWebMoneyRUR}"></c:set>



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


          <td><c:out value="${userId}"></c:out></td>
          <td><c:out value="${user.firstName}"></c:out></td>
          <td><c:out value="${user.middleName}"></c:out></td>
          <td><c:out value="${user.lastName}"></c:out></td>
          <td><c:out value="${user.birthday}"></c:out></td>

          <td><fmt:formatDate value="${user.registrationDate}" pattern="yyyy-dd-MM HH:mm:ss"/></td>
          <td><c:out value="${user.sex}"></c:out></td>

  </tr>
</table>

<c:if test="${isBitcoin == 0 || isYandexMoney == 0 || isWebMoneyEUR == 0 || isWebMoneyUSD == 0 || isWebMoneyUAH == 0 || isWebMoneyRUR == 0}">
<form action="/AddWallet" method="get">
    <input type="hidden" name="userId" value="${userId}" >
    <input type="submit" value="Add Wallet">
    </form>
</c:if>

<table>
    <tr>
        <c:if test="${isYandexMoney == 1}">
        <td>
            <form action="/ReadYandex" method="get">
            <input type="hidden" name="userId" value="${userId}" >
            <input type="submit" value="Yandex Money">
        </form>
        </td>

        </c:if>
        <c:if test="${isBitcoin == 1}">
        <td><form action="/ReadBitcoin" method="get">
            <input type="hidden" name="userId" value="${userId}" >
            <input type="submit" value="Bitcoin">
        </form>
        </td>
        </c:if>

        <c:if test="${isWebMoneyEUR == 1}">
        <td><form action="/ReadWebMoneyEUR" method="get">
            <input type="hidden" name="userId" value="${userId}" >
            <input type="submit" value="WebMoneyEUR">
        </form>
        </td>
        </c:if>

        <c:if test="${isWebMoneyUSD == 1}">
        <td><form action="/ReadWebMoneyUSD" method="get">
            <input type="hidden" name="userId" value="${userId}" >
            <input type="submit" value="WebMoneyUSD">
        </form>
        </td>
        </c:if>

        <c:if test="${isWebMoneyUAH == 1}">
        <td><form action="/ReadWebMoneyUAH" method="get">
            <input type="hidden" name="userId" value="${userId}" >
            <input type="submit" value="WebMoneyUAH">
        </form>
        </td>
        </c:if>

        <c:if test="${isWebMoneyRUR == 1}">
        <td><form action="/ReadWebMoneyRUR" method="get">
            <input type="hidden" name="userId" value="${userId}" >
            <input type="submit" value="WebMoneyRUR">
        </form>
        </td>
        </c:if>


    </tr>
</table>
</body>
</html>
