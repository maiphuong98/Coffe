<%@page import="fpt.common.ConvertDate"%>
<%@page import="fpt.model.bean.NganSach"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Quản lý ngân sách</title>

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
				<i class="fa fa-fw fa-money"></i> &nbsp;Quản lý ngân sách <a
					href="ThemThuChi.jsp" class="btn btn-primary pull-right"><b>Thêm
						ngân sách</b></a>
			</h1>
			</section>

			<!-- Main content -->
			<section class="content">
			<div class="col-xs-12" style="padding-top: 10px;">
				<div class="box">
					<div class="box-header with-border">
						<h3 class="box-title">Danh sách ngân sách</h3>
					</div>
					<!-- /.box-header -->
					<div class="box-body table-responsive no-padding">

						<form action="NganSachServlet" method="post">
							<div class="form-group col-md-4" style="padding-left: 10px;">
								<label>Từ ngày: </label>
								<div class="input-group date">
									<div class="input-group-addon">
										<i class="fa fa-calendar"></i>
									</div>
									<input type="date" class="form-control pull-right"
										id="txtNgayTruoc" name="txtNgayTruoc">
								</div>
								<!-- /.input group -->
							</div>
							<div class="form-group col-md-4" style="padding-left: 10px;">
								<label>Đến ngày: </label>
								<div class="input-group date">
									<div class="input-group-addon">
										<i class="fa fa-calendar"></i>
									</div>
									<input type="date" class="form-control pull-right"
										id="txtNgaySau" name="txtNgaySau">
								</div>
								<!-- /.input group -->
							</div>
							<div class="form-group col-md-4" style="padding-top: 24px;">
								<button type="submit" name="btnXem" class="btn btn-primary">Xem</button>
							</div>
						</form>
						<table class="table table-hover">
							<tbody>
								<tr>
									<th>#</th>
									<th>Ngày chi</th>
									<th>Tên khoản chi</th>
									<th>Số tiền</th>
								</tr>
								<tr>
									<%
									  int i = 1;
									  ArrayList<NganSach> listNS = (ArrayList<NganSach>) request
									      .getAttribute("listNganSach");
									  for (NganSach ns : listNS) {
										  
									%>
									<td><%=i%></td>
									<td><%=new ConvertDate().convertDateMonthYear(ns.getNgayChi())%></td>
									<td><%=ns.getTenKhoanChi()%></td>
									<td><%=new common().fomatTien(ns.getSoTien())%></td>
								</tr>
								<%
								  i++;
								  }
								%>
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