<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Create User</title>
</head>
<body>
	<form:form action="/createUser" method="post">
  		 Enter User Name: <form:input path="name" /> <br />
   		 Enter age      : <form:input path="age" /> <br />
         Enter location : <form:input path="location" /> <br />
		<input type="submit">
	</form:form>
</body>
</html>