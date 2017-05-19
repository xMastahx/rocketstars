
<%@include file="includes/header.jsp"%>

<body>
	<c:forEach items="${requestScope.matches}" var="match">
		<c:out value="${match.platformId}"/>
		<c:out value="${match.gameId}"/>
	</c:forEach>
</body>
</html>