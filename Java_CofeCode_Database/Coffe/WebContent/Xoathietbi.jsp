<%@page import="fpt.model.bean.ThietBi"%>
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
	</div>

	<!-- Content Wrapper. Contains page content -->


	<div class="content-wrapper" style="min-height: 621px;">

		<body>
			<%
	ThietBi thietbi = (ThietBi)request.getAttribute("thietbi");
%>
			<div class="container">
				<h3>
					Xóa thiết bị:
					<%=thietbi.getTenThietBi() %></h3>
				<br>

				<form action="XoaSinhVienServlet" method="post">
					<div class="row form-group">
						<label class="col-lg-2">Mã thiết bị</label>
						<div class="col-lg-3">
							<input type="text" class=" form-control" name="matb"
								readonly="readonly" value="<%=thietbi.getMaThietBi()%>" />
						</div>
					</div>
					<div class="row form-group">
						<label class="col-lg-2">Tên thiết bị</label>
						<div class="col-lg-3">
							<input type="text" class="form-control" name="ten"
								readonly="readonly" value="<%=thietbi.getTenThietBi()%>" />
						</div>
					</div>
					<div class="row form-group">
						<label class="col-lg-2">SoLuong</label>
						<div class="col-lg-3">
							<input type="text" class="form-control" name="soLuong"
								readonly="readonly" value="<%=thietbi.getSoLuong()%>" />
						</div>
					</div>
					<div class="row form-group">
						<label class="col-lg-2">Ngày mua</label>
						<div class="col-lg-3">
							<input type="text" class="form-control" name="ngaymua"
								readonly="readonly" value="<%=thietbi.getNgayMua()%>" />
						</div>
					</div>
					<div class="row form-group">
						<label class="col-lg-2">Don Gia</label>
						<div class="col-lg-3">
							<input type="text" class="form-control" name="gia"
								readonly="readonly" value="<%=thietbi.getDonGia()%>" />
						</div>
					</div>

				</form>
			</div>
			<div class="row form-group">
				<div class="col-lg-3 col-lg-offset-2">
					<button class="btn btn-primary" type="submit" value="submit"
						name="submit">Xác nhận</button>
					<input class="btn btn-primary" type="button" value="Quay lại"
						onclick="history.go(-1);" />
				</div>
			</div>


			<!-- /.content-wrapper -->

		</body>

		<%@include file="./Shared/_main-footer.jsp"%>
	</div>

	<%@include file="./Shared/_js.jsp"%>
</body>
</html>