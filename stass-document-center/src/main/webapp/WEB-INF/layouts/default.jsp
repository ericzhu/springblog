<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=8"/>
    <spring:url value="/resources/styles/standard.css" var="app_css_url"/>
    <link rel="stylesheet" type="text/css" media="screen" href="${app_css_url}"/>

    <!-- Get the user locale from the page context (it was set by Spring MVC's locale resolver) -->
    <c:set var="userLocale">
        <c:set var="plocale">${pageContext.response.locale}</c:set>
        <c:out value="${fn:replace(plocale, '_', '-')}" default="en"/>
    </c:set>

    <spring:message code="application_name" var="app_name" htmlEscape="false"/>
    <title><spring:message code="welcome_h3" arguments="${app_name}"/></title>
    
    <!-- jQuery and jQuery UI -->
	<spring:url value="/resources/scripts/jquery-1.11.1.js" var="jquery_url" />
	<spring:url value="/resources/scripts/jquery-ui-1.10.4.custom.min.js" var="jquery_ui_url" />
	<spring:url value="/resources/styles/custom-theme/jquery-ui-1.10.4.custom.css" var="jquery_ui_theme_css" />
	<link rel="stylesheet" type="text/css" media="screen" href="${jquery_ui_theme_css}" />
	<script src="${jquery_url}" type="text/javascript"><jsp:text/></script>
	<script src="${jquery_ui_url}" type="text/javascript"><jsp:text/></script>
</head>
<body>
    <div id="headerWrapper">
        <tiles:insertAttribute name="header" ignore="true"/>
    </div>
    <div id="wrapper">
        <tiles:insertAttribute name="menu" ignore="true"/>
        <div id="main">
            <tiles:insertAttribute name="body"/>
            <tiles:insertAttribute name="footer" ignore="true"/>
        </div>
    </div>
</body>
</html>
