<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체조회</title>
<style>
	table, tr, th, td{
		border : 1px solid black;
	}
</style>
</head>
<body>
	<button type="button" onclick="location.href='empInsert'">등록</button>
	<table>
		<thead>
			<tr>
				<th>employee_id</th>
				<th>first_name</th>
				<th>last_name</th>
				<th>email</th>
				<th>hire_date</th>
				<th>job_id</th>
				<th>salary</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${empList }" var="emp">
				<tr onclick="location.href='empInfo?employeeId=${emp.employeeId}'">
					<td>${emp.employeeId }</td>
					<td>${emp.firstName }</td>
					<td>${emp.lastName }</td>
					<td>${emp.email }</td>
					<td>${emp.hireDate }</td>
					<td>${emp.jobId }</td>
					<td>${emp.salary }</td>
					<td><button button type="button" onclick="deleteInfo(${emp.employeeId},event)">Delete</button></td>
					<!-- href페이지 전환 onclick="location.href='deleteInfo?employeeId=${emp.employeeId}'"으로 삭제도 가능 화면전환이 필요할 때만 사용 -->
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script>
		function printAlert(message){
			if(message == null || message == '') return;
			alert(message);
		}
		
		printAlert(`${result}`); //jsp에서 java를 가장 먼저 컴파일 printAlert(`값`) 이런식으러 ''말고 ``쓰는 이유는 줄바꿈 인식시키려고,'' 생략하면 안 됨
		
		function deleteInfo(id){
			$.ajax({
				url : 'empDelete',
				method : 'post',
				data : {employeeId : id}, //?employeeId=id 로 보냈다고 생각
				//dataType : 'json', //서버(controller)로부터 받을 데이터의 타입지정, jqeury는 이거 생략하면 자동으로 데이터타입 읽어서(html, text, json, xml) parsing 해줌
				success : function(data){
					console.log(data);
				},
				error : function(reject){
					console.log(reject);
				}
				
			})
			event.stopPropagation(); //매개변수로 event를 받아야 됨 이벤트 전파 안되게 하는 함수
		}
	</script>
</body>
</html>