<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Updating Account</title>
</head>
<body>
<h3>Update Account</h3>
<form:form action="addaccount" method="post" modelAttribute="addAccount">
	<form:hidden path="accountId" value="${addAccount.accountId}"/>
	<table>
		<tr>
			<td>Enter name</td>
			<td><form:input path="name" readonly="true"/><form:errors path="name" class="error"/></td>
		</tr>
		<tr>
			<td>Enter balance</td>
			<td><form:input path="balance" readonly="true"/><form:errors path="balance" class="error"/></td>
		</tr>
		<tr>
			<td>Enter address</td>
			<td><form:input path="address"/><form:errors path="address" class="error"/></td>
		</tr>
		<tr>
			<td>Enter phone</td>
			<td><form:input path="phone"/><form:errors path="phone" class="error"/></td>
		</tr>
		<tr>
			<td>Enter email</td>
			<td><form:input path="email" readonly="true"/><form:errors path="email" class="error"/></td>
		</tr>
		<tr>
			<td>Enter aadharCard</td>
			<td><form:input path="adharCard" readonly="true"/><form:errors path="adharCard" class="error"/></td>
		</tr>
		
		<tr>
			<td>Enter panNumber</td>
			<td><form:input path="panNumber" readonly="true"/><form:errors path="panNumber" class="error"/></td>
		</tr>
		
		<tr>
			<td><input type="submit" value="Submit"></td>
		</tr>
	</table>
</form:form>
</body>
</html>