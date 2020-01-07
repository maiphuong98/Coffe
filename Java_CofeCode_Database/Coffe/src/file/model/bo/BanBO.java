package fpt.model.bo;

import java.util.ArrayList;

import fpt.model.bean.Ban;
import fpt.model.dao.BanDAO;

/***
 * 
 * @author vTr
 *
 */
public class BanBO {
	
	BanDAO banDAO = new BanDAO();
	
	/**
	 * 
	 * @param maBan
	 * @return
	 */
	public boolean checkID(String maBan){
		return banDAO.checkID(maBan);
	}
	/**
	 * 
	 * @param maBan
	 * @return
	 */
	public Ban getBan(String maBan) {
		return banDAO.getBan(maBan);
	}
	/***
	 * getList Bàn
	 * @return
	 */
	public ArrayList<Ban> getListBan() {
		return banDAO.getListBan();
	}
	
	/**
	 * 
	 * @param status
	 * @param maBan
	 * @return
	 */
	public int updateStatus(String status, String maBan){
		return banDAO.updateStatus(status, maBan);
	}
	
	/**
	 * 
	 * @param ban
	 * @return
	 */
	public int addBan(Ban ban){
		return banDAO.addBan(ban);
	}
	
	/**
	 * 
	 * @param ban
	 * @return
	 */
	public int updateBan(Ban ban){
		return banDAO.updateBan(ban);
	}
}
