<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>

	<h1>Persons</h1>

	<table>
		<tr>
			<td width="50">Id</td>
			<td width="150">First Name</td>
			<td width="150">Last Name</td>
			<td width="100">Money</td>
			<td width="50">Currency</td>
		</tr>
		<c:forEach items="${persons}" var="person">
			<tr>
				<td><c:out value="${person.id}" /></td>
				<td><c:out value="${person.firstName}" /></td>
				<td><c:out value="${person.lastName}" /></td>
				<td><c:out value="${person.money}" /></td>
				<td><c:out value="${person.currency}" /></td>
			</tr>
		</c:forEach>
	</table>
	${msg}
</body>
</html>