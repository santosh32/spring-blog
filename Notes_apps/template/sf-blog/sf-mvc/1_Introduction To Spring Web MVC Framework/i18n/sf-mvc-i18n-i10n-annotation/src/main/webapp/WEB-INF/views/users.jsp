<%@ page contentType="text/html;charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<title>user details</title>
</head>

<body>
	<h2>
		<spring:message code="lbl.page" text="All Users in System" />
	</h2>

	<table border="1">
		<tr>
			<th><spring:message code="lbl.Id" text="User Id" /></th>
			<th><spring:message code="lbl.firstName" text="First Name" /></th>
			<th><spring:message code="lbl.lastName" text="Last Name" /></th>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>