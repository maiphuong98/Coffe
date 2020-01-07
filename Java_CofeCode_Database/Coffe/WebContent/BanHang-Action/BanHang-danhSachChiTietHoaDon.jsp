<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="fpt.model.bean.ThongTinDatBan"%>
<%@page import="fpt.model.bean.ChiTietHoaDon"%>
<%@page import="fpt.model.bean.ThucDon"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	long tongTienTatCa = 0;
	if (request.getAttribute("thongTinDatBan") != null) {
		ThongTinDatBan thongTinDatBan = (ThongTinDatBan) request.getAttribute("thongTinDatBan");

		Date date = (new SimpleDateFormat("yyyy-MM-dd")).parse(thongTinDatBan.getNgay());
		String ngayHienThi = new SimpleDateFormat("dd-MM-yyyy").format(date);
%>
<div style="padding: 100px;" align="left">
	<div class="row">
		<div class="col-lg-1 col-xs-1"></div>
		<div class="col-lg-8 col-xs-8">
			<h3>Thông tin đặt bàn:</h3>
		</div>
		<div class="col-lg-3 col-xs-3"></div>
	</div>
	<div class="row">
		<div class="col-lg-2 col-xs-2"></div>
		<div class="col-lg-8 col-xs-8">
			<i class="fa fa-users">&nbsp; &nbsp; <b><%=thongTinDatBan.getTenKH()%></b></i>
		</div>
		<div class="col-lg-2 col-xs-2"></div>
	</div>
	<br>
	<div class="row">
		<div class="col-lg-2 col-xs-2"></div>
		<div class="col-lg-8 col-xs-8">
			<i class="fa fa-phone-square">&nbsp; &nbsp; <b><%=thongTinDatBan.getSDT()%></b></i>
		</div>
		<div class="col-lg-2 col-xs-2"></div>
	</div>
	<br>
	<div class="row">
		<div class="col-lg-2 col-xs-2"></div>
		<div class="col-lg-8 col-xs-8">
			<i class="fa fa-calendar">&nbsp; &nbsp; <b><%=ngayHienThi%></b></i>
		</div>
		<div class="col-lg-2 col-xs-2"></div>
	</div>
	<br>
	<div class="row">
		<div class="col-lg-2 col-xs-2"></div>
		<div class="col-lg-8 col-xs-8">
			<i class="fa fa-times-circle-o">&nbsp; &nbsp; <b> <%=thongTinDatBan.getGio()%></b></i>
		</div>
		<div class="col-lg-2 col-xs-2"></div>
	</div>
</div>

<!-- Nếu có thẻ này thì bàn đã đặt -->
<p id="checkBanDaDat" hidden=""></p>
<%
	} else if (request.getAttribute("danhSachChiTietHoaDon") != null) {
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		ArrayList<ChiTietHoaDon> danhSachChiTietHoaDon = (ArrayList<ChiTietHoaDon>) request
				.getAttribute("danhSachChiTietHoaDon");
		//Nếu bàn trống
		if (danhSachChiTietHoaDon.isEmpty()) {
%>
<h3 style="padding: 150px; text-shadow: 0 0 5px rgba(0, 0, 0, 0.5);">
	<i class="fa fa-hand-o-left"></i>&nbsp;Mời chọn món
</h3>
<%
	} else { //Bàn có gọi món r
%>
<table class="table">
	<thead>
		<tr>
			<th style="width: 10px"></th>
			<th>Tên :</th>
			<th style="width: 80px">Số lượng :</th>
			<th>Giá :</th>
			<th style="width: 40px">Tổng:</th>
		</tr>
	</thead>
	<tbody>
		<%
			try {
						for (ChiTietHoaDon chiTietHoaDon : danhSachChiTietHoaDon) {
							long soLuongMua = chiTietHoaDon.getSoLuongMua();
							long gia = chiTietHoaDon.getGia();
							long tongTien = gia * soLuongMua;
							tongTienTatCa += tongTien;
		%>
		<tr>
			<td><button class="btn btn-danger btn-sx"
					value="<%=chiTietHoaDon.getMaCTHD()%>"
					onclick="xoaChiTietHoaDon(this.value)">
					<i class="fa fa-close"></i>
				</button></td>
			<td><%=chiTietHoaDon.getTenMon().length() > 30 ? chiTietHoaDon.getTenMon().substring(0,30) : chiTietHoaDon.getTenMon()	%></td>
			<td><input type="number" style="width: 40px; height: 25px; padding-left: 0px; padding-right: 0px;"
				class="form-control" value="<%=soLuongMua%>"
				onchange="thayDoiSoLuongCTHD(this.value,<%=chiTietHoaDon.getMaCTHD()%>)"  min=1></td>
			<td><span><%=formatter.format(gia)%></span></td>
			<td><span class="badge bg-red"><%=formatter.format(tongTien)%></span></td>
		</tr>
		<%
			}
					} catch (Exception e) {
						System.out.println("error content ChiTietHoaDon");
						e.printStackTrace();
					}
				}
		%>
	</tbody>
</table>

<!-- Hóa đơn in ra -->

<div style="display: none" id="hoadonin">
	<div align="left">
		<h1>Cửa hàng Cafe_abc</h1>
	</div>

	<div align="center">
		<h3>HÓA ĐƠN THANH TOÁN</h3>
	</div>
	<br>
	<div align="center">
		<table>
			<thead>
				<td align="left" width="10px;">#</td>
				<td width="300px;">Tên món:</td>
				<td>Giá:</td>
				<td align="right">SL:</td>
				<td align="right">Thành tiền:</td>
			</thead>
			<tbody>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<%
					int stt = 1;
						for (ChiTietHoaDon chiTietHoaDon : danhSachChiTietHoaDon) {
							long soLuongMua = chiTietHoaDon.getSoLuongMua();
							long gia = chiTietHoaDon.getGia();
							long tongTien = gia * soLuongMua;
							
				%>
				<tr>
					<td align="left"><%=stt + "."%></td>
					<td><%=chiTietHoaDon.getTenMon()%></td>
					<td><%=formatter.format(gia)%></td>
					<td align="right"><%=soLuongMua%></td>
					<td align="right"><%=formatter.format(tongTien)%></td>
				</tr>
				<%
					stt++;
						}
				%>
			</tbody>
			<tfoot>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td><b>Tổng tiền: <%=formatter.format(tongTienTatCa) + " VNĐ"%></b></td>
				</tr>
			</tfoot>
		</table>
	</div>

</div>

<!-- Tổng tiền ẩn -->
<p hidden="">
	<input type="text" id="tongtien-hidden" value="<%=tongTienTatCa%>">
</p>
<%
	}
	//Nếu bàn chưa có hóa đơn(Trống)
	else {
%>
<h3 style="padding: 150px; text-shadow: 0 0 5px rgba(0, 0, 0, 0.5);">
	<i class="fa fa-hand-o-left"></i>&nbsp;Bàn Trống
</h3>
<%
	}
%>
