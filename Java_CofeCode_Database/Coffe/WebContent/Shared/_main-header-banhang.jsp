<%@page import="fpt.common.common"%>
<%@page import="fpt.model.bean.NhanVien"%>
<%@page import="fpt.model.bo.NhanVienBO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<header class="main-header">
	<nav class="navbar navbar-static-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a href="BanHang_Menu" class="navbar-brand"><b>Cafe</b>&nbsp;abc</a>
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar-collapse">
					<i class="fa fa-bars"></i>
				</button>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse pull-left" id="navbar-collapse">
				<ul class="nav navbar-nav">
					<li><button class="btn-ban-thucdon btn-ban-thucdon-active"
							value="ban" style="margin-top: 8px; margin-left: 12px"
							id="btnBan" onclick="clickMenu(this.value)">Bàn</button> <span
						class="sr-only">(current)</span></li>
					<li><button
							class="btn btn-block btn-primary btn-flat btn-ban-thucdon"
							value="thucdon" style="margin-top: 8px; margin-left: 12px"
							id="btnThucDon" onclick="clickMenu(this.value)">Thực Đơn</button>
						<span class="sr-only"></span></li>
				</ul>
				<form class="navbar-form navbar-left" role="search"
					style="margin-top: 10px; margin-bottom: 6px;">
					<div class="form-group">
						<input type="text" class="form-control timkiem"
							id="navbar-search-input" placeholder="Tìm kiếm trong thực đơn"
							name="search-thucdon" onkeyup="searchthucdon(this.value)"
							style="width: 360px; height: 29px;">
					</div>
				</form>
			</div>
			<!-- /.navbar-collapse -->
			<!-- Navbar Right Menu -->
			<div class="navbar-custom-menu">
			<%
							 NhanVienBO nhanVienBO = new NhanVienBO();

					    	 String tenDangNhap = (String) session.getAttribute("txtTenDangNhap");
					 	 	 NhanVien anhNV = nhanVienBO.TrangCaNhanBO(tenDangNhap);
							%>
				<ul class="nav navbar-nav">
					<%if(common.QUAN_TRI_VIEN.equals(((NhanVien)session.getAttribute("user")).getChucVu())) {%>
					<!-- Notifications Menu -->
					<li class="dropdown notifications-menu">
						<!-- Menu toggle button --> <a href="TrangChu"> <i class="fa fa-bell-o"></i> <span
							class="label label-warning">Quản trị viên</span>
					</a>
						
					</li>
					<%} %>
					<!-- User Account Menu -->
					<li class="dropdown user user-menu"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"
						aria-expanded="false"> <img src="upload/<%=anhNV.getAnh()%>"
							class="user-image" alt="User Image"> <%
 	if (session.getAttribute("txtTenDangNhap") != null) {
 %> <span class="hidden-xs"><strong><%=((NhanVien)session.getAttribute("user")).getHoTen()%></strong></span>
							<%
								}
							%>
					</a>
						<ul class="dropdown-menu">
							<!-- User image -->

							<li class="user-header"><img src="upload/<%=anhNV.getAnh()%>"
								class="img-circle" alt="User Image"> <%
 	if (session.getAttribute("txtTenDangNhap") != null) {
 %>
								<p>
									<strong><%=((NhanVien)session.getAttribute("user")).getHoTen()%></strong> <small>Member
										since Nov. 2017</small>
								</p> <%
 	}
 %></li>
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
				</ul>
			</div>
			<!-- /.navbar-custom-menu -->
		</div>
		<!-- /.container-fluid -->
	</nav>
</header>
