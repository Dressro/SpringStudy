<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 	<!-- form:form -->
 	<!-- post 형식으로 multipart/form-data 으로 인코딩 함  -->
 	<!-- modelAttribute 를 통해 input 혹은 textarea 값을 이름과 매칭 시켜서 전송된다.-->
	<form:form method="post" enctype="multipart/form-data" modelAttribute="uploadFile" action="upload">
		<h1>UPLOAD FORM</h1>
		file<br>
		<input type="file" name="mpfile"/><br/>
		<p style="color:red; font-weight:bold;">
			<form:errors path="mpfile" />
		</p>
		<br>
		description<br/>
		<textarea rows="10" cols="60" name="desc"></textarea>
		<input type="submit" value="send">
	</form:form>
	
	<!-- 
		form tag의 enctype 속성
		1. application/www-form-urlencoded : 문자들이 encoding 됨 (default)
		2. multipart/form-data : file upload 가능 (post)
		3. text/plain : encoding하지 않음
		
		Spring form tag
		form:errors -> Errors, BindingResult를 사용할 때, command 객체의 특정 field에서 발생하는 에러메시지 출력 가능
			
	 -->
</body>
</html>