 <%@page import="com.kosa.myapp3.common.StringUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.kosa.myapp3.common.*"%>
<%@page import="com.kosa.myapp3.board.*"%>
<!DOCTYPE html>
<html>
<head>
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
		String mode = StringUtil.nullToValue(request.getParameter("mode"), "insert");
	String seq = StringUtil.nullToValue(request.getParameter("seq"), "-1");
	//수정, 답글, 추가
	//수정 : 수정 할 글 정보 Dto		: if문으로 상황에 따라 다르게 동작하는것보다는 똑같은 dto 객체를 만드어서 보내는것이 프로그램이 편하다.
	//답글 : 원글에 대한 정보 Dto
	//없다. 빈 Dto
	BoardDto dto = (BoardDto) request.getAttribute("boardDto");
	if(dto==null)
		dto = new BoardDto();
	%>

	<form name="myform" id="myform">
		<input type="hidden" name="mode" id="mode" value="<%=mode%>">
		<input type="hidden" name="seq" id="seq" value="<%=seq%>">

		<%@ include file="../include/nav.jsp"%>

		<div class="container mt-3">
			<h3>게시판 글쓰기</h3>


			<table class="table">
				<colgroup>
					<col width="30%">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>제목
						</td>
						<td>
							<div class="input-group">
								<input type="text" class="form-control" placeholder="제목을 입력하세요"
									name="title" id="title" value="<%=dto.getTitle()%>">
							</div>
						</td>
					</tr>
					<tr>
						<th>작성자
						</td>
						<td>
							<div class="input-group">
								<input type="text" class="form-control" placeholder="제목을 입력하세요"
									name="userid" id="userid" value="<%=session.getAttribute("user_name")%>" readonly>
							</div>
						</td>
					</tr>
					<tr>
						<th>파일첨부
						</td>
						<td>
							<%
								if (!mode.equals("modify")) {
							%>
							<div class="input-group">
								<input type="file" class="form-control" placeholder="파일을 선택하세요"
									name="file1" id="file1">
							</div> <%
 	} else {
 %>
							<div class="input-group">
								<input type="file" class="form-control" placeholder="파일을 선택하세요"
									name="file1" id="file1" style="display: none"> 
									<input type="checkbox" id="del1" onclick="goChange('1')" value="1">
								<input type="text" name="old_name" id="old_name1"
									value="<%=dto.getFilename1()%>">
							</div> <%
 	}
 %>
						</td>
					</tr>
					<tr>
						<th>파일첨부
						</td>
						<td>
							<%
								if (!mode.equals("modify")) {
							%>
							<div class="input-group">
								<input type="file" class="form-control" placeholder="파일을 선택하세요"
									name="file2" id="file2">
							</div> <%
 	} else {
 %>
							<div class="input-group">
								<input type="file" class="form-control" placeholder="파일을 선택하세요"
									name="file2" id="file2" style="display: none"> <input
									type="checkbox" id="del2" onclick="goChange('2')" value="2">
								<input type="text" name="old_name" id="old_name2"
									value="<%=dto.getFilename2()%>">
							</div> <%
 	}
 %>
						</td>
					</tr>
					<tr>
						<th>파일첨부
						</td>
						<td>
							<%
								if (!mode.equals("modify")) {
							%>
							<div class="input-group">
								<input type="file" class="form-control" placeholder="파일을 선택하세요"
									name="file3" id="file3">
							</div> <%
 	} else {
 %>
							<div class="input-group">
								<input type="file" class="form-control" placeholder="파일을 선택하세요"
									name="file3" id="file3" style="display: none"> <input
									type="checkbox" id="del3" onclick="goChange('3')" value="3">
								<input type="text" name="old_name" id="old_name3"
									value="<%=dto.getFilename3()%>">
							</div> <%
 	}
 %>
						</td>
					</tr>
					<tr>
						<th>내용
						</td>
						<td>
							<div class="input-group">
								<textarea type="text" class="form-control"
									placeholder="내용을 입력하세요" name="contents" id="contents" rows="5"><%=dto.getContents()%></textarea>
							</div>
						</td>
					</tr>


				</tbody>
			</table>
		</div>


		<div class="container" style="text-align: right">
			<button type="button" class="btn btn-primary" id="btnSend">저장하기</button>
		</div>

	</form>
</body>

<script>

$(()=>{					//goSend() 함수호출결과를 전달
	$("#btnSend").click(goSend);//함수 주소만
})

function goSend(){	//자바스크립트로 ajax로 파일 정송시 FormData 함수를 이용해 form에 있는 데이터를 직렬화 한다.
					//document.폼이름
					//jquery는 $("#폼아이디")[0] - 인덱스 생략불가
// 	var frm = document.myform;
<%-- 	frm.action="<%=request.getContextPath()%>/board/save"; --%>
// 	frm.method="post";
// 	frm.submit();

	var frm = new FormData(document.myform);
	console.log(frm);
	for(key of frm.keys()){
		console.log(key); //키 출력
		console.log(frm.get(key)); //값 출력
	}
	let file = frm.get("file1");
	console.log(file.type);
	console.log(file.name);
	
	let url;
	if($("#mode").val()=="insert")
	url = "<%=request.getContextPath()%>/board/save";
	else if($("#mode").val()=="reply")
	url = "<%=request.getContextPath()%>/board/reply_save";	
	else
	url = "<%=request.getContextPath()%>/board/modify_save";	
	
	console.log($("#mode").val(), url);
	if($("#mode").val()=="modify"){
		for(i=1; i<=3; i++){
			//체크 안된경우에만 추가한다.
			if(!document.getElementById("del"+i).checked)
				frm.append("del", "");
			else
				frm.append("del", $("#del"+i).val()	);
				
		}
	}
	
	$.ajax({
		url : url,
		data:frm,
		dataType:"json", //데이터 수신시 json으로
		processData:false,	//fileupload시 꼭 필요
		contentType:false,	//fileupload시 꼭 필요
		enctype:"multipart/form-data", //fileupload시 꼭 필요
		timeout:600000, //전송시간 제한(이 시간 지나면 끊겠다)
		type:"POST"	//fileupload시 꼭 필요, 전송방식 post로
	})
	.done((res)=>{
		alert(res.result);
		location.href="<%=request.getContextPath()%>/board/list";
	})
	.fail((res,status,error)=>{
		console.log(status); //통신상황
		console.log(error); //에러메시지
	}) 
}

function goChange(id)
{
   if(document.getElementById("del"+id).checked){
      document.getElementById("file"+id).style.display="block";
   }
   else{
      document.getElementById("file"+id).style.display="none";
   }
}


</script>
</html>