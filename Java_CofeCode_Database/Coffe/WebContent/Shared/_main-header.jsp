<%@page import="fpt.model.bean.NhanVien"%>
<%@page import="fpt.model.bo.NhanVienBO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<header class="main-header">
	<!-- Logo -->
	<a href="TrangChu" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
		<span class="logo-mini"><b>CF</b></span> <!-- logo for regular state and mobile devices -->
		<span class="logo-lg"><b>CAFE </b>abc</span>
	</a>
	<!-- Header Navbar: style can be found in header.less -->
	<nav class="navbar navbar-static-top">
		<!-- Sidebar toggle button-->
		<a href="#" class="sidebar-toggle" data-toggle="push-menu"
			role="button"> <span class="sr-only">Toggle navigation</span> <span
			class="icon-bar"></span> <span class="icon-bar"></span> <span
			class="icon-bar"></span>
		</a>

		<div class="navbar-custom-menu">

			<ul class="nav navbar-nav">

				<%
   		if (session.getAttribute("txtTenDangNhap") != null) {
		   NhanVienBO nhanvienBO = new NhanVienBO();

  	 	String tenDangNhap = (String) session.getAttribute("txtTenDangNhap");
	 	 NhanVien anhNV = nhanvienBO.TrangCaNhanBO(tenDangNhap);
 %>
				<li class="dropdown user user-menu"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"
					aria-expanded="false"> <img src="upload/<%=anhNV.getAnh()%>"
						class="user-image" alt="User Image"> <span class="hidden-xs"><strong><%=((NhanVien)session.getAttribute("user")).getHoTen()%></strong></span>

				</a>
					<ul class="dropdown-menu">
						<!-- User image -->

						<li class="user-header"><img src="upload/<%=anhNV.getAnh()%>"
							class="img-circle" alt="User Image">
							<p>
								<strong><%=((NhanVien)session.getAttribute("user")).getHoTen()%></strong>
								<small>Member since Nov. 2017</small>
							</p></li>
						<!-- Menu Body -->

						<!-- Menu Footer-->
						<li class="user-footer">
							<div class="pull-left">
								<a href="TrangCaNhanServlet" class="btn btn-default btn-flat">Trang
									cá nhân</a>
							</div>
							<form action="DangXuatServlet" method="post">
								<div class="pull-right">
									<button type="submit" name="btnDangXuat" id="btnDangXuat"
										class="btn btn-default btn-flat">Đăng xuất</button>
								</div>
							</form>
						</li>
					</ul></li>
				<%
						  }
						%>
			</ul>
		</div>
	</nav>
</header>

<!-- =============================================== -->