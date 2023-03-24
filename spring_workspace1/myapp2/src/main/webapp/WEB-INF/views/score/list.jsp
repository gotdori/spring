<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.kosa.mycompany.score.*"%>
<%@ page import="com.kosa.mycompany.common.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>

	<%
		List<ScoreDto> list = (List<ScoreDto>) request.getAttribute("list");
	%>

		<table class="table">
			<colgroup>
				<col width="8%">
				<col width="*">
				<col width="12%">
				<col width="12%">
				<col width="8%">
			</colgroup>
			<thead class="table-dark">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (int i = 0; i < list.size(); i++) {
					ScoreDto dto = list.get(i);
				%>
				<tr>
					<td><%=dto.getName()%></td>
					<td><%=dto.getKor()%></td>
					<td><%=dto.getMat()%></td>
					<td><%=dto.getEng()%></td>
					<td><%=dto.getWdate()%></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
	<div class="container" style="text-align: right">
	</div>

	<div class="container" style="text-align: right">
		<button type="button" class="btn btn-primary">글쓰기</button>
	</div>

</form>
</body>
<script>
</script>
</html>