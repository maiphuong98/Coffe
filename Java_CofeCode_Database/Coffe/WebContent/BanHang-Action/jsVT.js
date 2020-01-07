function ihackmyweb(){
	alert('Web đã bị tôi hack ^^');
};
//Validate,.........
function resetSoLuong(id, value){
	var slMax = document.getElementById(id).max;
	if(value > slMax || value < 1)
		document.getElementById(id).value = slMax;
};

function enableSoLuong(checkbox){
	if(document.getElementById("SL" + checkbox).disabled == true){
		document.getElementById("SL" + checkbox).disabled = false;
	}else document.getElementById("SL" + checkbox).disabled = true;
};


///Nhóm button thanh toán, ...

//Check tách bàn
function ktraChonMon(){
	var lstCheck = document.getElementsByName('checkbox-tachban');

	for(var i = 0; i< lstCheck.length; i++)
		if(lstCheck[i].checked === true)
			return true;

	alert('Bạn chưa chọn món cần tách!');
	return false;
};

//Nhấn tách bàn
function tachBan(){
	return;
	var lstBan1 = document.getElementsByName('checkbox-tachban-ban1');
	var ban2 = document.getElementById('select-gopban2').value;

	//Lấy mảng các bàn check
	var arr = new Array();

	//Lấy bàn checked
	for(var i = 0; i< lstBan1.length; i++){
		if(lstBan1[i].checked === true){
			arr.push(lstBan1[i]); //lstBan1[i].value
		}
	}
	if(arr.length == 0){
		alert('Bạn chưa chọn bàn cần gộp!');
		return;
	}

	requestGopBan(arr,ban2,0);
};



//Nhấn gộp bàn
function gopBan(){
	var lstBan1 = document.getElementsByName('checkbox-gopban-ban1');
	var ban2 = document.getElementById('select-gopban2').value;

	//Lấy mảng các bàn check
	var arr = new Array();

	//Lấy bàn checked
	for(var i = 0; i< lstBan1.length; i++){
		if(lstBan1[i].checked === true){
			arr.push(lstBan1[i]); //lstBan1[i].value
		}
	}
	if(arr.length == 0){
		alert('Bạn chưa chọn bàn cần gộp!');
		return;
	}

	requestGopBan(arr,ban2,0);
};


function requestGopBan(lstBan1,maBan2, vitri){
	//Nếu vị trí nhỏ hơn độ lớn mảng
	if(vitri < lstBan1.length){

		var maBan1 = lstBan1[vitri].value;
		var xmlhttp = new XMLHttpRequest();
		xmlhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				requestGopBan(lstBan1, maBan2, vitri+1);
				if(vitri==0){
					$('.modal').modal('hide');
					clickMenu('ban');
				}
				if(document.getElementById(maBan1)!=null){
					document.getElementById(maBan1).className = "badge bg-green";
					document.getElementById(maBan1).innerHTML = "Trống";
				}
				return;
			}
		};

		xmlhttp.open("GET", "BanHang_Action?gopban="+maBan1 +"&ban2=" + maBan2, true);
		xmlhttp.send();
	}else return;	
};




//Nhấn Chuyển bàn
function chuyenBan(){
	var maBan = layMaBanDangChon();
	var banChuyenDen = document.getElementById('select-chuyenban').value;

	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			$('.modal').modal('hide');
			clickMenu('ban');
		}
	};

	xmlhttp.open("GET", "BanHang_Action?chuyenban="+maBan +"&banchuyenden=" + banChuyenDen, true);
	xmlhttp.send();
};

//Load dữ liệu modal tách bàn
function loadTachBan() {
	var maBan = layMaBanDangChon();
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("content-tachban").innerHTML = this.responseText;
			//
			//
		}
	};

	xmlhttp.open("GET", "BanHang_LoadModal?modal=tachban&maban=" + maBan, true);
	xmlhttp.send();
};

//Load dữ liệu modal gộp bàn
function loadGopBan() {
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("content-gopban").innerHTML = this.responseText;
			//
			//
		}
	};

	xmlhttp.open("GET", "BanHang_LoadModal?modal=gopban", true);
	xmlhttp.send();
};


//Load dữ liệu modal chuyển bàn
function loadChuyenBan() {
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("content-chuyenban").innerHTML = this.responseText;
			//
			setTenBanVaoID('modal-tenban');
		}
	};

	xmlhttp.open("GET", "BanHang_LoadModal?modal=chuyenban", true);
	xmlhttp.send();
};

//Nhấn btnThanhToan

