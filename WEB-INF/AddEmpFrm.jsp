<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<%@include file="HeadSection.jsp"%>

<%@include file="Header.jsp"%>

<body>
	<section>
		<h2>Add Employee</h2>

		<form:form action="add" method="post" modelAttribute="ebean"
			enctype="multipart/form-data">
			<table bgcolor="lightblue" style="margin: 0 auto">
				<tr >
					<td>Employee ID</td>
					<td><form:input path="empId" /></td>
					<td><form:errors path="empId" cssStyle="color:red"
							element="div" /></td>
				</tr>
				<tr>
					<td>Employee Name</td>
					<td><form:input path="empName" /></td>
					<td><form:errors path="empName" cssStyle="color:red"
							element="div" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><form:password path="pwd" /></td>
					<td><form:errors path="pwd" cssStyle="color:red" element="div" /></td>

				</tr>
				<tr>
					<td>Salary</td>
					<td><form:input path="sal" /></td>
					<td><form:errors path="sal" cssStyle="color:red" element="div" /></td>
				</tr>
				<tr>
					<td>Dept</td>
					<td><form:select items="${dmap}" cssStyle="color:red"
							path="dept.deptId" /></td>
				</tr>
				<tr>
					<td>Choose image to upload</td>
					<td><input type="file" name="fname" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="finish" /></td>

				</tr>

			</table>
		</form:form>

	</section>

	<%@include file="Footer.jsp"%>
</body>
</html>