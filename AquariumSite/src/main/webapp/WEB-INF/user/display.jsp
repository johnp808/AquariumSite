<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Info</title>
<link rel="stylesheet" href="css/main.css">
<link rel="icon" type="image/png" href="img/favicon.png">
</head>
<body class="display-background">

	<h1 class="display-h1">${user.userName}</h1>

	<h1>${user.age}</h1>

	<h1>${user.location}</h1>

	<h1><img class="profile-picture-display" src="${user.profilePicture}"></img></h1>

<!-- set up for each to iterate over each aquarium and display their individual 
info once clicked on, once aquarium is built out -->
      		<div class="aquarium-info-box">
<c:choose>
    <c:when test="${not empty user.userAquariums}">
<!-- How do i iterate over all my aquarium items when I have to use .get(multiple indices) ? EDIT: COMPLETED -->
		<c:forEach items="${user.userAquariums}" var="uAquarium">
<!--			  figure out how to use a c:for to iterate thru aquarium numbers						     -->
		<%-- <c:forEach var = "aquariumNum" begin = "1" end = "${uAquarium.aquarium.id}">
         	<h1 class="h1-small-font">Aquarium #<c:out value = "${aquariumNum}"/></h1>
      	</c:forEach> --%>
			<h1 class="h1-small-font-blue underline-text">Aquarium #${uAquarium.aquarium.aquariumNumber}</h1>
			<h1><img class="aquarium-picture" src="${uAquarium.aquarium.aquariumPic}"></img></h1>
			<h1 class="h1-small-font underline-text">Fish In Tank</h1>
			<h1 class="h1-small-font">&#11015;</h1>
				<c:forEach items="${uAquarium.aquarium.fishInAquarium}" var="aquariumFish" >
					<c:choose>
    					<c:when test="${aquariumFish.quantity gt 1}">
			<h1 class="h1-small-font underline-text">${aquariumFish.fish.fishName}s x${aquariumFish.quantity}</h1>
						</c:when>    
				    <c:otherwise>
			<h1 class="h1-small-font underline-text">${aquariumFish.fish.fishName} x${aquariumFish.quantity}</h1>
		  		    </c:otherwise>
					</c:choose>
			</c:forEach>
			<h1 class="dash-h1">&#11835;</h1>
		</c:forEach>
    </c:when>    
    <c:otherwise>
<h1 class="h1-small-font underline-text">${user.userName} Owns Ø Fish Tanks</h1>
    </c:otherwise>
</c:choose>
      		</div>
	<form action="updateUserSlot.do" method="POST">
		<input type="hidden" name="userId" value="${user.id}" /><br><input class="update-button" type="submit" value="Update User &#10226;"/>
	</form>

	<form action="deleteUser.do" method="POST">
		<input type="hidden" name="userId" value="${user.id}" /><br><input class="delete-button" type="submit" value="Delete User &#8553;"/>
	</form>
	
	<br>
	
	<a href="home.do"> <input class="home-button" type="submit" value="Return Home &#8617;"/></a>
	
</body>
</html>