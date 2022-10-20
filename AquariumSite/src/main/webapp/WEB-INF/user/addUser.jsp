<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create User</title>
<link rel="stylesheet" href="css/main.css">
<link rel="icon" type="image/png" href="img/favicon.png">
</head>
<body class="add-background">
	
	<h1 align="center"> Add A New User</h1>
	
	<div class="white-text">
	<form action="createUser.do" method="POST">
				User Name: <input style="height: 10%; width: 10.7%; box-sizing: border-box;" type="text" name="userName"/>
				<br>
			    Age: <input type="text" name="age"/>
				<br>
				Location: <input style="height: 10%; width: 11.65%; box-sizing: border-box;" type="text" name="location"/>
				<br>
				Profile Picture Url: <input style="height: 10%; width: 7.9%; box-sizing: border-box;" type="text" name="profilePicture" placeholder="Default profile picture" value="https://i.ibb.co/2d7Sj6Z/johngates.png"/>
				<br>
				<br>
				<input class="add-button" type="submit" value="Add New User &#67166;&plus;"/>
				<br>
	</form>
	
	<br>
	
	<a href="home.do"> <input class="home-button" type="submit" value="Return Home &#8617;"/></a>
	</div>
	
</body>
</html>