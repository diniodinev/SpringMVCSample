<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Hello Mr ${param.firstName} ${param.firstName}

	<br />
	<br /> Greetings for: ${param.country}

	<br />
	<br /> We know that your favourite language is:
	<ul>
		<%
			String[] languages = request.getParameterValues("favouriteProgramingLanguage");

			for (String lang : languages) {
				out.println("<li>" + lang + "</li>");
			}
		%>
	</ul>
</body>
</html>