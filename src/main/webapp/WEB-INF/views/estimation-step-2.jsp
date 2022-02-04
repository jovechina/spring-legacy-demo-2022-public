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
			<form:hidden path="roomId" />
			<form:hidden path="interiorDecoration" />
			<input id="pageStatus" name="pageStatus" type="hidden" value="${ pageStatus }">

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
									<form:checkboxes path="${ roomService.serviceShortName }" items="${roomService.roomProducts}" itemValue="productId" itemLabel="productName" disabled="${ pageStatus }" />
								</c:if>
								<c:if test="${ roomService.roomProducts.size()  gt 1 }">
									<form:select path="${ roomService.serviceShortName }" multiple="false" disabled="${ pageStatus }">
										<form:options items="${roomService.roomProducts}" itemValue="productId" itemLabel="productName" />
									</form:select>
								</c:if>
							</div>
						</c:forEach>
					</div>
				</div>
			</c:forEach>
			<div class="row d-flex mt-2">
				<c:if test="${ pageStatus eq 'false' }">
					<div class="col d-flex justify-content-start">
						<button type="submit" class="btn btn-primary col-4" name="action" value="prev">上一步</button>
					</div>
					<div class="col d-flex justify-content-end">
						<button type="submit" class="btn btn-primary col-4" name="action" value="next">下一步</button>
					</div>
				</c:if>
				<c:if test="${ pageStatus eq 'true' }">
					<c:choose>
						<c:when test="${pageType eq 'DETAIL'}">
							<div class="col d-flex justify-content-center">
								<a class="btn btn-primary col-4" href="${pageContext.request.contextPath}/estimation-search" role="button">返回</a>
							</div>
						</c:when>
						<c:when test="${pageType eq 'EDIT'}">
							<div class="col d-flex justify-content-start">
								<button type="submit" class="btn btn-primary col-4" name="action" value="prev">上一步</button>
							</div>
							<div class="col d-flex justify-content-end">
								<button type="submit" class="btn btn-primary col-4" name="action" value="update">更新</button>
							</div>
						</c:when>
						<c:otherwise>
							<div class="col d-flex justify-content-start">
								<button type="submit" class="btn btn-primary col-4" name="action" value="prev">上一步</button>
							</div>
							<div class="col d-flex justify-content-end">
								<button type="submit" class="btn btn-primary col-4" name="action" value="save">保存</button>
							</div>
						</c:otherwise>
					</c:choose>
				</c:if>
			</div>
		</div>
	</form:form>


	<!-- footer -->
	<jsp:include page="includes/footer.jsp" />
</body>
</html>

