/**
 * 
 */
package nuc.edu.dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nuc.edu.coon.DBUtil;
import nuc.edu.entity.Major;
import nuc.edu.entity.Teacher;

/**实现管理员对老师的处理
 * @author TaoXu
 *
 */
public class TeacherDao implements AdminDaoImpl<Teacher> {
    private Connection coon = DBUtil.getCoon();
    private PreparedStatement pst = null;
    String sql = null;

	//添加老师 通过字符到major表中获的major_id
	public int Insert(Teacher obj,Major obj2) {
		// TODO Auto-generated method stub
		int rs = 0;
		sql="insert into teacher (t_username,t_no,t_Email,t_introduce,t_major) values (?,?,?,?,?)";
		try {
			pst = coon.prepareStatement(sql);
			pst.setString(1, obj.getT_username());
			pst.setString(2, obj.getT_no());
			pst.setString(3, obj.getT_Email());
			pst.setString(4, obj.getT_introduce());
			pst.setInt(5, obj2.getMajor_id());
			rs = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	//删除老师
	public int Delete(Teacher obj) {
		// TODO Auto-generated method stub
		int rs = 0;
		sql = "delete from teacher where t_id = ?";
		try {
			pst = coon.prepareStatement(sql);
			pst.setInt(1, obj.getT_id());
			rs = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
    
	//查看老师信息
	public List<Teacher> findAll(int start) {
		// TODO Auto-generated method stub
		List<Teacher> teachers = new ArrayList<Teacher>();
		ResultSet rs =null;
		sql = "select * from teacher limit ?,?";
		try {
			pst =coon.prepareStatement(sql);
			pst.setInt(1, (start-1)*10);
			pst.setInt(2, 10);
			rs = pst.executeQuery();
			Teacher teacher = null;
			while(rs.next()) {
				teacher = new Teacher();
				teacher.setT_id(rs.getInt(1));
				teacher.setT_username(rs.getString(2));
				teacher.setT_Email(rs.getString(5));
				teacher.setT_introduce(rs.getString(6));
				teachers.add(teacher);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teachers;
	}
    
	//根据id查找老师
	public Teacher findById(Teacher obj) {
		// TODO Auto-generated method stub
		 ResultSet rs =null;
		 Teacher	teacher = null; 
		sql = " select * from teacher where t_id = ?";
		try {
			pst = coon.prepareStatement(sql);
			pst.setInt(1, obj.getT_id());
			rs = pst.executeQuery();
		   
			if(rs.next()) {
				teacher = new Teacher();
				teacher.setT_id(rs.getInt(1));
				teacher.setT_username(rs.getString(2));
				teacher.setT_no(rs.getString(3));
				teacher.setT_Email(rs.getString(5));
				teacher.setT_introduce(rs.getString(6));
				teacher.setT_major(rs.getInt(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teacher;
	}

	
	public int Update(Teacher obj,Major obj2) {
		// TODO Auto-generated method stub
		int rs = 0;
		sql="update teacher set t_username=? , t_no = ?, t_Email = ? ,t_introduce = ? ,t_major = ? where t_id = ?";
		try {
			pst = coon.prepareStatement(sql);
			pst.setString(1, obj.getT_username());
			pst.setString(2, obj.getT_no());
			pst.setString(3, obj.getT_Email());
			pst.setString(4, obj.getT_introduce());
			pst.setInt(5, obj2.getMajor_id());
			pst.setInt(6, obj.getT_id());
			rs = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public List<Teacher> findOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Teacher> findTopPost() {
		// TODO Auto-generated method stub
		return null;
	}

	public int Insert(Teacher obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Teacher Update(Teacher obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
