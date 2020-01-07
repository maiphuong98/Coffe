<%@page import="fpt.model.bean.Ban"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!-- Modal Xác nhận thanh toán -->
<div class="modal fade" id="modal-xacnhanthanhtoan">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-body">
				<div class="row">
					<div class="col-lg-12 col-xs-12">
					
					</div>
				</div>
				<div class="row" >
					<div class="col-lg-12 col-xs-12" id="content-xacnhanhoadon" style="overflow: auto; max-height: 500px;">
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<div class="row">
					<div class="col-lg-6 col-xs-6">
						<button type="button" class="btn btn-block btn-success btn-flat"
							data-dismiss="modal">Đóng</button>
					</div>
					<div class="col-lg-6 col-xs-6">
						<button type="submit" class="btn btn-block btn-danger btn-flat"
							onclick="thanhToan(layMaBanDangChon())">Thanh Toán</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /.modal-content -->
</div>
<!-- End modal Xác Nhận Thanh Toán -->


<!-- Modal đặt bàn -->

<div class="modal fade" id="modal-datban">
	<div class="modal-dialog">
		<!-- onsubmit="return chanSubmit()" -->
		<form action="BanHang_Action" method="post">
		<input type="text" name="datban" id="maBanFormDatBan" hidden="">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" align="left">
						<i class="fa fa-calendar-plus-o"></i>&nbsp;Đặt bàn
					</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-users"></i></span>
							<input type="text" class="form-control"
								placeholder="Tên khách hàng (*)" id="tenKH" required minlength="2"  maxlength="50" name="tenKH" >
						</div>
					</div>
					<div class="form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-phone"></i></span>
							<input type="text" class="form-control"
								placeholder="Số điện thoại (*)" id="sdt" required name="sdt" pattern="^\+?\d{1,3}?[- .]?\(?(?:\d{2,3})\)?[- .]?\d\d\d[- .]?\d\d\d\d$" maxlength="50">
						</div>
					</div>
					<div class="form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
							<input type="date" class="form-control" id="ngay" required name="ngay"  onchange="setMinGioDatBan()">
						</div>
					</div>
					<div class="form-group">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="fa fa-times-circle-o"></i></span> <input type="time"
								class="form-control pull-right" id="gio" required name="gio">
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default pull-left"
						data-dismiss="modal">Hủy</button>
					<button type="submit" class="btn btn-primary">Đặt
						ngay</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</form>
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- End modal đặt bàn -->

<!-- Modal Hủy bàn -->
<div class="modal fade" id="modal-huyban">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">

			<div class="modal-body">
				<div class="row">
					<div class="col-lg-12 col-xs-12">
						<div align="center">
							<h3>Bạn có chắc chắn muốn hủy bàn này !</h3>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<div class="row">
					<div class="col-lg-6 col-xs-6">
						<button type="button" class="btn btn-block btn-success btn-flat"
							data-dismiss="modal">Không</button>
					</div>
					<div class="col-lg-6 col-xs-6">
						<button type="submit" class="btn btn-block btn-danger btn-flat"
							onclick="huyban()">Có</button>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- /.modal-content -->
</div>
<!-- /.modal-dialog -->
<!-- End modal Hủy bàn -->


<!-- Modal chuyển bàn -->

<div class="modal fade" id="modal-chuyenban">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" align="left">
					<i class="fa  fa-exchange"></i> &nbsp;Chuyển &nbsp;<span
						id="modal-tenban"></span>
				</h4>
			</div>
			<div class="modal-body">
				<div class="form-group" align="left">

					<label>Chọn bàn cần chuyển đến</label>

					<div id="content-chuyenban">

						<!-- nội dung modal chuyển bàn -->

					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default pull-left"
					data-dismiss="modal">Hủy</button>
				<button type="submit" class="btn btn-primary" onclick="chuyenBan()">Chuyển</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- End modal Chuyển bàn -->

<!-- Modal Gộp bàn -->

<div class="modal fade" id="modal-gopban">
	<div class="modal-dialog">
		<div class="modal-content">
			<!-- <form action="BanHang_Action?gopban" method="post"> -->
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" align="left">
					<i class="fa  fa-exchange"></i> &nbsp;Gộp bàn
				</h4>
			</div>
			<div class="modal-body">

				<div id="content-gopban">

					<!-- nội dung modal gộp bàn -->

				</div>

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default pull-left"
					data-dismiss="modal">Hủy</button>
				<button type="submit" class="btn btn-primary" onclick="gopBan()">Gộp</button>
			</div>
			<!-- </form>-->
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- End modal gộp bàn -->

<!-- Modal tách bàn -->

<div class="modal fade" id="modal-tachban">
	<div class="modal-dialog">
		<div class="modal-content">
			<form action="BanHang_TachBan" method="post" onsubmit="return ktraChonMon()">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" align="left">
						<i></i> &nbsp;Tách bàn &nbsp;<span
							id="modal-tenban"></span>
					</h4>
				</div>
				<div class="modal-body" id="content-tachban">

					<!-- nội dung modal chuyển bàn -->

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default pull-left"
						data-dismiss="modal">Hủy</button>
					<button type="submit" class="btn btn-primary">Tách</button>
				</div>
			</form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- End modal tách bàn -->