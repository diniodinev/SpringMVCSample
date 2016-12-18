<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ include file="_include/taglibs.jsp" %>
<%@ include file="_include/js_scripts.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Project Manager</title>


</head>
<body>

	<jsp:include page="../views/fragments/header.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div class="col-lg-11 col-md-offset-4">
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-9">
							<form:form modelAttribute="loginForm">
								<div class="row">
									<div class="form-group col-xs-3">
										<label for="userName"><spring:message
												code="loginForm.userName" /></label>
										<form:input path="userName" cssClass="form-control" />
									</div>
								</div>
								<div class="row">
									<div class="form-group col-xs-3">
										<label for="firstName"><spring:message
												code="loginForm.firstName"></spring:message></label>
										<form:input path="firstName" cssClass="form-control" />
									</div>
								</div>
								<div class="row">
									<div class="form-group col-xs-3">
										<label for="middleName"><spring:message
												code="loginForm.middleName" /></label>
										<form:input path="middleName" cssClass="form-control" />
									</div>
								</div>
								<div class="row">
									<div class="form-group col-xs-3">
										<label for="lastName"><spring:message
												code="loginForm.lastName" /></label>
										<form:input path="lastName" cssClass="form-control" />
									</div>
								</div>

								<div class="row">
									<div class="form-group col-xs-3">
										<label for="organizations"><spring:message
												code="loginForm.lastName" /></label>
										<spring:message code="login.select.default.option"
											var="defaultSelectName" />
										<form:select path="organizations" multiple="false"
											cssClass="form-control">
											<form:option value="${defaultSelectName}"></form:option>
											<form:options items="${companyNames}"></form:options>
										</form:select>
									</div>
								</div>

								<div class="row">
									<div class="form-group col-xs-3">
										<fieldset for="categories">
											<spring:message code="loginForm.categories" />
											<div class="checkbox">
												<c:forEach items="${categs}" var="category">
													<label for="categories"> ${category.name} </label>
													<form:checkboxes path="categories"
														items="${category.parts}" class="checkbox" />
												</c:forEach>
											</div>
										</fieldset>
									</div>
								</div>

								<div class="row">
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-2">
												<div class="btn-group">
													<button type="submit" id="submitButton"
														class="btn btn-default">
														<spring:message code="button.login" />
													</button>
												</div>
											</div>
										</div>
									</div>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>