<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Login</title>
</head>
<body>
	<h2>Login Page</h2>
	<form:form method="post" action="userCheck">

		<table>
			<tr>
				<td>Enter User Name :</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Enter Password :</td>
				<td><input type="password" name="pwd" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="login" /></td>
			</tr>
		</table>

	</form:form>
</body>
</html>