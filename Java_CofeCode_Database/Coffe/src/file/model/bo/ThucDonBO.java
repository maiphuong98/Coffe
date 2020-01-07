package fpt.model.bo;

import java.util.ArrayList;

import fpt.model.bean.ThucDon;
import fpt.model.dao.ThucDonDAO;
/***
 * 
 * @author vTr
 *
 */
/**
 * 
 */

public class ThucDonBO {
	
	ThucDonDAO thucDonDAO = new ThucDonDAO();
	
	/**
	 * 
	 * @param maMon
	 * @return
	 */
	public boolean checkID(String maMon){
		return thucDonDAO.checkID(maMon);
	}
	/**
	 * 
	 * @param maMon
	 * @return
	 */
	public ThucDon getThucDon(String maMon){
		return thucDonDAO.getThucDon(maMon);
	}
	/**
	 * 
	 * @param maMon
	 * @return
	 */
	public int deleteThucDon(String maMon){
		return thucDonDAO.deleteThucDon(maMon);
	}
	
	/**
	 * 
	 * @param thucDon
	 * @return
	 */
	public int updateThucDon(ThucDon thucDon){
		return thucDonDAO.updateThucDon(thucDon);
	}
	/***
	 * 
	 * @return
	 */
	public ArrayList<ThucDon> getListThucDon() {
		return thucDonDAO.getListThucDon();
	}
	/**
	 * 
	 * @param key
	 * @return
	 */
	public ArrayList<ThucDon> getListThucDon(String key) {
		return thucDonDAO.getListThucDon(key);
	}
	/**
	 * 
	 * @param thucDon
	 * @return
	 */
	public int addThucDon(ThucDon thucDon){
		return thucDonDAO.addThucDon(thucDon);
	}
}
