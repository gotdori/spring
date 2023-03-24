<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<form id="myform" name="myform">
		<div class="container">
			<h2>Carousel Example</h2>
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner" id="Carousel_div"></div>

				<!-- Left and right controls -->
				<a class="left carousel-control" href="#myCarousel"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#myCarousel"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
			<input type="button" name="Write" id="Write" onclick="goWrite()">

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
		url:"<%=request.getContextPath()%>/home/list",
		dataType:"json"
	})
	.done((res)=>{
		let temp ="";
		for(i=0; i<res.data.length; i++){
			if(i==0)
				temp+='<div class="item active">';
			else
				temp+='<div class="item">';
			temp += '<img src="<%=request.getContextPath()%>/upload/'+res.data[i].image+'" alt="'+res.data[i].image+'" style="width:100%;">';
			temp+=	'</div>';
		}
		$("#Carousel_div").html(temp);
		
	})
	.fail((res, status, error)=>{
		console.log(status);
		console.log(error);
	})
}

function goWrite(){
	var frm = $("#myform");
	frm.prop("action", "<%=request.getContextPath()%>/home/write");
	frm.submit();
}

</script>
