<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function update(var nick){
		
	}
</script>

</head>
<body>
	<img src="${imgURL }">
	<c:set var="sdto" value="${leagueInfo }"/>
	<c:set var="fdto" value="${finduser }"/>
	<c:choose>
		<c:when test="${sdto != null }">
		${sdto.nick }<br>
		${sdto.rank }<br>
		${sdto.tier }<br>
		${sdto.score }<br>
		${sdto.total }<br>
		${sdto.winrate }<br>
		${sdto.most1 }<br>
		${sdto.most2 }<br>
		${sdto.most3 }<br>
		${sdto.most4 }<br>
		${sdto.most5 }<br>
		</c:when>
		<c:otherwise>
			${sdto.nick }<br>
		${fdto.rank }<br>
		${fdto.tier }<br>
		${fdto.score }<br>
		${fdto.total }<br>
		${fdto.winrate }<br>
		${fdto.most1 }<br>
		${fdto.most2 }<br>
		${fdto.most3 }<br>
		${fdto.most4 }<br>
		${fdto.most5 }<br>
		</c:otherwise>
	</c:choose>
	<img src="resources/reflash.JPG" style="height:30px; width:30px;" onclick="update(sdto.nick)">
		
	
</body>
</html>