<h1 class="text-center display-3 mt-4">Please make an order:</h1>
<div class="row justify-content-md-center">
    <form class="col-md-8 mb-4" action="${pageContext.request.contextPath}/add_order" method="post">
        <div class="row">
            <div class="form-group col-12">
                <label for="employeeSelect">Select employee</label>
                <select class="form-control" id="employeeSelect" name="employee"
                        aria-describedby="employeeHelp">
                    <option value="" selected disabled></option>
                    <c:forEach items="${employees}" var="employee">
                        <option value="${employee.id}">${employee.id} ${employee.name}</option>
                    </c:forEach>
                </select>
                <small id="employeeHelp" class="form-text font-weight-light text-muted">
                    The order will be reserved for this employee. (required)
                </small>
            </div>
            <div class="form-group col-12">
                <label for="regionSelect">Select region</label>
                <select class="form-control" id="regionSelect" name="region"
                        aria-describedby="regionHelp">
                    <option value="" selected disabled></option>
                    <c:forEach var="region" items="${regions}">
                        <option value="${region.id}">${region.id} ${region.name}</option>
                    </c:forEach>
                </select>
                <small id="regionHelp" class="form-text font-weight-light text-muted">The order will
                    be reserved in this region. (required)
                </small>
            </div>
            <div class="col form-group">
                <label for="price">Enter price</label>
                <input type="number" class="form-control" id="price" name="price"
                       aria-describedby="priceHelp"
                       placeholder="Enter price for order..." min="1">
                <small id="priceHelp" class="form-text font-weight-light text-muted">This is price.
                    Must be greater then '0'. (required)
                </small>
            </div>
            <div class="col form-group">
                <label for="dateInput">Choose date</label>
                <div class="input-group date" id="dateInput">
                    <input type="text" class="form-control" id="datepicker" name="date"
                           placeholder="dd-mm-yyyy" value="${date}">
                    <span class="input-group-addon"><i class="material-icons">date_range</i></span>
                </div>
            </div>
            <div class="form-group col-12">
                <button class="btn btn-lg btn-success" type="submit">Add order</button>
            </div>
        </div>
    </form>
    <%@include file="alert.jsp"%>
    <%@include file="info.jsp"%>
</div>