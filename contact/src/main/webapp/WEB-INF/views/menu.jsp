<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div id="menu">
    <spring:message code="menu_header_text" var="menuHeaderText"/>
    <spring:message code="menu_add_contact" var="menuAddContact"/>
    <spring:url value="/contacts?form" var="addContactUrl"/>
    <h3>${menuHeaderText}</h3>
    <a href="${addContactUrl}"><h3>${menuAddContact}</h3></a>
</div>