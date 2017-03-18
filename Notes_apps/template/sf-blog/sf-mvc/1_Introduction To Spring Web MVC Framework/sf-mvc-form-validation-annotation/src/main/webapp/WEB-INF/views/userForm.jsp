<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>User Page</title>
</head>
<body>
	<form:form method="POST" commandName="userForm">
		<table>
			<tr>
				<td>Email :</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" cssClass="error" /></td>
			</tr>
		</table>
		<tr>
			<td colspan="3"><input type="submit" value="Login"></td>
		</tr>
	</form:form>
</body>
</html>