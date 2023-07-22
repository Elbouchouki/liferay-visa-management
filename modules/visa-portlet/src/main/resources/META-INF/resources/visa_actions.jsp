<%@ include file="/init.jsp" %>

<c:set
        var="visa"
        value="${SEARCH_CONTAINER_RESULT_ROW.object}"
/>

<liferay-ui:icon-menu markupView="lexicon">

    <portlet:renderURL var="viewVisaURL">
        <portlet:param name="mvcRenderCommandName" value="<%=VisaPortletKeys.MVCCommandNames.VIEW_VISA %>"/>
        <portlet:param name="redirect" value="${currentURL}"/>
        <portlet:param name="visaId" value="${visa.visaId}"/>
    </portlet:renderURL>

    <liferay-ui:icon message="view" url="${viewVisaURL}"/>

    <portlet:renderURL var="editVisaURL">
        <portlet:param name="mvcRenderCommandName" value="<%=VisaPortletKeys.MVCCommandNames.EDIT_VISA %>"/>
        <portlet:param name="redirect" value="${currentURL}"/>
        <portlet:param name="visaId" value="${visa.visaId}"/>
    </portlet:renderURL>

    <liferay-ui:icon message="edit" url="${editVisaURL}"/>

    <portlet:actionURL name="<%=VisaPortletKeys.MVCCommandNames.DELETE_VISA %>" var="deleteVisaURL">
        <portlet:param name="redirect" value="${currentURL}"/>
        <portlet:param name="visaId" value="${visa.visaId}"/>
    </portlet:actionURL>

    <liferay-ui:icon-delete url="${deleteVisaURL}"/>

</liferay-ui:icon-menu>