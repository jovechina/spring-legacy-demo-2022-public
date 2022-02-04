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
	<form action="${pageContext.request.contextPath}/login" method="post">
	<div class="container">
		<div class="col d-flex justify-content-center">
			<div class="card col-6 " >
				<div class="card-header">登录画面</div>
				<div class="card-body text-primary">
					<div class="mb-3">
						<label for="userName" class="form-label">用户名:</label>
						<input type="text" class="form-control" name="userName" id="userName">
					</div>
					<div class="mb-3">
						<label for="password" class="form-label">密码:</label>
						<input type="password" class="form-control" name="password" id="password">
					</div>
					<div class="col d-flex justify-content-center">
						<button type="submit" class="btn btn-primary col-4">登录</button>
					</div>					
				</div>
			</div>
		</div>
	</div>
	</form>


	<!-- footer -->
	<jsp:include page="includes/footer.jsp" />
</body>
</html>

