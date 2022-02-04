<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<!-- header -->
<jsp:include page="includes/header.jsp" />
<body>

	<!-- menu -->
	<jsp:include page="includes/navbar.jsp" />

	<!-- body -->
	<form:form action="${pageContext.request.contextPath}/estimation-1" modelAttribute="estimation" method="post">
		<div class="container">
			<div class="mt-4">请输入住房的基本信息：</div>
			<div class="input-group mt-2">
				<span class="input-group-text col-2">房型:</span>

				<form:select class="form-select" path="roomId" multiple="false">
					<option>请选择房型</option>
					<form:options items="${roomTypes}" itemValue="roomId" itemLabel="roomType" />
				</form:select>
			</div>

			<div class="input-group mt-2">
				<span class="input-group-text col-2">装修状况:</span>


				<c:forEach var="item" items="${codeMasters}" varStatus="loop">
					<c:choose>
						<c:when test="${loop.first}">
							<div class="col-2">
								<div class="form-control border-end-0 rounded-0">
									<form:radiobutton class="form-check-input" path="interiorDecoration" value="${item.key }" />
									<label class="form-check-label" for="blank"> ${item.value}</label>
								</div>
							</div>
						</c:when>
						<c:when test="${loop.last}">
							<div class="form-control border-start-0 rounded-right">
								<form:radiobutton class="form-check-input" path="interiorDecoration" value="${item.key }" />
								<label class="form-check-label" for="blank"> ${item.value} </label>
							</div>
						</c:when>
						<c:otherwise>
							<div class="col-2">
								<div class="form-control border-start-0 border-end-0 rounded-0">
									<form:radiobutton class="form-check-input" path="interiorDecoration" value="${item.key }" />
									<label class="form-check-label" for="blank"> ${item.value} </label>
								</div>
							</div>
						</c:otherwise>
					</c:choose>
				</c:forEach>

			</div>
			<div class="row d-flex mt-2">
				<div class="col d-flex justify-content-start">
					<button type="submit" class="btn btn-primary col-4" name="action" value="prev">上一步</button>
				</div>
				<div class="col d-flex justify-content-end">
					<button type="submit" class="btn btn-primary col-4" name="action" value="next">下一步</button>
				</div>
			</div>
		</div>
	</form:form>


	<!-- footer -->
	<jsp:include page="includes/footer.jsp" />
</body>
</html>

