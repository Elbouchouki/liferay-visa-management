<%@ include file="init.jsp" %>

<%
    String errorMessage = (String) request.getAttribute("errorMessage");
    String callBackURL = (String) request.getAttribute("callBackURL");
%>

<clay:alert
        cssClass="alert-danger fade show mt-3"
        message="<%= errorMessage %>"
        title="Visa Management"
        type="danger"
/>

<div class="container-fluid-1280 align-items-center justify-content-center">
    <div class="text-center">
        <a href="<%= callBackURL %>" class="btn btn-danger">
            Go Home
        </a>
    </div>
</div>
