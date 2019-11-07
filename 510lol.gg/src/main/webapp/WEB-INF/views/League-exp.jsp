<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="league-exp-re">
	<select name="queue">
		<option>--Queue--</option>
		<option value="RANKED_SOLO_5x5" >솔로</option>
		<option value="RANKED_TFT">롤토체스</option>
		<option value="RANKED_FLEX_SR">5:5팀랭</option> 
		<option value="RANKED_FLEX_TT">3:3팀랭</option> 
	</select>
	<select name="tier">
		<option>--Tier-</option>
		<option value="CHALLENGER" >챌린저</option>
		<option value="GRANDMASTER">그마</option>
		<option value="MASTER">마스터</option> 
		<option value="DIAMOND">다이아</option>
		<option value="PLATINUM">플레</option>
		<option value="GOLD">골드</option> 
		<option value="SILVER">실버</option> 
		<option value="BRONZE">브론즈</option>
		<option value="IRON">아이언</option> 
	</select>
		<select name="division">
		<option>--Division--</option>
		<option value="I" >I</option>
		<option value="II">II</option>
		<option value="III">III</option> 
		<option value="IV">IV</option>
	</select>
	<input type="hidden" value="1" name="page">
	<input type="submit" value="Search">
</form>
</body>
</html>