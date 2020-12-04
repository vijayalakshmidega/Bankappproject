<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show all users</title>
</head>
<body>
<h3>Show all users</h3>
<h4><a href="home">Home</a></h4>
<h4><a href="adduser"> Add User </a></h4>
<h4><a href="logout">Logout</a></h4>
<table>
	<tr>

		<th>Username</th>
		<th>Address</th>
		<th>Phone</th>
		<th>Email</th>
		<th>Delete user</th>
		<th>Update user</th>
		
	</tr>
	<c:forEach var="user" items="${allusers}">
	
	<tr>
		<td>${user.username}</td>
		<td><c:out value="${user.address}"></c:out> </td>
		<td><c:out value="${user.phone}"></c:out> </td>
		<td><c:out value="${user.email}"></c:out> </td>
		<td><a href="deleteuser?id=${user.uid}">delete user</a></td>
		<td><a href="updateuser?id=${user.uid}">update user</a></td>
		
	</tr>
	</c:forEach>
</table>
</body>
</html>