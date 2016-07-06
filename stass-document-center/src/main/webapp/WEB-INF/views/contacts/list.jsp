<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div>
    <spring:message code="label_contact_list" var="labelContactList"/>
    <spring:message code="label_contact_first_name" var="labelContactFirstName"/>
    <spring:message code="label_contact_last_name" var="labelContactLastName"/>
    <spring:message code="label_contact_birth_date" var="labelContactBirthDate"/>
    <spring:url value="/contacts" var="showContactUrl"/>
    <h1>${labelContactList}</h1>
    <c:if test="${not empty contacts}">
    <table>
        <thead>
        <tr>
            <th>${labelContactFirstName}</th>
            <th>${labelContactLastName}</th>
            <th>${labelContactBirthDate}</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${contacts}" var="contact">
            <tr>
                <td>
                    <a href="${showContactUrl}/${contact.id}">${contact.firstName}</a>
                </td>
                <td>${contact.lastName}</td>
                <td><joda:format value="${contact.birthDate}" pattern="yyyy-MM-dd"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </c:if>
</div>