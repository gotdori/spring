<%@page import="com.ds.damin.user.UserDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>LIST</title>
<meta content="" name="description">
<meta content="" name="keywords">
<%@include file="../include/css.jsp"%>
</head>

<body>
<%@include file="../include/nav.jsp"%>
	<main id="main">

		<section class="section pb-5">
			<div class="container">

				<div class="row mb-5 align-items-end justify-content-center">
					<div class="col-md-6" data-aos="fade-up">
						<h2>회원 명단</h2>
						</p>
					</div>
				</div>
				<div class="row justify-content-center" data-aos="fade-up">

					<form id="myform" name="myform">
						<div class="container">
							<div class="row">
								<div class="col-lg-12">
									<div class="main-box clearfix">
										<div class="table-responsive">
											<table class="table user-list text-md-center">
												<col width="10%">
												<col width="10%">
												<col width="10%">
												<col width="10%">
												<col width="20%">
												<col width="20%">
												<col width="10%">
												<col width="10%">
												</colgroup>
												<thead>
												<colgroup>
												<tr>
													<th><span>아이디</span></th>
													<th><span>전화번호</span></th>
													<th><span>이메일</span></th>
													<th><span>우편번호</span></th>
													<th><span>주소</span></th>
													<th><span>상세주소</span></th>
													<th><span>관리자</span></th>
													<th><span> </span></th>
												</tr>
												</thead>
												<tbody>
													<tr>
														<%
														List<UserDto> list = (List<UserDto>) request.getAttribute("userList");
														for (UserDto dto : list) {
														%>
														<td><span><%=dto.getU_name()%></span></td>
														<td><span><%=dto.getU_phone()%></span></td>
														<td><span><%=dto.getU_email()%></span></td>
														<td><span><%=dto.getU_zipcode()%></span></td>
														<td><span><%=dto.getU_address1()%></span></td>
														<td><span><%=dto.getU_address2()%></span></td>
														<td><span><%=dto.getU_manage()%></span></td>
														<td style="width: 20%;"><a href="${ctx}/user/update?mode=update&u_seq=<%=dto.getU_seq() %>" class="table-link"> <span class="fa-stack"> <i class="fa fa-square fa-stack-2x"></i>
																	<i class="fa fa-pencil fa-stack-1x fa-inverse"></i>
															</span>
														</a> <a href="#" class="table-link danger"> <span class="fa-stack" onclick="U_Delete(<%=dto.getU_seq()%>)"> <i class="fa fa-square fa-stack-2x" ></i> <i
																	class="fa fa-trash-o fa-stack-1x fa-inverse"></i>
															</span>
														</a></td>
													</tr>
												</tbody>
												<%
												}
												%>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</form>


				</div>

			</div>

		</section>

	</main>
	<!-- End #main -->

<%@include file="../include/footer.jsp"  %>
</body>
</html>
<script>
function U_Delete(seq) {
    if (confirm("삭제하시겠습니까?")) {
    	$.ajax({
    		url : "${ctx}/user/delete",
   			data:{"u_seq":seq},
   			dataType:"json"
    	})
    	.done((r)=>{
    		if(r.result=="ok"){
		        alert("삭제되었습니다.");
    			location.href="${ctx}/user/list";
    		}else
    			alert("실패")
    	})
    } else {
    }
}

</script>