package fpt.model.bo;

import fpt.model.bean.ThongTinDatBan;
import fpt.model.dao.DatBanDAO;

public class DatBanBO {
	DatBanDAO datBanDAO = new DatBanDAO();
	/**
	 * 
	 * @param maTTDB
	 * @param maBan
	 * @return
	 */
	public int chuyenThongTinDatBan(long maTTDB, String maBan){
		return datBanDAO.chuyenThongTinDatBan(maTTDB, maBan);
	}
	/**
	 * 
	 * @param thongTinDatBan
	 * @return
	 */
	public int addThongTinDatBan(ThongTinDatBan thongTinDatBan){
		return datBanDAO.addThongTinDatBan(thongTinDatBan);
	}

	/**
	 * 
	 * @param maBan
	 * @return
	 */
	public ThongTinDatBan getThongTinDatBan(String maBan){
		return datBanDAO.getThongTinDatBan(maBan);
	}
	
	/**
	 * 
	 * @param maBan
	 * @return
	 */
	public int deleteThongTinDatBan(String maBan){
		return datBanDAO.deleteThongTinDatBan(maBan);
	}
}
