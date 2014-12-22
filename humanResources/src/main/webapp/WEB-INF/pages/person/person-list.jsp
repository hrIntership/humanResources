<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<div class="container-fluid">
	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">List Person</h1>
		</div>
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-6">
			<div class="table-responsive">
				<table class="table table-bordered table-hover table-striped">
					<thead>
						<tr>
							<th>Lastname</th>
							<th>Name</th>
							<th>ID Number</th>
							<th>Actions</th>
							<th>Background</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="person" items="${personList}">
							<tr>
								<td>${person.lastname}</td>
								<td>${person.firstname}</td>
								<td>${person.idNumber}</td>
								<td><a
									href="${pageContext.request.contextPath}/person/edit.html?personID=${person.idPerson}" >Edit</a><br />

								 <a
									href="${pageContext.request.contextPath}/person/delete/${person.idPerson}.html">Delete</a><br />

								</td>
								<td><a
									href="${pageContext.request.contextPath}/background/list/${person.idPerson}.html">List</a><br />
									<a
									href="${pageContext.request.contextPath}/background/create.html?personID=${person.idPerson}">Add new</a><br />
									
									</td>
									<td><a
									href="${pageContext.request.contextPath}/skills/create.html?personID=${person.idPerson}">Skill</a><br />
							
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!-- /.row -->

</div>
<!-- /.container-fluid -->
</body>

</html>