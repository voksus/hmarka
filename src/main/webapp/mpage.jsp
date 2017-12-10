<%--
  User: Volodymyr Burtsev
  Date: 07.12.2017
  Time: 12:30
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>hmarka test</title>
    <%@include file="incl/header_config.jsp" %>
</head>
<body>
<%@include file="incl/navbar.jsp" %>
<main class="wrapper bg-gray scrollable">
    <div class="content">
        <div class="container">
            <div class="row my-3">
                <div class="rounded-box bg-light col-12">
                    <c:choose>
                        <c:when test="${page.equals('make_order')}">
                            <%@include file="incl/order_form.jsp" %>
                        </c:when>
                        <c:when test="${page.equals('statistics')}">
                            <%@include file="incl/statistics.jsp" %>
                        </c:when>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
    <%@include file="incl/footer.jsp" %>
</main>
</body>
</html>