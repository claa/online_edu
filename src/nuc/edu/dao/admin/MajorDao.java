package nuc.edu.dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nuc.edu.coon.DBUtil;
import nuc.edu.entity.Academy;
import nuc.edu.entity.Major;
import nuc.edu.entity.Teacher;
/**
 * 对专业进行管理
 * @author TaoXu
 *
 */
public class MajorDao implements AdminDaoImpl<Major>{
    
	private Connection coon = DBUtil.getCoon();
	private PreparedStatement pst = null;
	AcademyDao academy = new AcademyDao();
	Major major = null;
	String sql = null;
    
	//返回专业id
    public Major  findById(String obj) {
    	ResultSet rs = null;
    	sql = "select major_id from major where major_name = ?";
    	try {
			pst = coon.prepareStatement(sql);
			pst.setString(1, obj);
			rs = pst.executeQuery();
			if(rs.next()) {
				major = new Major();
				major.setMajor_id(rs.getInt(1));
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return major;
    }
    
    
    //返回专业名称
    public Major  findByName(int id) {
    	ResultSet rs = null;
    	sql = "select major_name from major where major_id = ?";
    	try {
			pst = coon.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				major = new Major();
				major.setMajor_name(rs.getString(1));
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return major;
    }
    
    //添加专业信息
	public int Insert(Major obj) {
		// TODO Auto-generated method stub
		int rs = 0;
		sql="insert into major (major_name,academy_id) values (?,?)";
		try {
			pst = coon.prepareStatement(sql);
			pst.setString(1, obj.getMajor_name());
			pst.setInt(2, (academy.findById(obj.getAcademy())).getAcademy_id());
			rs = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}


	public int Delete(Major obj) {
		// TODO Auto-generated method stub
		int rs = 0;
		sql = "delete from major where major_id = ?";
		try {
			pst = coon.prepareStatement(sql);
			pst.setInt(1, obj.getMajor_id());
		    rs = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}


	public List<Major> findAll(int start) {
		// TODO Auto-generated method stub
		List<Major> majors = new ArrayList<Major>();
		ResultSet rs = null;
		
		sql = "select * from major limit ?,?";
		try {
			pst = coon.prepareStatement(sql);
			pst.setInt(1, (start-1)*10);
			pst.setInt(2, 10);
            rs = pst.executeQuery();
            Major major = null;
            while(rs.next()) {
            	major = new Major();
            	major.setMajor_id(rs.getInt(1));
            	major.setMajor_name(rs.getString(2));
            	major.setAcademy_id(rs.getInt(3));
            	major.setAcademy((academy.findByName(rs.getInt(3))).getAcademy_name());
            	majors.add(major);
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return majors;
	}


	public Major findById(Major obj) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		Major major = null;
		sql = "select * from major where major_id = ?";
		try {
			pst = coon.prepareStatement(sql);
			pst.setInt(1, obj.getMajor_id());
			rs = pst.executeQuery();
			if(rs.next()) {
				major = new Major();
				major.setAcademy_id(rs.getInt(1));
				major.setMajor_name(rs.getString(2));
            	major.setAcademy_id(rs.getInt(3));
            	major.setAcademy((academy.findByName(rs.getInt(3))).getAcademy_name());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	public int Updates(Major obj) {
		// TODO Auto-generated method stub
		int rs = 0;
		sql = "update major set major_name=? , academy_id=? where major_id = ?";
		try {
			pst = coon.prepareStatement(sql);
			pst.setString(1, obj.getMajor_name());
			pst.setInt(2, (academy.findById(obj.getAcademy())).getAcademy_id());
			pst.setInt(3,obj.getAcademy_id());
			rs = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}


	public List<Major> findOrder() {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Major> findTopPost() {
		// TODO Auto-generated method stub
		return null;
	}

	public Major Update(Major obj) {
		// TODO Auto-generated method stub
		return null;
	}

	
    
    
}
