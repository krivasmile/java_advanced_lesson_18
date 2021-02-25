<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<title>lesson-18</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Spring MVC</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
				aria-controls="navbarNavAltMarkup" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<div class="navbar-nav">
					<a class="nav-link active" aria-current="page" href="/">All participants</a> 
					<a class="nav-link" href="new">New participant</a> 
				</div>
			</div>
		</div>
	</nav>

	<div class="container">
		<c:choose>
			<c:when test="${mode == 'PARTICIPANT_VIEW'}">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Email</th>
							<th>Level</th>
							<th>Primary skills</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="participant" items="${participants}">
							<tr>
								<td>${participant.id}</td>
								<td>${participant.name}</td>
								<td>${participant.email}</td>
								<td>${participant.level}</td>
								<td>${participant.primarySkill}</td>
								<td><a href="update?id= ${participant.id}">edit</a></td>
								<td><a href="delete?id= ${participant.id}">delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>

			<c:when test="${mode == 'PARTICIPANT_EDIT' || mode == 'PARTICIPANT_CREATE'}">
				<form action="save" method="POST">
					<input type="hidden" value="${participant.id}" class="form-control"
						id="id" name="id">
					<div class="form-group">
						<label for="name">Name:</label> <input type="text"
							class="form-control" id="name" name="name"
							value="${participant.name}">
					</div>

					<div class="form-group">
						<label for="email">Email:</label> 
						<input type="text"
							class="form-control" id="email" name="email"
							value="${participant.email}">
					</div>

					<div class="form-group">
						<label for="level">Level:</label> <select class="form-control"
							id="level" name="level" value="${participant.level}">
							<option>L1</option>
							<option>L2</option>
							<option>L3</option>
							<option>L4</option>
							<option>L5</option>
						</select>
					</div>

					<div class="form-group">
						<label for="skills">Primary skills:</label> <input type="text"
							class="form-control" id="skills" name="primarySkill"
							value="${participant.primarySkill}">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</c:when>

		</c:choose>
	</div>
</body>
</html>