function thanhToan(maBan) {
	//Hiển  thị form in
	inHoaDon("hoadonin");
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			//document.getElementById("content-chitiethoadon").innerHTML = null;
			//document.getElementById("lblTongTien").innerHTML = "Tổng tiền: &nbsp;0 &nbsp;VNĐ";
			//document.getElementById(maBan).innerHTML = 'Trống';
			//document.getElementById(maBan).className = 'badge bg-green';
			$('.modal').modal('hide');
			clickMenu('ban');
		}
	};

	xmlhttp.open("GET", "BanHang_Action?thanhtoan=" + maBan, true);
	xmlhttp.send();
};

//Set min giờ đặt bàn
function setMinGioDatBan(){
	let today = new Date().toISOString().substr(0, 10);
	var dateValue = document.getElementById("ngay").value;

	var time = new Date().toString().substr(16, 5);;

	if(today == dateValue) 
		document.getElementById("gio").min = time;
	else 
		document.getElementById("gio").min = "00:00";
};

//Nhấn btnDatBan
function datBan(){
	//set mã bàn đang chọn
	var maBan = layMaBanDangChon();
	document.getElementById("maBanFormDatBan").value = maBan;
	//set min value ngày đặt
	let today = new Date().toISOString().substr(0, 10);
	document.getElementById("ngay").min = today;
};
//Đặt bàn ajax
//function datban() {
//var maBan = layMaBanDangChon();
//var tenKH = document.getElementById("tenKH").value;
//var sdt = document.getElementById("sdt").value;
//var ngay = document.getElementById("ngay").value;
//var gio = document.getElementById("gio").value;

//if (tenKH == "" || sdt == "" || ngay == "" || gio == "")
//return;

//var xmlhttp = new XMLHttpRequest();
//xmlhttp.onreadystatechange = function() {
//if (this.readyState == 4 && this.status == 200) {
////ẩn modal
//$('.modal').modal('hide');
//clickMenu('ban');
//}
//};

//xmlhttp.open("GET", "BanHang_Action?datban=" + maBan + "&tenKH="
//+ tenKH + "&sdt=" + sdt + "&ngay=" + ngay + "&gio=" + gio,
//true);
//xmlhttp.send();
//};

//Nhấn có trong hủy bàn
function huyban() {
	var maBan = layMaBanDangChon();

	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			//ẩn modal
			$('.modal').modal('hide');
			clickMenu('ban');
		}
	};

	xmlhttp.open("GET", "BanHang_Action?huyban=" + maBan, true);
	xmlhttp.send();
};

///Chọn bàn, thực đơn, tìm kiếm

//Chọn bàn
function chonBan(id) {
	//xử lí btn
	if (document.getElementById(id) != null) {
		//Nếu bàn trống thì disable btnHuyBan 
		if (document.getElementById(id).innerHTML != 'Trống') {
			document.getElementById("btnHuyBan").disabled = false;

			document.getElementById("btnChuyenBan").disabled = false;

			if (document.getElementById(id).innerHTML == 'Đã đặt') {
				document.getElementById("btnThanhToan").disabled = true;
				document.getElementById("btnTachBan").disabled = true;
			} else {
				document.getElementById("btnThanhToan").disabled = false;
				document.getElementById("btnTachBan").disabled = false;
			}

		} else {
			document.getElementById("btnHuyBan").disabled = true;
			document.getElementById("btnThanhToan").disabled = true;
			document.getElementById("btnChuyenBan").disabled = true;
			document.getElementById("btnTachBan").disabled = true;
		}

		//Nếu bàn đang sử dụng thì disable btnDatBan
		if (document.getElementById(id).innerHTML != 'Trống')
			document.getElementById("btnDatBan").disabled = true;
		else
			document.getElementById("btnDatBan").disabled = false;
	}

	//set ID bàn vào textbox ẩn
	document.getElementById("maban-hidden").value = id;
	//set ten ban vao lblTenBan
	if (document.getElementById(id + "tenBan") != null)
		document.getElementById("lblTenBan").innerHTML = document
		.getElementById(id + "tenBan").innerHTML;

	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("content-chitiethoadon").innerHTML = this.responseText;

			//load xong, set Tổng tiền vào lblTongTien
			var tongtien = 0;
			if (document.getElementById("tongtien-hidden") != null)
				tongtien = document.getElementById("tongtien-hidden").value;

			document.getElementById("lblTongTien").innerHTML = "Tổng tiền: &nbsp;"
				+ number_format(tongtien, 0, '.', ',')
				+ " &nbsp;VNĐ";

			//Ktra xem đang ở thực đơn hay danh sách bàn
			if (document.getElementById("isThucDon") == null
					&& document.getElementById(id).innerHTML != 'Đã đặt') {
				//Chuyển sang thực đơn nếu checked = true
				if (document.getElementById("checkChuyenSangChonMon").checked === true)
					clickMenu('thucdon');
			}

		}
	};

	xmlhttp.open("GET", "BanHang_ChonBan?maban=" + id, true);
	xmlhttp.send();
};

