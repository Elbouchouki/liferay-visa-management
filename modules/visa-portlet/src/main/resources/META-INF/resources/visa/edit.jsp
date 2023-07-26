<%@ include file="../init.jsp" %>

<%
    Visa visa = (Visa) request.getAttribute("visa");
%>

<portlet:actionURL name="<%= VisaPortletKeys.MVCCommandNames.EDIT_VISA %>" var="editVisaActionURL"/>

<liferay-ui:header title="visa.edit"/>

<aui:form action="<%= editVisaActionURL %>" name="visaForm" method="post">

    <aui:input name="visaId" type="hidden" value="<%= visa.getVisaId() %>"/>

    <aui:fieldset label="visa.information.status">
        <aui:row>
            <aui:col span="3">
                <aui:select name="etat" label="visa.label.status" value="<%= visa.getEtat() %>">
                    <aui:option value="0" label="visa.status.pending"/>
                    <aui:option value="1" label="visa.status.accepted"/>
                    <aui:option value="-1" label="visa.status.rejected"/>
                </aui:select>
            </aui:col>
        </aui:row>
    </aui:fieldset>
    <aui:fieldset label="visa.information.personal">
        <aui:row>
            <aui:col span="6">
                <aui:input name="cin" label="visa.label.cin" type="text" value="<%= visa.getCin() %>">
                    <aui:validator name="required" errorMessage="Cin is required"/>
                    <aui:validator name="alphanum" errorMessage="Cin must be alphanumeric"/>
                </aui:input>
            </aui:col>
            <aui:col span="6">
                <aui:input name="passport" label="visa.label.passport" type="text" value="<%= visa.getPassport() %>">
                    <aui:validator name="required" errorMessage="Passport number is required"/>
                    <aui:validator name="alphanum" errorMessage=" Passport number must be alphanumeric"/>
                </aui:input>
            </aui:col>
        </aui:row>

        <aui:row>
            <aui:col span="6">
                <aui:input name="nom" label="visa.label.nom" type="text" value="<%= visa.getNom() %>">
                    <aui:validator name="required" errorMessage="Firstname is required"/>
                    <aui:validator name="alpha" errorMessage="Firstname must be alphabetic"/>
                </aui:input>
            </aui:col>
            <aui:col span="6">
                <aui:input name="prenom" label="visa.label.prenom" type="text" value="<%= visa.getPrenom() %>">
                    <aui:validator name="required" errorMessage="Lastname is required"/>
                    <aui:validator name="alpha" errorMessage="Lastname must be alphabetic"/>
                </aui:input>
            </aui:col>
        </aui:row>
        <aui:row>
            <aui:col>
                <%--                <aui:input name="dateNaissance" label="visa.label.dateNaissance" type="date"--%>
                <%--                           value="${dateNaissance}">--%>
                <%--                    <aui:validator name="required" errorMessage="Birthdate is required"/>--%>
                <%--                </aui:input>--%>
                <aui:input name="dateNaissance" label="visa.label.dateNaissance" type="text"
                           value="<%= visa.getDateNaissance() %>"
                           disabled="true"
                >
                    <aui:validator name="required" errorMessage="Birthdate is required"/>
                </aui:input>
            </aui:col>
        </aui:row>
    </aui:fieldset>
    <aui:fieldset label="visa.information.traveling">
        <aui:row>
            <aui:col span="6">
                <%--                <aui:input name="dateVoyage" label="visa.label.dateVoyage" type="date" value="${dateVoyage}">--%>
                <%--                    <aui:validator name="required" errorMessage="Travel date is required"/>--%>
                <%--                </aui:input>--%>
                <aui:input name="dateVoyage" label="visa.label.dateVoyage" type="text"
                           value="<%= visa.getDateVoyage() %>"
                           disabled="true">
                    <aui:validator name="required" errorMessage="Travel date is required"/>
                </aui:input>
            </aui:col>
            <aui:col span="6">
                <aui:input name="dureeVoyage" label="visa.label.dureeVoyage" type="number"
                           value="<%= visa.getDureeVoyage() %>">
                    <aui:validator name="required" errorMessage="Travel duration is required"/>
                </aui:input>
            </aui:col>
        </aui:row>
        <aui:row>
            <aui:col>
                <aui:input name="motifVoyage" label="visa.label.motifVoyage" type="textarea"
                           value="<%= visa.getMotifVoyage() %>">
                    <aui:validator name="required" errorMessage="Reason for travel is required"/>
                </aui:input>
            </aui:col>
        </aui:row>

    </aui:fieldset>

    <aui:button-row cssClass="cropper-center">
        <aui:button type="submit" value="visa.edit.submit"/>
    </aui:button-row>
</aui:form>