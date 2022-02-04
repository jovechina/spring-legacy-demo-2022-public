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
	<form:form action="${pageContext.request.contextPath}/estimation-search" method="get">
		<div class="container">
			<div class="card">
				<div class="card-body">
					<div class="col d-flex justify-content-center">
						<h5 class="card-title">申请编号:(${ estimationId })的预算申请
						<c:if test="${pageType eq 'NEW' }" >
						提交
						</c:if>	
						<c:if test="${pageType eq 'EDIT'}" >
						更新
						</c:if>
						成功。</h5>
					</div>
					<div class=" d-flex justify-content-center">
						<p class="card-text">预估预算总价 - 报价逻辑---开发中...</p>
					</div>
				</div>
			</div>
			<div class="col d-flex justify-content-center">
				<button type="submit" class="btn btn-primary btn-sm col-4" name="action" value="next">返回</button>
			</div>
		</div>
	</form:form>


	<!-- footer -->
	<jsp:include page="includes/footer.jsp" />
</body>
</html>