//Giống chọn bàn - Nhưng k ktra checkbox chọn thực đơn 
function chonLaiBan(id) {
	//xử lí btn
	if (document.getElementById(id) != null) {
		//Nếu bàn trống thì disable btnHuyBan 
		if (document.getElementById(id).innerHTML != 'Trống') {
			document.getElementById("btnHuyBan").disabled = false;

			document.getElementById("btnChuyenBan").disabled = false;

			if (document.getElementById(id).innerHTML == 'Đã đặt') {
				document.getElementById("btnThanhToan").disabled = true;
				document.getElementById("btnTachBan").disabled = true;
			} else {
				document.getElementById("btnThanhToan").disabled = false;
				document.getElementById("btnTachBan").disabled = false;
			}

		} else {
			document.getElementById("btnHuyBan").disabled = true;
			document.getElementById("btnThanhToan").disabled = true;
			document.getElementById("btnChuyenBan").disabled = true;
			document.getElementById("btnTachBan").disabled = true;
		}

		//Nếu bàn đang sử dụng thì disable btnDatBan
		if (document.getElementById(id).innerHTML != 'Trống')
			document.getElementById("btnDatBan").disabled = true;
		else
			document.getElementById("btnDatBan").disabled = false;
	}

	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("content-chitiethoadon").innerHTML = this.responseText;

			//load xong, set Tổng tiền vào lblTongTien
			var tongtien = 0;
			if (document.getElementById("tongtien-hidden") != null)
				tongtien = document.getElementById("tongtien-hidden").value;

			document.getElementById("lblTongTien").innerHTML = "Tổng tiền: &nbsp;"
				+ number_format(tongtien, 0, '.', ',')
				+ " &nbsp;VNĐ";

		}

	}

	xmlhttp.open("GET", "BanHang_ChonBan?maban=" + id, true);
	xmlhttp.send();
};

//Chọn thực đơn
function chonThucDon(maMon) {
	var maban = layMaBanDangChon();

	if (maban == null || maban == "") {
		alert('Bạn cần chọn bàn!');
		return;
	} else if (document.getElementById('checkBanDaDat') != null) {
		alert('Bàn đã có người khác đặt!');
		return;
	}

	//
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("content-chitiethoadon").innerHTML = this.responseText;
			//load xong, set Tổng tiền vào lblTongTien
			var tongtien = document.getElementById("tongtien-hidden").value;

			document.getElementById("lblTongTien").innerHTML = "Tổng tiền: &nbsp;"
				+ number_format(tongtien, 0, '.', ',')
				+ " &nbsp;VNĐ";

			document.getElementById("btnChuyenBan").disabled = false;
			document.getElementById("btnThanhToan").disabled = false;
			document.getElementById("btnTachBan").disabled = false;
			document.getElementById("btnHuyBan").disabled = false;
			document.getElementById("btnDatBan").disabled = true;

		}
	};

	xmlhttp.open("GET", "BanHang_ChonMon?mamon=" + maMon + "&maban="
			+ maban, true);
	xmlhttp.send();
};

//Sau khi load trang thì disable các button
function loadTrang() {
	document.getElementById("btnThanhToan").disabled = true;
	document.getElementById("btnChuyenBan").disabled = true;
	document.getElementById("btnTachBan").disabled = true;
	document.getElementById("btnHuyBan").disabled = true;
	document.getElementById("btnDatBan").disabled = true;
};

//Click menu bàn hay thực đơn
function clickMenu(menu) {
	if (menu == 'ban' || menu == 'thucdon') {

		var xmlhttp = new XMLHttpRequest();
		xmlhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				document.getElementById("content-ban-thucdon").innerHTML = this.responseText;

				if(menu == 'ban'){
					document.getElementById("btnBan").className = "btn-ban-thucdon btn-ban-thucdon-active";
					document.getElementById("btnThucDon").className  = "btn btn-block btn-primary btn-flat btn-ban-thucdon";
				}else{
					document.getElementById("btnThucDon").className = "btn-ban-thucdon btn-ban-thucdon-active";
					document.getElementById("btnBan").className  = "btn btn-block btn-primary btn-flat btn-ban-thucdon";
				}


				if (layMaBanDangChon() != null)
					chonLaiBan(layMaBanDangChon());
			}
		};

		xmlhttp.open("GET", "BanHang_Menu?menu=" + menu, true);
		xmlhttp.send();
	}

};

