<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/guestbook.css" rel="stylesheet" type="text/css">


<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-1.12.4.js"></script>


</head>

<body>
	<div id="wrap">

		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		<!-- //header -->
	
		<div id="container" class="clearfix">
			<c:import url="/WEB-INF/views/include/aside_guestbook.jsp"></c:import>
			<!-- //aside -->

			<div id="content">
				
				<div id="content-head" class="clearfix">
					<h3>일반방명록</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>방명록</li>
							<li class="last">일반방명록</li>
						</ul>
					</div>
				</div>
				<!-- //content-head -->

				<div id="guestbook">
				
					<!--  <form action="${pageContext.request.contextPath}/api/guest/" method="get"> -->
					
						<table id="guestAdd">
							<colgroup>
								<col style="width: 70px;">
								<col>
								<col style="width: 70px;">
								<col>
							</colgroup>
							<tbody>
								<tr>
									<th><label class="form-text" for="input-uname">이름</label></th>
									<td><input id="input-uname" type="text" name="name"></td>
									<th><label class="form-text" for="input-pass">패스워드</label></th>
									<td><input id="input-pass"type="password" name="password"></td>
								</tr>
								<tr>
									<td colspan="4"><textarea name="content" cols="72" rows="5"></textarea></td>
								</tr>
								<tr class="button-area">
									<td colspan="4" class="text-center"><button id="add" type="submit">등록</button></td>
								</tr>
							</tbody>
							
						</table>
						<!-- //guestWrite -->
						
					<!--  </form>	-->
					
					<div id="listArea">
						<!-- list 출력되는곳 -->
					</div>
					<!-- //guestRead -->
					
				</div>
				<!-- //guestbook -->
			
			</div>
			<!-- //content  -->
		</div>
		<!-- //container  -->

		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		<!-- //footer -->
	</div>
	<!-- //wrap -->

</body>

<script>
	// 로딩되기 전에 요청
	$(document).ready(function() {
		// 리스트 출력
		fetchList();
	});	
	
	// '등록'버튼 클릭될때
	$("#add").on("click", function() {
		console.log("add button click");
		
		// 데이터 수집
		var name= $("#input-uname").val();
		var password= $("#input-pass").val();
		var content= $("[name='content']").val();
		
		// 객체 만들기
		var guestbookVo= {
				name: name,
				password: password,
				content: content
		};
		
		console.log(guestbookVo);
		
		$.ajax({
			
			url : "${pageContext.request.contextPath}/api/guest/add",		
			type : "post",
			// contentType : "application/json",
			data : guestbookVo,

			// dataType : "json",
			success : function(guestbookVo){
				/*성공시 처리해야될 코드 작성*/
				console.log(guestbookVo);
				
				for(var i= 0; i<gList.length; i++) {
					render(gList[i]); // 방명록리스트 그리기
				}
				
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
	});
	

	// 리스트 출력
	function fetchList() {

		$.ajax({
			
			url : "${pageContext.request.contextPath}/api/guest/list",		
			type : "post",
			// contentType : "application/json",
			// data : {name: "홍길동"},

			dataType : "json",
			success : function(gList){
				/*성공시 처리해야될 코드 작성*/
				console.log(gList);
				
				for(var i= 0; i<gList.length; i++) {
					render(gList[i]); // 방명록리스트 그리기
				}
				
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
	};

	// 리스트 그리기
	function render(vo) {
		
		var str= '';
		str += ' <table class="guestRead"> ';
		str += ' 	<colgroup> ';
		str += ' 		<col style="width: 10%;"> ';
		str += ' 		<col style="width: 40%;"> ';
		str += ' 		<col style="width: 40%;"> ';
		str += ' 		<col style="width: 10%;"> ';
		str += ' 	</colgroup> ';
		str += ' 	<tr> ';
		str += ' 		<td>'+vo.no+'</td> ';
		str += ' 		<td>'+vo.name+'</td> ';
		str += ' 		<td>'+vo.regDate+'</td> ';
		str += ' 		<td><a href="">[삭제]</a></td> ';
		str += ' 	</tr> ';
		str += ' 	<tr> ';
		str += ' 		<td colspan=4 class="text-left">'+vo.content+'</td> ';
		str += ' 	</tr> ';
		str += ' </table> ';
		
		$("#listArea").append(str);
	};
	
</script>






</html>