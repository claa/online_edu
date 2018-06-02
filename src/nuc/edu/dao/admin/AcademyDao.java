package nuc.edu.dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import nuc.edu.coon.DBUtil;
import nuc.edu.entity.Academy;

/**
 * 对学院进行管理
 * @author TaoXu
 *
 */
public class AcademyDao {
	private Connection coon = DBUtil.getCoon();
	private PreparedStatement pst = null;
	
	Academy acadmy = null;
	String sql = null;
    
	//返回专业id
    public Academy  findById(String obj) {
    	ResultSet rs = null;
    	sql = "select academy_id from academy where academy_name = ?";
    	try {
			pst = coon.prepareStatement(sql);
			pst.setString(1, obj);
			rs = pst.executeQuery();
			if(rs.next()) {
				acadmy = new Academy();
				acadmy.setAcademy_id(rs.getInt(1));
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return acadmy;
    }
    
    
    //返回专业名称
    public Academy  findByName(int id) {
    	ResultSet rs = null;
    	sql = "select academy_name from academy where academy_id = ?";
    	try {
			pst = coon.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				acadmy = new Academy();
				acadmy.setAcademy_name(rs.getString(1));
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return acadmy;
    }
}
