<%@page import="fpt.model.bean.NhanVien"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Quản lý nhân viên</title>

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
			<!-- Content Header (Page header) -->
			<section class="content-header"> <br>
			<h1>
				<i class="fa fa-users"></i> &nbsp;Quản lý nhân viên <a
					href="ThemNhanVien.jsp" class="btn btn-primary pull-right"><b>Thêm
						nhân viên</b></a>
			</h1>
			</section>
			<!-- Main content -->
			<section class="content">
			<div class="col-xs-12" style="padding-top: 10px;">
				<div class="box">
					<form action="NhanVienServlet" method="post">
						<div class="box-header">
							<h3 class="box-title">Danh sách nhân viên</h3>
							<div class="box-tools">
								<div class="input-group input-group-sm col-sm-4 pull-right">
									<input type="text" id="txtkey" name="txtKey"
										class="form-control pull-right" placeholder="Tìm kiếm...">

									<div class="input-group-btn">
										<button type="submit" class="btn btn-default" id="btnSearch"
											name="btnSearch">
											<i class="fa fa-search"></i>
										</button>
									</div>
								</div>
							</div>
						</div>
					</form>
					<!-- /.box-header -->
					<div class="box-body table-responsive no-padding">
						<table class="table table-hover">
							<tbody>
								<tr>
									<th>#</th>
									<th>Họ và Tên</th>
									<th>Chức vụ</th>
									<th>Lương</th>
								</tr>
								<tr>
									 <%
									  int i = 1;
									  ArrayList<NhanVien> listNV = (ArrayList<NhanVien>) request
									      .getAttribute("listNhanVien");
									  if((ArrayList<NhanVien>) request
									      .getAttribute("listNhanVien") != null)
									  for (NhanVien nv1 : listNV) {
									%> 
									<td><%=i%></</td>
									<td><%=nv1.getHoTen()%></td>
									<td><%=nv1.getChucVu()%></td>
									<td><%=new common().fomatTien(nv1.getLuong())%></td>
									<td><a id="example-2"
										href="SuaNhanVienServlet?maNV=<%=nv1.getMaNV()%>"
										original-title="Sửa"><i class="fa fa-pencil-square-o"
											aria-hidden="true"></i></a></td>
									<td><a href="XoaNhanVienServlet?maNV=<%=nv1.getMaNV()%>"><i
											class="fa fa-trash-o" aria-hidden="true"></i></a></td> 
								</tr>
							<%
								  i++;
								  }
								%> 
								<div class="box-footer clearfix">
									<ul class="pagination pagination-sm no-margin pull-right">
										<li><a href="#">«</a></li>
										<li><a href="#">1</a></li>
										<li><a href="#">2</a></li>
										<li><a href="#">3</a></li>
										<li><a href="#">»</a></li>
									</ul>
								</div>
							</tbody>
						</table>
					</div>
					<!-- /.box-body -->
				</div>
				<!-- /.box -->
			</div>


			<div class="box-footer" style="display: none;">Footer</div>
			<!-- /.box-footer-->
		</div>
		<!-- /.box -->
		</section>
		<!-- /.content -->
	</div>


	<!-- /.content-wrapper -->

	<div id="myModalXoa" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Cảnh báo!</h4>
				</div>
				<div class="modal-body">
					<p>Bạn có chắc chắn muốn xóa?</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-info">Xóa</button>
					<button type="button" class="btn btn-info" data-dismiss="modal">Đóng</button>
				</div>
			</div>
		</div>
	</div>


	<%@include file="./Shared/_main-footer.jsp"%>
	</div>

	<%@include file="./Shared/_js.jsp"%>
</body>
</html>