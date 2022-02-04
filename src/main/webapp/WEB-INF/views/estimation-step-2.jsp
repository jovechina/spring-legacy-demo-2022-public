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
	<form:form action="${pageContext.request.contextPath}/estimation-2" modelAttribute="estimation" method="post">
		<div class="container">
			<c:forEach var="roomCategory" items="${ roomCategories }">
				<div class="mt-4 mb-2">
					<div class="row  ps-1 mb-2 title-1">${ roomCategory.categoryName }</div>
					<div class="row">
						<c:forEach var="roomService" items="${ roomCategory.roomServices }" varStatus="roomServiceStatus">

							<div class="col-1  label-1">
								<label>${roomService.serviceName}</label>
							</div>
							<div class="col-3  form-control-1">
								<c:if test="${ roomService.roomProducts.size() eq 1 }">
									<form:checkboxes path="${ roomService.serviceShortName }" items="${roomService.roomProducts}" itemValue="productId" itemLabel="productName" />
								</c:if>
								<c:if test="${ roomService.roomProducts.size()  gt 1 }">
									<form:select path="${ roomService.serviceShortName }" multiple="false">
										<form:options items="${roomService.roomProducts}" itemValue="productId" itemLabel="productName" />
									</form:select>
								</c:if>
							</div>
						</c:forEach>
					</div>
				</div>
			</c:forEach>
			<div class="col d-flex justify-content-end mt-2">
				<button type="submit" class="btn btn-primary col-4">下一步</button>
			</div>
		</div>
	</form:form>


	<!-- footer -->
	<jsp:include page="includes/footer.jsp" />
</body>
</html>

