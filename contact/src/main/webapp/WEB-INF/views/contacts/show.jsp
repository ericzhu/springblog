<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div>
    <spring:message code="label_contact_info" var="labelContactInfo"/>
    <spring:message code="label_contact_first_name" var="labelContactFirstName"/>
    <spring:message code="label_contact_last_name" var="labelContactLastName"/>
    <spring:message code="label_contact_birth_date" var="labelContactBirthDate"/>
    <spring:message code="label_contact_description" var="labelContactDescription"/>
    <spring:message code="label_contact_update" var="labelContactUpdate"/>
    <spring:message code="date_format_pattern" var="dateFormatPattern"/>
    <spring:url value="/contacts" var="editContactUrl"/>
    <h1>${labelContactInfo}</h1>
    <div id="contactInfo">
        <c:if test="${not empty message}">
            <div id="message" class="${message.type}">${message.message}</div>
        </c:if>
        <table>
            <tr>
                <td>${labelContactFirstName}</td>
                <td>${contact.firstName}</td>
            </tr>
            <tr>
                <td>${labelContactLastName}</td>
                <td>${contact.lastName}</td>
            </tr>
            <tr>
                <td>${labelContactBirthDate}</td>
                <td><joda:format value="${contact.birthDate}" pattern="${dateFormatPattern}"/></td>
            </tr>
            <tr>
                <td>${labelContactDescription}</td>
                <td>${contact.description}</td>
            </tr>
        </table>
        <a href="${editContactUrl}/${contact.id}?form">${labelContactUpdate}</a>
    </div>
</div>