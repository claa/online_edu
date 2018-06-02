package nuc.edu.dao.post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nuc.edu.conn.Conn;
import nuc.edu.entity.Academy;

public class AllAcademyDaoImpl implements AllAcademyDao {
	
	private Connection conn = Conn.getConn();
	
	public List<Academy> selectAllAcademy() {
		// TODO Auto-generated method stub
		List<Academy> academys = new ArrayList<Academy>();
		String sql = "select * from academy";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				Academy academy = new Academy();
				academy.setAcademy_id(rs.getInt("academy_id"));
				academy.setAcademy_name(rs.getString("academy_name"));
				academys.add(academy);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return academys;
	}
	
}
