<%@page import="fpt.model.bean.NhanVien"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Trang cá nhân</title>

<%@include file="./Shared/_bootstrap.jsp"%>
</head>
<body class="fixed sidebar-mini sidebar-mini-expand-feature skin-black-light"
	style="height: auto; min-height: 100%;">
	<!-- Site wrapper -->
	<div class="wrapper" style="height: auto; min-height: 100%;">
		<%@include file="./Shared/_main-header.jsp"%>
		<%@include file="./Shared/_main-sidebar.jsp"%>



		<!-- Content Wrapper. Contains page content -->

		<div class="content-wrapper" style="min-height: 252px;">
			<section class="content-header"> <br>
			<h1>
				<i class="fa fa-users"></i> &nbsp;Trang cá nhân
			</h1>
			</section>
			<section class="content">
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">Thông tin cá nhân</h3>
				</div>
							<%
					 	 	NhanVien nv = (NhanVien) request.getAttribute("nhanVien");
							%>
				<div class="box-body box-profile">
					<img class="profile-user-img img-responsive img-circle"
						src="upload/<%=nv.getAnh()%>" alt="Avatar">

					<h3 class="profile-username text-center"><%=nv.getHoTen()%></h3>

					<p class="text-muted text-center"><%=nv.getChucVu()%></p>
					<br>

					<div class="row invoice-info">
						<div class="col-sm-3 invoice-col"></div>
						<!-- /.col -->
						<div class="col-sm-3 invoice-col">
							<address>
								<strong>Họ và Tên </strong><br> <strong>Chức vụ
								</strong><br> <strong>Lương </strong><br> <strong>Địa
									chỉ </strong><br> <strong>Số điện thoại </strong><br> <strong>Tên
									đăng nhập </strong>
							</address>
						</div>
						<!-- /.col -->
						<div class="col-sm-3 invoice-col">
							<address>
							
								<%=nv.getHoTen()%><br><%=nv.getChucVu()%><br><%=new common().fomatTien(nv.getLuong())%><br>
								<%=nv.getDiaChi()%><br><%=nv.getSoDienThoai()%><br>
								<%=nv.getTenDangNhap()%>
							</address>
						</div>
						<!-- /.col -->
						<div class="col-sm-3 invoice-col"></div>
						<!-- /.col -->
					</div>

					<a href="SuaTrangCaNhanServlet" class="btn btn-primary pull-right"><b>Sửa
							Profile</b></a>
				</div>
				<!-- /.box-body -->
			</div>
			</section>
		</div>


		<!-- /.content-wrapper -->




		<%@include file="./Shared/_main-footer.jsp"%>
	</div>

	<%@include file="./Shared/_js.jsp"%>
</body>
</html>