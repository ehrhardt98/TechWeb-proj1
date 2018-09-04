<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
	<head>
	<%@ page import="java.util.*,br.edu.Insper.*" %>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">

	    <title>Wall</title>

	    <style type="text/css">
			@import url("css/styles.css");
		</style>
	</head>


	<body>
		<jsp:useBean id="dao" class="br.edu.Insper.DAO"/>
		<div class="nav-bar">
			<div class="title">
				<h2>Nome do mural</h2>
			</div>
			
			<div class="menu-button">
				<h2>Menu</h2>
			</div>
			<form class="search">
				<input type="text" name="search" placeholder="Procurar..." style="border: none;
				    border-bottom: solid;
				    border-radius: 5px;
				    color: white;
				    border-color: #a0a0a0;
				    background-color: #5d5d5d;
				    height: 32px;
				    width: 32%;
				    min-width: 130px;
				    background-position: 9px 4px; 
				    background-image: url('img/search-icon.png');
				    background-repeat: no-repeat;
				    padding-left: 40px;">
			</form>
		</div>

		<div class="menu">
			<p>ob</p>
		</div>

		<div class="canvas">
			<div class="create-note-div">
				<form class="create-note-form">
					<input type="text" name="create-note" placeholder="Crie uma nota" style="display: block;
	   				border-style: solid;
				    border-width: 2px;
				    border-color: #a0a0a0;
				    border-radius: 4px;
				    box-shadow: 1px 3px 3px grey;
				    height: 32px;
				    width: 48%;
				    margin: 0;
				    padding: 0px 0px 0px 12px;">
				</form>
			</div>
			
			
		</div>

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="js/main.js">
		</script>
	</body>
</html>