package nuc.edu.action.task;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import nuc.edu.entity.ShowTask;
import nuc.edu.entity.Task;
import nuc.edu.service.task.TaskService;

public class QuerryAction extends ActionSupport {

	private List<ShowTask> t_list = new ArrayList<ShowTask>();
	
	

	public List<ShowTask> getT_list() {
		return t_list;
	}



	public void setT_list(List<ShowTask> t_list) {
		this.t_list = t_list;
	}



	/*
	 * 展示老师发布任务
	 * */
	public String querry() {
		
		TaskService tservice = new TaskService();
		
		t_list=tservice.querryTask();
		
		return "querryOK";
	}
}
