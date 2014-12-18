<%@page import="org.springframework.web.bind.annotation.RequestMethod"%>
<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@page import="com.cme.hr.model.Person"%>
<%@page import="com.cme.hr.controller.PersonController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">


<div class="container-fluid">

	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Edit Person</h1>
		</div>
	</div>
	<!-- /.row -->

	<div class="row">
		<div class="col-lg-6">

			<form:form method="POST" commandName="person"
				action="${pageContext.request.contextPath}/person/edit/${person.idPerson}.html">
				<div class="table-responsive">
					<table class="table">
						<tbody>
							<tr>
								<td>Name:</td>
								<td><form:input path="firstname" /></td>
								<td><form:errors path="firstname" cssStyle="color: red;" /></td>
							</tr>
							<tr>
								<td>Lastname:</td>
								<td><form:input path="lastname" /></td>
							</tr>
							<tr>
								<td>ID Type:</td>
								<td><form:input path="idType" /></td>
							</tr>
							<tr>
								<td>ID number:</td>
								<td><form:input path="idNumber" /></td>
								<td><form:errors path="idNumber" cssStyle="color: red;" /></td>
							</tr>
							<tr>
								<td>CUIL:</td>
								<td><form:input path="cuil" /></td>
							</tr>
					<!--  		<tr>
								<td>Place of birth:</td>
								<td><form:input path="birthplace" /></td>
							</tr>-->
							<tr> 
								<td>Date of birth:</td>
								<td><form:input path="birthdate" /></td>
							</tr>
							<tr>
								<td>Address:</td>
								<td><form:input path="address" /></td>
							</tr>
							<tr>
								<td>Zip code:</td>
								<td><form:input path="zipCode" /></td>
							</tr>
							<tr>
								<td>City/Town:</td>
								<td><form:input path="city" /></td>
							</tr>
							<tr>
								<td>Province:</td>
								<td><form:input path="province" /></td>
							</tr>
							<tr>
								<td>Country:</td>
								<td><select name="country">
										<option value="" selected="selected">- select -</option>
										<c:forEach var="itemCountry" items="${countryList}">
											<option value="<c:out value='${itemCountry.idCountry}' />"
												<c:if test="${person.country==itemCountry.idCountry}"> selected </c:if>>
												<c:out value="${itemCountry.name}" />
											</option>
										</c:forEach>

								</select></td>

								<td><form:errors path="country" cssStyle="color: red;" /></td>
							</tr>
							<tr>
								<td>Phone:</td>
								<td><form:input path="phone" /></td>
							</tr>
							<tr>
								<td>Cellphone:</td>
								<td><form:input path="cellphone" /></td>
							</tr>
							<tr>
								<td>Email:</td>
								<td><form:input path="email" /></td>
							</tr>
							<tr>
								<td>Maritar Status:</td>
								<td><form:input path="maritalStatus" /></td>
							</tr>
							<tr>
								<td>state:</td>
								<td><select name="state">
										<option value="" selected="selected">- select -</option>
										<c:forEach var="item" items="${list}">
											<option value="<c:out value='${item}' />"
												<c:if test="${person.state==item}"> selected </c:if>>
												<c:out value="${item}" />
											</option>
										</c:forEach>

								</select></td>

								<td><form:errors path="state" cssStyle="color: red;" /></td>
							</tr>

							<tr>
								<td><input type="submit" value="Create" /></td>
								<td></td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</div>
			</form:form>
		</div>
	</div>
	<!-- /.row -->

</div>


</body>

</html>
