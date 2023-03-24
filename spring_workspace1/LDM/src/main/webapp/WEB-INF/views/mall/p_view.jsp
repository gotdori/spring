<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="com.ds.damin.mall.MallDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.ds.damin.mall.*"%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <title>Detail View</title>
<%@include file="../include/css.jsp" %>
</head>

<body>
<%@include file="../include/nav.jsp" %>
<%MallDto dto = (MallDto)request.getAttribute("mallgetView");
System.out.println(dto);%>
  <main id="main">
    <section class="section">
      <div class="container">
        <div class="row mb-4 align-items-center">
          <div class="col-md-6" data-aos="fade-up">
            <h2><%=dto.getP_name()%></h2>
          </div>
        </div>
      </div>
    <form id="viewForm" name="viewForm">  
	<input type="hidden" name="mode" id="mode" value=""> 
	<input type="hidden" name="p_seq" id="p_seq" value=""> 
      <div class="site-section pb-0">
        <div class="container">
          <div class="row align-items-stretch">
            <div class="col-md-8" data-aos="fade-up">
				<div id="carousel" class="carousel slide" data-bs-ride="carousel">
				  <div class="carousel-inner">
				    <div class="carousel-item active">
				      <img src="${ctx}/resources/upload/p_image/<%=dto.getP_image1()%>" class="img-fluid" alt="Image1">
				    </div>
				    <div class="carousel-item">
				      <img src="${ctx}/resources/upload/p_image/<%=dto.getP_image2()%>" class="img-fluid" alt="Image2">
				    </div>
				    <div class="carousel-item">
				      <img src="${ctx}/resources/upload/p_image/<%=dto.getP_image3()%>" class="img-fluid" alt="Image3">
				    </div>
				  </div>
				    <button class="carousel-control-prev" type="button" data-bs-target="#carousel" data-bs-slide="prev">
				    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
				    <span class="visually-hidden">Previous</span>
				  </button>
				  <button class="carousel-control-next" type="button" data-bs-target="#carousel" data-bs-slide="next">
				    <span class="carousel-control-next-icon" aria-hidden="true"></span>
				    <span class="visually-hidden">Next</span>
				  </button>
				</div>
            </div>
            <div class="col-md-3 ml-auto" data-aos="fade-up" data-aos-delay="100">
              <div class="sticky-content">
                <h3 class="h3"><%=dto.getP_name()%></h3>
                <p class="mb-4"><span class="text-muted">Detail</span></p>

                <div class="mb-5">
                  <p><%=dto.getP_contents()%></p>

                </div>

                <h4 class="h4 mb-3">What I</h4>
                <ul class="list-unstyled list-line mb-5">
                  <li><%=dto.getP_price()%></li>
                  <li><%=dto.getP_size()%></li>
                  <li><%=dto.getP_category()%></li>
                </ul>

                <p><a href="${ctx}/mall/list" class="readmore">목록</a>   <a href="#" id="btnUpdate" class="readmore">수정</a>  <a id="btnDelete" href="none" class="readmore">삭제</a></p>
              </div>
            </div>
          </div>
        </div>
    </section>
</form>
    <!-- ======= Testimonials Section ======= -->
    <section class="section pt-0">
      <div class="container">

        <div class="testimonials-slider swiper" data-aos="fade-up" data-aos-delay="100">
          <div class="swiper-wrapper">

            <div class="swiper-slide">
              <div class="testimonial-wrap">
                <div class="testimonial">
                  <img src="${ctx}/resources/assets/img/person_1.jpg" alt="Image" class="img-fluid">
                  <blockquote>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Quisquam necessitatibus incidunt ut officiis
                      explicabo inventore.</p>
                  </blockquote>
                  <p>&mdash; Jean Hicks</p>
                </div>
              </div>
            </div><!-- End testimonial item -->

            <div class="swiper-slide">
              <div class="testimonial-wrap">
                <div class="testimonial">
                  <img src="${ctx}/resources/assets/img/person_2.jpg" alt="Image" class="img-fluid">
                  <blockquote>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Quisquam necessitatibus incidunt ut officiis
                      explicabo inventore.</p>
                  </blockquote>
                  <p>&mdash; Chris Stanworth</p>
                </div>
              </div>
            </div><!-- End testimonial item -->

          </div>
          <div class="swiper-pagination"></div>
        </div>

      </div>
    </section><!-- End Testimonials Section -->

  </main><!-- End #main -->
  
<%@include file="../include/footer.jsp"  %>
</body>
</html>
<script>

$(()=>{
	$("#btnUpdate").click(()=>{
		$("#mode").val("update");
		$("#p_seq").val(<%=dto.getP_seq() %>)
		$("#viewForm").prop("action", "${ctx}/mall/update");
		$("#viewForm").submit();
	})

	$("#btnDelete").click(()=>{
		$("#p_seq").val(<%=dto.getP_seq() %>);
		let viewForm=$("#viewForm").serialize();
		$.ajax({
			url:"${ctx}/mall/delete",
			data:viewForm,
			dataType:"json",
			type:"get"
		})
		.done((res)=>{
			if (res.result=="ok") {
				alert("삭제완료")
				location.href="${ctx}/mall/list"
			}
		})
		.fail((res, status, error)=>{
			console.log(error)
			console.log(res)
		})
	})
})



</script>