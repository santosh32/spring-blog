<html>
<head>
<title>Success Page</title>
</head>
<body>
	User Details
	<hr>
	User Name : ${user.name}
	<br /> Gender : ${user.gender}
	<br /> Date Of Birth : ${user.dateOfBirth}
	<br /> Country : ${user.country}
	<br /> About You : ${user.aboutYou}
	<br /> Community : ${user.community[0]} ${user.community[1]}
	${user.community[2]}
	<br /> Feed: ${user.feed}
</body>
</html>