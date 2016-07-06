<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<spring:message code="label_contact_new" var="labelContactNew"/>
<spring:message code="label_contact_update" var="labelContactUpdate"/>
<spring:message code="label_contact_first_name" var="labelContactFirstName"/>
<spring:message code="label_contact_last_name" var="labelContactLastName"/>
<spring:message code="label_contact_birth_date" var="labelContactBirthDate"/>
<spring:message code="label_contact_description" var="labelContactDescription"/>
<spring:message code="label_contact_photo" var="labelContactPhoto"/>
<spring:eval expression="contact.id == null ? labelContactNew:labelContactUpdate" var="formTitle"/>
<div>
    <h1>${formTitle}</h1>
    <div id="contactUpdate">
        <form:form modelAttribute="contact" id="contactUpdateForm" method="post">
        <c:if test="${not empty message}">
            <div id="message" class="${message.type}">${message.message}</div>
        </c:if>
            <form:label path="firstName">
                ${labelContactFirstName}*
            </form:label>
            <form:input path="firstName" />
            <div>
                <form:errors path="firstName" cssClass="error" />
            </div>
            <p/>
            <form:label path="lastName">
                ${labelContactLastName}*
            </form:label>
            <form:input path="lastName" />
            <div>
                <form:errors path="lastName" cssClass="error" />
            </div>
            <p/>
            <form:label path="birthDate">
                ${labelContactBirthDate}
            </form:label>
            <form:input path="birthDate" id="birthDate"/>
            <div>
                <form:errors path="birthDate" cssClass="error" />
            </div>
            <p/>
            <form:label path="description">
                ${labelContactDescription}
            </form:label>
            <form:textarea cols="60" rows="8" path="description" id="contactDescription"/>
            <div>
                <form:errors path="description" cssClass="error" />
            </div>
            <p/>
            <form:hidden path="version" />
            <button type="submit">Save</button>
            <button type="reset">Reset</button>
        </form:form>
    </div>
</div>
