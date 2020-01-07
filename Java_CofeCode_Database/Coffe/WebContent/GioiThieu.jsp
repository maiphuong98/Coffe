<%@page import="fpt.model.bean.NhanVien"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Gioi Thieu</title>

<%@include file="./Shared/_bootstrap.jsp"%>
</head>
<body class="fixed sidebar-mini sidebar-mini-expand-feature skin-black-light"
	style="height: auto; min-height: 100%;">
	<!-- Site wrapper -->
	<div class="wrapper" style="height: auto; min-height: 100%;">
		<%@include file="./Shared/_main-header.jsp"%>
		<%@include file="./Shared/_main-sidebar.jsp"%>



		<!-- Content Wrapper. Contains page content -->


		<div class="content-wrapper" style="min-height: 1126px;">
			<!-- Content Header (Page header) -->
			<section class="content-header">
			<h1>Giới thiệu</h1>
			</section>

			<div class="pad margin no-print">
				<div class="callout callout-info"
					style="margin-bottom: 0 !important;">
					<h4>
						<i class="fa fa-info"></i> Chú ý:
					</h4>
					Mọi thắc mắt quý khách hàng có thể liên hệ với chũng tôi theo qua
					hotline (+84.1900.100 có), hoặc email: <a
						href="mailto:Group01Support@gmail.com?Subject=Hello%20again"
						target="_top">Group01Support@gmail.com</a> hoặc gặp trực tiếp chúng tôi. Chúng tôi sẽ phản hồi
					sớm nhất có thể.
				</div>
			</div>

			<!-- Main content -->
			<section class="invoice"> <!-- title row -->
			<div class="row">
				<div class="col-xs-12">
					<h2 class="page-header">
						<i class="fa fa-globe"></i> Group01, Inc. <small
							class="pull-right">Ngày: 15/03/2018</small>
					</h2>
				</div>
				<!-- /.col -->
			</div>
			<!-- info row -->
			<div class="row invoice-info">
				<div class="col-sm-6 invoice-col">
					Địa chỉ 1
					<address>
						<strong>Group01, Inc.</strong><br> 356 Điện Biên Phủ - Quận Thanh Khê – TP Đà Nẵng<br>
						Quận Thanh Khê – TP Đà Nẵng<br> Phone: (+84.900.333.333)<br>
						Email: Group01Support@gmail.com
					</address>
				</div>
				<!-- /.col -->
				<div class="col-sm-6 invoice-col">
					Địa chỉ 2
					<address>
						<strong>Group01, Inc.</strong><br> 36 Nguyễn Văn Linh - Quận Hải Hòa – TP Đà Nẵng<br>
						Quận Hải Hòa – TP Đà Nẵng<br> Phone: (+84.900.444.444)<br>
						Email: Group01Support2@gmail.com
					</address>
				</div>
			</div>
			<!-- /.row --> <!-- this row will not appear when printing -->
			<div class="row no-print">
				<div class="col-xs-12">
					<button type="button" class="btn btn-success pull-right">
						<i class="fa fa-fw fa-headphones"></i> Liên hệ
					</button>
				</div>
			</div>
			</section>
			<!-- /.content -->
			<div class="clearfix"></div>
		</div>
		<!-- /.content -->
	</div>

	<!-- /.content-wrapper -->
	<%@include file="./Shared/_main-footer.jsp"%>
	</div>

	<%@include file="./Shared/_js.jsp"%>
</body>
</html>