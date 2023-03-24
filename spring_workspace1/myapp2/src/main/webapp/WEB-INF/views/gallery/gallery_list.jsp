<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.kosa.mycompany.common.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>
	<%
String pg=request.getParameter("pg");
	if(pg == null)
		pg = "0";
String searchKey = request.getParameter("searchKey");
if(searchKey == null)
	searchKey = "";
String searchKeyword = request.getParameter("searchKeyword");
if(searchKeyword == null)
	searchKeyword = "";
%>
	<form name="myform" id="myform">
		<input type="hidden" name="pg" id="pg" value="<%=pg %>">

		<!-- 메뉴 -->
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<div class="container-fluid">
				<a class="navbar-brand" href="#"> <img
					src="/resources/images/img_avatar1.png" alt="Avatar Logo"
					style="width: 40px;" class="rounded-pill">
				</a>

				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="collapsibleNavbar">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" role="button"
							data-bs-toggle="dropdown">Dropdown</a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="#">Link</a></li>
								<li><a class="dropdown-item" href="#">Another link</a></li>
								<li><a class="dropdown-item" href="#">A third link</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</nav>

		<%
		int totalCnt = (Integer) request.getAttribute("totalCnt");
		%>


		<div class="container mt-3">
			<h3>Navbar With Dropdown</h3>
			<p>This example adds a dropdown menu in the navbar.</p>

			<div class="input-group mt-3 mb-3">
				<button type="button" class="btn btn-primary dropdown-toggle"
					data-bs-toggle="dropdown" id="select">선택하세요</button>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" class="nav-link"
						style="text-align: center" href="#" onclick="goSearchKey('1')">제목</a></li>
					<li><a class="dropdown-item" class="nav-link"
						style="text-align: center" href="#" onclick="goSearchKey('2')">내용</a></li>
					<li><a class="dropdown-item" class="nav-link"
						style="text-align: center" href="#" onclick="goSearchKey('3')">제목+내용</a></li>
				</ul>
				<!-- ul 태그는 값을 저장하지 못한다. 서버에 보낼려면 input 태그에 넣어야 함 -->
				<input type="hidden" name="searchKey" id="searchKey"
					value="<%=searchKey%>" /> <input type="text" name="searchKeyword"
					id="searchKeyword" class="form-control" placeholder="검색어를 입력하세요"
					value="<%=searchKeyword %>">
				<div class="input-group-append">
					<button class="btn btn-primary" type="button" onclick="goSearch()">GO</button>
				</div>
			</div>

			<div id="contents"></div>
		</div>

		<div class="container" style="text-align: right">
			<%=pager.makeTag(request, totalCnt, 10)%>
		</div>

		<div class="container" style="text-align: right">
			<button type="button" class="btn btn-primary">글쓰기</button>
		</div>
	</form>
</body>
</html>
<script>
$(()=>{
	load_data();
})

function load_data(){
	$.ajax({
		url:"<%=request.getContextPath()%>/gallery/listdata",
		data:{pg:$("#pg").val(), searchKey:$("#searchKey").val(), searchKeyword:$("#searchKeyword").val()},
		dataType:"json"
	})
	.done((res)=>{
		let temp ="";
		for(i=0; i<res.data.length; i++){
			if(i%4==0)
			temp+=	'<div class="row">';
			temp+=		'<div class="col-sm-3">';
			temp+=		'<div class="thumbnail">';
			temp+=			'<a href="<%=request.getContextPath()%>/upload/'+res.data[i].image+'"> <img src="<%=request.getContextPath()%>/upload/'+res.data[i].image+'" alt="Lights" style="width: 100%">';
			temp+=				'<div class="caption">';
			temp+='					<p>'+res.data[i].image+'</p>';
			temp+='				</div>';
			temp+='			</a>';
			temp+='		</div>';
			temp+='	</div>';
			if(i%4==3||i==res.data.length-1)
			temp+='</div>';
		}
		$("#contents").html(temp);
	})
	.fail((res, status, error)=>{
		console.log(status);
		console.log(error);
	});
}

function goPage(pg){
	$("#pg").val(pg);
	$("#myform").prop("action", "<%=request.getContextPath()%>/gallery/gallery_list");
	$("#myform").submit();
}

function goSearchKey(key){
	var select=["","제목", "내용", "제목+내용"];
	$("#select").html(select[key]);
	$("#searchKey").val(key);
}

function goSearch(){
	$("#myform").prop("action", "<%=request.getContextPath()%>/gallery/gallery_list");
	$("#myform").submit();
}

</script>
