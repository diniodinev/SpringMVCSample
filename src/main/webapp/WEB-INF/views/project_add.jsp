<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Manager</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<spring:url value="/resources/css/home.css"/>" type="text/css" />
<link rel="stylesheet"
	href="<spring:url value="/resources/css/global.css"/>" type="text/css" />
<link rel="stylesheet"
	href="<spring:url value="/resources/css/bootstrap-select.min.css"/>"
	type="text/css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script
	src="<spring:url value="/resources/js/bootstrap-select.min.js"/>"></script>

</head>
<body>

	<jsp:include page="../views/fragments/header.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<spring:url value="/project/add" var="addUrl" />
			<form:form action="${addUrl }" method="post" modelAttribute="project"
				class="col-md-8 col-md-offset-2">

				<div class="form-group has-feedback">
					<label class="control-label">Project Name</label>
					<form:input path="name" id="project-name" cssClass="form-control"
						placeholder="Project Name" aria-describedby="basic-addon1" />
					<i class="glyphicon glyphicon-th-list form-control-feedback"></i>
				</div>
				<form:errors path="name" cssClass="alert alert-danger" />
				<br>

				<div class="form-group has-feedback">
					<label class="control-label">City Name</label>

					<form:select multiple="single" path="countries"
						cssClass="selectpicker">
						<c:forEach items="${inputCountries}" var="currentCountry">
							<optgroup label="${currentCountry.name}">
								<form:options items="${currentCountry.cities}"
									itemValue="cityName" itemLabel="cityName" />
							</optgroup>
						</c:forEach>
					</form:select>
				</div>
				<br>



				<div class="form-group">
					<label for="sponsor">Sponsor name</label>
					<form:input id="sponsor" cssClass="form-control"
						path="sponsor.name" />
				</div>

				<div class="form-group">
					<label for="sponsor">Sponsor email</label>
					<form:input id="sponsor" cssClass="form-control"
						path="sponsor.email" />
				</div>

				<div class="form-group">
					<label for="sponsor">Sponsor organization</label>
					<form:input id="sponsor" cssClass="form-control"
						path="sponsor.organization" />
				</div>

				<div class="form-group">
					<label for="funds">Authorized Funds</label>
					<form:input id="funds" cssClass="form-control"
						path="authorizedFunds" name="authorizedFunds" />
				</div>

				<div class="form-group">
					<label for="hours">Authorized Hours</label>
					<form:input id="hours" cssClass="form-control"
						path="authorizedHours" name="authorizedHours" />

				</div>

				<div class="form-group">
					<label for="project-name">Description</label>
					<form:textarea cssClass="form-control" rows="3" path="description"></form:textarea>
					<form:errors path="description" cssClass="error" />
				</div>

				<div class="form-group">
					<label for="poc">POC</label>
					<form:input path="personOfContact[0]" id="poc"
						cssClass="form-control" name="poc" />
				</div>

				<div class="form-group">
					<label for="poc2">POC2</label>
					<form:input path="personOfContact[1]" id="poc2"
						cssClass="form-control" name="poc2" />
				</div>

				<div class="form-group">
					<label for="poc3">POC3</label>
					<form:input path="personOfContact[2]" id="poc3"
						cssClass="form-control" name="poc3" />
				</div>

				<div class="control-group">
					<p class="pull-left">Payment Types</p>
					<br>
					<div class="controls span2">
						<label class="custom-control custom-checkbox"> <c:forEach
								items="${favLanguage}" var="language" varStatus="loop">
								<c:if test="${loop.index % 3 == 0}">
									<br>
								</c:if>
								<form:checkbox id="special" label="${language}"
									value="${language}" path="favouriteLanguage"
									name="${loop.index}" cssClass="custom-control-input" />
							</c:forEach>
						</label>
					</div>

				</div>

				<div class="control-group">
					<p class="pull-left">Favourite Phrases</p>
					
					<br>
					
					<form:input type="text" path="favouritePhrases[0]" placeholder="First phrase"/>
					<form:input type="text" path="favouritePhrases[1]" placeholder="One more"/>
					<form:input type="text" path="favouritePhrases[2]" placeholder="Finally"/>
				</div>
				<button type="submit" class="btn btn-default">Submit</button>

			</form:form>

		</div>
	</div>
</body>
</html>