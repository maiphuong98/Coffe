package fpt.common;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import fpt.model.bean.NhanVien;

public class common {
	public static final String QUAN_TRI_VIEN = "Quản trị viên";
	public static final String NHAN_VIEN = "Nhân viên";

	//hiển thị thời khoảng thời gian cách giữa datestart vs hiện tại
	public String tinhThoiGianGiua2Ngay(Date dateStart){	
        // Custom date format
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date d1 = null;
        Date d2 = null;
        String stringDateStart = "";
        try {
        	stringDateStart = format.format(dateStart.getTime());
            d1 = format.parse(format.format(dateStart));
            d2 = format.parse(format.format(new Date()));
            
        } catch (ParseException e) {
        	return stringDateStart;
        }
        // Get msec from each, and subtract.
       
        
        long diff = d2.getTime() - d1.getTime();
//        long diffSeconds = diff / 1000;
        long diffMinutes = diff / (60 * 1000);
        long diffHours = diff / (60 * 60 * 1000);
        
        if(diffMinutes < 1) return "Vài giây trước";
        else if(diffHours < 1) return diffMinutes + " phút trước";
        else if(diffHours < 24) return diffHours + " giờ trước";
        else if(diffHours < 48) return "Hôm qua lúc " + dateStart.getHours() + ":" + dateStart.getMinutes();
		return stringDateStart;
	}
	
	/**
	 * CHuyển đổi định dang sang tiền việt
	 * @param tien
	 * @return
	 */
	public String fomatTien(long tien){
		DecimalFormat formatter = new DecimalFormat("###,###,###"); 
		 return formatter.format(tien);
	}
}
