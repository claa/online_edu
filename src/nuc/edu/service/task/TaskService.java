package nuc.edu.service.task;

import java.util.ArrayList;
import java.util.List;

import nuc.edu.dao.task.TaskDao;
import nuc.edu.dao.task.TeacherDao;
import nuc.edu.entity.ShowTask;
import nuc.edu.entity.Task;
import nuc.edu.util.String_Method;

public class TaskService {
	TaskDao tDao = new TaskDao();
	
	
	public int addTask(Task task) {
		int rs = 0;
		rs = tDao.InsertTask(task);
		return rs;
	}
	
	
	public List<ShowTask> querryTask(){
		
		List<ShowTask> s_list = new ArrayList<ShowTask>();
		List<Task> t_list = new ArrayList<Task>();
		t_list = tDao.QueryTask();
		
		for(Task t:t_list) {
			ShowTask st = new ShowTask();
			st.setT_id(t.getT_id());
			TeacherDao tDao = new TeacherDao();
			st.setT_username(tDao.getTeacher_Name(t.getT_id()));
			st.setTask_id(t.getTask_id());
			st.setTask_url(t.getTask_url());
			st.setTask_name(String_Method.getFileName(t.getTask_url()));
			s_list.add(st);
		}
	
		
		return s_list;
	}
	
	
	
	
	
	
	
	
	
	public static void Insert() {
		Task task = new Task();
		TaskDao tDao = new TaskDao();
		task.setT_id(33);
		task.setTask_url("c:\\sf\\sd");
		tDao.InsertTask(task);
	}
	
	
	
	
	public static void main(String args[]) {
		Insert();
	}
}
