<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>User Page</title>
<style>
.error {
	color: #ff0000;
}
</style>
</head>
<body>
	<form:form method="POST" action="user" modelAttribute="user">
		<table>
			<tr>
				<td>User Name :</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Date Of Birth :</td>
				<td><form:input path="dateOfBirth" placeholder="MM/dd/yyyy"/></td>
				<td><form:errors path="dateOfBirth" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Salary :</td>
				<td><form:input path="salary" /></td>
				<td><form:errors path="salary" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>