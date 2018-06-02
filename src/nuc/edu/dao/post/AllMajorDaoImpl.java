package nuc.edu.dao.post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nuc.edu.conn.Conn;
import nuc.edu.entity.Major;

public class AllMajorDaoImpl implements AllMajorDao {
private Connection conn = Conn.getConn();
	
	public List<Major> selectAllMajor(int academy_id) {
		// TODO Auto-generated method stub
		List<Major> majors = new ArrayList<Major>();
		String sql = "select * from major where academy_id=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, academy_id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				Major major = new Major();
				major.setMajor_id(rs.getInt("major_id"));
				major.setMajor_name(rs.getString("major_name"));
				major.setAcademy_id(rs.getInt("academy_id"));
				majors.add(major);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return majors;
	}

}
