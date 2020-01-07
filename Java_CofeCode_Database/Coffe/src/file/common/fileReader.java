package fpt.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import fpt.model.bean.HangBanChay;
import fpt.model.bean.HoaDon;
import fpt.model.bean.NhapXuat;

public class fileReader {
	public boolean kiemTraFile(String file){
		File out = new File(file);
		if(out.exists())
			return false;
		return true;
	}
	public void xuatFileNhapXuat(String filename, String loaiFile, ArrayList<NhapXuat> arrNhapXuat){
		InputStreamReader cin = new InputStreamReader(System.in);
		if("excel".equals(loaiFile)){
			try {
				FileWriter out = new FileWriter("E:/OneDrive/Projects/Java_FPT/Coffe_FPT_Group01/ThongKeBaoCao/"+filename+".csv");
				out.write("MaNhapXuat, NgayNhap, NgayXuat, SoLuong, DonGia, MaNguyenLieu");
				out.write("\n");
				for(int i = 0; i < arrNhapXuat.size(); i++){
					String line = arrNhapXuat.get(i).getMaNhapXuat()+","+arrNhapXuat.get(i).getNgayNhap()+","+arrNhapXuat.get(i).getNgayXuat()+","+arrNhapXuat.get(i).getSoLuong()+","+arrNhapXuat.get(i).getDonGia()+","+arrNhapXuat.get(i).getMaNguyenLieu();
					out.write(line);
					out.write("\n");
				}
				out.close();
				cin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if("txt".equals(loaiFile)){
			try {
				FileWriter out = new FileWriter("E:/OneDrive/Projects/Java_FPT/Coffe_FPT_Group01/ThongKeBaoCao/"+filename+".txt");
				out.write("MaNhapXuat, NgayNhap, NgayXuat, SoLuong, DonGia, MaNguyenLieu\r\n");
				for(int i = 0; i < arrNhapXuat.size(); i++){
					String line = arrNhapXuat.get(i).getMaNhapXuat()+","+arrNhapXuat.get(i).getNgayNhap()+","+arrNhapXuat.get(i).getNgayXuat()+","+arrNhapXuat.get(i).getSoLuong()+","+arrNhapXuat.get(i).getDonGia()+","+arrNhapXuat.get(i).getMaNguyenLieu()+"\r\n";
					out.write(line);
				}
				out.close();
				cin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void xuatFileHoaDon(String filename, String loaiFile, ArrayList<HoaDon> arrHoaDon){
		InputStreamReader cin = new InputStreamReader(System.in);
		if("excel".equals(loaiFile)){
			try {
				FileWriter out = new FileWriter("E:/OneDrive/Projects/Java_FPT/Coffe_FPT_Group01/ThongKeBaoCao/"+filename+".csv");
				out.write("MaHD, MaNV, MaBan, NgayBan, ThanhTien");
				out.write("\n");
				for(int i = 0; i < arrHoaDon.size(); i++){
					String line = arrHoaDon.get(i).getMaHD()+","+arrHoaDon.get(i).getMaNV()+","+arrHoaDon.get(i).getMaBan()+","+arrHoaDon.get(i).getNgayBan()+","+arrHoaDon.get(i).getThanhTien();
					out.write(line);
					out.write("\n");
				}
				out.close();
				cin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if("txt".equals(loaiFile)){
			try {
				FileWriter out = new FileWriter("E:/OneDrive/Projects/Java_FPT/Coffe_FPT_Group01/ThongKeBaoCao/"+filename+".txt");
				out.write("MaHD, MaNV, MaBan, NgayBan, ThanhTien\r\n");
				for(int i = 0; i < arrHoaDon.size(); i++){
					String line = arrHoaDon.get(i).getMaHD()+","+arrHoaDon.get(i).getMaNV()+","+arrHoaDon.get(i).getMaBan()+","+arrHoaDon.get(i).getNgayBan()+","+arrHoaDon.get(i).getThanhTien()+"\r\n";
					out.write(line);
				}
				out.close();
				cin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void xuatFileHangBanChay(String filename, String loaiFile,ArrayList<HangBanChay> arrHangBanChay) {
		InputStreamReader cin = new InputStreamReader(System.in);
		if("excel".equals(loaiFile)){
			try {
				FileWriter out = new FileWriter("E:/OneDrive/Projects/Java_FPT/Coffe_FPT_Group01/ThongKeBaoCao/"+filename+".csv");
				out.write("TenMon, NgayBan, SoLuong");
				out.write("\n");
				for(int i = 0; i < arrHangBanChay.size(); i++){
					String line = arrHangBanChay.get(i).getTenMon()+","+arrHangBanChay.get(i).getNgayBan()+","+arrHangBanChay.get(i).getSoLuongMua();
					out.write(line);
					out.write("\n");
				}
				out.close();
				cin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if("txt".equals(loaiFile)){
			try {
				FileWriter out = new FileWriter("E:/OneDrive/Projects/Java_FPT/Coffe_FPT_Group01/ThongKeBaoCao/"+filename+".txt");
				out.write("TenMon, NgayBan, SoLuong\r\n");
				for(int i = 0; i < arrHangBanChay.size(); i++){
					String line = arrHangBanChay.get(i).getTenMon()+","+arrHangBanChay.get(i).getNgayBan()+","+arrHangBanChay.get(i).getSoLuongMua()+"\r\n";
					out.write(line);
				}
				out.close();
				cin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
//	public static void main(String[] args) {
//		fileReader f = new fileReader();
//		ArrayList<HangBanChay> arrHangBanChay = new ArrayList<>();
//		ArrayList<HoaDon> arrHoaDon = new ArrayList<>();
//		arrHoaDon.add(new HoaDon(1001, "NV1", "B1", new Timestamp(arg0), 1, 30000));
//		arrHangBanChay.add(new HangBanChay("Ca phe", new Date("8/20/2014"), 12));
//		arrHoaDon.add(new HoaDon(1, "NV1", "MB1", new Date("8/20/2014"), 30000));
//		arrHoaDon.add(new HoaDon(2, "NV2", "MB2", new Date("8/22/2014"), 32000));
//		f.xuatFileHangBanChay("txt", arrHangBanChay);
//	}
}
