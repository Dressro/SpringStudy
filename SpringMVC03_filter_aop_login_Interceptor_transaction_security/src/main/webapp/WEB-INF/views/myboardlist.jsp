<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Hello,${login.memberid }</h1>
	<h1>BoardList</h1>
	<table border="1">
		<col width="50"/>
		<col width="100"/>
		<col width="500"/>
		<col width="100"/>
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>날짜</th>
		</tr>
		<c:choose>
			<c:when test="${empty list}">
				<tr>
					<th>---------------------작성 된 글이 없습니다----------------------</th>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="dto">
					<tr>
						<td>${dto.myno }</td>
						<td>${dto.myname }</td>
						<td><a href="./select.do?myno=${dto.myno }">${dto.mycontent }</a></td>
						<td>${dto.mydate }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<tr>
			<td colspan="4" align="right">
				<input type="button" value="글작성" onclick="location.href='./insertform.do'"/>
			</td>
		</tr>
	</table>
</body>
</html>