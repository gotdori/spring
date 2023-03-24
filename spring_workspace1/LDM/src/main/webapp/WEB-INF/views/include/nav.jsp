<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- ======= Navbar ======= -->
	<div class="collapse navbar-collapse custom-navmenu" id="main-navbar">
		<div class="container py-2 py-md-5">
			<div class="row align-items-start justify-content-center">
				<div class="col-md-2">
					<ul class="custom-menu">
						<li><a href="#" onclick="category('(\'SH\',\'CL\')')">전체보기</a></li>
						<li><a href="#" onclick="category('\'SH\'')">신발</a></li>
						<li><a href="#" onclick="category('\'CL\'')">의류</a></li>
					</ul>
				</div>
				<div class="col-md-6 d-none d-md-block  mr-auto">
					<div class="tweet d-flex">
						<div>
							<p>NEW BALANCE(뉴발란스)는 1906년 미국 매사추세츠 주 보스턴에서 발에 장애가 있거나 경찰 소방관 우체부 등 하루 종일 서서 일하는 발에 무리가 가는 사람들을 위해 아치 서포트(Arch Support : 지지대가 있는 신발 깔창)를
								만드는데서부터 시작되었습니다. 닭의 세 개의 발톱이 만드는 균형 (Balance)에서 영감을 얻어 아치 서포트와 신발을 개발하였습니다. 지금의 뉴발란스(New balance)라는 회사명과 브랜드 명도 불균형한 발에 새로운 균형을 창조한다 하는 개념으로부터
								유래되었습니다.</p>
						</div>
					</div>
				</div>
				<div class="col-md-2 " style="text-align: right">
					<ul class="custom-menu align-items-end">
						<c:if test="${u_info == null}">
						<li><a href="${ctx}/user/write">회원가입</a></li>
						<li><a href="${ctx}/user/login">로그인</a></li>
						</c:if>
						
						<c:if test="${u_info != null}">
						<li><a href="#" id="btnLogout">로그아웃</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<nav class="navbar navbar-light custom-navbar">
		<div class="container">
			<a class="navbar-brand" href="${ctx}/mall/list">NEW BALANCE</a> 
			<c:if test="${u_name != null}">
			<span>${u_name}님 반갑습니다.</span> 
			</c:if>
			<a href="#" class="burger" data-bs-toggle="collapse" data-bs-target="#main-navbar">
				<span></span>
			</a>
		</div>
	</nav>

</body>
</html>
<script>
// function btnLogout(){  // 온클릭으로 함수 만들어서 할 때 
// 	$.ajax({
// 		url:"${ctx}/user/logout",
// 		method:"POST",
// 		dataType:"json"
// 	})
// 	.done((r)=>{
// 		if(r.result=="success"){
// 			alert("로그아웃 되었습니다.");
// 			location.href="${ctx}/mall/list";
// 		} else {
// 			alert("로그아웃 실패");
// 		}
// 	})
// 	.faile((status, res, error)=>{
// 		console.log(status);
// 		console.log(error);
// 	})
// }

$(()=>{
	$("#btnLogout").click(()=>{
	$.ajax({
		url:"${ctx}/user/logout",
		method:"POST",
		dataType:"json"
	})
	.done((r)=>{
		if(r.result=="success"){
			alert("로그아웃 되었습니다.");
			location.href="${ctx}/mall/list";
		} else {
			alert("로그아웃 실패");
		}
	})
	.faile((status, res, error)=>{
		console.log(status);
		console.log(error);
	})
})
})

function category(cate) {
	let moveForm = $("#moveForm");
		location.href="${ctx}/mall/list?cate="+cate;
   		$("#pageNum").val("1");
   		$("#cate").val(cate);
   		moveForm.prop("action", "${ctx}/mall/list");
   		moveForm.submit();
}
</script>