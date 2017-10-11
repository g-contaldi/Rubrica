<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista contatti</title>
<link href="<c:url value='/css/bootstrap.css' />" rel="stylesheet"></link>
<link href="<c:url value='/css/app.css' />" rel="stylesheet"></link>
<script src="js/sorttable.js"></script>
</head>
<body>
	<div class="generic-container">
		<div class="panel panel-default media">
			<div class="panel-heading">
				<div class="media-left">
					<img src="https://lh4.ggpht.com/abxUwjG1zZsOn0WnMHENcaw_AXaHlVXKhLqLTi-3fZ6exJt2gIFmL5CfRAJcFR-wEA=w300" class="media-object" style="width:50px">
				</div>
				<div class="media-body">
				<span class="lead" >MyContacts</span>
				<a href="logout" style="float: right; margin-top: 17px;">${user.username} - Logout</a>
				</div>
			</div>
			<div class="table-responsive">
				<table class="table table-striped table-hover sortable">
					<thead>
						<tr>
							<th style="width: 3%"> <a data-toggle="tooltip" title="Click me!">#</a></th>
							<th style="width: 20%"><a data-toggle="tooltip" title="Click me!">Nome</a></th>
							<th style="width: 20%"><a data-toggle="tooltip" title="Click me!">Cognome</a></th>
							<th style="width: 20%"><a data-toggle="tooltip" title="Click me!">Telefono</a></th>
							<th style="width: 20%"><a data-toggle="tooltip" title="Click me!">Mail</a></th>
							<th style="width: 15%"><a data-toggle="tooltip" title="Click me!">Azioni</a></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="contact" items="${list}" varStatus="status">
							<tr>
								<td>${status.index +1}</td>
								<td>${contact.getNome()}</td>
								<td>${contact.cognome}</td>
								<td>${contact.tel}</td>
								<td>${contact.mail}</td>
								<td><a href="editContact?id=${contact.id}">Modifica</a>
									| <a href="deleteContact?id=${contact.id}"
									onclick="return confirm('Sicuro di voler eliminare ${contact.nome} ${contact.cognome}?')">Cancella</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="well">
			<a href="addContact">Aggiungi nuovo contatto</a>
		</div>
	</div>
</body>
</html>