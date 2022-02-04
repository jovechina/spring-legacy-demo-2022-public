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
					请输入住房的基本信息：
				</div>
				<div class="input-group">
					<span class="input-group-text col-2">房型:</span> 
					<select class="form-select" name="roomType" >
						<option selected>请选择房型</option>
						<option value="1">一室户</option>
						<option value="2">一室一厅</option>
						<option value="3">二室一厅</option>
					</select>
				</div>
				
				<div class="input-group">

					<span class="input-group-text col-2">装修状况:</span>

					<div class="col-2">
					<div class="form-control border-end-0">
						<input class="form-check-input" type="radio" name="interiorDecoration" id="blank" value="0">
						<label class="form-check-label" for="blank">
						    毛坯
						</label>
					</div>
					</div>
					<div class="form-control border-start-0">
						<input class="form-check-input" type="radio" name="interiorDecoration" id="renovated" value="1">					
						<label class="form-check-label" for="renovated">
						    已装修
						</label>	
					</div>			
				</div>				

			<div class="col d-flex justify-content-end mt-2">
				<button type="submit" class="btn btn-primary col-4">下一步</button>
			</div>
		</div>
		</div>
	</form>


	<!-- footer -->
	<jsp:include page="includes/footer.jsp" />
</body>
</html>

