<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<div class="container-fluid">
	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">List Family Member</h1>
		</div>
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="table-responsive">
				<table class="table table-bordered table-hover table-striped">
					<thead>
						<tr>

							<th>Full Name</th>
							<th>Nationality</th>
							<th>Relationship</th>
							<th>ID Type</th>
							<th>ID number</th>
							<th>Date of Birth</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="familyMember" items="${familyMemberListId}">
							<tr>

								<td>${familyMember.fullName}</td>
								<td>${familyMember.nationality}</td>
								<td>${familyMember.relationship}</td>
								<td>${familyMember.idType}</td>
								<td>${familyMember.idNumber}</td>
								<td>${familyMember.birthdate}</td>
								<td><a
									href="${pageContext.request.contextPath}/familyMember/edit/${staff.idPerson}.html">Edit</a><br />
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<input type=button class="btn btn-primary"
				onClick="location.href='${pageContext.request.contextPath}/familyMember/create.html'"
				value='ADD'>

		</div>



	</div>
	<!-- /.row -->

</div>
<!-- /.container-fluid -->

</html>