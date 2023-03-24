<%@page import="com.ds.damin.common.PagerMakerDto"%>
<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="com.ds.damin.mall.MallDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>NeBalance</title>
<meta content="" name="description">
<meta content="" name="keywords">
<%@include file="../include/css.jsp"%>
</head>

<body>
	<%@include file="../include/nav.jsp"%>
	<main id="main">

		<!-- ======= Works Section ======= -->
		<section class="section site-portfolio">
			<div class="container">
				<div class="row mb-5 align-items-center">
					<div class="col-md-12 col-lg-6 mb-4 mb-lg-0" data-aos="fade-up">
						<h2>손이 자주 가는 아이템</h2>
						<p class="mb-0">어디든 매치가 쉬운 뉴발란스 아이템으로, 다양한 룩을 완성해보세요!</p>
					</div>
					<div class="col-md-12 col-lg-6 text-start text-lg-end" data-aos="fade-up" data-aos-delay="100">
						<div id="filters" class="filters">
							<a id = "list_1" href="#" onclick="sort(1)" >신상품순</a> <a id = "list_2" href="#" onclick="sort(2)">높은 가격순</a> <a id = "list_3" href="#" onclick="sort(3)">낮은 가격순</a>
						</div>
					</div>
				</div>
					<div id="product" class="row no-gutter" data-aos="fade-up" data-aos-delay="200">
						<%
						List<MallDto> list = (List<MallDto>) request.getAttribute("mallList");
						%>
						<%
						for (int i = 0; i < list.size(); i++) {
							MallDto dto = list.get(i);
						%>
						<div class="item web col-sm-6 col-md-4 col-lg-4 mb-4">
							<a href="${ctx}/mall/view?p_seq=<%=dto.getP_seq() %>" class="item-wrap fancybox">
								<div class="work-info">
									<h3><%=dto.getP_name()%></h3>
									<span><%=dto.getP_price()%></span>
								</div> <img class="img-fluid" src="${ctx}/resources/upload/p_image/<%=dto.getP_image1()%>">
							</a>
						</div>
						<%
						}
						%>
					</div>
		</section>
		<!-- End  Works Section -->

		<!-- ======= pager ======= -->

		<div id="pageInfo_wrap">
			<div id="pageInfo_area">
				<ul id="pageInfo" style="list-style: none; display: flex; justify-content: center;">

					<!-- 이전페이지 버튼 -->
					<c:if test="${pageMaker.prev}">
						<li id="pageInfo_btn previous" style="margin: 10px;"><a style="margin: 10px;"${pageMaker.startPage-1}"> &lt; </a></li>
					</c:if>

					<!-- 각 번호 페이지 버튼 -->
					<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
						<li id="pageInfo_btn" style="display: block; margin: 10px"><a href="#" onclick="asd(${num})" class="pageInfo_a"> ${num} </a></li>

					</c:forEach>

					<!-- 다음페이지 버튼 -->
					<c:if test="${pageMaker.next}">
						<li id="pageInfo_btn next"><a href="${pageMaker.endPage + 1 }"> &gt; </a></li>
					</c:if>

				</ul>
			</div>
		</div>

		<form id="moveForm">
			<input type="hidden" name="pageNum" id="pageNum" value="${pageMaker.cri.pageNum }">
			<input type="hidden" name="amount" id="amount" value="${pageMaker.cri.amount }">
			<input type="hidden" name="num" id="num" value="${pageMaker.cri.num }">
			<input type="hidden" name="cate" id="cate" value="${pageMaker.cri.cate }">
		</form>


		<!-- ======= Clients Section ======= -->
		<section class="section">
			<div class="container">
				<div class="row justify-content-center text-center mb-4">
					<div class="col-5">
						<h3 class="h3 heading">My Clients</h3>
						<p>Lorem ipsum dolor sit amet consectetur adipisicing elit explicabo inventore.</p>
					</div>
				</div>
				<div class="row">
					<div class="col-4 col-sm-4 col-md-2">
						<a href="#" class="client-logo"><img src="${ctx}/resources/assets/img/logo-adobe.png" alt="Image" class="img-fluid"></a>
					</div>
					<div class="col-4 col-sm-4 col-md-2">
						<a href="#" class="client-logo"><img src="${ctx}/resources/assets/img/logo-uber.png" alt="Image" class="img-fluid"></a>
					</div>
					<div class="col-4 col-sm-4 col-md-2">
						<a href="#" class="client-logo"><img src="${ctx}/resources/assets/img/logo-apple.png" alt="Image" class="img-fluid"></a>
					</div>
					<div class="col-4 col-sm-4 col-md-2">
						<a href="#" class="client-logo"><img src="${ctx}/resources/assets/img/logo-netflix.png" alt="Image" class="img-fluid"></a>
					</div>
					<div class="col-4 col-sm-4 col-md-2">
						<a href="#" class="client-logo"><img src="${ctx}/resources/assets/img/logo-nike.png" alt="Image" class="img-fluid"></a>
					</div>
					<div class="col-4 col-sm-4 col-md-2">
						<a href="#" class="client-logo"><img src="${ctx}/resources/assets/img/logo-google.png" alt="Image" class="img-fluid"></a>
					</div>

				</div>
			</div>
		</section>
		<!-- End Clients Section -->

<%@include file="../include/footer.jsp"  %>
</body>
</html>
<script>
function asd(num) {
	let moveForm = $("#moveForm");
   	$("#pageNum").val(num);
       moveForm.prop("action", "${ctx}/mall/list");
       moveForm.submit();
}

function sort(num) {
	let moveForm = $("#moveForm");
   	$("#num").val(num);
       moveForm.prop("action", "${ctx}/mall/list");
       moveForm.submit();
}

function category(cate) {
	let moveForm = $("#moveForm");
   		$("#pageNum").val("1");
   		$("#cate").val(cate);
   		moveForm.prop("action", "${ctx}/mall/list");
   		moveForm.submit();
}

</script>
