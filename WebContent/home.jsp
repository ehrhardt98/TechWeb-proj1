<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ page import="java.util.*,br.edu.Insper.*" %>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>Home</title>

	<style type="text/css">
		@import url("css/styles.css");
	</style>
</head>

<body>
	<div class="nav-bar">
		<div class="title">
			<h2>Home</h2>
		</div>
		

		<a href="inicio.jsp" class="menu-button">Logout</a>

		<form class="search">
			<input type="text" name="search" placeholder="Procurar..."
				style="border: none; border-bottom: solid; border-radius: 5px; color: white; border-color: #a0a0a0; background-color: #5d5d5d; height: 26px; width: 30%; min-width: 130px; background-position: 9px 4px; background-image: url('img/search-icon.png'); background-repeat: no-repeat; padding-left: 40px;">
		</form>
		</div>

		<div class="canvas">
			<% DAO dao = new DAO();
				ArrayList<Mural> murais = dao.getListaMurais(1);
				for (Mural mural : murais) { %>
				<form action="SelecionaMural" style="width: auto; height:auto; margin-right: 0">
					<button type="submit" name="idmural" value="<%=mural.getId() %>" style="display: inline;
				    margin: 30px 10px 0px 10px;
				    height: 12%;
				    width: 25%;
				    min-width: 180px;
				    padding-bottom: 0.83em;
				    background-color: #707070;
				    ">
				    	<h2><%=mural.getNome() %></h2>
				    	Ultima modificação: <%=mural.getUltimaMod() %>
			    	</button>
				</form>
				
			<% } %>


			<form action="CriaMural" style="width: auto; height:auto; margin-right:0 ">
				<button type="submit" name="novomural" style="display: inline; margin: 30px 10px 0px 10px; height: 12%; width: 25%; min-width: 180px; padding-bottom: 0.83em; background-color: #707070;">
					<h2>Criar novo mural</h2>
				</button>
			</form>
		</div>

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="js/main.js">
		</script>
	</body>
</html>