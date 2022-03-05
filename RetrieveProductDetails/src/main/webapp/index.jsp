<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Retrieve Product</title>
<style>
	body{
		text-align: center;
	}
</style>
</head>
<body>
	<h3><b>Retrieve Product using ProductID</b></h3>
	<hr>
	<form action="searchproduct" method="get">
		Enter ProductID : <input type="number" name="ID">
		<input type="submit" value="Search">
	</form>
</body>
</html>