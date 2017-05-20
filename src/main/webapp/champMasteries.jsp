<!--  header -->
<%@include file="includes/header.jsp"%>

<body>
	<h1 class="titulo">Maestría del jugador</h1>
<div class="elementoCentral">
	<p class="textoGen">Nombre de invocador: <c:out value="${requestScope.summoner.name}"/></p>
	<h3 id="Statistics">Maestrias de campeones</h3>
	<div class="stats">
		
		
		
		<c:forEach items="${requestScope.champions}" var="champ" varStatus="pool">
			<p class="campeon"><img alt="Campeón" class="campeon-mini" src="http://ddragon.leagueoflegends.com/cdn/6.24.1/img/champion/<c:out value="${champ.image.full}"/>"> <c:out value="${champ.name}"/> Nivel: <c:out value="${requestScope.masteries[pool.index].championLevel}"/>
			. <c:out value="${requestScope.masteries[pool.index].championPoints}"/> puntos.</p>
		</c:forEach>
			
		<c:forEach items="${requestScope.masteryinfo}" var="mastery" varStatus="pool">
			<p class="masterylevels"><c:out value="${mastery}"/></p>
		</c:forEach>
		
		
		<form class="form" method="post" action="TelegramMasteriesController">
			<input type="hidden" name="invo" value="${requestScope.summoner.name}"></input>
			<input type="hidden" name="masteryinfo" value="${requestScope.masteryinfo}"></input>
			
     		<button class="btn" type="submit" name="req" value="tweet">Comparte tu resumen en Telegram!</button>
     	
		</form> 
		
		<form class="form" method="post" action="PostTweetMasteriesController">
					<input type="hidden" name="tweetmasteryinfo" value="${requestScope.tweetmasteryinfo}"></input>
					<input type="hidden" name="invotw" value="${requestScope.summoner.name}"></input>
     	<button class="btn" type="submit" name="req" value="tweet">Tweet this</button>
     	
			</form> 
		
	</div>
</div>				
</body>
</html>