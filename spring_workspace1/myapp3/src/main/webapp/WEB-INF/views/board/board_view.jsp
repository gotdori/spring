<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.kosa.myapp3.board.*"%>
<%@ page import="com.kosa.myapp3.common.*"%>
<%@ page import="com.kosa.myapp3.comment.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

</head>
<body>
	<%
		String seq = StringUtil.nullToValue(request.getParameter("seq"), "");
	BoardDto dto = (BoardDto) request.getAttribute("view");
	List<CommentDto> c_list = (List<CommentDto>) request.getAttribute("comment_list");
	%>
	<form name="myform" id="myform">
		<input type="hidden" name="seq" id="seq" value="<%=seq%>">
		<input type="hidden" name="mode" id="mode">
		<input type="hidden" name="userid" id="userid" value="<%=session.getAttribute("user_name")%>">
		<input type="hidden" name="group_id" id="group_id" value="<%=dto.getGroup_id()%>">
		<input type="hidden" name="depth" id="depth" value="<%=dto.getDepth()%>">
		<input type="hidden" name="g_level" id="g_level" value="<%=dto.getG_level()%>">

		<%@include file="../include/nav.jsp"%>




		<div class="container mt-3">
			<h3>Navbar With Dropdown</h3>
			<p>This example adds a dropdown menu in the navbar.</p>
			
		<div class="container" style="text-align: right">
			<button type="button" class="btn btn-primary" id="btnReply">답글</button>
			&nbsp;&nbsp;
			<button type="button" class="btn btn-primary" id="btnModify">수정</button>
			&nbsp;&nbsp;
			<button type="button" class="btn btn-primary" id="btnDelete">삭제</button>
			&nbsp;&nbsp;
			<button type="button" class="btn btn-primary" id="btnList">목록</button>
			&nbsp;&nbsp;
		</div>


			<table class="table">
				<colgroup>
					<col width="30%">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>제목
						</td>
						<td><%=dto.getTitle()%></td>
					</tr>
					<tr>
						<th>작성자
						</td>
						<td><%=dto.getUserid()%></td>
					</tr>
					<tr>
						<th>첨부파일 1
						</td>
						<td><a href="<%=request.getContextPath()%>/down?path=board&filename=<%=dto.getFilename1()%>" class="btn"><%=dto.getFilename1()%></a></td>
					</tr>
					<tr>
						<th>첨부파일 2
						</td>
						<td><a href="<%=request.getContextPath()%>/down?path=board&filename=<%=dto.getFilename2()%>" class="btn"><%=dto.getFilename2()%></a></td>
					</tr>
					<tr>
						<th>첨부파일 3
						</td>
						<td><a href="<%=request.getContextPath()%>/upload/board/<%=dto.getFilename3()%>" class="btn" download><%=dto.getFilename3()%></a></td>
					</tr>
					<tr>
						<th>조회수
						</td>
						<td><%=dto.getHit()%></td>
					</tr>
					<tr>
						<th>내용
						</td style="word-break:break-all">
						<td><%=dto.getContents().replaceAll("\n", "<br>")%></td>
					</tr>
				</tbody>
			</table>
		</div>



		<!-- 댓글 붙이기 -->
		<div class="container mt-3">
			<!-- 댓글 입력창 -->
			<table class="table">
				<tbody>
					<tr>
						<td style="width: 80%">
							<div class="input-group">
								<textarea type="text" class="form-control" rows="4" name="comments" id="comments"></textarea>
							</div>
						</td>
						<td style="width: 20%">
							<button type="button" class="btn btn-primary" id="btnCmtSave">작성</button>
						</td>
					</tr>
				</tbody>
			</table>

			<!-- 댓글 리스트 -->
			<table class="table" id="commentTable">
				<tbody>
					<%
						for (int i = 0; i < c_list.size(); i++) {
						CommentDto ccdto = c_list.get(i); //한개씩 정보 꺼내기
					%>
					<tr id="tr<%=ccdto.getSeq()%>">
						<td><%=ccdto.getUserid()%> : <%=ccdto.getComments()%></td>
						<td><button type="button" class="btn btn-primary" onclick="cmtDelete(<%=ccdto.getSeq()%>)">삭제</button></td>
					</tr><%} %>
				</tbody>
			</table>

		</div>

	</form>
</body>
</html>
<script>
$(()=>{
	$("#btnReply").click(()=>{
		$("#mode").val("reply");
		$("#myform").prop("action","<%=request.getContextPath()%>/board/reply");
		$("#myform").submit();
	})
})

$(()=>{
	$("#btnModify").click(()=>{
	$("#mode").val("modify");
	$("#myform").prop("action", "<%=request.getContextPath()%>/board/modify");
	$("#myform").submit();
	})
})

$(()=>{
	$("#btnDelete").click(()=>{
		
		let param = $("#myform").serialize();
		//직렬화 :  multipart 아닐때
		//FormData :  multipart 일 때
		//seq=4&group_id=3...
		$.ajax({
			url:"<%=request.getContextPath()%>/board/delete",
			data:param,
			dataType:"json"
		})
		.done((res)=>{
			if(res.result=="success"){
				alert("글이 삭제되었습니다.")				
				location.href="<%=request.getContextPath()%>/board/list";
			}else{
				alert("실패하였습니다.")				
			}
		})
		.fail((res, status, error)=>{
			console.log(status);
			console.log(error);
		})
	})
})

$(()=>{
	$("#btnCmtSave").click(()=>{
		//자바스크립트를 라이브러리화 한게 Jquery
		//serialize는 자바스크립트가 아니고 Jquery가 만듬
		//board_seq=12&comment=문장&userid=test
	let param = $("#myform").serialize();
	console.log(param); // 디버깅용
	$.ajax({
		url:"<%=request.getContextPath()%>/board/commentsave",
		data:param,
		dataType:"json",
		method:"POST"
	})
	.done((res)=>{
		alert(res.result);
		location.href="<%=request.getContextPath()%>/board/view?seq=<%=dto.getSeq()%>";
		})
	.fail((res,status,error)=>{
		console.log(status); //통신상황
		console.log(error); //에러메시지
	}) 
	})
})

function cmtDelete(seq){
		console.log(seq);
		$.ajax({
			url:"<%=request.getContextPath()%>/board/commentdelete",
			data:{seq:seq},
			dataType:"json",
			method:"POST"
		})
		.done((res)=>{
			alert(res.result);
			$("#tr"+res.seqq).remove();
		})
		.fail((res, status, error)=>{
			console.log(status); //통신상황
			console.log(error); //에러메시지
		})
}

</script>