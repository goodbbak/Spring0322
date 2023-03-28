<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="updateForm" action="boardUpdate" method="POST" onsubmit="return false" >
		<div>
			<h3>${boardInfo.bno}번 게시글 상세보기</h3>
		</div>
		<table>
			<tr>
				<th>번호</th>
				<td><input type="number" name="bno" value="${boardInfo.bno}" readonly></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="${boardInfo.title}"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" value="${boardInfo.writer}"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="contents">${boardInfo.contents}</textarea></td>
			</tr>
			<tr>
				<th>첨부이미지</th>
				<td><input type="text" name="image" value="${boardInfo.image}"></td>
			</tr>
		</table>
		<button onclick="location.href='boardUpdate?bno=${boardInfo.bno}'">수정</button>
		<button onclick="location.href='boardDelete?bno=${boardInfo.bno}'">삭제</button>
	</form>
	<script>
		
	</script>
</body>
</html>