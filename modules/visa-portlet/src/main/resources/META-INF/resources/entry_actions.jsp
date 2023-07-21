<%@ include file="/init.jsp" %>


<liferay-ui:icon-menu markupView="lexicon">

    <%-- View action. --%>
    <portlet:renderURL var="editAssignmentURL">
        <portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.ADD_VISA %>"/>
        <portlet:param name="redirect" value="${currentURL}"/>
        <portlet:param name="assignmentId" value="${assignment.assignmentId}"/>
    </portlet:renderURL>

    <liferay-ui:icon message="edit" url="${editAssignmentURL}"/>

</liferay-ui:icon-menu>