<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Info</title>
<link rel="stylesheet" href="css/main.css">
</head>
<body class="display-background">

	<h1 class="display-h1">${user.userName}</h1>

	<h1 class="display-h1">${user.age}</h1>

	<h1 class="display-h1">${user.location}</h1>

	<h1><img src="${user.profilePicture}" style="border: 5px solid black; width:200px; height:200px" width="200" width="200"></img></h1>

<!-- set up for each to iterate over each aquarium and display their individual 
info once clicked on once aquarium controller is built out -->

<%-- <c:forEach var="aquarium" items="${}"> --%>


<%-- </c:forEach> --%>

	<form action="updateUserSlot.do" method="POST">
		<input type="hidden" name="userId" value="${user.id}" /><br><input class="update-button" type="submit" value="Update User"/>
	</form>

	<form action="deleteUser.do" method="POST">
		<input type="hidden" name="userId" value="${user.id}" /><br><input class="delete-button" type="submit" value="Delete User"/>
	</form>
	
	<br>
	
	<a href="home.do"> <input class="home-button" type="submit" value="Return Home"/></a>
	
</body>
</html>