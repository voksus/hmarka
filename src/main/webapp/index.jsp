<%--
  User: Volodymyr Burtsev
  Date: 07.12.2017
  Time: 12:30
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <div class="rounded-box bg-light ">
                    <h1 class="text-center display-3 mt-4">Please make an order:</h1>
                    <div class="row justify-content-md-center row">
                        <form class="col-md-8 mb-4" action="${pageContext.request.contextPath}/add"
                              method="post">
                            <div class="row">
                                <div class="form-group col-12">
                                    <label for="employeeSelect">Select employee</label>
                                    <select class="form-control" id="employeeSelect" aria-describedby="employeeHelp"
                                            required>
                                        <option class="text-dark font-italic bg-gray" value="" selected disabled>Choose
                                            employee</option>
                                        <c:forEach var="employee" items="${employees}">
                                            <option value="${employee.id}">${employee.name}</option>
                                        </c:forEach>
                                    </select>
                                    <small id="employeeHelp" class="form-text font-weight-light text-muted">The order
                                        will be reserved for this employee. (required)
                                    </small>
                                </div>
                                <div class="form-group col-12">
                                    <label for="regionSelect">Select region</label>
                                    <select class="form-control" id="regionSelect" aria-describedby="regionHelp"
                                            required>
                                        <option value="" selected disabled>Choose region</option>
                                        <c:forEach var="region" items="${regions}">
                                            <option value="${region.id}">${region.name}</option>
                                        </c:forEach>
                                    </select>
                                    <small id="regionHelp" class="form-text font-weight-light text-muted">The order will
                                        be reserved in this region. (required)
                                    </small>
                                </div>
                                <div class="col form-group">
                                    <label for="price">Enter price</label>
                                    <input type="number" class="form-control" id="price" aria-describedby="priceHelp"
                                           placeholder="Enter price for order..." min="1" required>
                                    <small id="priceHelp" class="form-text font-weight-light text-muted">This is price.
                                        Must be greater then '0'. (required)
                                    </small>
                                </div>
                                <div class="col form-group">
                                    <script>
                                        $('[data-toggle="datepicker"]').datepicker();
                                    </script>
                                    <label for="dateInput">Choose date</label>
                                    <div class="input-group date" id="dateInput">
                                        <input type="text" class="form-control" data-toggle="datepicker"
                                               placeholder="dd-mm-yyyy">
                                        <span class="input-group-addon"><i class="material-icons">date_range</i></span>
                                    </div>
                                </div>
                                <div class="form-group col-12">
                                    <button class="btn btn-primary" type="submit">Submit</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@include file="incl/footer.jsp" %>
</main>
</body>
</html>