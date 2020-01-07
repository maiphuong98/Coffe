package fpt.model.bean;

import java.util.Comparator;

/**
 * Ban bean
 * @author vTr
 *
 */
public class Ban {
	private String maBan;
	private String tenBan;
	private String trangThai;
	public String getMaBan() {
		return maBan;
	}
	public void setMaBan(String maBan) {
		this.maBan = maBan;
	}
	public String getTenBan() {
		return tenBan;
	}
	public void setTenBan(String tenBan) {
		this.tenBan = tenBan;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public Ban(String maBan, String tenBan, String trangThai) {
		super();
		this.maBan = maBan;
		this.tenBan = tenBan;
		this.trangThai = trangThai;
	}
	public Ban() {
		super();
	}
	
	public static Comparator<Ban> compare = new Comparator<Ban>() {

		@Override
		public int compare(Ban o1, Ban o2) {
			
			try {
				String[] s = o1.getTenBan().split("[ ]");
				String[] s1 = o2.getTenBan().split("[ ]");
				
				return Integer.parseInt(s[1]) > Integer.parseInt(s1[1]) ?  1 : -1;
				
			} catch (Exception e) {
				return o1.getTenBan().compareTo(o2.getTenBan());
			}
			
		}
	
	};
}
