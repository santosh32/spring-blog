<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Success Page</title>
</head>
<body>
	User Details
	<hr>
	User Name : ${user.name}
	<br /> Gender : ${user.gender}
	<br /> Country : ${user.country}
	<br /> About You : ${user.aboutYou}
	<br /> Community :
	<c:forEach items="${user.community}" var="c">
		<c:out value="${c}" />
	</c:forEach>
	<br /> hobbies :
	<c:forEach items="${user.hobbies}" var="h">
		<c:out value="${h}" />
	</c:forEach>
	<br />Feed Subscription: ${user.feed}
</body>
</html>