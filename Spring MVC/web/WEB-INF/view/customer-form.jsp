<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
	<title>Customer Registration Form</title>
	
	<style>
		.error {color:red}
	</style>
</head>
<body>

<i>Fill out the form. Asterisk (*) means required.</i>
<br><br>

	<form:form action="processForm" modelAttribute="customer">
	
		First name: <form:input path="firstName" />
		
		<br><br>
		
		Last name (*): <form:input path="lastName" />
		<form:errors path="lastName" cssClass="error" />
		
		<br><br>

		Free pasess
		<form:input path="freePases" />
		<form:errors path="freePases" cssClass="error"/>
		<br><br>

		postalCode
		<form:input path="postalCode" />
		<form:errors path="postalCode" cssClass="error"/>

		<input type="submit" value="Submit" />
				
	</form:form>

</body>

</html>










