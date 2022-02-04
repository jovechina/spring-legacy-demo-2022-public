<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<html>
<!-- header -->
<jsp:include page="includes/header.jsp" />
<body>

	<!-- menu -->
	<jsp:include page="includes/navbar.jsp" />

	<!-- body -->
	<form:form action="${pageContext.request.contextPath}/estimation-action" method="post">
		<div class="container">
			<table class="table table-bordered table-hover">
				<thead class="table-info">
					<tr>
						<th scope="col">#</th>
						<th scope="col">估算ID</th>
						<th scope="col">客户</th>
						<th scope="col">房型</th>
						<th scope="col">当前装修状况</th>
						<th scope="col">电路</th>
						<th scope="col">网络</th>
						<th scope="col">创建日期</th>
						<th scope="col">更新日期</th>
						<th scope="col">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="est" items="${estLists}" varStatus="estStatus">
						<tr>
							<th scope="row">${ estStatus.count }</th>
							<td>${ est.estimationId }</td>
							<td>${ est.userName }</td>
							<td>${ est.roomType }</td>
							<td>${ est.interiorDecoration }</td>
							<td>${ est.wires }</td>
							<td>${ est.cable }</td>
							<td><fmt:formatDate value="${est.createDate}" pattern="yyyy-MM-dd" /></td>
							<td><fmt:formatDate value="${est.updateDate}" pattern="yyyy-MM-dd" /></td>
							<td>
								<a href="${pageContext.request.contextPath}/estimation/detail/${ est.estimationId }" class="link-dark">详细</a> 
								<a href="${pageContext.request.contextPath}/estimation/edit/${ est.estimationId }" class="link-primary">编辑</a> 
								<a href="${pageContext.request.contextPath}/estimation/del/${ est.estimationId }" class="link-danger">删除</a> 
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</form:form>


	<!-- footer -->
	<jsp:include page="includes/footer.jsp" />
</body>
</html>

