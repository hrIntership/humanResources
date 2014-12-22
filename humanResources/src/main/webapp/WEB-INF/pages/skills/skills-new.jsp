<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrapValidator.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrapValidator.min.js"></script>
<script>
$(document).ready(function() {

$('#typeSelect').change(function(event) {
	var typeSelect = $("select#typeSelect").val();
	$.get("select", {
		typeSkill : typeSelect
	}, function(jsonResponse) {

	var select = $('#skillSelect');
	select.find('option').remove();
	$('<option>').val(null).text("-- Select --").appendTo(select)
 	  $.each(jsonResponse, function(index, value) {
	  $('<option>').val(value.idSkill).text(value.nameSkill).appendTo(select);
      });
	});
	});
});

</script>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="list-group">
				<a href="#" class="list-group-item active">${person.firstname} ${person.lastname}</a>
				<div class="list-group-item">Skills</div>
				<div class="list-group-item">
					
					<div class="container-fluid "  style=" height: 300px; overflow-y: scroll;"  >
						<div class="container-fluid">
							<div class="row clearfix ">
								<div class="col-md-12 column">
									<table class="table table-hover table-condensed  table-striped " >
										<thead>
											<tr>

												<th>Type of Skill</th>
												<th>Skill</th>
												<th>Level Skill</th>
											</tr>
										</thead>
										<tbody>

											<c:forEach var="skillsList" items="${skillsList}">
												<tr>
													<td>${skillsList.stringType}</td>
													<td>${skillsList.stringSkill}</td>
													<td>${skillsList.stringLevel}</td>
                                               
                              <td><a
									href="${pageContext.request.contextPath}/skills/delete.html?personID=${personID} &idSkill=${skillsList.id}" >Delete</a>
                                                  </td>
                                                      
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>

					<form:form method="POST" commandName="skill" id="skill"
						action="${pageContext.request.contextPath}/skills/create.html">
						<div class="list-group-item">
							<a class="list-group-item active"><span class="badge"></span>Add
								Skill</a>
							<div class="container-fluid">

								<div class="col-lg-3">
									<div class="form-group">
										<form:label path="">Type of Skill</form:label>

										<select class="form-control select2-select" name="typeSelect" id="typeSelect"
											required="required">
											<option value=null selected="selected">- select -</option>
											<c:forEach var="itemIdType" items="${typeSelect}">
												<option value="<c:out value='${itemIdType.idTypeSkill}' />"
													<c:if test=""> selected </c:if>>
													<c:out value="${itemIdType.nameType}" />
												</option>
											</c:forEach>
										</select>
									</div>
								</div>
								
								<div class="col-lg-3">
									<div class="form-group">
										<form:label path=""> Skill</form:label>

										
								<select class="form-control select2-select" id="skillSelect" name="skillSelect" required="required">
		                              <option>Select Skill</option>
	                                </select>
									</div>
								</div>
								
								
								<div class="col-lg-3">
									<div class="form-group">
										<form:label path="">level Skill</form:label>

										<select class="form-control select2-select" name="levelSkill"
											required="required">
											<option value="" selected="selected">- select -</option>
											<c:forEach var="level" items="${levelSelect}">
												<option value="<c:out value='${level.idLevel}' />"
													<c:if test=""> selected </c:if>>
													<c:out value="${level.nameLevel}" />
												</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<input type="hidden" name="personID" value="${personID}">
							</div>
						</div>
                      	<input class="btn btn-default" type="submit" value="Save" />
					</form:form>
					
				</div>
				</div>
				</div>
				</div>
				</div>
<script>
$(document).ready(function() {
    $('#skill').bootstrapValidator();
});
</script>