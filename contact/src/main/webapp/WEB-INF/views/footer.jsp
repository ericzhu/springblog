<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div id="footer">
    <spring:message code="home_text" var="homeText"/>
    <spring:message code="label_en_US" var="labelEnUs"/>
    <spring:message code="label_zh_HK" var="labelZhHk"/>
    <spring:url value="/contacts" var="homeUrl"/>
    <a href="${homeUrl}">${homeText}</a> |
    <a href="${homeUrl}?lang=en_US">${labelEnUs}</a> |
    <a href="${homeUrl}?lang=zh_HK">${labelZhHk}</a>
</div>
