<%@page import="java.util.Date"%>
<%@page import="org.apache.naming.java.javaURLContextFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	The current server time is :
	<%=new Date()%>
	
	</br>
	</br>
	
	Is this right: <%= 79<69 %>
	</br>
	</br>
	
	</br>
	</br>
	
	 I am a mathematician I can multiply easily 56 * 19  <%= 56*19 %>
</body>
</html>