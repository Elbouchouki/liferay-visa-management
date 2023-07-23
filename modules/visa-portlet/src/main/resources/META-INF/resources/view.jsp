<%@ include file="/init.jsp" %>

<liferay-ui:error key="serviceErrorDetails">
    <liferay-ui:message arguments='<%= SessionErrors.get(request, "serviceErrorDetails") %>'
                        key="error.visa-service-error"/>
</liferay-ui:error>

<liferay-ui:success key="visaAdded" message="visa.add.success"/>
<liferay-ui:success key="visaDeleted" message="visa.delete.success"/>
<liferay-ui:success key="visaEdited" message="visa.edit.success"/>


<div class="container-fluid-1280">

    <h1><liferay-ui:message key="visa.title"/></h1>


    <clay:management-toolbar
            displayContext="${visaManagementToolbarDisplayContext}"
            selectable="false"
            itemsTotal="${visasCount}"
            searchContainerId="visaSearchContainer"

    />

    <liferay-ui:search-container
            id="visaSearchContainer"
            emptyResultsMessage="visa.empty"
            iteratorURL="${portletURL}"
            total="${visasCount}"

    >
        <liferay-ui:search-container-results results="${visas}"/>

        <liferay-ui:search-container-row
                className="com.liferay.gwenod.visa.model.Visa"
                modelVar="visa">

            <liferay-ui:search-container-column-user
                    name="author"
                    userId="<%= visa.getUserId() %>"
            />

            <liferay-ui:search-container-column-text
                    name="visa.label.cin"
                    value="<%= visa.getCin() %>"
            />

            <liferay-ui:search-container-column-text
                    name="visa.label.passport"
                    value="<%= visa.getPassport() %>"
            />

            <liferay-ui:search-container-column-text
                    name="status"
                    value='<%= visa.getEtat() == 0 ? "Pending" : visa.getEtat() == 1 ? "Accepted": "Refused" %>'
            />

            <liferay-ui:search-container-column-date
                    name="create-date"
                    property="createDate"
            />

            <liferay-ui:search-container-column-jsp
                    name=""
                    truncate="false"
                    path="/visa_actions.jsp"
            />

        </liferay-ui:search-container-row>


        <liferay-ui:search-iterator
                markupView="lexicon"
        />

    </liferay-ui:search-container>


</div>
