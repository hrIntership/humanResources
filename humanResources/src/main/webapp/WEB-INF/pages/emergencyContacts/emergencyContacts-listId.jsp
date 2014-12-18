<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<%
	HttpSession ses = request.getSession();
	Integer sessionIdPerson = (Integer) ses.getAttribute("id_Person");
%>
<div class="container-fluid">
	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">List Emergency Contacts</h1>
		</div>
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="table-responsive">
				<table class="table table-bordered table-hover table-striped">
					<form:input type="hidden" path="idPerson"
						value='<%=sessionIdPerson%>' />

					<thead>
						<tr>

							<th>Full Name</th>
							<th>Relationship</th>
							<th>Movile</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="emergencyContacts"
							items="${emergencyContactsListId}">
							<tr>

								<td>${emergencyContacts.fullName}</td>
								<td>${emergencyContacts.relationship}</td>
								<td>${emergencyContacts.movile}</td>
								<td><a
									href="${pageContext.request.contextPath}/emergencyContacts/edit/${emergencyContacts.idPerson}.html">Edit</a><br />
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<input type=button class="btn btn-primary"
				onClick="location.href='${pageContext.request.contextPath}/emergencyContacts/create.html'"
				value='ADD'>

		</div>
	</div>
	<!-- /.row -->

</div>
<!-- /.container-fluid -->

</html>