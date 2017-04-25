<!--  header -->
<%@include file="includes/header.jsp"%>

<body>
	<p>Nombre de invocador: <c:out value="${requestScope.summoner.name}"/></p>
	<h3>Estadisticas to wapas</h3>
	<div class="stats">
		<table>
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
		
		<c:forEach items="${requestScope.champions}" var="champ">
			<p><img alt="el diablo mola mas" src="http://ddragon.leagueoflegends.com/cdn/6.24.1/img/champion/<c:out value="${champ.image.full}"/>"> <c:out value="${champ.name}"/> Nivel: <c:out value="${requestScope.masteries[0].championLevel}"/></p>
		</c:forEach>
		
	</div>
</body>
</html>