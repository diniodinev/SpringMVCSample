<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<jsp:include page="../header.jsp"></jsp:include>
		
		<form action="studentsWelcome" method="post">
		  First name <input type="text" name="firstName" value="First name"/>
		  <br/><br/>
		  Last name <input type="text" name="lastName" value="Last name"/>
		  <br/><br/>
		  Choose country: 
		  <select name="country">
		  	<option>Bulgaria</option>
		  	<option>India</option>
		  	<option>Sumalia</option>
		  	<option>Syria</option>
		  	<option>Iran</option>
		  	<option>Afganistan</option>
		  </select>
		  <br/><br/>
		  
		  <input type="checkbox" name="favouriteProgramingLanguage" value="Java">Java</input>
		  <input type="checkbox" name="favouriteProgramingLanguage" value="Go">Go</input>
		  <input type="checkbox" name="favouriteProgramingLanguage" value="Scala">Scala</input>
		  <input type="checkbox" name="favouriteProgramingLanguage" value="Groovy">Groovy</input>
		  <br/><br/>
		  <input type="submit" value="Submit...">
		</form>
</body>
</html>