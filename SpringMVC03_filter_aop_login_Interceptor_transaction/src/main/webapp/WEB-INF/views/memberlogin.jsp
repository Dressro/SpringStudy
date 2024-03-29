<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function () {
		$("#loginChk").hide();
	});
	
	function login(){
		var memberid = $("#memberid").val().trim();
		var memberpw = $("#memberpw").val().trim();
		
		var loginVal = {
				"memberid" : memberid,
				"memberpw" : memberpw
		}
		
		if(memberid == null || memberid == "" || memberpw == null || memberpw == ""){
			alert ("ID 와 PW를 다시 확인해 주세요!");
		} else{
			$.ajax({
				type:"post",
				url:"ajaxlogin.do",
				// json 형태로 이루어진 loginval 보내기
				data:JSON.stringify(loginVal),
				// 서버에 알려주는 용도
				contentType:"application/json",
				dataType:"json",
				success:function(msg){
					if(msg.check==true){
						location.href="list.do";
					}else{
						$("#loginChk").show();
						$("#loginChk").html("ID 혹은 PW를 다시 확인해 주세요!");
					}
				},
				error:function(){
					alert("통신 실패");
				}
			});
		}
	}
</script>
</head>
<body>

	<table border="1">
		<tr>
			<th>ID</th>
			<td>
				<input type="text" id="memberid" />
			</td>
		</tr>
		<tr>
			<th>PW</th>
			<td>
				<input type="text" id="memberpw" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="login" onclick="login();" />
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center" id="loginChk"></td>
		</tr>
	</table>
</body>
</html>