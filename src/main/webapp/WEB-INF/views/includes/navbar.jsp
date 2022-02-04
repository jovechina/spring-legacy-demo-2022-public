<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="container">
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#"> <img src="https://getbootstrap.com/docs/5.1/assets/brand/bootstrap-logo.svg" width="30" height="30" alt=""> 精品住宅设计
		</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active" aria-current="page" href="#">估算报价</a></li>
				<li class="nav-item"><a class="nav-link" href="#">历史报价</a></li>
				<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false"> 后台管理 </a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item" href="#">主服务类别</a></li>
						<li><a class="dropdown-item" href="#">服務项目</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="#">商品类型</a></li>
						<li><a class="dropdown-item" href="#">商品品牌</a></li>
					</ul></li>
			</ul>

			<div class="d-flex align-items-center">
				<c:if test="${not empty user }">
					<span>${ user.userName } </span>
				</c:if>

			</div>

			<div class="d-flex nav-item ">

				<a class="nav-link">退出系统</a>
			</div>
			<!--  
      <form class="d-flex">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
  -->
		</div>
	</nav>
</div>

