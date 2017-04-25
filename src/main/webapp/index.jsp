<!--  header -->
<%@include file="includes/header.jsp"%>

<body>
	<div id="banner"><h1 id="bannertext">Tol banner wapo ahí</h1></div>
	<div class="description">
		<h2 class="tittle">This is LoL Stats</h2>
		<p>Esto es como la descripción de la pag y lo que hace, abe o no?</p>
	</div>
	<form class="form" action="IndexSearchController" method="post">
		<input class="summoner" type="text" placeholder="Nombre de invocador" name="summoner"></input>
		<br>
		<button class="btn" type="submit" name="req" value="sumary">Resumen del invocador</button>
		<button class="btn" type="submit" name="req" value="playing">Partida actual</button>
		<br>
		<button class="btn" type="submit" name="req" value="history">Historial de partidas</button>
		<button class="btn" type="submit" name="req" value="masteries">Maestrias de campeones</button>
	</form>
</body>
</html>