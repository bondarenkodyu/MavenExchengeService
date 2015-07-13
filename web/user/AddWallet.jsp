<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
</head>
<body>
<c:set var="userId" scope="request" value="${user.id}"></c:set>
<c:set var="isBitcoin" scope="request" value="${user.isBitcoin}"></c:set>
<c:set var="isYandexMoney" scope="request" value="${user.isYandexMoney}"></c:set>
<c:set var="isWebMoneyEUR" scope="request" value="${user.isWebMoneyEUR}"></c:set>
<c:set var="isWebMoneyUSD" scope="request" value="${user.isWebMoneyUSD}"></c:set>
<c:set var="isWebMoneyUAH" scope="request" value="${user.isWebMoneyUAH}"></c:set>
<c:set var="isWebMoneyRUR" scope="request" value="${user.isWebMoneyRUR}"></c:set>

<table border="1">
  <tr>
  <c:if test="${isBitcoin == 0}"><td>
    <form action="/CreateBitcoin" method="get">
      <input type="hidden" name="userId" value="${userId}">
      <input type="submit" value="Create Bitcoin">

    </form>
    </td>
    </c:if>

  <c:if test="${isYandexMoney == 0}">
    <td>
  <form action="/CreateYandex" method="get">
    <input type="hidden" name="userId" value="${userId}">
    <input type="submit" value="Create Yandex Money">
     </form>
  </td>
  </c:if>

  <c:if test="${isWebMoneyEUR == 0}">
    <td>
      <form action="/CreateWebMoneyEUR" method="get">
        <input type="hidden" name="userId" value="${userId}" >
        <input type="submit" value="Create WebMoney EUR">
        </form>

  </td>
  </c:if>

    <c:if test="${isWebMoneyUSD == 0}">
      <td>
        <form action="/CreateWebMoneyUSD" method="get">
          <input type="hidden" name="userId" value="${userId}">
          <input type="submit" value="Create WebMoney USD">

        </form>
      </td>
    </c:if>

    <c:if test="${isWebMoneyUAH == 0}">
      <td>
        <form action="/CreateWebMoneyUAH" method="get">
          <input type="hidden" name="userId" value="${userId}">
          <input type="submit" value="Create WebMoney UAH">

        </form>
      </td>
    </c:if>

    <c:if test="${isWebMoneyRUR == 0}">
      <td>
        <form action="/CreateWebMoneyRUR" method="get">
          <input type="hidden" name="userId" value="${userId}">
          <input type="submit" value="Create WebMoney RUR">

        </form>
      </td>
    </c:if>
  </tr>
</table>


</body>
</html>
