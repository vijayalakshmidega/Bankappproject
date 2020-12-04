<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transactions of User</title>
</head>
<body>
<form action="gettransactions" method="post" modelAttribute="gettrans">
  <div class="imgcontainer">
    <img src="img_avatar2.png" alt="Avatar" class="avatar">
  </div>

  <div class="container">
    <label for="accid"><b>Enter AccountId</b></label>
    <input type="text" placeholder="Enter AccountId" name="accid" required><br>

   
    <button type="submit">Login</button><br>
    
  </div>

  
</form>
</body>
</html>