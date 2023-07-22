<%@ include file="../init.jsp" %>

<portlet:actionURL name="<%= VisaPortletKeys.MVCCommandNames.ADD_VISA %>" var="addVisaActionURL"/>

<liferay-ui:header title="visa.add"/>

<aui:form action="<%= addVisaActionURL %>" name="visaForm" method="post">

    <aui:fieldset label="visa.information.personal">
        <aui:row>
            <aui:col span="6">
                <aui:input name="cin" label="visa.label.cin" type="text">
                    <aui:validator name="required" errorMessage="Cin is required"/>
                    <aui:validator name="alphanum" errorMessage="Cin must be alphanumeric"/>
                </aui:input>
            </aui:col>
            <aui:col span="6">
                <aui:input name="passport" label="visa.label.passport" type="text">
                    <aui:validator name="required" errorMessage="Passport number is required"/>
                    <aui:validator name="alphanum" errorMessage=" Passport number must be alphanumeric"/>
                </aui:input>
            </aui:col>
        </aui:row>

        <aui:row>
            <aui:col span="6">
                <aui:input name="nom" label="visa.label.nom" type="text">
                    <aui:validator name="required" errorMessage="Firstname is required"/>
                    <aui:validator name="alpha" errorMessage="Firstname must be alphabetic"/>
                </aui:input>
            </aui:col>
            <aui:col span="6">
                <aui:input name="prenom" label="visa.label.prenom" type="text">
                    <aui:validator name="required" errorMessage="Lastname is required"/>
                    <aui:validator name="alpha" errorMessage="Lastname must be alphabetic"/>
                </aui:input>
            </aui:col>
        </aui:row>
        <aui:row>
            <aui:col>
                <aui:input name="dateNaissance" label="visa.label.dateNaissance" type="date">
                    <aui:validator name="required" errorMessage="Birthdate is required"/>
                </aui:input>
            </aui:col>
        </aui:row>
    </aui:fieldset>
    <aui:fieldset label="visa.information.traveling">
        <aui:row>
            <aui:col span="6">
                <aui:input name="dateVoyage" label="visa.label.dateVoyage" type="date">
                    <aui:validator name="required" errorMessage="Travel date is required"/>
                </aui:input>
            </aui:col>
            <aui:col span="6">
                <aui:input name="dureeVoyage" label="visa.label.dureeVoyage" type="number">
                    <aui:validator name="required" errorMessage="Travel duration is required"/>
                </aui:input>
            </aui:col>
        </aui:row>
        <aui:row>
            <aui:col>
                <aui:input name="motifVoyage" label="visa.label.motifVoyage" type="textarea">
                    <aui:validator name="required" errorMessage="Reason for travel is required"/>
                </aui:input>
            </aui:col>
        </aui:row>

    </aui:fieldset>

    <aui:button-row cssClass="cropper-center">
        <aui:button type="submit" value="visa.add.submit"/>
    </aui:button-row>
</aui:form>
