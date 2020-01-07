<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
		boolean checkThucDon = (boolean) request.getAttribute("checkThucDon");

		if(checkThucDon){%>
<p id="check-true" style="color: red;">Mã món đã tồn tại!</p>
<%	
		}else{
	%>
<p id="check-false" style="color: green;">Mã món hợp lệ!</p>
<%}%>