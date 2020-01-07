<%@page import="fpt.model.bean.Ban"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div class="row"></div>
<%
	ArrayList<Ban> dsBan = (ArrayList<Ban>) request.getAttribute("dsBan");
%>
<div class="row">
	<div class="col-lg-5 col-xs-5 " align="left">
		<label>Chọn bàn cần gộp</label>

		<div class="info-box"
			style="padding: 5px; overflow: auto; height: 165px;">
			<div class="form-group">

					<%
					for (Ban ban : dsBan) {
						if ("Đang sử dụng".equals(ban.getTrangThai())) {
				%>
					<div class="checkbox">
						<label> <input type="checkbox" value="<%=ban.getMaBan()%>"
							name="checkbox-gopban-ban1"> <%=ban.getTenBan()%>
						</label>
					</div>
					<%
					}
					}
				%>


			</div>
		</div>
	</div>

	<div class="col-lg-1 col-xs-1 " style="padding-top: 70px;">
		<h1>
			<i class="fa fa-exchange"></i>
		</h1>
	</div>

	<div class="col-lg-6 col-xs-6 ">
		<label>Chọn bàn gộp đến</label> <select class="form-control"
			id="select-gopban2" name="select-gopban2">
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