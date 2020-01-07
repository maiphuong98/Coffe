<%@page import="fpt.model.bean.NganSach"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Thêm thu chi</title>

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
				<i class="fa fa-fw fa-money"></i> &nbsp;Thêm thu chi
			</h1>
			</section>
			<section class="content">
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">Thêm thu chi</h3>
				</div>
				<div class="box-body box-profile">

					<div class="tab-pane active" id="settings">
						<form action="ThemThuChi" mothod="post" class="form-horizontal">
						<div class="form-group">
								<label for="inputEmail" class="col-sm-4 control-label">Mã thu chi: </label>

								<div class="col-sm-4">
									<input type="text" class="form-control" id="txtMaThuChi" name="txtMaThuChi"
										placeholder="Mã thu chi" required>
								</div>
							</div>
							<div class="form-group">
								<label for="inputName" class="col-sm-4 control-label">Ngày
									thu chi: </label>

								<div class="col-sm-4">
									<div class="input-group date">
										<div class="input-group-addon">
											<i class="fa fa-calendar"></i>
										</div>
										<input type="date" class="form-control pull-right"
											id="txtNgayThuChi" name="txtNgayThuChi" placeholder="Ngày thu chi" required>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail" class="col-sm-4 control-label">Khoản thu chi: </label>

								<div class="col-sm-4">
									<input type="text" class="form-control" id="txtTenThuChi" name="txtTenThuChi"
										placeholder="Khoản thu chi" required>
								</div>
							</div>
							<div class="form-group">
								<label for="inputName" class="col-sm-4 control-label">Số
									tiền: </label>

								<div class="col-sm-4">
									<input type="number" class="form-control" id="txtSoTien" name="txtSoTien"
										placeholder="Số tiền " required>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-4 col-sm-4">
									<button type="submit" name="btnThem" class="btn btn-primary">Thêm</button>
									<a href="NganSachServlet" class="btn btn-primary"><b>Đóng</b></a>
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