<%@page import="fpt.model.bean.Ban"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<select class="form-control" id="select-chuyenban">
	<%
		ArrayList<Ban> dsBan = (ArrayList<Ban>) request.getAttribute("dsBan");

		for (Ban ban : dsBan) {
			if ("Đang sử dụng".equals(ban.getTrangThai()) || "Đã đặt".equals(ban.getTrangThai())) {

			}

			else {
	%>
	<option value="<%=ban.getMaBan()%>"><%=ban.getTenBan()%></option>

	<%
		}
		}
	%>
</select>