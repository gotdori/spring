<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="com.ds.damin.mall.MallDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>insert_prodcut</title>
<meta content="" name="description">
<meta content="" name="keywords">
<%@include file="../include/css.jsp"%>
</head>

<body>

	<%
	MallDto dto = (MallDto) request.getAttribute("MallDto");
	String mode = request.getParameter("mode");
	if(mode == null)
		mode="write";
	%>
	<%@include file="../include/nav.jsp"%>

	<main id="main">

		<section class="section pb-5">
			<div class="container">

				<div class="row mb-5 align-items-end">
					<div class="col-md-6" data-aos="fade-up">
						<h2>제품 등록</h2>
						<p class="mb-0">제품 사진은 최대 3장, 빈 칸 없이 모두 기입 하시기 바랍니다.</p>
					</div>

				</div>
				<form name="writeForm" id="writeForm">
					<input type="hidden" name="mode" id="mode" value="<%=mode%>">
					<input type="hidden" name="p_seq" id="p_seq" value="<%=dto.getP_seq()%>">
					<div class="row">
						<div class="col-md-6 mb-5 mb-md-0" data-aos="fade-up">

							<div class="row gy-3">
								<div class="col-md-12 form-group">
									<label for="name">제품명</label>
									<input type="text" class="form-control" name="p_name" id="p_name" value="<%=dto.getP_name()%>" required>
								</div>
								<div class="col-md-4 form-group">
									<label for="name">가격</label>
									<input type="text" name="p_price" class="form-control" id="p_price" value="<%=dto.getP_price()%>" required>
								</div>
								<div class="col-md-4 form-group">
									<label for="name">사이즈</label>
									<input type="text" class="form-control" name="p_size" id="p_size" value="<%=dto.getP_size()%>" required>
								</div>
								<div class="col-md-4 form-group">
									<label for="name">카테고리</label>
									<input type="text" name="p_category" class="form-control" id="p_category" value="<%=dto.getP_category()%>" required>
								</div>
								<div class="col-md-12 form-group">
									<label for="name">세부내용</label>
									<textarea class="form-control" name="p_contents" cols="30" rows="13" required><%=dto.getP_contents()%></textarea>
								</div>

								<div class="col-md-12 mt-0 form-group">
									<button type="button" class="readmore d-block w-100" name="btnSave" id="btnSave">저장하기</button>
								</div>
							</div>
						</div>

						<div class="col-md-6 mb-5 mb-md-0" data-aos="fade-up">
							<div class="row gy-3">
								<%
								if (!mode.equals("update")) {
								%>
								<div class="col-md-12 form-group">
									<label for="name">이미지1</label>
									<input type="file" class="form-control" name="file1" id="file1" accept=".jpg, .jpeg, .png">
								</div>
								<div class="col-md-12 form-group">
									<label for="name">이미지2</label>
									<input type="file" class="form-control" name="file2" id="file2" accept=".jpg, .jpeg, .png">
								</div>
								<div class="col-md-12 form-group">
									<label for="name">이미지3</label>
									<input type="file" class="form-control" name="file3" id="file3" accept=".jpg, .jpeg, .png">
									<%
									} else {
									%>
									<div class="col-md-12 form-group">
										<label for="name">이미지1</label>
										<input type="file" class="form-control" name="file1" id="file1" accept=".jpg, .jpeg, .png">
										<input type="hidden" name="old_name" id="old_name1" value=" ">
									</div>
									<div class="col-md-12 form-group">
										<label for="name">이미지2</label>
										<input type="file" class="form-control" name="file2" id="file2" accept=".jpg, .jpeg, .png">
										<input type="hidden" name="old_name" id="old_name1" value=" ">
									</div>
									<div class="col-md-12 form-group">
										<label for="name">이미지3</label>
										<input type="file" class="form-control" name="file3" id="file3" accept=".jpg, .jpeg, .png">
										<input type="hidden" name="old_name" id="old_name1" value=" ">
										<%
										}
										%>
									</div>
								</div>
							</div>
						</div>
					</div>
				</form>



			</div>

		</section>

	</main>
	<!-- End #main -->

<%@include file="../include/footer.jsp"  %>
</body>
</html>
<script>
$(()=>{
	$("#btnSave").click(()=>{
		//let data = $("#myform").serialize();

		let formData = new FormData( $("#writeForm")[0] );
		
		let url;
		if($("#mode").val()=="update")
		url ="${ctx}/mall/update_save";
		else
		url ="${ctx}/mall/save";
		//console.log(data);
		$.ajax({
			url:url,
			data:formData,
			dataType:"json",
		    processData:false,
		    contentType:false,
			enctype:"multipart/form-data",
			timeout:600000,
			type:"POST"
		})
		.done((res)=>{
			alert(res.res);
			location.href="${ctx}/mall/list";
		})
		.fail((res, status, error)=>{
			console.log(error)
			console.log(status)
			console.log(res)
		})
	})
})

// function setThumbnail(event) {
//         var reader = new FileReader();

//         reader.onload = function(event) {
//           var img = document.createElement("img");
//           img.setAttribute("src", event.target.result);
//           document.querySelector("div#image_container").appendChild(img);
//         };

//         reader.readAsDataURL(event.target.files[0]);
//       }


</script>