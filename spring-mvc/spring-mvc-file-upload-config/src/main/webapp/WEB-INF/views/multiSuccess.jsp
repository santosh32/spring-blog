<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>File Upload Success</title>

</head>
<body>
	<div>
		<c:forEach var="fileName" items="${fileNames}"> File  <strong>${fileName}</strong> uploaded successfully<br /> </c:forEach>
		<br /> <a href="<c:url value='/welcome' />">Home</a>
	</div>
</body>
</html>