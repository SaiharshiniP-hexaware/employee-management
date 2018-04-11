<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="HeadSection.jsp" %>
<body>
	<%@include file="Header.jsp"%>
	
	<section id="home">
		<h2>Home Page</h2>
		<h3 align="center">${msg }</h3>
		<div>
			<nav>
				<table>
					<tr>
						<td><a href="viewall?pno=1">View All Employee</a></td>
						<td> <a href="viewdepts">View By Department</a></td>
						
					</tr>
					<tr>
						<td> <a href="idfrm">View By Employee Id</a></td>
						<td><a href="addfrm">Add Employee</a></td>
					</tr>
				</table>
				
			</nav>
		</div>

	</section>

	<%@include file="Footer.jsp"%>
</body>
</html>