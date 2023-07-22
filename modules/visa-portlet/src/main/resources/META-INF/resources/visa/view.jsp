<%@ include file="../init.jsp" %>

<liferay-ui:header title="visa.view"/>

<aui:fieldset>

    <c:if test='${!visa.getEtat().equals("")}'>
        <aui:fieldset label="visa.information.status">
            <aui:row>
                <aui:col span="3">
                    <aui:input name="status" value="${visa.getEtat()}" label="visa.label.etat" type="text"
                               readonly="true"/>
                </aui:col>
            </aui:row>
        </aui:fieldset>
    </c:if>

    <aui:fieldset label="visa.information.personal">
        <aui:row>
            <aui:col span="6">
                <aui:input name="cin" value="${visa.getCin()}" label="visa.label.cin" type="text" readonly="true"/>
            </aui:col>
            <aui:col span="6">
                <aui:input name="passport" value="${visa.getPassport()}" label="visa.label.passport" type="text"
                           readonly="true"/>
            </aui:col>
        </aui:row>

        <aui:row>
            <aui:col span="6">
                <aui:input name="nom" value="${visa.getNom()}" label="visa.label.nom" type="text" readonly="true"/>
            </aui:col>
            <aui:col span="6">
                <aui:input name="prenom" value="${visa.getPrenom()}" label="visa.label.prenom" type="text"
                           readonly="true"/>
            </aui:col>
        </aui:row>
        <aui:row>
            <aui:col>
                <aui:input name="dateNaissance" value="${visa.getDateNaissance()}" label="visa.label.dateNaissance"
                           type="date" readonly="true"/>
            </aui:col>
        </aui:row>
    </aui:fieldset>
    <aui:fieldset label="visa.information.traveling">
        <aui:row>
            <aui:col span="6">
                <aui:input name="dateVoyage" value="${visa.getDateVoyage()}" label="visa.label.dateVoyage" type="date"
                           readonly="true"/>
            </aui:col>
            <aui:col span="6">
                <aui:input name="dureeVoyage" value="${visa.getDureeVoyage()}" label="visa.label.dureeVoyage"
                           type="number" readonly="true"/>
            </aui:col>
        </aui:row>
        <aui:row>
            <aui:col>
                <aui:input name="motifVoyage" value="${visa.getMotifVoyage()}" label="visa.label.motifVoyage"
                           type="textarea" readonly="true"/>
            </aui:col>
        </aui:row>
    </aui:fieldset>
</aui:fieldset>

