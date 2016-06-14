<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<spring:message code="label_contact_list" var="labelContactList" />
<spring:message code="label_contact_first_name" var="labelContactFirstName" />
<spring:message code="label_contact_last_name" var="labelContactLastName" />
<spring:message code="label_contact_birth_date" var="labelContactBirthDate" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${labelContactList}</title>
</head>
<body>
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
						<td>${contact.firstName}</td>
						<td>${contact.lastName}</td>
						<td><joda:format value="${contact.birthDate}"
								pattern="yyyy-MM-dd" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>