package nuc.edu.dao.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import nuc.edu.coon.DBUtil;

public class LoginDao implements LoginDaoImpl {
    private Connection coon =DBUtil.getCoon();
    private PreparedStatement pst = null;
    private ResultSet rs =null;
    String sql=null;
   
	public ResultSet find(String no, String pass, String type) {
		// TODO Auto-generated method stub
		if(type.equals("学生")) {
			 sql = "select * from student where s_no=? and s_password=? ";
		}else if(type.equals("教师")) {
			 sql = "select * from teacher where t_no=? and t_password=? ";
		}else if(type.equals("管理员")) {
			 sql = "select * from admin where admin_username=? and admin_password=?";
		}
		try {
			pst = coon.prepareStatement(sql);
			pst.setString(1, no);
			pst.setString(2, pass);
			rs=pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet getPass(String no, String name, String type, String email) {
		// TODO Auto-generated method stub
		if(type.equals("学生")) {
			 sql = "select s_password from student where s_no=? and s_username=? and s_Email=? ";
		}else if(type.equals("教师")) {
			 sql = "select t_password from teacher where t_no=? and t_username=? and t_Email=? ";
		}
		try {
			pst = coon.prepareStatement(sql);
			pst.setString(1, no);
			pst.setString(2, name);
			pst.setString(3, email);
			rs=pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
