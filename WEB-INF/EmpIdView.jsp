<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="HeadSection.jsp"%>
<body>
	<%@include file="Header.jsp"%>
	<section>
		<h2>View Employee By ID</h2>
		<div align="center">
			<img src="viewimg?imgname=${emp.img}" height="200" width="200" />
		</div>
		<table id="tlist">
			<tr>
				<td>Employee ID</td>
				<td>${emp.empId }</td>
			</tr>

			<tr>
				<td>Employee Name</td>
				<td>${emp.empName }</td>
			</tr>
			<tr>
				<td>Salary</td>
				<td>${emp.sal }</td>
			</tr>
			<tr>
				<td>Department</td>
				<td>${emp.dept.deptName}</td>
			</tr>
		</table>



	</section>
	<%@include file="Footer.jsp"%>
</body>
</html>