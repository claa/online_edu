package nuc.edu.dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nuc.edu.coon.DBUtil;
import nuc.edu.entity.Major;
import nuc.edu.entity.Student;

public class StudentDao implements AdminDaoImpl<Student> {
	private Connection coon = DBUtil.getCoon();
	private PreparedStatement pst = null;
	MajorDao major = new MajorDao();
	
	String sql = null;
	public int Insert(Student obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int Delete(Student obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Student> findAll(int start) {
		// TODO Auto-generated method stub
		List<Student> students = new ArrayList<Student>();
		ResultSet rs = null;
		sql = "select * from student limit ?,?";
		try {
			pst = coon.prepareStatement(sql);
			pst.setInt(1, (start-1)*10);
			pst.setInt(2, 10);
			rs = pst.executeQuery();
			Student student = null;
			while(rs.next()) {
				student = new Student();
				student.setS_username(rs.getString(2));
				student.setS_id(rs.getInt(1));
				student.setS_no(rs.getString(3));
				student.setS_Email(rs.getString(5));
				student.setMajorname((major.findByName(rs.getInt(8))).getMajor_name());
				students.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}

	public Student findById(Student obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Student Update(Student obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Student> findOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Student> findTopPost() {
		// TODO Auto-generated method stub
		return null;
	}

}
