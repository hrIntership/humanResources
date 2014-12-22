<%@page import="org.springframework.web.bind.annotation.RequestMethod"%>
<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<script src="${pageContext.request.contextPath}/resources/js/bootstrapValidator.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrapValidator.min.js"></script>

<div class="container-fluid">
	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Add Work Experience</h1>
		</div>
	</div>
	<!-- /.row -->

	<form:form method="POST" commandName="background"
		action="${pageContext.request.contextPath}/background/edit.html">
		
             <input type="hidden" name="idBackground" value="${idBackground}"/>
			<div class="row">
			<div class="form-group">
				<div class="col-sm-4">
					<label class="col-lg-4 control-label">Company *</label>

					<form:input type="text" class="form-control" name="company"
						placeholder="company" path="company" 
						data-bv-notempty="true"
						data-bv-notempty-message="The Company is required and cannot be empty" />

				</div>
			</div>
		</div>
		<div class="row"></div>
		<div class="row">
			<div class="form-group">
				<div class="col-sm-4">
					<form:label path="jobTitle">Job Title *</form:label>
					<form:input type="text" class="form-control" name="jobTitle"
						placeholder="jobTitle" path="jobTitle" 
						data-bv-notempty="true"
						data-bv-notempty-message="The Job Title is required and cannot be empty" />

				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group">
				<div class="col-sm-4">

					<form:label path="dateFrom">From</form:label>
					<form:input class="form-control" path="dateFrom" value="1970-01-01"
						type="date" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group">
				<div class="col-sm-4">
					<form:label path="dateTo">To</form:label>
					<form:input class="form-control" path="dateTo" value="1970-01-01"
						type="date" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group">
				<div class="col-sm-4">
					<form:label path="comment">Comment</form:label>
					<form:textarea class="form-control" path="comment" />

				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header"></h1>
		</div>
	</div>
	
<input class="btn btn-default" type="submit" value="Save" 
			name="saveandcont" />
	</form:form>
</div>
<!-- /.container-fluid -->

<script>
$(document).ready(function() {
    $('#background').bootstrapValidator();
});
</script>
