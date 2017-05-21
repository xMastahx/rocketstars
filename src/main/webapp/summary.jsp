<!--  header -->
<%@include file="includes/header.jsp"%>

<body>
	<h1 class="titulo">Resumen del invocador</h1>
<div class="elementoCentral">
	<p class="textoGen">Nombre de invocador: <c:out value="${requestScope.summoner.name}"/></p>
	<h3 id="Statistics">Estadísticas</h3>
	<div class="stats">
		<table class="tablaStats">
			<tr>
				<th>Modo de juego</th>
				<th>Victorias</th>
				<th>Total de asesinatos</th>
			</tr>
			<c:forEach items="${requestScope.stats}" var="stat">
				<tr>
					<td><c:out value="${stat.playerStatSummaryType}"/></td>
					<td><c:out value="${stat.wins}"/></td>
					<td><c:out value="${stat.aggregatedStats.totalChampionKills}"/></td>
				</tr>
			</c:forEach>
		</table>
		
		
		
		<c:forEach items="${requestScope.champions}" var="champ" varStatus="pool">
			<p class="campeon"><img alt="Campeón" src="http://ddragon.leagueoflegends.com/cdn/6.24.1/img/champion/<c:out value="${champ.image.full}"/>"> <c:out value="${champ.name}"/> Nivel: <c:out value="${requestScope.masteries[pool.index].championLevel}"/></p>
		</c:forEach>
		
		
		<div class="separa">
			<h3 id="Statistics">Runas</h3>
			<c:forEach items="${requestScope.runes}" var="rune">
				<p class="runa"><c:out value="${rune}"/></p>
			</c:forEach>
		</div>
		<form class="form" method="post" action="TelegramController">
			<input type="hidden" name="telegram" value="${requestScope.telegram}"></input>
     		<button class="btn" type="submit" name="req" value="tweet">Comparte tu resumen en Telegram!</button>
     	
		</form> 
		
		<form class="form" method="post" action="PostTweetController"> 
					<input type="hidden" name="tweet" value="${requestScope.tweet}"></input>  
     	<button class="btn" type="submit" name="req" value="tweet">Tweet this</button>
     	
			</form> 
		
	</div>
</div>				
</body>
</html>