<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Aquariums</title>
<link rel="icon" type="image/png" href="img/favicon.png">
<link rel="stylesheet" href="css/main.css">
</head>
<body class="home-background">
	
	<h1 class="underline-text">Take A Look At A Users Aquariums</h1>
	
	<h1 class="h1-small-font underline-text">Click A Profile Picture</h1>

	<h1>&#11015;</h1>

	<div class="grid-container">
	
		<div class="grid-item">
	</div>
		<div class="grid-item">
	</div>
		<div class="grid-item">
	</div>
		<div class="grid-item">
	</div>
		<div class="grid-item">
		
			<c:forEach var="user" items="${users}">
			
				<b class="username-style">${user.userName}</b>
						
				<div class="grid-item">		
				
				<a href="getUser.do?userId=${user.id}"> <img class="profile-picture" src="${user.profilePicture}"></img></a>
		</div>
			</c:forEach>
		</div>
	</div>
	<div class="grid-item">
		<form action="createUserSlot.do" method="POST"><input class="add-button" type="submit" value="Add User &#67166;&plus;"/></form>
	</div>
	
</body>
</html>