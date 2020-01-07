<%@page import="fpt.common.common"%>
<%@page import="fpt.model.bean.NhanVien"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Sửa Trang Cá Nhân</title>

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
				<i class="fa fa-users"></i> &nbsp;Sửa trang cá nhân
			</h1>
			</section>
			<section class="content">
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">Sửa thông tin cá nhân</h3>
				</div>
				<div class="box-body box-profile form-horizontal">
					<%
					  NhanVien nv = (NhanVien) request.getAttribute("nhanVien");
					%>
					<img class="profile-user-img img-responsive img-circle"
						src="upload/<%=nv.getAnh()%>" alt="Avatar">
					<h3 class="profile-username text-center"><%=nv.getHoTen()%></h3>

					<p class="text-muted text-center"><%=nv.getChucVu()%></p>
					<br>
					<form method="post" action="UploadServlet"
						enctype="multipart/form-data">
						<div class="form-group">
							<div class="col-sm-3"></div>
							<label for="inputName" class="col-sm-2 control-label">Avatar</label>
							<div class="col-sm-2">
								<input type="file" name="uploadFile" id="uploadFile" />
							</div>
							<div class="col-sm-2">
								<input type="submit" value="Thay đổi" />
							</div>
							<div class="col-sm-3"></div>
						</div>
					</form>
					<hr>
					<div class="tab-pane active" id="settings">
						<form action="SuaTrangCaNhanServlet" method="post"
							class="form-horizontal">
							<div class="form-group">
								<label for="inputName" class="col-sm-4 control-label">Mã
									Nhân viên</label>

								<div class="col-sm-4">
									<input type="text" class="form-control" id="txtMaNhanVien"
										name="txtMaNhanVien" placeholder="Mã nhân viên"
										value="<%=nv == null ? "" : nv.getMaNV()%>"
										readonly="readonly" required>
								</div>
							</div>
							<div class="form-group">
								<label for="inputName" class="col-sm-4 control-label">Họ
									và Tên</label>

								<div class="col-sm-4">
									<input type="text" class="form-control" id="txtTenNhanVien"
										name="txtTenNhanVien"
										value="<%=nv == null ? "" : nv.getHoTen()%>" placeholder="Tên"
										required>
								</div>
							</div>
							<%
					
						if(common.QUAN_TRI_VIEN.equals(nv.getChucVu())){
					
					%>
							<div class="form-group">
								<label for="inputEmail" class="col-sm-4 control-label">Chức
									vụ</label>

								<div class="col-sm-4">
									<select class="form-control" id="txtChucVu" name="txtChucVu"
										value="<%=nv == null ? "" : nv.getChucVu()%>">
										<option>Nhân viên</option>
										<option>Quản trị viên</option>
									</select>
								</div>
							</div>
							<%} %>
							<div class="form-group">
								<label for="inputName" class="col-sm-4 control-label">Lương</label>

								<div class="col-sm-4">
									<input type="number" class="form-control" id="txtLuong"
										name="txtLuong" value="<%=nv == null ? "" : nv.getLuong()%>"
										placeholder="Lương " readonly="readonly" required>
								</div>
							</div>
							<div class="form-group">
								<label for="inputExperience" class="col-sm-4 control-label">Địa
									chỉ</label>

								<div class="col-sm-4">
									<input type="text" class="form-control" id="txtDiaChi"
										name="txtDiaChi" value="<%=nv == null ? "" : nv.getDiaChi()%>"
										placeholder="Địa chỉ" required></input>
								</div>
							</div>
							<div class="form-group">
								<label for="inputSkills" class="col-sm-4 control-label">Số
									điện thoại</label>

								<div class="col-sm-4">
									<input type="text" class="form-control" id="txtSoDienThaoi"
										name="txtSoDienThaoi"
										value="<%=(nv == null ? "" : nv.getSoDienThoai())%>"
										placeholder="Số điện thoại" required>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-4 col-sm-4">
									<input type="submit" class="btn btn-primary" name="btnSua"
										value="Lưu thay đổi"> <a href="TrangCaNhanServlet"
										class="btn btn-primary"><b>Đóng</b></a>
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