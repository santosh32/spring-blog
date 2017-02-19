<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC - Employee</title>
</head>
<body>
	<h2>Login</h2>
	<form:form method="post" action="addEmployee">

		<table>
			<tr>
				<td><form:label path="firstName">First Name</form:label></td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName">Last Name</form:label></td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td><form:label path="age">Age</form:label></td>
				<td><form:input path="age" /></td>
			</tr>
			<tr>
				<td><form:label path="department">Department</form:label></td>
				<td><form:input path="department" /></td>
			</tr>
			<tr>
				<td><form:label path="salary">Salary</form:label></td>
				<td><form:input path="salary" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>

	</form:form>
</body>
</html>