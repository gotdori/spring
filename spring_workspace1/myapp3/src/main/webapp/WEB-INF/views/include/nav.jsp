<%@page import="com.kosa.myapp3.member.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta chareset='utf-8'>
<!-- 메뉴 -->
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<div class="container-fluid">
		<a class="navbar-brand" href="<%=request.getContextPath()%>/board/list">LIST </a>

		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
				<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Dropdown</a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="#">Link</a></li>
						<li><a class="dropdown-item" href="#">Another link</a></li>
						<li><a class="dropdown-item" href="#">A third link</a></li>
					</ul></li>
			</ul>
		</div>
		<%
			if (session.getAttribute("user_id") == null ||  session.getAttribute("user_id").equals("")) {
		%>
		<ul class="navbar-nav justify-content-end">
			<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/member/login">로그인</a></li>
			<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/member/write">회원가입</a></li>
		</ul>
		<%
			} else {
		%>
		<ul class="navbar-nav justify-content-end">
			<li class="nav-item"><a class="nav-link" href="#none"><%=session.getAttribute("user_name")%>님</a></li>
			<li class="nav-item"><a class="nav-link" href="#none" onclick="goLogOut()">로그아웃</a></li>
		</ul>
		<%
			}
		%>
	</div>
</nav>

<script>
function goLogOut(){
	$.ajax({
	url:"<%=request.getContextPath()%>/member/logout",
		method:"POST",
		dataType:"json"
	})
		.done((res)=>{
		alert(res.result);
		location.replace("<%=request.getContextPath()%>");
	})
	.fail((res, stats, error)=>{
		console.log(status);
		console.log(error);
	})
}
</script>