<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript">
function loadXMLDoc() {
    var xmlhttp = new XMLHttpRequest();

    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == XMLHttpRequest.DONE ) {
           if (xmlhttp.status == 200) {
               document.getElementById("myDiv").innerHTML = xmlhttp.responseText;
           }
           else if (xmlhttp.status == 400) {
              alert('There was an error 400');
           }
           else {
               alert('something else other than 200 was returned');
           }
        }
    };

    xmlhttp.open("GET", "ajax_info.txt", true);
    xmlhttp.send();
}
</script>

</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="../header.jsp"></jsp:include>

	<h4>Add items</h4>

	<form action="addItems">
		<input type="text" name="inputField" value="Add item">
			<br /> <br />
		 <input
			type="submit" name="btnSubmit" value="Sumbit ...">
			
				<br /> <br />
				
				 <input
			type="submit" name="btnSubmit" value="Invalidate Session" onclick="invalidateSession()">

		<%
			List<String> items = (List<String>) session.getAttribute("itemsList");
			if (items == null) {
				items = new ArrayList<String>();
			}
			if (request.getParameter("inputField") != null) {
				items.add(request.getParameter("inputField"));
			}
			session.setAttribute("itemsList", items);
		%>

		<br /> <br /> Current list items:
		<ol>
			<%
				for (String item : items) {
					out.println("<li>" + item + "</li>");
				}
			%>
		</ol>
	</form>
</body>
</html>