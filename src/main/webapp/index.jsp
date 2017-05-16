<!--  header -->
<%@include file="includes/header.jsp"%>

<body>
	<div id="banner"><h1 id="bannertext">League of Legends Stats</h1></div>
	<div class="description">
		<h2>LOL Stats, tu web de estadísticas del MOBA más popular</h2>
		<p>Descripción de la página</p>
	</div>
	<div class="telegramShare" style="display: <c:if test="${empty requestScope.visibilidadtg}">none</c:if>"><p>¡Felicidades, lo has compartido por telegram!</p></div>
	<div class="twitterShare" style="display: <c:if test="${empty requestScope.visibilidadtw}">none</c:if>"><p>¡Felicidades, lo has compartido por Twitter!</p></div>
	
	<form class="form" action="IndexSearchController" method="post">
		<input class="summoner" type="text" placeholder="Nombre de invocador" name="summoner" required></input>
		<br>
		<button class="btn" type="submit" name="req" value="summary">Resumen del invocador</button>
		<button class="btn" type="submit" name="req" value="playing">Partida actual</button>
		<br>
		<button class="btn" type="submit" name="req" value="history">Historial de partidas</button>
		<button class="btn" type="submit" name="req" value="masteries">Maestrias de campeones</button>
	</form>
</body>
</html>