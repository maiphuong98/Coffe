<%@page import="fpt.model.bean.NhanVien"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Thêm nhân viên</title>

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
				<i class="fa fa-fw fa-user-plus"></i> &nbsp;Thêm nhân viên
			</h1>
			</section>
			<section class="content">
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">Thêm nhân viên</h3>
				</div>
				<div class="box-body box-profile">

					<div class="tab-pane active" id="settings">
						<form action="ThemNhanVienServlet" method="post"
							class="form-horizontal">
							<div class="form-group">
								<label for="inputName" class="col-sm-4 control-label">Mã
									nhân viên</label>

								<div class="col-sm-4">
									<input type="text" class="form-control" id="txtMaNhanVien"
										name="txtMaNhanVien" placeholder="Mã nhân viên" required>
								</div>
							</div>
							<div class="form-group">
								<label for="inputName" class="col-sm-4 control-label">Họ
									và Tên</label>

								<div class="col-sm-4">
									<input type="text" class="form-control" id="txtTenNhanVien"
										name="txtTenNhanVien" placeholder="Tên" required>
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail" class="col-sm-4 control-label">Chức
									vụ</label>

								<div class="col-sm-4">
									<select class="form-control" id="txtChucVu" name="txtChucVu">
										<option>Nhân viên</option>
										<option>Quản trị viên</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="inputName" class="col-sm-4 control-label">Lương</label>

								<div class="col-sm-4">
									<input type="number" class="form-control" id="txtLuong"
										name="txtLuong" placeholder="Lương " required>
								</div>
							</div>
							<div class="form-group">
								<label for="inputExperience" class="col-sm-4 control-label">Địa
									chỉ</label>

								<div class="col-sm-4">
									<input type="text" class="form-control" id="txtDiaChi"
										name="txtDiaChi" placeholder="Địa chỉ" required></input>
								</div>
							</div>
							<div class="form-group">
								<label for="inputSkills" class="col-sm-4 control-label">Số
									điện thoại</label>

								<div class="col-sm-4">
									<input type="text" class="form-control" id="txtSdt"
										name="txtSdt" placeholder="Số điện thoại" required>
								</div>
							</div>
							<div class="form-group">
								<label for="inputSkills" class="col-sm-4 control-label">Tên
									đăng nhập</label>

								<div class="col-sm-4">
									<input type="text" class="form-control" id="txtTenDangNhap"
										name="txtTenDangNhap" placeholder="Tên đăng nhập" required>
								</div>
							</div>
							<div class="form-group">
								<label for="inputSkills" class="col-sm-4 control-label">Mật
									khẩu</label>

								<div class="col-sm-4">
									<input type="password" class="form-control" id="txtMatKhau"
										name="txtMatKhau" placeholder="Mật khẩu" required>
								</div>
							</div>
							<div class="form-group ">
							<label for="inputSkills" class="col-sm-4 control-label"></label>
							<div class="col-sm-4">

								<input type="file" id="txtAnh" name="txtAnh">
							</div>
							<label for="inputSkills" class="col-sm-4 control-label"></label>
						</div>
							<div class="form-group">
								<div class="col-sm-offset-4 col-sm-4">
									<button type="submit" name="btnThem" class="btn btn-primary">Thêm</button>
									<a href="NhanVienServlet" class="btn btn-primary"><b>Đóng</b></a>
								</div>

							</div>
						</form>
					</div>
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