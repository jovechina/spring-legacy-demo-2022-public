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
				<div class="mt-4 mb-2">
					估算第二步画面，设计中...
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

