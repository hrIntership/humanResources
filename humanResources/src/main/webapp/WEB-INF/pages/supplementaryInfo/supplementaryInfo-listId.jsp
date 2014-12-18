<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script>
$(document).ready(function() {

	$("#search").on("input", function(e) {
		var val = $(this).val();
		if(val === "") return;
		//You could use this to limit results
		//if(val.length < 3) return;
		console.log(val);
		$.get("artservice.cfc?method=getart&returnformat=json", {term:val}, function(res) {
			var dataList = $("#searchresults");
			dataList.empty();
			if(res.DATA.length) {
				for(var i=0, len=res.DATA.length; i<len; i++) {
					var opt = $("<option></option>").attr("value", res.DATA[i][0]);
					dataList.append(opt);
				}

			}
		},"json");
	});

})
</script>

<div class="container-fluid">
	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-4">
			<h3 class="page-header">Employee Information</h3>

			<form action="">
				<div class="form-group input-group">
					<input list="staff" name="staff" class="form-control">
					<datalist id="staff">
						<option value="Internet Explorer">
						<option value="Firefox">
						<option value="Opera">

							<option value="Safari">
					<c:forEach var="itemStaff" items="${staffList}">
								<option value="<c:out value='${itemStaff}' />"
									<c:if test="${supplementaryInfo.staff==itemStaff}"> selected </c:if>>
									<c:out value="${itemStaff}" />
								</option>
							</c:forEach></datalist>
					<span class="input-group-btn"><button
							class="btn btn-default" type="button">
							<i class="fa fa-search"></i>
						</button></span>
				</div>
			</form>


		</div>

		<div class="col-lg-12">
			<h1 class="page-header">List Supplementary Information</h1>
		</div>
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="table-responsive">
				<table class="table table-bordered table-hover table-striped">
					<thead>
						<tr>

							<th>Operation</th>
							<th>Amount</th>
							<th>Causes</th>
							<th>Allergy</th>
							<th>Pre existing Diseases</th>
							<th>Blood Group</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="supplementaryInfo"
							items="${supplementaryInfoListId}">
							<tr>

								<td>${supplementaryInfo.operation}</td>
								<td>${supplementaryInfo.opAmount}</td>
								<td>${supplementaryInfo.opCauses}</td>
								<td>${supplementaryInfo.allergy}</td>
								<td>${supplementaryInfo.preexDiseases}</td>
								<td>${supplementaryInfo.bloodType}</td>


								<td><a
									href="${pageContext.request.contextPath}/supplementaryInfo/edit/${supplementaryInfo.idPerson}.html">Edit</a><br />
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<input type=button class="btn btn-primary"
				onClick="location.href='${pageContext.request.contextPath}/supplementaryInfo/create.html'"
				value='ADD'>

		</div>
	</div>
	<!-- /.row -->

</div>
<!-- /.container-fluid -->

</html>