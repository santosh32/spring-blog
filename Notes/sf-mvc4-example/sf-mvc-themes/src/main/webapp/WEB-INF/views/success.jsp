<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
   <head>
        <title><spring:message code="user.title"/></title>
        <link rel="stylesheet" href="<spring:theme code='styleSheet'/>" type="text/css"/>
   </head>
<body bgcolor="<spring:theme code='background'/>">
  Change language: <a href="user?mylocale=en">English </a> | <a href="user?mylocale=de">German </a><br/><br/>
  Change theme: <a href="user?mytheme=theme1">Theme 1 </a> | <a href="user?mytheme=theme2"> Theme 2 </a>
  
  <h3> <spring:message code="user.success"/></h3>
</body>
</html>
