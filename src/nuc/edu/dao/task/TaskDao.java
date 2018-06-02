package nuc.edu.dao.task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import nuc.edu.dbbase.DbBase;
import nuc.edu.entity.Student;
import nuc.edu.entity.Task;

public class TaskDao {
	private Student stu = new Student();
	
	private DbBase db = new DbBase();
	Connection conn = db.getConnection();
	PreparedStatement pst = null;
	
	/**
	 * ���뵽�������(task��t_id,task_url��ֵ)
	 * ����ֵ��int����
	 * */
	public int  InsertTask(Task task) {
		int result = 0;
		try {
			String sql = "insert into task (t_id, task_url) values(?,?)";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, task.getT_id());
			pst.setString(2,task.getTask_url());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("2");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * ��ѯ��ʦ���з���������
	 * ����ֵ��List<Task>
	 * */
	public List<Task> QueryTask(){
		List<Task> list = new ArrayList<Task>();
		
		try {
			String sql = "select * from task";
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Task task = new Task();
				task.setT_id(rs.getInt("t_id"));
				task.setTask_id(rs.getInt("task_id"));
				task.setTask_url(rs.getString("task_url"));
				list.add(task);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * ͨ��id��ѯ��ʦ����������
	 * ����ֵ��Task����
	 * */
	public Task SelectOneTaskById(int id) {
		Task task = new Task();
		try {
			String sql = "Select * from task where task_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				task.setT_id(rs.getInt("t_id"));
				task.setTask_id(rs.getInt("task_id"));
				task.setTask_url(rs.getString("task_url"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return task;
	}
	
	
	/**
	 * ɾ����ʦ����������ͨ��(id)
	 * ����ֵ��int����
	 * */
	public int delTask(int id) {
		int rs = 0;
		
		try {
			String sql = "delete from task where task_id = ? ";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * �޸���ʦ����������ͨ��(id)
	 * ����ֵ��int
	 * */
	public int updateTask(Task task) {
		int rs = 0;
		
		try {
			String sql = "update task set t_id = ? ,task_url=? where t_id=?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, task.getT_id());
			pst.setString(2, task.getTask_url());
			pst.setInt(3, task.getT_id());
			rs = pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
