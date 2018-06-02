package nuc.edu.entity;

public class ShowTask {
	 private String t_username;//老师姓名
	 private int t_id;//老师id 
	 private int task_id;//老师下发任务的id
	 private String task_url;//任务链接
	 private String task_name; //任务名称
	public String getT_username() {
		return t_username;
	}
	public void setT_username(String t_username) {
		this.t_username = t_username;
	}
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public int getTask_id() {
		return task_id;
	}
	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}
	public String getTask_url() {
		return task_url;
	}
	public void setTask_url(String task_url) {
		this.task_url = task_url;
	}
	public String getTask_name() {
		return task_name;
	}
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
	 
	 
	 
	 
}
