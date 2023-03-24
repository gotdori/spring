<%@page import="com.ds.damin.user.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <title>LOGIN</title>
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
            <h2>로그인</h2>
            </p>
          </div>
        </div>
        <div class="row justify-content-center">
          <div class="col-md-6 mb-5 mb-md-0 " data-aos="fade-up">
            <form name="loginForm" id="loginForm">
              <div class="row gy-3 ">
                <div class="col-md-12 form-group">
                    <label for="name">아이디</label>
                    <input type="text" class="form-control" name="u_name" id="u_name" value="" required>
                </div>
                <div class="col-md-12 form-group">
                  <label for="name">비밀번호</label>
                  <input type="password" name="u_password" class="form-control" id="u_password"  value="" required>
                </div>

                <div class="col-md-12 mt-20 form-group">
                 <p>
                  <div class="col-md-12 my-3">
                  <div class="join_fail" id ="id_fail" style="display: none">ID를 확인해주세요.</div>
                  <div class="join_fail" id ="pw_fail" style="display: none">PW를 확인해주세요.</div>
                 </div>
                </p>
                  <button type="button" class="readmore d-block w-100" id="btnLogin" onclick="btnLogin" >로그인</button>
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

$("#btnLogin").click(()=>{
	let formdata = $("#loginForm").serialize();
	let id = $("#u_name").val();
	let password = $("#u_password").val();
	
	$.ajax({
		url:"${ctx}/user/longin_proc",
		data:formdata,
		method:"POST",
		dataType:"json"
	})
	.done((r)=>{
		
		if(r.result=="id_f"){
			$('#id_fail').css("display", "block");
			return;
		}
		else if(r.result=="pw_f"){
			alert('dd');
			$('#pw_fail').css("display", "block");
			return;
		}
		else{
			location.href="${ctx}/mall/list";
		}
	})
	
})



// 	$("#idCheck").click(()=>{
// 		let data = {u_name:$("#u_name").val()}
// 		$.ajax({
// 			url:"${ctx}/user/idcheck",
// 			data:data,
// 			type:"POST"
// 		})
// 		.done((res)=>{
// 			if(res.result==false){
// 			alert("사용가능한 아이디입니다.")
// 				$('#u_name').prop("readOnly", true);
// 			}
// 			else
// 			alert("이미 사용중인 아이디입니다.")
// 		})
// 		.fail((res, error, status)=>{
// 			console.log(error)
// 		})
// 	})
	
// 	$("#btnJoin").click(()=>{
// 		let formData = $("#myform").serialize();
// 		let id = $("#u_name").val();
// 		let password = $("#u_password").val();
// 		let password2 = $("#u_password2").val();
// 		let phone = $("#u_phone").val();
// 		let email = $("#u_email").val();
// 		let zipcode = $("#u_zipcode").val();
// 		let re = $("#join_fail").val();

//         if(id == "" || $('#u_name').attr("readOnly") == "readOnly" || password == "" || password != password2  || phone == "" || email == "" || zipcode == ""){
//             $('#re').css('display','block');
//            	return
//         }
//         $('#re').css('display','none');
// 		$.ajax({
// 			url:"${ctx}/user/save",
// 			data:formData,
// 			dataType:"json",
// 			method:"POST"
// 		})
// 		.done((res)=>{
// 			alert("가입되었습니다.")
//  			location.href="${ctx}/user/list"
// 		})
// 		.fail((res, error, status)=>{
// 			console.log(error);
// 		})
// 	})

</script>