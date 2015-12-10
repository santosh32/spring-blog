<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Create User</title>
</head>
<body>
	<h2>Create User</h2>
	<form:form method="post" action="/createUser" commandName="user">

		<table>
			<tr>
				<td><form:label path="name">Enter User Name:</form:label></td>
				<td><form:input path="name" /> <font color="red"> 
				<form:errors path="name"></form:errors></font></td>
			</tr>
			<tr>
				<td><form:label path="age">Enter age:</form:label></td>
				<td><form:input path="age" /> <font color="red"> 
				<form:errors path="age"></form:errors></font></td>
			</tr>
			<tr>
				<td><form:label path="location">Enter location :</form:label></td>
				<td><form:input path="location" /> <font color="red"> 
				<form:errors path="location"></form:errors></font></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add User" /></td>
			</tr>
		</table>

	</form:form>
</body>
</html>