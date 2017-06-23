<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="<c:url value='/css/bootstrap.css' />" rel="stylesheet"></link>
<link href="<c:url value='/css/app.css' />" rel="stylesheet"></link>
<title>Aggiungi contatto</title>
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h1>Aggiungi contatto</h1>
		</div>

		<form method="post" action="addContact">
			<div class="form-group">
			<label for="email">Nome:</label>
				<input class="form-control" type="text" name="nome"
					placeholder="Inserisci nome" required /><br> 
			<label for="email">Cognome:</label>
				<input class="form-control" type="text" name="cognome"
					placeholder="Inserisci cognome" required /><br> 
			<label for="email">Telefono:</label>
				<input class="form-control" type="number" name="tel" pattern="[0-9]"
					placeholder="Inserisci telefono" required /><br> 
			<label for="email">Mail:</label>
				<input class="form-control" type="email" name="mail"
					placeholder="Inserisci mail" required /><br>
			</div>
			<input class="btn btn-info" type="submit" value="Salva" style="float: right; margin"/>
			<a href="listContacts" class="btn btn-danger" style="float: right; margin-right: 15px"> Cancel </a>
		</form>
		<br>
	</div>
</body>
</html>