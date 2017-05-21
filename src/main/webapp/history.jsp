
<%@include file="includes/header.jsp"%>

<body>
	<h1 class="titulo">Historial de partidas</h1>
	<div class="elementoCentral">
	<h3 id="Statistics">Nombre de invocador: <c:out value="${requestScope.summoner.name}"/></h3>
	
	
	<c:forEach items="${requestScope.stats}" var="stat" varStatus="pool">
		<p class="textoPartida">Partida <c:out value="${pool.index+1}"/>: </p>
		<p class="textoGen">Campeón: <c:out value="${requestScope.champions[pool.index]}"/>. Resultado
		<c:out value="${requestScope.kills[pool.index]}"/>/<c:out value="${requestScope.deaths[pool.index]}"/>/<c:out value="${requestScope.assists[pool.index]}"/>. 
		KDA: <c:out value="${requestScope.kda[pool.index]}"/><br>
		<c:out value="${requestScope.win[pool.index]}"/></p>
		</c:forEach>
		<p class="textoGen"><strong>KDA medio:</strong> <c:out value="${requestScope.globalkda}"/></p>
	
	
		<form class="form" method="post" action="TelegramController">
			<input type="hidden" name="telegram" value="${requestScope.telegram}"></input>
     		<button class="btn" type="submit" name="req" value="tweet">Comparte tu resumen en Telegram!</button>
		</form> 
		
		<form class="form" method="post" action="PostTweetController">
			<input type="hidden" name="tweet" value="${requestScope.tweet}"></input>
     		<button class="btn" type="submit" name="req" value="tweet">Tweet this</button>
		</form> 
	
	</div>
</body>
</html>