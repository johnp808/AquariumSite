<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update User</title>
<link rel="stylesheet" href="css/main.css">
<link rel="icon" type="image/png" href="img/favicon.png">
</head>
<body class="update-background">
	
	<h1>Update ${user.userName}</h1>
	
	<h1 class="underline-text">Current User Info</h1>
	
	<h1>&#11015;</h1>
	
	<h1>${user.userName}</h1>
	
	<h1>${user.age}</h1>
	
	<h1>${user.location}</h1>
	
	<img src="${user.profilePicture}" style="border: 5px solid black; width:200px; height:200px" width="200" width="200"></img>

	<form class="white-text" action="updateUser.do" method="POST">
	
		<input type="hidden" name="userId" value="${user.id}"/>
		
		User Name: <input style="height: 10%; width: 10.7%; box-sizing: border-box;" type="text" value="${user.userName}" name="userName"/> 
		
		<br> 
		
		Age: <input type="text" value="${user.age}" name="age"/> 
		
		<br>
		
		Location: <input style="height: 10%; width: 11.7%; box-sizing: border-box;" type="text" value="${user.location}" name="location"/> 
		
		<br> 
		
		Profile Picture Url: <input style="height: 10%; width: 7.9%; box-sizing: border-box;" type="text" value="${user.profilePicture}" name="profilePicture"/>
		
		<br>
		<br>
		
		<input class="update-button" type="submit" value="Update ${user.userName} &#10226;"/> 
		
		<br>
		<br>
		
	</form>
		<a href="home.do"> <input class="home-button" type="submit" value="Return Home &#8617;"/></a>
	
</body>
</html>