<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="HeadSection.jsp"%>
<body>
	<%@include file="Header.jsp"%>
	<section>
		<h2>View Employee By Department</h2>
		<div align="center">
			<form action="viewbydept">
				Department <select name="cbodept">
					<c:forEach items="${dlist}" var="d">
						<option value="${d.deptId}">${d.deptName}</option>
					</c:forEach>
					<input type="hidden" name="pno" value="1"/>
				</select> <input type="submit" value="view" />
			</form>
		</div>
	</section>
	<%@include file="Footer.jsp"%>
</body>
</html>