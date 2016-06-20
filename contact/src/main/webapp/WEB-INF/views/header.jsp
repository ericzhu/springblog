<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div id="header">
    <spring:message code="header_text" var="headerText"/>
    <div id="appname">
        <h1>${headerText}</h1>
    </div>
</div>