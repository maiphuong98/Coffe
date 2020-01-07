<%@page import="fpt.model.bean.Ban"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản Lý Bán Hàng</title>
<%@include file="./Shared/_bootstrap.jsp"%>
<style type="text/css">
.footer-banhang-right {
	position: fixed;
	left: 51%;
	bottom: 5%;
	background-color: #ffffff;
	width: 49%;
	color: black;
	text-align: right;
	height: 5%;
	padding: 5px;
}

.footer-banhang-left {
	position: fixed;
	right: 51%;
	bottom: 5%;
	background-color: #ffffff;
	width: 49%;
	color: black;
	text-align: right;
	height: 5%;
	padding: 5px;
}

.button-quanly {
	height: 60px;
	width: 90px;
}

.button-quanly-col {
	padding-left: 5px;
	padding-right: 5px;
}

.style-section {
	padding: 0px;
}

.style-col-main {
	padding-left: 5px;
	padding-right: 5px;
}

.btn-ban:HOVER {
	background-color: #e2dede;
}

.btn-ban:ACTIVE {
	background-color: #e2dede;
}

.btn-ban-thucdon {
	margin-top: 5px;
	margin-bottom: 0px;
	padding-bottom: 14px;
	width: 90px;
	border-bottom: 0px;
}

.btn-ban-thucdon-active {
	margin-top: 13px;
	margin-left: 12px;
	border-top-width: 0px;
	margin-top: 8px;
	margin-left: 12px;
	border-bottom-width: 0px;
	border-color: #ffffff;
	background-color: #ffffff;
	padding-bottom: 15px;
	padding-top: 8px;
}
</style>
</head>

<body class="layout-top-nav skin-blue-light"
	style="height: auto; min-height: 100%;" onload="loadTrang()">

	<div class="wrapper" style="height: auto; min-height: 100%;">
		<%@include file="./Shared/_main-header-banhang.jsp"%>
		<div align="center" class="content-wrapper" style="min-height: 621px;">
			<section class="content style-section">
			<div>
				<div class="col-lg-6 col-xs-6 style-col-main">
					<div class="info-box"
						style="padding: 20px; overflow: auto; height: 545px;">
						<!-- <div class="box-header">
							 <h3 class="box-title">Application Buttons</h3>
						</div> -->
						<div class="box-body">
							<div align="center" class="row" id="content-ban-thucdon">
								<%@include file="./BanHang-Action/BanHang-danhSachBan.jsp"%>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="input-group">
							<div class="checkbox">
								<div class="footer-banhang-left">
									<label><input type="checkbox"
										id="checkChuyenSangChonMon"> <b>Mở thực đơn khi
											chọn bàn</b></label>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-6 col-xs-6 style-col-main">
					<div class="box-body">
						<!-- Set mã bàn khi chọn bàn -->
						<p hidden="">
							<input type="text" id="maban-hidden">
						</p>

						<div class="col-lg-2 col-xs-2 button-quanly-col">
							<button class="btn btn-warning button-quanly" type="button"
								id="btnThanhToan" data-toggle="modal"
								data-target="#modal-xacnhanthanhtoan"
								onclick="loadModalThanhToan()">Thanh toán</button>
						</div>
						<div class="col-lg-2 col-xs-2 button-quanly-col">
							<button class="btn btn-info button-quanly" type="button"
								id="btnChuyenBan" data-toggle="modal"
								data-target="#modal-chuyenban" onclick="loadChuyenBan()">Chuyển
								bàn</button>
						</div>
						<div class="col-lg-2 col-xs-2 button-quanly-col">
							<button class="btn btn-success button-quanly" type="button"
								id="btnGopBan" data-toggle="modal" data-target="#modal-gopban"
								onclick="loadGopBan()">Gộp bàn</button>
						</div>
						<div class="col-lg-2 col-xs-2 button-quanly-col">
							<button class="btn btn-primary button-quanly" type="button"
								id="btnDatBan" data-toggle="modal" data-target="#modal-datban"
								onclick="datBan()">Đặt bàn</button>
						</div>
						<div class="col-lg-2 col-xs-2 button-quanly-col">
							<button class="btn bg-purple button-quanly" type="button"
								id="btnHuyBan" data-toggle="modal" data-target="#modal-huyban">Hủy
								bàn</button>
						</div>
						<div class="col-lg-2 col-xs-2 button-quanly-col">
							<button class="btn btn-danger button-quanly" type="button"
								id="btnTachBan" data-toggle="modal" data-target="#modal-tachban"
								onclick="loadTachBan()">Tách bàn</button>
						</div>

					</div>
					<!-- MODAL BUTTON -->

					<%@include file="./BanHang-Action/BanHang-Modal.jsp"%>

					<!-- END MODAL BUTTON -->


					<div id="content-inhoadon">
						<!-- Hóa đơn -->
						<!-- Hoa Don Content -->

						<div class="info-box" style="overflow: auto; height: 465px">
							<!-- 
							<div class="box-header">
								<h3 class="box-title">Simple Full Width Table</h3>
							</div>
							 -->
							<!-- /.box-header -->
							<div class="box-body no-padding" id="content-chitiethoadon">

								<!-- content chi tiết hóa đơn -->

							</div>
							<!-- /.box-body -->
						</div>

						<!--END Hoa Don Content -->
						<!-- footer hóa đơn -->
						<div class="footer-banhang-right">
							<div class="col-lg-3 col-xs-3">
								<b><p align="left" id="lblTenBan">Chưa chọn bàn</p></b>
							</div>
							<div class="col-lg-5 col-xs-5">
								<b><p align="left"></p></b>
							</div>
							<div class="col-lg-4 col-xs-4">
								<b><p id="lblTongTien">Tổng tiền:&nbsp; 0 &nbsp;VNĐ</p> <b>
							</div>
						</div>
						<!-- End footer hóa đơn -->
					</div>
					<!-- End hóa đơn -->
				</div>
			</div>
			</section>
		</div>

		<div class="">
			<%@include file="./Shared/_main-footer.jsp"%>
		</div>


	</div>

	<%@include file="./Shared/_js.jsp"%>

	<!-- JS Bán hàng -->
	<script src="./BanHang-Action/jsVT.js"></script>
	<script type="text/javascript">
		function loadModalThanhToan() {
			document.getElementById('content-xacnhanhoadon').innerHTML = document
					.getElementById('hoadonin').innerHTML;
		};
	</script>


</body>
</html>