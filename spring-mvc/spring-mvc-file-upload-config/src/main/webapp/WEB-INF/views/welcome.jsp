<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<title>Spring 4 MVC File Upload Example</title>

</head>
<body>
	<div>
		<h1>Welcome to FileUploader Example</h1>

		Click on below links to see FileUpload in action.<br /> <br />
		 <a href="<c:url value='/singleUpload' />">Single File Upload</a> OR 
		 <a href="<c:url value='multiUpload' />">Multi File Upload</a>
	</div>
</body>
</html>