//Tìm kiếm món ăn 
function searchthucdon(key) {
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("content-ban-thucdon").innerHTML = this.responseText;
		}
	};

	xmlhttp.open("GET", "BanHang_Menu?key=" + key, true);
	xmlhttp.send();
};

////Nhóm chi tiết hóa đơn

//Xóa chi tiết hóa đơn
function xoaChiTietHoaDon(maCTHD) {
	var maban = document.getElementById('maban-hidden').value;
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {

			/// load lại danh sách đã chọn
			var xmlhttp1 = new XMLHttpRequest();
			xmlhttp1.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					document.getElementById("content-chitiethoadon").innerHTML = this.responseText;

					//load xong, set Tổng tiền vào lblTongTien
					var tongtien = document
					.getElementById("tongtien-hidden").value;

					document.getElementById("lblTongTien").innerHTML = "Tổng tiền: &nbsp;"
						+ number_format(tongtien, 0, '.', ',')
						+ " &nbsp;VNĐ";
				}
			};

			xmlhttp1
			.open("GET", "BanHang_ChonBan?maban=" + maban, true);
			xmlhttp1.send();
			///
		}
	};
	xmlhttp.open("GET", "BanHang_Action?xoacthd=" + maCTHD, true);
	xmlhttp.send();
};

//Thay đổi số lượng của món
function thayDoiSoLuongCTHD(soLuongMoi, maChiTietHoaDon) {
	if(soLuongMoi < 1){
		alert('Số lượng phải lớn hơn 0 và không được để trống!');
		return;
	}else if(soLuongMoi > 1000){
		alert('Số lượng quá lớn!');
		return;
	}
	var maban = document.getElementById('maban-hidden').value;
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {

			/// load lại danh sách đã chọn
			var xmlhttp1 = new XMLHttpRequest();
			xmlhttp1.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					document.getElementById("content-chitiethoadon").innerHTML = this.responseText;

					//load xong, set Tổng tiền vào lblTongTien
					var tongtien = document
					.getElementById("tongtien-hidden").value;

					document.getElementById("lblTongTien").innerHTML = "Tổng tiền: &nbsp;"
						+ number_format(tongtien, 0, '.', ',')
						+ " &nbsp;VNĐ";
				}
			};

			xmlhttp1
			.open("GET", "BanHang_ChonBan?maban=" + maban, true);
			xmlhttp1.send();
			///
		}
	};

	xmlhttp.open("GET", "BanHang_Action?thaysoluong=" + maChiTietHoaDon
			+ "&soluong=" + soLuongMoi, true);
	xmlhttp.send();
};

//In hóa đơn
function inHoaDon(divName) {
	var printContents = document.getElementById(divName).innerHTML;
	w = window.open();
	w.document.write(printContents);
	w.print();
	w.close();
};

/// Nhóm support
//Lấy mã bàn đang chọn
function layMaBanDangChon() {
	if (document.getElementById("maban-hidden") != null)
		return document.getElementById("maban-hidden").value;
	return null;
};
/// Khác

//format tiền
function number_format(number, decimals, dec_point, thousands_sep) {
	// http://kevin.vanzonneveld.net
	// + original by: Jonas Raoni Soares Silva (http://www.jsfromhell.com)
	// + improved by: Kevin van Zonneveld (http://kevin.vanzonneveld.net)
	// + bugfix by: Michael White (http://crestidg.com)
	// + bugfix by: Benjamin Lupton
	// + bugfix by: Allan Jensen (http://www.winternet.no)
	// + revised by: Jonas Raoni Soares Silva (http://www.jsfromhell.com)
	// * example 1: number_format(1234.5678, 2, '.', '');
	// * returns 1: 1234.57

	var n = number, c = isNaN(decimals = Math.abs(decimals)) ? 2
			: decimals;
	var d = dec_point == undefined ? "," : dec_point;
	var t = thousands_sep == undefined ? "." : thousands_sep, s = n < 0 ? "-"
			: "";
	var i = parseInt(n = Math.abs(+n || 0).toFixed(c)) + "", j = (j = i.length) > 3 ? j % 3
			: 0;

	return s + (j ? i.substr(0, j) + t : "")
	+ i.substr(j).replace(/(\d{3})(?=\d)/g, "$1" + t)
	+ (c ? d + Math.abs(n - i).toFixed(c).slice(2) : "");
};
//chặn submit form
function chanSubmit() {
	return false;
};
//lấy tên bàn từ lbl tên bàn(lúc đã chọn bàn rồi)
function layTenBan(){
	return document.getElementById("lblTenBan").innerHTML;
};
//gán tên bàn vào id
function setTenBanVaoID(id){
	if(document.getElementById(id)!=null)
		document.getElementById(id).innerHTML=layTenBan();
};