<%@ include file="init.jsp" %>


<%
    ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
    Visa visa = (Visa) row.getObject();
    String visaId = String.valueOf(visa.getVisaId());

    boolean canDelete = (boolean) request.getAttribute("canDelete");
    boolean canUpdate = (boolean) request.getAttribute("canUpdate");
    boolean canView = (boolean) request.getAttribute("canView");
    boolean canViewPermissions = (boolean) request.getAttribute("canViewPermissions");

%>

<liferay-ui:icon-menu markupView="lexicon">
    <c:if test="<%=canView%>">
        <portlet:renderURL var="viewVisaURL">
            <portlet:param name="mvcRenderCommandName" value="<%=VisaPortletKeys.MVCCommandNames.VIEW_VISA %>"/>
            <portlet:param name="redirect" value="<%=currentURL%>"/>
            <portlet:param name="visaId" value="<%=visaId%>"/>
        </portlet:renderURL>
        <liferay-ui:icon message="view" url="<%=viewVisaURL%>"/>
    </c:if>

    <c:if test="<%=canUpdate%>">
        <portlet:renderURL var="editVisaURL">
            <portlet:param name="mvcRenderCommandName" value="<%=VisaPortletKeys.MVCCommandNames.EDIT_VISA %>"/>
            <portlet:param name="redirect" value="<%=currentURL%>"/>
            <portlet:param name="visaId" value="<%=visaId%>"/>
        </portlet:renderURL>
        <liferay-ui:icon message="edit" url="<%=editVisaURL%>"/>
    </c:if>


    <c:if test="<%=canDelete%>">
        <portlet:actionURL name="<%=VisaPortletKeys.MVCCommandNames.DELETE_VISA %>" var="deleteVisaURL">
            <portlet:param name="redirect" value="<%=currentURL%>"/>
            <portlet:param name="visaId" value="<%=visaId%>"/>
        </portlet:actionURL>
        <liferay-ui:icon-delete url="<%=deleteVisaURL%>"/>
    </c:if>


    <%--    <c:if test="<%=canViewPermissions%>">--%>
    <%--        <liferay-security:permissionsURL--%>
    <%--                modelResource="com.liferay.gwenod.visa.model.Visa"--%>
    <%--                modelResourceDescription="${visa.getCin()}"--%>
    <%--                resourcePrimKey="${visa.visaId}"--%>
    <%--                var="permissionsURL"--%>
    <%--        />--%>
    <%--        <liferay-ui:icon message="permissions" url="<%=permissionsURL%>"/>--%>
    <%--    </c:if>--%>

</liferay-ui:icon-menu>