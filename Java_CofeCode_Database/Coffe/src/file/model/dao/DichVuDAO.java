package fpt.model.dao;


/**
 * 
 * @author vTr
 *
 */
public class DichVuDAO extends _BaseDAO{
	/**
	 * 
	 * @param dichVu
	 * @return
	 */
//	public int taoMoiDichVu(DichVu dichVu){
//		String sql = "INSERT INTO dbo.DichVu (MaDV, TenDV, DonViTinh, DonGia) VALUES  (?,?,?,?)";
//		
//		try {
//			pstm = getConnection().prepareStatement(sql);
//			pstm.setString(1, dichVu.getMaDV());
//			pstm.setString(2, dichVu.getTenDV());
//			pstm.setString(3, dichVu.getDonViTinh());
//			pstm.setLong(4, dichVu.getDonGia());
//			return pstm.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return 0;
//		}
//	}
	
	/**
	 * 
	 * @return
	 */
//	public ArrayList<DichVu> getAllDichVu(){
//		rs = getTable("DichVu");
//
//		ArrayList<DichVu> lst = new ArrayList<>();
//		try {
//			while(rs.next()){
//				lst.add(new DichVu(rs.getString("maDV"), rs.getString("tenDV"), rs.getString("donViTinh"), rs.getLong("donGia")));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return lst;
//	}
}
