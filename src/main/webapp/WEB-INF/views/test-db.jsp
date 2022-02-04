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
	<div class="container">
		<div class="col d-flex justify-content-center">
			<div class="card col-6 " >
				<div class="card-body text-primary">
					<div class="mb-3">
						<label for="userName" class="form-label">用户名:</label>
						<form:input class="form-control" path="contentResult.name" />
					</div>
				</div>
			</div>
		</div>
	</div>	


	<!-- footer -->
	<jsp:include page="includes/footer.jsp" />
</body>
</html>
