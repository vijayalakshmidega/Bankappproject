<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
  font-family: Arial;
  font-size: 17px;
  padding: 8px;
}

* {
  box-sizing: border-box;
}

.row {
  display: -ms-flexbox; /* IE10 */
  display: flex;
  -ms-flex-wrap: wrap; /* IE10 */
  flex-wrap: wrap;
  margin: 0 -16px;
}

.col-25 {
  -ms-flex: 25%; /* IE10 */
  flex: 25%;
}

.col-50 {
  -ms-flex: 50%; /* IE10 */
  flex: 50%;
}

.col-75 {
  -ms-flex: 75%; /* IE10 */
  flex: 75%;
}

.col-25,
.col-50,
.col-75 {
  padding: 0 16px;
}

.container {
  background-color: #f2f2f2;
  padding: 5px 20px 15px 20px;
  border: 1px solid lightgrey;
  border-radius: 3px;
}

input[type=text] {
  width: 100%;
  margin-bottom: 20px;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 3px;
}

label {
  margin-bottom: 10px;
  display: block;
}

.icon-container {
  margin-bottom: 20px;
  padding: 7px 0;
  font-size: 24px;
}

.btn {
  background-color: #4CAF50;
  color: white;
  padding: 12px;
  margin: 10px 0;
  border: none;
  width: 100%;
  border-radius: 3px;
  cursor: pointer;
  font-size: 17px;
}
.btn:hover {
  background-color: #45a049;
}
a {
  color: #2196F3;
}
hr {
  border: 1px solid lightgrey;
}
span.price {
  float: right;
  color: grey;
}

@media (max-width: 800px) {
  .row {
    flex-direction: column-reverse;
  }
  .col-25 {
    margin-bottom: 20px;
  }
}
</style>
</head>
<body>
<h2>Adding new User to the BankAccount</h2>
<div class="row">
  <div class="col-75">
    <div class="container">
      <form action="/updateuser" method="post" modelAttribute="adduser">
      <form:form hidden path="uid" value=""${user.uid}""/>
       
            <h3>Updating user</h3>
            <label for="uname">Enter UserName</label>
            <input type="text" id="uname" name="userame" placeholder="Enter Username" readonly="readonly">
            <label for="pw">Enter Password</label>
            <input type="password" id="pw" name="password" placeholder="Enter password" readonly="readonly">
            <label for="fname">Enter Full Name</label>
            <input type="text" id="fname" name="firstname" placeholder="Enter name" readonly="readonly">
            <label for="email">Enter Email</label>
            <input type="text" id="email" name="email" placeholder="email@example.com" readonly="readonly">
            <label for="adr">Enter Address</label>
            <input type="text" id="adr" name="address" placeholder="Enter Addrress">
             <label for="phone">Enter MobileNumber</label>
            <input type="text" id="phone" name="phonenum" placeholder="Enter Mobile Number" readonly="readonly">
            
           
            
        <input type="submit" value="submit" >
      </form>
    </div>
  </div>
 </div>

</body>
</html>