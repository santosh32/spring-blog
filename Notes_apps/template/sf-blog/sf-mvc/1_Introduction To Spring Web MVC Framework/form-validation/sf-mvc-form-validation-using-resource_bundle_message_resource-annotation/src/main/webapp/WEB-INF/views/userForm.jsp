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
	<form:form method="POST" commandName="user">
		<table>
			<tr>
				<td>User Name :</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Gender :</td>
				<td>
					<form:radiobutton path="gender" value="M" label="M" /> 
					<form:radiobutton path="gender" value="F" label="F" />
				</td>
				<td><form:errors path="gender" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Country :</td>
				<td><form:select path="country" items="${countries}" /></td>
				<td><form:errors path="country" cssClass="error" /></td>
			</tr>
			<tr>
				<td>About you :</td>
				<td><form:textarea path="aboutYou" /></td>
				<td><form:errors path="aboutYou" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Community :</td>
				<td><form:checkboxes items="${communities}" path="community" />
				</td>
				<td><form:errors path="community" cssClass="error" /></td>
			</tr>
			<tr>
				<td></td>
				<td><form:checkbox path="feed"
						label="Would you like to notify if any least updates ?" /></td>
				<td />
			</tr>
			<tr>
				<td colspan="3"><input type="submit"></td>
			</tr>

		</table>
	</form:form>
</body>
</html>