<c:if test="${!empty alert_msg}">
    <div class="alert alert-danger alert-dismissible fade show col-md-8">
            ${alert_msg}
        <c:set var="alert_msg" value="${null}"/>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
</c:if>