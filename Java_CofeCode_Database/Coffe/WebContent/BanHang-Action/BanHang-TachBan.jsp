<%@page import="fpt.model.bean.ChiTietHoaDon"%>
<%@page import="fpt.model.bean.Ban"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div class="row"></div>
<%
	ArrayList<Ban> dsBan = (ArrayList<Ban>) request.getAttribute("dsBan");
	Ban banDangChon = (Ban) request.getAttribute("ban");
	ArrayList<ChiTietHoaDon> dsCTHD = (ArrayList<ChiTietHoaDon>) request.getAttribute("dsCTHD");
%>
<div class="row">
	<div class="col-lg-6 col-xs-6 " align="left">
		<label>Chọn món cần tách ở <%=banDangChon.getTenBan()%></label>

		<div class="info-box"
			style="padding: 5px; overflow: auto; max-height: 410px;">
			<%
				if (dsCTHD != null) {
			%>

			<input name="bandangchon" value="<%=banDangChon.getMaBan()%>"
				hidden="">
			<table class="table">
				<thead>
					<td align="left"><i class="fa fa-check-square-o"></i>&nbsp;&nbsp; Tên món</td>
					<td align="right">Số lượng</td>
				</thead>
				<tbody>
					<%
						for (ChiTietHoaDon chiTietHoaDon : dsCTHD) {
					%>
					<tr>
						<td>
							<div class="checkbox">
								<label> <input type="checkbox"
									value="<%=chiTietHoaDon.getMaCTHD()%>" name="checkbox-tachban"
									onclick="enableSoLuong(this.value)"> <%=chiTietHoaDon.getTenMon()%>
								</label>
							</div>
						</td>
						<td align="right"><input class="form-control input-sm"
							type="number" value="<%=chiTietHoaDon.getSoLuongMua()%>"
							style="width: 40px; padding: 1px; font-size: 15px;"
							name="<%=chiTietHoaDon.getMaCTHD()%>"
							id="<%="SL" + chiTietHoaDon.getMaCTHD()%>" disabled="" min="1"
							max="<%=chiTietHoaDon.getSoLuongMua()%>" required></td>
					</tr>
					<%
						}
					%>

				</tbody>
			</table>
			<%
				} else {
			%>
			<b>Bàn này chưa chọn món.</b>
			<%
				}
			%>
		</div>
	</div>

	<div class="col-lg-1 col-xs-1 " style="padding-top: 70px;">
		<h1>
			<i class="fa fa-exchange"></i>
		</h1>
	</div>

	<div class="col-lg-5 col-xs-5 ">
		<label>Chọn bàn tách đến</label> <select class="form-control"
			id="select-tach" name="select-tachban">
			<%
				for (Ban ban : dsBan) {
					if (!"Đã đặt".equals(ban.getTrangThai())) {
			%>
			<option value="<%=ban.getMaBan()%>"><%=ban.getTenBan()%></option>

			<%
				}
				}
			%>
		</select>
	</div>
</div>