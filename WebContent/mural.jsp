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
		<%-- <jsp:useBean id="dao" class="br.edu.Insper.DAO"/> --%>
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
			
			<% DAO dao = new DAO();
				ArrayList<Nota> notas = dao.getListaNotas(1);
				for (Nota nota : notas ) { %>
				<table style="display: inline;
			    margin: 0px 8px;
			    width: auto;
			    height: auto;
			    min-width: 100px;
			    min-height: 100px;">
			    
					<tr style="display: block;
				    background-color: #cccc00;
				    width: auto;
				    height: auto;
				    word-break: break-word;">
						<td name="id" style="display: inline-block;
					    max-width: 90%;
					    height: 100%;
					    word-break: break-word;">
							<%=nota.getId() %>
						</td>
						<td style="display: inline-block;
					    float: right;
					    width: auto;
					    word-break: break-word;
					    vertical-align: middle;
					    margin: auto;
					    height: 20px;
					    padding: 0px">
						<form action="DeletaNota">
							<button type="submit" name="idnota" value="<%=nota.getId() %>" style="display: block;
						    width: 20px;
						    height: 20px;
						    background-position: 0px 0px;
						    border: 0px;
						    padding: 1px;
						    cursor: pointer;
						    background-color: #cccc00;">
						    	<img src="img/oba.png" title="Apagar nota" style="display: block;
						    	height: 18px;						    	
							    margin-left: auto;
							    margin-right: auto;">
						    </button>
						</form>
					</td>
					</tr>
					
					<tr style="display: block;
				    background-color: #ffff99;
				    width: auto;
				    height: auto;
				    word-break: break-word; ">
						<td class="bot-nota-cell">
							<%=nota.getConteudo() %>
						</td>
					</tr>
					
				</table>
			<% } %>

<%-- 			<c:forEach var="nota" items="${dao.getListaNotas}" varStatus="id_nota">
				<table class="nota">
					<tr class="top-nota">
						<td class="top-nota-cell">
							${id_nota.count}
						</td>
					</tr>
					<tr class="bot-nota">
						<td class="bot-nota-cell">
							${nota.conteudo}
						</td>
					</tr>
				</table>
			</c:forEach> --%>

			
		</div>

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="js/main.js">
		</script>
	</body>
</html>