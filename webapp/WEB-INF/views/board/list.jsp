<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css">

</head>


<body>
	<div id="wrap">

		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		<!-- //header -->

		<div id="container" class="clearfix">
		
			<c:import url="/WEB-INF/views/include/aside_board.jsp"></c:import>
			<!-- //aside -->

			<div id="content">

				<div id="content-head">
					<h3>게시판</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>게시판</li>
							<li class="last">일반게시판</li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<!-- //content-head -->
	
				<div id="board">
					<div id="list">
						<form action="" method="get">
							<div class="form-group text-right">
								<input type="text">
								<button type="submit" id=btn_search>검색</button>
							</div>
						</form>
						
						<table >
							<thead>
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>글쓴이</th>
									<th>조회수</th>
									<th>작성일</th>
									<th>관리</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${pMap.bList}" var="vo">
									<tr>
										<td>${vo.no}</td>
										<td class="text-left"><a href="${pageContext.request.contextPath}/board/read?no=${vo.no}">${vo.title}</a></td>
										<td>${vo.userName}</td>
										<td>${vo.hit}</td>
										<td>${vo.regDate}</td>
										<c:if test="${authUser.no eq vo.userNo}">
											<td><a href="${pageContext.request.contextPath}/board/delete?no=${vo.no}">[삭제]</a></td>
										</c:if>
									</tr>
								</c:forEach>
							</tbody>
						</table>
			
						<div id="paging">
							<ul>
								<c:if test="${pMap.prev eq true}">
									<li><a href="${pageContext.request.contextPath}/board/list?crtPage=${pMap.startBtnNo-1}">◀</a></li>
								</c:if>
								
								<!-- 현재페이지 볼드처리 -->
								<c:forEach begin="${pMap.startBtnNo}" end="${pMap.endBtnNo}" step="1" var="page">
									<li class= ${pMap.crtPageNo eq page ? "active" : ""}>
										<a href="${pageContext.request.contextPath}/board/list?crtPage=${page}">${page}</a>
									</li>
								</c:forEach>
								
								<c:if test="${pMap.next==true}">
									<li><a href="${pageContext.request.contextPath}/board/list?crtPage=${pMap.endBtnNo+1}">▶</a></li>
								</c:if>
							</ul>
							
							
							<div class="clear"></div>
						</div>
						<c:if test="${authUser ne null}">
							<a id="btn_write" href="${pageContext.request.contextPath}/board/writeForm">글쓰기</a>
						</c:if>
					</div>
					<!-- //list -->
				</div>
				<!-- //board -->
			</div>
			<!-- //content  -->

		</div>
		<!-- //container  -->
		

		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		<!-- //footer -->
	</div>
	<!-- //wrap -->

</body>

</html>
