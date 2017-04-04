<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<title>Success Page</title>
</head>
<body>
	User Details
	<hr>
	User Name : ${user.name}<br/>
	Date Of Birth : ${user.dateOfBirth}<br/>
	Salary : ${user.salary}<br/>
	<br /> Formatted Date Of Birth : <spring:bind path="user.dateOfBirth">${status.value}</spring:bind>
	<br /> Formatted Salary : <spring:bind path="user.salary">${status.value}</spring:bind>
</body>
</html>