<html>
<head>
<title>Employee page</title>
</head>
<body>
	<h2>Employee Details Using Path Variables -</h2>
	<table>
		<tr>
			<td>Name : ${employee.getName()}</td>
		</tr>
		<tr>
			<td>Address : ${employee.getAddress()}</td>
		</tr>
		<tr>
			<td>City : ${employee.getCity()}</td>
		</tr>
		<tr>
			<td>State : ${employee.getState()}</td>
		</tr>
		<tr>
			<td>Country : ${employee.getCountry()}</td>
		</tr>
	</table>
</body>
</html>