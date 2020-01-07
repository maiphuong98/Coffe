<%@page import="fpt.model.bean.ThietBi"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Trang chủ - CAFE</title>

<%@include file="./Shared/_bootstrap.jsp"%>
</head>
<body class="fixed sidebar-mini sidebar-mini-expand-feature skin-black-light"
	style="height: auto; min-height: 100%;">
	<!-- Site wrapper -->
	<div class="wrapper" style="height: auto; min-height: 100%;">
		<%@include file="./Shared/_main-header.jsp"%>
		<%@include file="./Shared/_main-sidebar.jsp"%>



		<!-- Content Wrapper. Contains page content -->


		<div class="content-wrapper" style="min-height: 621px;">
			<!-- Content Header (Page header) -->
			<section class="content-header">
			<div class="box box-info">
				<div class="box-header with-border">
					<h3 class="box-title">Chỉnh sửa thiết bị</h3>
				</div>
				<!-- /.box-header -->
				<!-- form start -->
				<form action="ChinhSuaThietBiServlet" method="post">
					<div class="box-body">
						<div class="row">
							<%
								ThietBi thietbi = (ThietBi)request.getAttribute("thietbi");
							%>
							<!-- /.col-lg-6 -->
							<div class="col-lg-6">
								<div class="form-group">
									<label for="inputPassword3" class="col-sm-3 control-label">Mã Thiết Bị</label>

									<div class="col-sm-6">
										<input type="text" class="form-control" name="maThietBi" id="input"
											value="<%=thietbi.getMaThietBi() %>" placeholder="" readonly="readonly">
									</div>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="form-group">
									<label for="inputPassword3" class="col-sm-3 control-label">Tên
										thiết bị</label>

									<div class="col-sm-6">
										<input type="text" class="form-control" name="tenThietBi" id="input"
											value="<%=thietbi.getTenThietBi() %>" placeholder="">
									</div>
								</div>
							</div>
							<!-- /.col-lg-6 -->
							<div class="col-lg-6">
								<div class="form-group">
									<label for="inputPassword3" class="col-sm-3 control-label">Số
										lựơng</label>

									<div class="col-sm-6">
										<input type="text" class="form-control" name="soLuong" id="input"
											value="<%=thietbi.getSoLuong() %>"placeholder="">
									</div>
								</div>
							</div>
						</div>
						<div class="row">

							<div class="col-lg-6"></div>
						</div>
						<div class="row">

							<div class="col-lg-6">
								<div class="form-group">
									<label for="inputPassword3" class="col-sm-3 control-label">Ngày
										nhập</label>

									<div class="col-sm-6">
										<div class="input-group date">
											<div class="input-group-addon">
												<i class="fa fa-calendar"></i>
											</div>
											<input type="date" class="form-control pull-right" name="ngayNhap"
												value="<%=thietbi.getNgayMua() %>" id="datepicker">
										</div>
									</div>
								</div>
							</div>

							<!-- /.col-lg-6 -->

							<div class="col-lg-6">
								<div class="form-group">
									<label for="inputPassword3" class="col-sm-3 control-label">Đơn
										giá</label>

									<div class="col-sm-6">
										<input type="text" class="form-control" id="inputgia" name="donGia"
											value="<%=thietbi.getDonGia() %>" placeholder="">
									</div>
								</div>
							</div>
						</div>



						<!-- /.col-lg-6 -->

					</div>
			</div>
			<!-- /.box-body -->
			<div class="box-footer" align="center">
				<button type="submit" name="sua" value="sua" class="btn btn-default">Sửa</button>
				<button type="reset" class="btn btn-info">Hủy</button>
			</div>
			<!-- /.box-footer -->
			</form>
		</div>

		</section>

		<!-- Main content -->
		<section class="content"> </section>
		<!-- /.content -->
	</div>


	<!-- /.content-wrapper -->




	<%@include file="./Shared/_main-footer.jsp"%>
	</div>

	<%@include file="./Shared/_js.jsp"%>
</body>
</html>