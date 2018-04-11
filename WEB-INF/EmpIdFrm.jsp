<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="HeadSection.jsp" %>
<body>
<%@include file="Header.jsp" %>
<section>
<h2>View Employee By ID </h2>
<div align="center">
<form action="viewbyid">
Employee ID
<input type="text" name="txteid"/>
<input type="submit" value="search"/>
</form>
</div>
</section>
<%@include file="Footer.jsp" %>
</body>
</html>