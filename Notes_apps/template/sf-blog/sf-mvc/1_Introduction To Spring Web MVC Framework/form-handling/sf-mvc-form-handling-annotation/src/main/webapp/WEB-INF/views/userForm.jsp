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
	<!-- Step 1. -->
	<form:form method="POST" action="user">
	<!-- Step 2. -->
	<%-- <form:form method="POST" action="user" commandName="user"> --%>
	<!-- Step 3. -->
	<%-- <form:form method="POST" action="user" modelAttribute="user"> --%>
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
				<td>
					<form:select path="country">
							<form:option value="0" label="Select" />
							<form:option value="1" label="India" />
							<form:option value="2" label="USA" />
							<form:option value="3" label="UK" />
					</form:select>
				</td>
				<td><form:errors path="country" cssClass="error" /></td>
			</tr>
			<tr>
				<td>About you :</td>
				<td><form:textarea path="aboutYou" /></td>
				<td><form:errors path="aboutYou" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Community :</td>
				<td>
					<form:checkbox path="community" value="Spring" label="Spring" /> 
					<form:checkbox path="community" value="Hibernate" label="Hibernate" /> 
					<form:checkbox path="community" value="Struts" label="Struts" />
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