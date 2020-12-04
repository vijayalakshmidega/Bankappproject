<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Depositing the Amount</title>
<style>
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
</head>
<body>

<h3>Account Withdrawn</h3>

<div>

  <form action="/deposit" method="post"   modelAttribute="withdrawbeans">
    <label for="accounid">Enter Account number to withdraw</label>
    <input type="text" id="accounid" name="accounid" placeholder="Enter Account number..">

    <label for="withdrawamount">Enter Amount to deposit</label>
    <input type="text" id="withdrawamount" name="dwithdrawamount" placeholder="Enter Amount..">

    <input type="submit" value="Submit">
  </form>
</div>
</body>
</html>