<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrapValidator.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery_checkbox.js"
	type="text/javascript"></script>

<!DOCTYPE html>
<%
	HttpSession ses = request.getSession();
	Integer sessionIdPerson = (Integer) ses.getAttribute("id_Person");
%>

<div class="container-fluid">
	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Add Supplementary Information</h1>
		</div>
	</div>
	<!-- /.row -->

	<form:form method="POST" commandName="supplementaryInfo"
		id="supplementaryInfo"
		action="${pageContext.request.contextPath}/supplementaryInfo/create.html">
		
				<form:input type="hidden" path="idPerson" value='<%=sessionIdPerson%>' />
		
		<div id="supplementaryInfo">
			<div class="row">

				<div class="form-group">
					<div class="col-sm-4">
						<label title="Enable" for="enable" class="col-sm-4 control-label">Operation</label>
						<div class="checkbox">

							<form:checkbox path="operation" id="enable" name="enable"
								checked="checked" value="" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-4">
						<label class="col-lg-4 control-label">Amount</label>
						<form:input type="text" class="form-control" name="opAmount"
							placeholder="opAmount" path="opAmount" />

					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-4">
						<label class="col-lg-4 control-label">Causes</label>
						<form:input type="text" class="form-control" name="opCauses"
							placeholder="opCauses" path="opCauses" />

					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group">

					<div class="col-sm-4">
						<form:label path="allergy">Are you allergic to anything?</form:label>
						<form:input type="text" class="form-control" name="allergy"
							placeholder="allergy" path="allergy" data-bv-regexp="true"
							data-bv-regexp-regexp="^[a-zA-Z,ñ]+$"
							data-bv-regexp-message="The username can only consist of alphabetical, number, dot and underscore" />

					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-4">
						<form:label path="preexDiseases">Do you have pre-existing diseases?</form:label>
						<form:input type="text" class="form-control" name="preexDiseases"
							placeholder="preexDiseases" path="preexDiseases"
							data-bv-regexp="true" data-bv-regexp-regexp="^[a-zA-Z,ñ]+$"
							data-bv-regexp-message="The preexDiseases can only consist of alphabetical, number, dot and underscore"
							data-bv-notempty="true"
							data-bv-notempty-message="The preexDiseases is required and cannot be empty" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-4">
						<form:label path="bloodType">Blood Group</form:label>
						<select class="form-control select2-select" name="bloodType"
							required="required">
							<option value="" selected="selected">- select -</option>
							<c:forEach var="itemBloodType" items="${bloodTypeList}">
								<option value="<c:out value='${itemBloodType}' />"
									<c:if test="${supplementaryInfo.bloodType==itemBloodType}"> selected </c:if>>
									<c:out value="${itemBloodType}" />
								</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header"></h1>
				</div>
			</div>

			<input class="btn btn-default" type="submit" value="save" id="save"
				name="save" />
		</div>
</form:form>

<script>
	$(document).ready(function() {
		$('#supplementaryInfo').bootstrapValidator();
	});
</script>
</div>

<!--  -</html>-->