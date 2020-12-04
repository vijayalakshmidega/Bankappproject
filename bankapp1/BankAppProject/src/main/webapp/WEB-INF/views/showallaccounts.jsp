<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show all accounts</title>
</head>
<body>
<br>
<h3>Show all accounts</h3>
<h4><a href="home">Home</a></h4>
<h4><a href="addaccount"> Add Account</a></h4>
<h4><a href="logout">Logout</a></h4>
<table>
	<tr>
		<th>Name</th>
		<th>Address</th>
		<th>Phone</th>
		<th>Email</th>
		<th>Aadhar Card Number</th>
		<th>PAN Number</th>
		<th>Balance</th>
		</tr>
		
		<c:forEach var="account" items="${allaccounts}">
	<tr>
		<td>${account.name}</td>
		<td><c:out value="${account.address}"></c:out> </td>
		<td><c:out value="${account.phone}"></c:out> </td>
		<td><c:out value="${account.email}"></c:out> </td>
		<td><c:out value="${account.adharCard}"></c:out> </td>
		<td><c:out value="${account.panNumber}"></c:out> </td>
		<td><c:out value="${account.balance}"></c:out></td>
		<td><a href="deleteaccount?id=${account.accountId}">delete account</a></td>
		<td><a href="updateaccount?id=${account.accountId}">update account</a></td>
		</tr>
	</c:forEach>
	
	
</table>
</body>
</html>