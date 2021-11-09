<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title><dec:title default="Trang chủ" /></title>

<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="<c:url value='/template/web/css/styles.css' />" rel="stylesheet" />
</head>

<body class="d-flex flex-column h-100">
	<main class="flex-shrink-0">

		<!-- Navigation-->
		<%@include file="/common/web/navigation.jsp"%>

	
		<!-- Header-->
		<%@include file="/common/web/header.jsp"%>
		
		<!-- Features section-->

		<dec:body />

	</main>


	<!-- Footer-->
	<%@include file="/common/web/footer.jsp"%>

	<!-- Bootstrap core JS-->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="<c:url value='/template/web/js/scripts.js' />"></script>
</body>
</html>