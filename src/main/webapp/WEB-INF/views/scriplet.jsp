<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		for (int i = 0; i <= 5; i++) {
			out.println("</br> I really love to code:" + i);
		}
	%>

</br>
</br>
	Now I will demonstrate the use of jsp declaration: <%= toLowerCase("Hello World") %>

	<%!
	String toLowerCase(String lower) {
		return lower.toLowerCase();
	}
	%>
</body>
</html>