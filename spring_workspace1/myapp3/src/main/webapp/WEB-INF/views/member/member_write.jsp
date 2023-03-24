<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>

	<!-- 메뉴 -->
	<%@include file="../include/nav.jsp"%>
<form name="myform" id="myform">

<input type="hidden" name="idcheck" id="idcheck" value="N">
	<div class="container mt-3">
		<h3>Navbar With Dropdown</h3>
		<p>This example adds a dropdown menu in the navbar.</p>


		<table class="table">
			<colgroup>
				<col width="30%">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>아이디
					</td>
					<td>
						<div class="input-group">
							<input type="text" class="form-control" placeholder="아이디를 입력하세요" name="user_id" id="user_id" >
							<button type="button" class="input-group-text" id="btnIdCheck" onclick="goIdCheck()">아이디중복체크</span>
						</div>
					</td>
				</tr>
				<tr>
					<th>패스워드
					</td>
					<td>
						<div class="input-group">
							<input type="password" class="form-control" placeholder="패스워드를 입력하세요" name="password" id="password">
						</div>
					</td>
				</tr>
				<tr>
					<th>패스워드확인
					</td>
					<td>
						<div class="input-group">
							<input type="password" class="form-control" placeholder="패스워드를 입력하세요" name="password2" id="password2">
						</div>
					</td>
				</tr>
				<tr>
					<th>이름
					</td>
					<td>
						<div class="input-group">
							<input type="text" class="form-control" placeholder="이름을 입력하세요" name="user_name" id="user_name">
						</div>
					</td>
				</tr>
				<tr>
					<th>이메일
					</td>
					<td>
						<div class="input-group">
							<input type="email" class="form-control" placeholder="이름을 입력하세요" name="email" id="email">
						</div>
					</td>
				</tr>
				<tr>
					<th>전화번호
					</td>
					<td>
						<div class="input-group">
							<input type="tel" class="form-control" placeholder="전화번호를 입력하세요" name="tel" id="tel">
						</div>
					</td>
				</tr>
				<tr>
					<th>주소
					</td>
					<td>
						<div style="width: 350px; flex-direction:row;">
							<div class="input-group">
								<input type="text" class="form-control" placeholder="우편번호를 입력하세요" name="zipcode" id="sample4_postcode" readonly>
								<button type="button" class="btn btn-primary" onclick="sample4_execDaumPostcode()" value="검색">우편번호 찾기</button>
							</div>
						</div>
									<input type="text" class="form-control" placeholder="상세주소를 입력하세요" name="adress1" id="adress1" readonly>
									<input type="text" class="form-control" placeholder="상세주소를 입력하세요" name="adress2" id="adress2">
					</td>
				</tr>
			</tbody>
		</table>
	</div>



	<div class="container" style="text-align: right">
		<button type="button" class="btn btn-primary" onclick="goSave()">가입하기</button>
	</div>
</form>
</body>

<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                if(data.jibunAddress == "")
                	document.getElementById('adress1').value = roadAddr;
                else
               	 document.getElementById('adress1').value = data.jibunAddress;
            }
        }).open();
    }
    
function goIdCheck(){ 
	let user_id = $("#user_id").val().trim();
	if(user_id.length<6){
		alert("아이디는 6자리 이상 입력하셔");
		$("#user_id").focus(); 
		return;
	}
	$.ajax({
		url:"<%=request.getContextPath()%>/member/idcheck",
		data:{"user_id":user_id},
		method:"POST",
		dataType:"JSON"
	})
	.done((response)=>{
		if(!response.result){
			$("#idcheck").val("Y");
			$("#user_id").prop("readonly", true);
			$("#btnIdCheck").prop("disabled", true); //왜 안되지..?
			alert("사용가능한 아이디 입니다.");
		}
		else{
			alert("이미 사용 중인 아이디 입니다.");
		}
	})
	.fail((response, status, error)=>{
		console.log(error);
	})
}
function goSave(){
	let user_id=$("#user_id").val().trim();
	if($("#idcheck").val()=="N"){
		alert("아이디 중복체크를 눌러요~")
		$("#user_id").focus();
		return;
	}
	if(fnerrorCheck()){
		var frmdata = $("#myform").serialize();
		$.ajax({
			url:"<%=request.getContextPath()%>/member/save",
			data:frmdata,
			method:"POST",
			dataType:"json"
		})
		.done((res)=>{
			alert(res.msg);
			location.href="<%=request.getContextPath()%>";
		})
		.fail((res, status, error)=>{
			console.log(status);
			console.log(error);
		})
<%-- 	$("#myform").prop("action", "<%=request.getContextPath()%>/member/save"); --%>
// 	$("#myform").method="post";
// 	$("#myform").submit();
	}
}

function fnerrorCheck(){ 
	if($("#user_id").val().trim().length<6){
		alert("아이디는 6자리 이상 입력하셔");
		$("#user_id").focus();
		return false;
	}
	if($("#password").val().trim().length<6){
		alert("비밀번호는 6자리 이상 입력하셔");
		$("#password").focus();
		return false;
	}
	if($("#password").val()!=$("#password2").val()){
		alert("비밀번호가 일치하지 않습니다.");
		$("#password").focus();
		return false;
	}
	if($("#user_name").val().trim().length<1){
		alert("이름 빠졌슈");
		$("#user_name").focus();
		return false;
	}	
		return true;
}
</script>
</html>