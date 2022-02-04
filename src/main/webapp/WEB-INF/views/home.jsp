<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<!-- header -->
<jsp:include page="includes/header.jsp" />
<body>

	<!-- menu -->
	<jsp:include page="includes/navbar.jsp" />

	<!-- body -->
	<form:form modelAttribute="user" class="form-horizontal" method="post" >
		<div class="container">
			<div class="col d-flex justify-content-center">
				<div class="card col-6 ">
					<div class="card-header">登录画面</div>

					
					<div class="card-body text-primary">
						<div class="mb-3">
							<label for="userName" class="form-label">用户名:</label>
							<form:input type="text" class="form-control input-sm" path="userName" id="userName" />
							<div class="has-error">
								<form:errors path="userName" class="help-inline text-danger" />
							</div>
						</div>
						<div class="mb-3">
							<label for="password" class="form-label">密码:</label>
							<form:input type="password" class="form-control input-sm" path="password" id="password" />
							<div class="has-error">
								<form:errors path="password" class="help-inline text-danger" />
							</div>
						</div>
						<div class="has-error mb-3">
							<form:errors class="help-inline text-danger" />
						</div>						
						<div class="col d-flex justify-content-center">
							<button type="submit" class="btn btn-primary btn-sm col-4" name="action" value="next">登录</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form:form>


	<!-- footer -->
	<jsp:include page="includes/footer.jsp" />
</body>
</html>

