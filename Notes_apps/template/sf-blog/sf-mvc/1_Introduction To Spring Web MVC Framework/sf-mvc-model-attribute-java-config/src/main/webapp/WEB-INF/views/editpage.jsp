<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

	<h1>Edit Person</h1>

	<c:url var="saveUrl" value="/person/edit/${personAttribute.id}" />
	<form:form modelAttribute="personAttribute" method="POST" action="${saveUrl}">
		<table>
			<tr>
				<td><form:label path="id">Id:</form:label></td>
				<td><form:input path="id" disabled="true" /></td>
			</tr>

			<tr>
				<td><form:label path="firstName">First Name:</form:label></td>
				<td><form:input path="firstName" /></td>
			</tr>

			<tr>
				<td><form:label path="lastName">Last Name</form:label></td>
				<td><form:input path="lastName" /></td>
			</tr>

			<tr>
				<td><form:label path="money">Money</form:label></td>
				<td><form:input path="money" /></td>
			</tr>

			<tr>
				<td><form:label path="currency">Currency:</form:label></td>
				<td><form:select path="currency" items="${currencies}" /></td>
			</tr>
		</table>

		<input type="submit" value="Save" />
	</form:form>

</body>
</html>