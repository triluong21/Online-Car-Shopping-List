<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Car Entry</title>
</head>
<body>
	<form action="editItemServlet" method="post">
		Car Make: <input type="text" name="carmake" value="${itemToEdit.make}">
		Car Model: <input type="text" name="carmodel" value="${itemToEdit.model}">
		Car Year: <input type="text" name="caryear" value="${itemToEdit.year}">
		<input type="hidden" name="id" value="${itemToEdit.id}"> <input
			type="submit" value="Save Edited Car">
	</form>
</body>
</html>