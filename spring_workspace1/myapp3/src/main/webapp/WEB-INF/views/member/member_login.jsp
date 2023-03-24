<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>

	<!-- 메뉴 -->
	<%@include file="../include/nav.jsp"%>
	<form name="myform" id="myform">

		<div class="container mt-3">
			<h3>Navbar With Dropdown</h3>
			<p>This example adds a dropdown menu in the navbar.</p>


			<table class="table">
				<colgroup>
					<col width="30%">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>아이디
						</td>
						<td>
							<div class="input-group">
								<input type="text" class="form-control" placeholder="아이디를 입력하세요" name="user_id" id="user_id">
							</div>
						</td>
					</tr>
					<tr>
						<th>패스워드
						</td>
						<td>
							<div class="input-group">
								<input type="password" class="form-control" placeholder="패스워드를 입력하세요" name="password" id="password">
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>



		<div class="container" style="text-align: right">
			<button type="button" class="btn btn-primary" onclick="Login()">로그인</button>
		</div>
	</form>
</body>
<script>
function Login(){
	let user_id = $("#user_id").val().trim();
	let password = $("#password").val().trim();
	if(user_id==""){
		alert("아이디를 입력하세용");
		$("#user_id").focus(); 
		return;
	}
	else if(password==""){		
		alert("패스워드를 입력하세용");
		$("#user_id").focus(); 
		return;
	}
	$.ajax({
		url:"<%=request.getContextPath()%>/member/loginproc",
		data:{"user_id":user_id, "password":password},
		method:"POST",
		dataType:"json"
	}) 
	.done((res)=>{
		alert(res.msg);
		location.href="<%=request.getContextPath()%>";
	})
	.fail((res, stats, error)=>{
		console.log(status);
		console.log(error);
	})
}
</script>
</html>