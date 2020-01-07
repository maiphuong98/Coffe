package fpt.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertDate {
	public String convertDateMonthYear(String str){
		SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
		String[] temp = str.split("-");
		Date date = new Date(temp[1]+"/"+temp[2]+"/"+temp[0]);
		return fm.format(date);
	}
//	public static void main(String[] args) {
//		ConvertDate c = new ConvertDate();
//		System.out.println(c.convertDateMonthYear("2017-01-23"));
//	}
}
