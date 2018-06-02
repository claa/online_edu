package nuc.edu.dao.task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import nuc.edu.dbbase.DbBase;

public class TeacherDao {
	private DbBase db = new DbBase();
	Connection conn = db.getConnection();
	PreparedStatement pst = null;
	
	public String getTeacher_Name(int id) {
		String name = null;
		
		try {
			String sql = "Select * from teacher where t_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				name = rs.getString("t_username");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return name;
	}
	
}
