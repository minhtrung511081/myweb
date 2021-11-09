<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container px-5">
		<a class="navbar-brand" href="index.html">Minh Trung</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link" href="index.html">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="about.html">About</a></li>
				<li class="nav-item"><a class="nav-link" href="contact.html">Contact</a></li>
				<li class="nav-item"><a class="nav-link" href="pricing.html">Pricing</a></li>
				<li class="nav-item"><a class="nav-link" href="faq.html">FAQ</a></li>
				<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" id="navbarDropdownBlog" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">QUẢN LÝ</a>
					<ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdownBlog">
					<c:if test="${not empty account}">
						<li>Hello , ${account.fullname}</li>
						<li><a class="dropdown-item" href='<c:url value="/dang-nhap?action=logout"/>'>Thoát</a></li>
					</c:if>
					
					<c:if test="${empty account}">
						<li><a class="dropdown-item" href='<c:url value="/dang-nhap?action=login"/>'>Đăng nhập</a></li>
					</c:if>
					
						
					</ul>
					
				</li>
				
			</ul>
		</div>
	</div>
</nav>