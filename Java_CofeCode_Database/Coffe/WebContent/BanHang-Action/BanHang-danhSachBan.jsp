<%@page import="fpt.model.bean.Ban"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	ArrayList<Ban> arrBan = (ArrayList<Ban>) request.getAttribute("danhSachBan");
	try {
		for (Ban ban : arrBan) {
%>
<div class="col-lg-3 col-xs-6">

	<button class="btn btn-app btn-ban" value="<%=ban.getMaBan()%>"	onclick="chonBan(this.value)" name="maBan" style="width: 110px; height: 60px">
		<span
			class='<%if ("Đang sử dụng".equalsIgnoreCase(ban.getTrangThai())) {%> 
		badge bg-red
		<%} else if ("Đã đặt".equalsIgnoreCase(ban.getTrangThai())) {%>
		badge bg-yellow
		<%} else {%>
		badge bg-green
		<%}%>
       '
			id="<%=ban.getMaBan()%>"><%=ban.getTrangThai()%></span> 
			<img alt="table" src="./Image/table2.png" width="50px" height="50px">
		<b id='<%=(ban.getMaBan() + "tenBan")%>' style="font-size: 15px;"><%=ban.getTenBan().length() > 6 ? ban.getTenBan().substring(0, 6) : ban.getTenBan()%></b>
	</button>
</div>
<%
	}
	} catch (Exception e) {
		System.out.println("error");
		e.printStackTrace();
	}
%>