<%@ include file="../init.jsp" %>


<%
    Visa visa = (Visa) request.getAttribute("visa");
%>

<liferay-ui:header title="visa.view"/>

<aui:fieldset>

    <aui:fieldset label="visa.information.status">
        <aui:row>
            <aui:col span="4">
                <aui:input name="status"
                           value='<%=visa.getEtat() == 0 ? "Pending" : visa.getEtat() == 1 ? "Accepted": "Refused"%>'
                           label="visa.label.etat" type="text"
                           readonly="true"/>
            </aui:col>
            <c:if test="<%=visa.getEtat() == 1%>">
                <aui:col span="4">
                    <aui:input name="modifiedBy" value="<%=visa.getModifiedBy()%>"
                               label="visa.label.modifiedBy"
                               type="text" readonly="true"/>
                </aui:col>
            </c:if>
            <c:if test="<%=visa.getEtat() == 1%>">
                <aui:col span="4">
                    <aui:input name="modifiedDate" value="<%=visa.getModifiedDate()%>"
                               label="visa.label.modifiedDate"
                               type="text" readonly="true"/>
                </aui:col>
            </c:if>
        </aui:row>
    </aui:fieldset>

    <aui:fieldset label="visa.information.personal">
        <aui:row>
            <aui:col span="6">
                <aui:input name="cin" value="<%=visa.getCin()%>"
                           label="visa.label.cin" type="text" readonly="true"/>
            </aui:col>
            <aui:col span="6">
                <aui:input name="passport" value="<%=visa.getPassport()%>"
                           label="visa.label.passport" type="text"
                           readonly="true"/>
            </aui:col>
        </aui:row>

        <aui:row>
            <aui:col span="6">
                <aui:input name="nom" value="<%=visa.getNom()%>"
                           label="visa.label.nom" type="text" readonly="true"/>
            </aui:col>
            <aui:col span="6">
                <aui:input name="prenom" value="<%=visa.getPrenom()%>"
                           label="visa.label.prenom" type="text"
                           readonly="true"/>
            </aui:col>
        </aui:row>
        <aui:row>
            <aui:col>
                <aui:input name="dateNaissance" value="<%=visa.getDateNaissance()%>"
                           label="visa.label.dateNaissance"
                           type="text" readonly="true"/>
            </aui:col>
        </aui:row>
    </aui:fieldset>
    <aui:fieldset
            label="visa.information.traveling">
        <aui:row>
            <aui:col span="6">
                <aui:input name="dateVoyage" value="<%=visa.getDateVoyage()%>"
                           label="visa.label.dateVoyage" type="text"
                           readonly="true"/>
            </aui:col>
            <aui:col span="6">
                <aui:input name="dureeVoyage" value="<%=visa.getDureeVoyage()%>"
                           label="visa.label.dureeVoyage"
                           type="number" readonly="true"/>
            </aui:col>
        </aui:row>
        <aui:row>
            <aui:col>
                <aui:input name="motifVoyage" value="<%=visa.getMotifVoyage()%>"
                           label="visa.label.motifVoyage"
                           type="textarea" readonly="true"/>
            </aui:col>
        </aui:row>
    </aui:fieldset>
</aui:fieldset>

