<%@page import="fpt.common.common"%>
<%@page import="fpt.model.bean.NhanVien"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!-- Left side column. contains the sidebar -->
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<div class="slimScrollDiv"
		style="position: relative; overflow: hidden; width: auto; height: 572px;">
		<section class="sidebar"
			style="overflow: hidden; width: auto; height: 572px;">
			<!-- Sidebar user panel -->

			<!-- sidebar menu: : style can be found in sidebar.less -->
			<ul class="sidebar-menu tree" data-widget="tree">
				<li class="header">MAIN NAVIGATION</li>

				<li class=""><a href="BanHang_Menu"> <i
						class="fa fa-shopping-cart"></i> <span>Quản lý bán hàng</span> <span
						class="pull-right-container"> </span>
				</a></li>
				<%
					if (session.getAttribute("user") != null) {
						NhanVien nhanVien = (NhanVien) session.getAttribute("user");
						if (common.QUAN_TRI_VIEN.equals(nhanVien.getChucVu())) {
				%>
				<li class=""><a href="NhanVienServlet"> <i
						class="fa fa-users"></i> <span>Quản lý nhân viên</span> <span
						class="pull-right-container"> </span>
				</a></li>
				<li class="treeview"><a href="#"> <i class="fa fa-wrench"></i>
						<span>Quản lý trang thiết bị</span> <span
						class="pull-right-container"> </span>
				</a>
					<ul class="treeview-menu">
						<li><a href="DanhSachThietBiServlet"><i
								class="fa fa-circle-o"></i> Xem danh sách thiết bị</a></li>
						<li><a href="Themthietbi.jsp"><i
								class="fa fa-circle-o"></i> Thêm thiết bị</a></li>
						<li><a href="Ban"><i
								class="fa fa-circle-o"></i> Xem danh sách bàn</a></li>
						<li><a href="ThemSuaBan.jsp"><i
								class="fa fa-circle-o"></i> Thêm bàn</a></li>
					</ul></li>

				<li class="treeview"><a href="#"> <i class="fa fa-archive"></i>
						<span>Quản lý kho hàng</span> <span class="pull-right-container">
					</span>
				</a>
					<ul class="treeview-menu">
						<li><a href="TrangChu"><i
								class="fa fa-circle-o"></i> Xem hàng trong kho</a></li>
						<li><a href="TrangChu"><i
								class="fa fa-circle-o"></i> Nhập hàng</a></li>
						<li><a href="TrangChu"><i
								class="fa fa-circle-o"></i> Xuất hàng</a></li>
					</ul></li>
				<li class="treeview"><a href="#"> <i
						class="fa fa-align-justify"></i> <span>Quản lý thực đơn</span> <span
						class="pull-right-container"> </span>
				</a>
					<ul class="treeview-menu">
						<li><a href="ThucDon"><i class="fa fa-circle-o"></i> Danh
								sách thực đơn</a></li>
						<li><a href="ThemSuaThucDon.jsp"><i
								class="fa fa-circle-o"></i> Thêm thực đơn</a></li>
					</ul></li>
				
				<li class=""><a href="NganSachServlet"> <i
						class="fa fa-fw fa-money"></i> <span>Quản lý ngân sách</span> <span
						class="pull-right-container"> </span>
				</a>
					</li>
				<li class="treeview"><a href="#"> <i class="fa fa-database"></i>
						<span>Quản lý dữ liệu</span> <span class="pull-right-container">
					</span>
				</a>
					<ul class="treeview-menu">
						<li><a href="TrangChu"><i
								class="fa fa-circle-o"></i> Sao lưu dữ liệu</a></li>
						<li><a href="TrangChu"><i
								class="fa fa-circle-o"></i> Phục hồi dữ liệu</a></li>
					</ul></li>
				<li class=""><a href="ThongKeBaoCaoServlet"> <i
						class="fa fa-pie-chart"></i> <span>Thống kê</span> <span
						class="pull-right-container"> </span>
				</a></li>
				<%
					}
					}
				%>
				<li class="header"></li>

				<li class=""><a href="GioiThieu.jsp"><i
						class="fa fa-circle-o text-aqua"></i> <span>Giới thiệu</span></a></li>
			</ul>
		</section>
		<div class="slimScrollBar"
			style="background: rgb(0, 0, 0); width: 7px; position: absolute; top: 0px; opacity: 0.4; display: none; border-radius: 7px; z-index: 99; right: 1px; height: 408.469px;"></div>
		<div class="slimScrollRail"
			style="width: 7px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; background: rgb(51, 51, 51); opacity: 0.2; z-index: 90; right: 1px;"></div>
	</div>
	<!-- /.sidebar -->
</aside>

<!-- =============================================== -->