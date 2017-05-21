
<%@include file="includes/header.jsp"%>

<body>
	<h1 class="titulo">Historial de partidas</h1>
	<div class="elementoCentral">
	<p class="textoGen">Nombre de invocador: <c:out value="${requestScope.summoner.name}"/></p>
	
	
	<c:forEach items="${requestScope.stats}" var="stat" varStatus="pool">
		<p>Partida <c:out value="${pool.index+1}"/>: </p>
		<p>Campeón: <c:out value="${requestScope.champions[pool.index]}"/>. Resultado
		<c:out value="${requestScope.kills[pool.index]}"/>/<c:out value="${requestScope.deaths[pool.index]}"/>/<c:out value="${requestScope.assists[pool.index]}"/>. 
		KDA: <c:out value="${requestScope.kda[pool.index]}"/><br>
		<c:out value="${requestScope.win[pool.index]}"/></p>
	</c:forEach>
	<p>KDA medio: <c:out value="${requestScope.globalkda}"/></p>
	</div>
	
	<form class="form" method="post" action="TelegramController">
			<input type="hidden" name="telegram" value="${requestScope.telegram}"></input>
			
     		<button class="btn" type="submit" name="req" value="tweet">Comparte tu resumen en Telegram!</button>
     	
		</form> 
		
		<form class="form" method="post" action="PostTweetController">
					<input type="hidden" name="tweet" value="${requestScope.tweet}"></input>
     	<button class="btn" type="submit" name="req" value="tweet">Tweet this</button>
     	
			</form> 
</body>
</html>