<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<title>Success Page</title>
</head>
<body>
	User Details
	<hr>
	User Name : ${user.name}
	<br /> Date Of Birth : <spring:bind path="user.dateOfBirth">${status.value}</spring:bind>
	<br /> Salary : <spring:bind path="user.salary">${status.value}</spring:bind>
</body>
</html>