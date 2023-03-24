<%@page import="com.ds.damin.user.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <title>JOIN</title>
  <meta content="" name="description">
  <meta content="" name="keywords">
<%@include file="../include/css.jsp" %>
</head>

<body>
<%@include file="../include/nav.jsp"%>
  <main id="main">

    <section class="section pb-5">
      <div class="container">

        <div class="row mb-5 align-items-end justify-content-center">
          <div class="col-md-6" data-aos="fade-up">
            <h2>회원가입</h2>
            </p>
          </div>
        </div>

        <div class="row justify-content-center">
          <div class="col-md-6 mb-5 mb-md-0 " data-aos="fade-up">

            <form name="myform" id="myform">
			<%UserDto dto = (UserDto)request.getAttribute("UserDto");%>
              <div class="row gy-3 ">
                <div class="col-md-9 form-group">
                    <label for="name">아이디</label>
                    <input type="text" class="form-control" name="u_name" id="u_name" value="<%=dto.getU_name() %>" required>
                </div>
                <div class="col-md-3 form-group">
                    <label for="namech"></label>
                    <button type="button" class="readmore d-block w-100" name="idCheck" id="idCheck">중복확인</button>
                </div>
                <div class="col-md-6 form-group">
                  <label for="name">비밀번호</label>
                  <input type="password" name="u_password" class="form-control" id="u_password"  value="<%=dto.getU_password() %>"required>
                </div>
                <div class="col-md-6 form-group">
                  <label for="name">비밀번호 확인</label>
                  <input type="password" class="form-control" name="u_password2" id="u_password2"  value="<%=dto.getU_password2() %>" required>
                </div>
                <div class="col-md-12 form-group">
                    <label for="name">전화번호</label>
                    <input type="email" class="form-control" name="u_phone" id="u_phone"  value="<%=dto.getU_phone() %>" required>
                </div>
                <div class="col-md-12 form-group">
                    <label for="name">이메일</label>
                    <input type="email" class="form-control" name="u_email" id="u_email"  value="<%=dto.getU_email()%>" required>
                </div>
                <div class="col-md-4 form-group">
                    <label for="u_zipcode">우편번호</label>
                    <input type="text" class="form-control" name="u_zipcode" id="u_zipcode" onclick="zipCode()"  value="<%=dto.getU_zipcode() %>" required readOnly>
                </div>
                <div class="col-md-8 form-group">
                    <label for="u_address1">주소</label>
                    <input type="text" class="form-control" name="u_address1" id="u_address1"  value="<%=dto.getU_address1() %>" required readonly>
                </div>
                <div class="col-md-12 form-group">
                    <label for="u_address2">상세주소</label>
                    <input type="text" class="form-control" name="u_address2" id="u_address2"  value="<%=dto.getU_address2()%>" required>
                </div>

                <div class="col-md-12 mt-20 form-group">
                 <p>
                  <div class="col-md-12 my-3">
                  <div class="join_fail" id ="re" style="display: none">정보를 확인해주세요.</div>
                 </div>
                </p>
                  <button type="button" class="readmore d-block w-100" id="btnJoin">가입하기</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>

    </section>

  </main><!-- End #main -->

<%@include file="../include/footer.jsp"  %>
</body>

</html>
<script>
$(()=>{


	$("#idCheck").click(()=>{
		let data = {u_name:$("#u_name").val()}
		$.ajax({
			url:"${ctx}/user/idcheck",
			data:data,
			type:"POST"
		})
		.done((res)=>{
			if(res.result==false){
			alert("사용가능한 아이디입니다.")
				$('#u_name').prop("readOnly", true);
			}
			else
			alert("이미 사용중인 아이디입니다.")
		})
		.fail((res, error, status)=>{
			console.log(error)
		})
	})
	
	$("#btnJoin").click(()=>{
		let formData = $("#myform").serialize();
		let id = $("#u_name").val();
		let password = $("#u_password").val();
		let password2 = $("#u_password2").val();
		let phone = $("#u_phone").val();
		let email = $("#u_email").val();
		let zipcode = $("#u_zipcode").val();
		let re = $("#join_fail").val();

        if(id == "" || $('#u_name').attr("readOnly") == "readOnly" || password == "" || password != password2  || phone == "" || email == "" || zipcode == ""){
            $('#re').css('display','block');
           	return
        }
        $('#re').css('display','none');
		$.ajax({
			url:"${ctx}/user/save",
			data:formData,
			dataType:"json",
			method:"POST"
		})
		.done((res)=>{
			alert("가입되었습니다.")
 			location.href="${ctx}/user/list"
		})
		.fail((res, error, status)=>{
			console.log(error);
		})
	})
})
</script>

<!-- 주소 입력 -->

<script>
function zipCode() {
    new daum.Postcode({
        oncomplete: function(data) {
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }
            document.getElementById("u_zipcode").value = data.zonecode;
            document.getElementById("u_address1").value = roadAddr+extraRoadAddr;
            //document.getElementById("u_address1").value = data.jibunAddress;
        }
    }).open();
}

</script>
