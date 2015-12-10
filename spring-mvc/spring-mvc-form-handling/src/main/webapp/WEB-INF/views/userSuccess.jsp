<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>User Details Page</title>
</head>
<body>
	<h2>User Details Page</h2>
	<form:form>

		<table>
			<tr>
				<td>Name :</td>
				<td>${param.name}</td>
			</tr>
			<tr>
				<td>Age :</td>
				<td>${param.age}</td>
			</tr>
			<tr>
				<td>Location :</td>
				<td>${param.location}</td>
			</tr>
		</table>

	</form:form>
</body>
</html>