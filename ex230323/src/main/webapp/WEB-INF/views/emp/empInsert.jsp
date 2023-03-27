<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록</title>
</head>
<body>
 	<!-- jsp파일에선 주석안의 태그도 인식 함 태그 넣으면 오류남 -->
	<!-- ContextPath 1) c태그url 2) el --> <!-- empInsert(EmpVO empVO) EmpVO의 필드명이랑 input의 name이 같아야 됨 -->
	<form action="${pageContext.request.contextPath}/empInsert" method="post"> 
		<div>
			<label>first_name : <input type="text" name="firstName"></label>
		</div>
		<div>
			<label>last_name : <input type="text" name="lastName"></label>
		</div>
		<div>
			<label>email : <input type="email" name="email"></label>
		</div>
		<div>
			<label>job_id : <input type="text" name="jobId"></label>
		</div>
		<div>
			<label>salary : <input type="number" name="salary"></label>
		</div>
		<button type="submit">등록</button>
		<button type="button" onclick="location.href='http://localhost:8081/spring/empList'">목록</button>
	</form>
</body>
</html>