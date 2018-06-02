package nuc.edu.dao.post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import nuc.edu.conn.Conn;
import nuc.edu.entity.Student;
import nuc.edu.entity.Teacher;

public class LoginDaoImpl implements LoginDao {

	private Connection conn = Conn.getConn();
	
	
	public Student StudentLogin(Student student) {
		Student st = new Student();
		String sql = "select * from student where s_no=? and s_password=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, student.getS_no());
			pst.setString(2, student.getS_password());
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				st.setS_id(rs.getInt("s_id"));
				st.setS_username(rs.getString("s_username"));
				st.setS_no(rs.getString("s_no"));
				st.setS_password(rs.getString("s_password"));
				st.setS_Email(rs.getString("s_Email"));
				st.setS_rank(rs.getString("s_rank"));
				st.setS_sign(rs.getInt("s_sign"));
				st.setS_major(rs.getInt("s_major"));
			}else{
				st = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
	}
	public Teacher teacherLogin(Teacher teacher) {
		Teacher tec = new Teacher();
		String sql = "select * from teacher where t_no=? and t_password=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, teacher.getT_no());
			pst.setString(2, teacher.getT_password());
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				tec.setT_id(rs.getInt("t_id"));
				tec.setT_username(rs.getString("t_username"));
				tec.setT_no(rs.getString("t_no"));
				tec.setT_password(rs.getString("t_password"));
				tec.setT_Email(rs.getString("t_Email"));
				tec.setT_introduce(rs.getString("t_introduce"));
				tec.setT_sign(rs.getInt("t_sign"));
				tec.setT_major(rs.getInt("t_major"));
				tec.setCourse_id(rs.getShort("course_id"));
			}else{
				tec=null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tec;
	}

}
