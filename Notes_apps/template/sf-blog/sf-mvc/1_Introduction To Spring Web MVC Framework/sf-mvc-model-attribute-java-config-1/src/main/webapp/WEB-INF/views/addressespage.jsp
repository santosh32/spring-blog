<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

	<h1>Addresses</h1>

	<table>
		<tr>
			<td width="100">Id</td>
			<td width="150">Street</td>
			<td width="150">City</td>
			<td width="150">Zip Code</td>
		</tr>
		<c:forEach items="${addresses}" var="address">
			<tr>
				<td><c:out value="${address.id}" /></td>
				<td><c:out value="${address.street}" /></td>
				<td><c:out value="${address.city}" /></td>
				<td><c:out value="${address.zipCode}" /></td>
			</tr>
		</c:forEach>
	</table>

	<p>${greetings}</p>
</body>
</html>