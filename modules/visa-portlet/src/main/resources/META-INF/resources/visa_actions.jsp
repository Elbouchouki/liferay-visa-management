<%@ include file="/init.jsp" %>

<c:set
        var="visa"
        value="${SEARCH_CONTAINER_RESULT_ROW.object}"
/>

<liferay-ui:icon-menu markupView="lexicon">
    <%--    <c:if test="${visaPermission.contains(permissionChecker, visa.visaId, 'VIEW' )}">--%>
    <portlet:renderURL var="viewVisaURL">
        <portlet:param name="mvcRenderCommandName" value="<%=VisaPortletKeys.MVCCommandNames.VIEW_VISA %>"/>
        <portlet:param name="redirect" value="${currentURL}"/>
        <portlet:param name="visaId" value="${visa.visaId}"/>
    </portlet:renderURL>
    <liferay-ui:icon message="view" url="${viewVisaURL}"/>
    <%--    </c:if>--%>

    <c:if test="${visaPermission.contains(permissionChecker, visa.visaId, 'UPDATE' )}">
        <portlet:renderURL var="editVisaURL">
            <portlet:param name="mvcRenderCommandName" value="<%=VisaPortletKeys.MVCCommandNames.EDIT_VISA %>"/>
            <portlet:param name="redirect" value="${currentURL}"/>
            <portlet:param name="visaId" value="${visa.visaId}"/>
        </portlet:renderURL>
        <liferay-ui:icon message="edit" url="${editVisaURL}"/>
    </c:if>


    <c:if test="${visaPermission.contains(permissionChecker, visa.visaId, 'DELETE' )}">
        <portlet:actionURL name="<%=VisaPortletKeys.MVCCommandNames.DELETE_VISA %>" var="deleteVisaURL">
            <portlet:param name="redirect" value="${currentURL}"/>
            <portlet:param name="visaId" value="${visa.visaId}"/>
        </portlet:actionURL>
        <liferay-ui:icon-delete url="${deleteVisaURL}"/>
    </c:if>


    <c:if test="${visaPermission.contains(permissionChecker, visa.visaId, 'PERMISSIONS')}">
        <liferay-security:permissionsURL
                modelResource="com.liferay.gwenod.visa.model.Visa"
                modelResourceDescription="${visa.getCin()}"
                resourcePrimKey="${visa.visaId}"
                var="permissionsURL"
        />
        <liferay-ui:icon message="permissions" url="${permissionsURL}"/>
    </c:if>


</liferay-ui:icon-menu>