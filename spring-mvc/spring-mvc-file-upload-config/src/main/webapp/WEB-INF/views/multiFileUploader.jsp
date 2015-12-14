<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

<head>
<title>Spring 4 MVC File Multi Upload Example</title>
</head>
<body>

	<div>
		<h1>Spring 4 MVC Multi File Upload Example</h1>
		<form:form method="POST" modelAttribute="multiFileBucket" enctype="multipart/form-data">

			<c:forEach var="v" varStatus="vs" items="${multiFileBucket.files}">
				<form:input type="file" path="files[${vs.index}].file" id="files[${vs.index}].file"/>
				<div>
					<form:errors path="files[${vs.index}].file"/>
				</div>
			</c:forEach>
			
			<br />
			<div>
				<div>
					<input type="submit" value="Upload">
				</div>
			</div>
		</form:form>

		<br /> <a href="<c:url value='/welcome' />">Home</a>
	</div>
</body>
</html>