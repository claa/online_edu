package nuc.edu.dao.forum;

import java.sql.Connection;
import java.sql.PreparedStatement;

import nuc.edu.conn.Conn;
import nuc.edu.entity.Teacher;
import java.sql.*;
public class TeacherDaoImpl implements TeacherDao{
	 public static Connection conn=Conn.getConn();
	public Teacher selectTeacherById(int t_id) {
		String sql="select * from teacher where t_id=?";
		ResultSet rs=null;
		Teacher t=new Teacher();
		try{
			 PreparedStatement pst=conn.prepareStatement(sql);
			 pst.setInt(1, t_id);
			 rs=pst.executeQuery();
			  if(rs.next()){
				  t.setT_username(rs.getString("t_username"));
			  }
		}catch(Exception e){
			 e.printStackTrace();
		}
		return t;
	}

}
