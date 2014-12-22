<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">

<div class="container-fluid">
	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Staff</h1>
		</div>
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="table-responsive">
				<table class="table table-bordered table-hover table-striped">
					<thead>
						<tr>
							<th>ID Person</th>
							<th>From</th>
							<th>To</th>
							<th>Salary</th>
							<th>Tasks</th>
							<th>Workspace</th>
							<th>Agreement</th>
							<th>Category</th>
							<th>Health Insurance</th>
							<th>Actions</th>

						</tr>
					</thead>
					<tbody>
						
							<tr>
							
								<td>${staff.idPerson}</td>
								<td>${staff.dateFrom}</td>
								<td>${staff.dateTo}</td>
								<td>${staff.salary}</td>
								<td>${staff.tasks}</td>
								<td>${staff.workspace}</td>
								<td>${staff.agreement}</td>
								<td>${staff.category}</td>
								<td>${staff.healthInsurance}</td>
								<td><a
									href="${pageContext.request.contextPath}/staff/edit/${staff.idPerson}.html">Edit</a><br />
								</td>
							</tr>
						
					</tbody>
				</table>
			</div>
		</div>
	
					<input type=button class="btn btn-primary" onClick="location.href='${pageContext.request.contextPath}/staff/create.html?personID=${personID}'"  value='ADD'>
	  </div>
	<!-- /.row -->

</div>
<!-- /.container-fluid -->

</html>