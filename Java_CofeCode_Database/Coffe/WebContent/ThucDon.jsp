<%@page import="fpt.model.bean.ThucDon"%>
<%@page import="fpt.model.bean.NhanVien"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Quản lý thực đơn</title>

<%@include file="./Shared/_bootstrap.jsp"%>
<link rel="stylesheet"
	href="./bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
</head>
<body
	class="fixed sidebar-mini sidebar-mini-expand-feature skin-black-light"
	style="height: auto; min-height: 100%;">
	<!-- Site wrapper -->
	<div class="wrapper" style="height: auto; min-height: 100%;">
		<%@include file="./Shared/_main-header.jsp"%>
		<%@include file="./Shared/_main-sidebar.jsp"%>



		<!-- Content Wrapper. Contains page content -->


		<div class="content-wrapper" style="min-height: 621px;">
			<!-- Content Header (Page header) -->
			<section class="content-header"> <br>
			</section>
			<!-- Main content -->
			<section class="content">
			<div class="col-xs-12 col-lg-12">

				<div class="box">
					<div class="box-header">
						<div class="col-lg-12">
							<div class="col-lg-6">
								<h3 class="box-title"><b>DANH SÁCH CÁC MẶT HÀNG</b></h3>
							</div>
							<div class="col-lg-6">
								<p align="right">
									<a href="ThemSuaThucDon.jsp" type="button" name=""
										class="btn btn-primary">Thêm</a>
								</p>
							</div>
						</div>


					</div>
					<!-- /.box-header -->
					<div class="box-body">
						<table id="example1" class="table table-bordered table-striped">
							<thead>
								<tr>
									<th width="50px">Mã mặt hàng</th>
									<th>Tên mặt hàng</th>
									<th>Giá</th>
									<th width="50px">Đơn vị tính</th>
									<th width="10px"></th>
								</tr>
							</thead>
							<tbody>
								<%
									if (request.getAttribute("dsThucDon") != null) {
										ArrayList<ThucDon> dsThucDon = (ArrayList<ThucDon>) request.getAttribute("dsThucDon");
										for (ThucDon thucDon : dsThucDon) {
								%>
								<tr>
									<td><%=thucDon.getMaMon()%></td>
									<td><%=thucDon.getTenMon()%></td>
									<td><%=(new common().fomatTien(thucDon.getGia()))%></td>
									<td><%=thucDon.getDonViTinh()%></td>
									<td><a id="sua"
										href="ThucDon?action=sua&mamon=<%=thucDon.getMaMon()%>"
										original-title="Sửa"><i class="fa fa-pencil-square-o"
											aria-hidden="true"></i></a></td>
								</tr>
								<%
									}
									}
								%>
							</tbody>
							<!-- <tfoot><tr><th>Rendering engine</th><th>Browser</th><th>Platform(s)</th><th>Engine version</th></tr></tfoot> -->
						</table>
					</div>
					<!-- /.box-body -->
				</div>


			</div>

			</section>
			<!-- /.content -->
		</div>
	</div>


	<!-- /.content-wrapper -->

	<%@include file="./Shared/_main-footer.jsp"%>
	</div>

	<%@include file="./Shared/_js.jsp"%>
	<script
		src="./bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
	<script
		src="./bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
	<script>
		$(function() {
			//edit jquery.dataTables.min.js
			$('#example1').DataTable()
			$('#example2').DataTable({
				'paging' : true,
				'lengthChange' : false,
				'searching' : false,
				'ordering' : false,
				'info' : true,
				'autoWidth' : false
			})
		})

	</script>
</body>
</html>