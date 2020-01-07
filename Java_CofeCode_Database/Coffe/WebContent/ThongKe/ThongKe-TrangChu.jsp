<%@page import="fpt.model.bean.MatHangBanChay"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!-- Top 10 mặt hàng -->
<%
	if (request.getAttribute("top10Hang") != null) {
%>
<div style="display: none;">
	<%
		ArrayList<MatHangBanChay> lstMH = (ArrayList<MatHangBanChay>) request.getAttribute("top10Hang");
			int j = 0;
			for (MatHangBanChay mh : lstMH) {
	%>
	<p id='<%="tenMon" + j%>'><%=mh.getTenMon()%></p>
	<p id='<%="tienHang" + j%>'><%=mh.getTongTien()%></p>
	<%
		j++;
			}
	%>
</div>
<%
	}
%>
<!-- 7 ngày và 3 tháng gần nhất -->
<%
	if (request.getAttribute("lstDateStringVN") != null && request.getAttribute("lstTien") != null) {
%>
<div style="display: none;">
	<%
		ArrayList<String> lstDateStringVN = (ArrayList<String>) request.getAttribute("lstDateStringVN");
			ArrayList<Long> lstTien = (ArrayList<Long>) request.getAttribute("lstTien");
			int i = 0;
			for (String s : lstDateStringVN) {
	%>
	<p id='<%="date" + i%>'><%=s%></p>
	<%
		i++;
			}
			i = 0;
			for (long t : lstTien) {
	%>
	<p id='<%="tien" + i%>'><%=t%></p>
	<%
		i++;
			}
	%>
</div>
<%
	}
%>

<!-- page script -->
<script>
	$(function() {
		
	})
</script>

