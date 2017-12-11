<c:if test="${!empty info_msg}">
    <div class="alert alert-success alert-dismissible fade show col-md-8">
            ${info_msg}
        <c:set var="info_msg" value="${null}"/>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
</c:if>