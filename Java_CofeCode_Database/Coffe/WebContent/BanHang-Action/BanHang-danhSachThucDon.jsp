<%@page import="java.text.DecimalFormat"%>
<%@page import="fpt.model.bean.ThucDon"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	DecimalFormat formatter = new DecimalFormat("###,###,###");

	ArrayList<ThucDon> arrThucDon = (ArrayList<ThucDon>) request.getAttribute("danhSachThucDon");
	try {
		for (ThucDon thucDon : arrThucDon) {
%>
<div class="col-lg-4 col-xs-6">
	<button class="btn btn-app" value="<%=thucDon.getMaMon()%>"
		onclick="chonThucDon('<%=thucDon.getMaMon()%>')"
		style="width: 170px; height: 60px">
		<span class="badge bg-red"><b><%=formatter.format(thucDon.getGia())%></b></span>
		<img alt="foot" src="./Image/tea.ico" width="50px" height="50px"
			align="left">
		<p align="left">
			<b><%=thucDon.getTenMon().length() > 15 ? thucDon.getTenMon().substring(0, 15) + ".."
							: thucDon.getTenMon()%></b>
		</p>
	</button>
</div>
<%
	}
	} catch (Exception e) {
		System.out.println("error");
		e.printStackTrace();
	}
%>

<!--dùng để check Ở đây là thực đơn -->
<p hidden="" id="isThucDon"></p>