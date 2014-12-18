<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
							<th>Full name</th>
							<th>Staff Details</th>
							<th>Background Check</th>
							<th>Emergency Contacts</th>
							<th>Family Member</th>
							<th>Supplementary Info</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="staff" items="${staffList}">
							<tr>
								<td>${staff.idPerson}</td>
								<td>${staff.firstname}${staff.middlename} ${staff.lastname}</td>
								<td><a
									href="${pageContext.request.contextPath}/staff/listId/.html?personID=${staff.idPerson}">Details</a><br />
								</td>
								<td><a
									href="${pageContext.request.contextPath}/bCheck/list/${staff.idPerson}.html">Details</a><br />
								</td>
								<td><a
									href="${pageContext.request.contextPath}/emergencyContacts/list/${staff.idPerson}.html">Details</a><br />
								</td>
								<td><a
									href="${pageContext.request.contextPath}/familyMember/list/${staff.idPerson}.html">Details</a><br />
								</td>
								<td><a
									href="${pageContext.request.contextPath}/supplementaryInfo/list/${staff.idPerson}.html">Details</a><br />
								</td>
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

</html>