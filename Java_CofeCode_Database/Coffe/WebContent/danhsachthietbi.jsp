<%@page import="fpt.model.bean.ThietBi"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Trang chủ - CAFE</title>

<%@include file="./Shared/_bootstrap.jsp"%>
</head>
<body class="fixed sidebar-mini sidebar-mini-expand-feature skin-black-light"
	style="height: auto; min-height: 100%;">
	<!-- Site wrapper -->
	<div class="wrapper" style="height: auto; min-height: 100%;">
		<%@include file="./Shared/_main-header.jsp"%>
		<%@include file="./Shared/_main-sidebar.jsp"%>



		<!-- Content Wrapper. Contains page content -->


		<div class="content-wrapper" style="min-height: 621px;">

			<form action="DanhSachThietBiServlet">
				<div class="container">
					<div class="row">
						<div class="col-lg-12 col-xs-12">
							<div class="col-lg-4" align="left">
								<i class="fa fa-users"></i> &nbsp;Danh sách thiết bị
							</div>
							<div class="col-lg-4" align="center">
								<div class="row form-group">
									<div align="">
										<input type="text"><input type="button"
											value="Tìm kiếm">
									</div>
								</div>
							</div>
								
						</div>
					</div>
					<h2>
									<a href="Themthietbi.jsp" class="btn btn-primary pull-right"><b>Thêm thiết bị
											</b></a>
								</h2>
				</div>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Mã thiết bị</th>
							<th>Tên thiết bị</th>
							<th>Ngày mua</th>
							<th>Số lựơng</th>
							<th>Đơn giá</th>
							<th>Giá</th>

						</tr>
					</thead>

					<tbody>
						<%
							ArrayList<ThietBi> arrThietBi = (ArrayList<ThietBi>) request.getAttribute("listThietBi");
							try {
								for (ThietBi thietbi : arrThietBi) {
						%>
						<tr>
							<td><%=thietbi.getMaThietBi()%></td>
							<td><%=thietbi.getTenThietBi()%></td>
							<td><%=thietbi.getSoLuong()%></td>
							<td><%=thietbi.getNgayMua()%></td>
							<td><%=thietbi.getDonGia()%></td>
							<td>
								<%
									out.print(thietbi.getSoLuong() * thietbi.getDonGia());
								%>
							</td>
							<td><a
								href="ChinhSuaThietBiServlet?maThietBi=<%=thietbi.getMaThietBi()%>"
								original-title="Sửa"> <i class="fa fa-pencil-square-o"
									aria-hidden="true"></i></a></td>
							<td><a
								href="XoaThietBiServlet?maThietBi=<%=thietbi.getMaThietBi()%>"
								onclick="deleteRow(this)"><i class="fa fa-trash-o"
									aria-hidden="true"></i></a></td>
						</tr>
						<%
							}
							} catch (Exception e) {
								System.err.println("Err DS Thiet Bi: ");
								e.printStackTrace();
							}
						%>
					</tbody>

				</table>
			</form>
		</div>



		<!-- /.content-wrapper -->




		<%@include file="./Shared/_main-footer.jsp"%>
	</div>
	<%@include file="./Shared/_js.jsp"%>
</body>
</html>