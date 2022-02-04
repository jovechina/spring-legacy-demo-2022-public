<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<!-- header -->
<jsp:include page="includes/header.jsp" />
<body>

	<!-- menu -->
	<jsp:include page="includes/navbar.jsp" />

	<!-- body -->
	<form action="${pageContext.request.contextPath}/estimation-1" method="post">
		<div class="container">
			<div class="mt-4">请输入住房的基本信息：</div>
			<div class="input-group mt-2">
				<span class="input-group-text col-2">房型:</span> <select class="form-select" name="roomType">
					<option selected>请选择房型</option>
					<c:forEach var="item" items="${roomTypes}">
						<option value="${item.roomId}">${item.roomType}</option>
					</c:forEach>
				</select>
			</div>

			<div class="input-group mt-2">
				<span class="input-group-text col-2">装修状况:</span>
				<c:forEach var="item" items="${codeMasters}" varStatus="loop">
					<c:choose>
						<c:when test="${loop.first}">
							<div class="col-2">
								<div class="form-control border-end-0 rounded-0">
									<input class="form-check-input" type="radio" name="interiorDecoration" id="item.key" value="0"> <label class="form-check-label" for="blank"> ${item.value} </label>
								</div>
							</div>
						</c:when>
						<c:when test="${loop.last}">
							<div class="form-control border-start-0 rounded-right">
								<input class="form-check-input" type="radio" name="interiorDecoration" id="item.key" value="0"> <label class="form-check-label" for="blank"> ${item.value} </label>
							</div>
						</c:when>
						<c:otherwise>
							<div class="col-2">
								<div class="form-control border-start-0 border-end-0 rounded-0">
									<input class="form-check-input" type="radio" name="interiorDecoration" id="item.key" value="0"> <label class="form-check-label" for="blank"> ${item.value} </label>
								</div>
							</div>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</div>				
				<div class="col d-flex justify-content-end mt-2">
					<button type="submit" class="btn btn-primary col-4">下一步</button>
				</div>

		</div>
	</form>


	<!-- footer -->
	<jsp:include page="includes/footer.jsp" />
</body>
</html>

