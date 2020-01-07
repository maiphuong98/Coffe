<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
		boolean checkBan = (boolean) request.getAttribute("checkBan");

		if(checkBan){%>
<p id="check-true" style="color: red;">Mã bàn đã tồn tại!</p>
<%	
		}else{
	%>
<p id="check-false" style="color: green;">Mã bàn hợp lệ!</p>
<%}%>