<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transfering the AMount</title>
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

<h3>Account transfer</h3>

<div>

  <form action="/transfer" method="post"   modelAttribute="transferbeans">
    <label for="fromaccount">Enter From Account Number</label>
    <input type="text" id="fromaccount" name="fromaccount" placeholder="Enter Account number..">

    <label for="toaccount">Enter To Account Number</label>
    <input type="text" id="toaccount" name="toaccount" placeholder="Enter Account number..">

    <label for="amount">Enter AMount</label>
    <input type="text" id="amount" name="amount" placeholder="Enter amount..">
  
    <input type="submit" value="Submit">
  </form>
</div>
</body>
</html>