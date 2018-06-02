package nuc.edu.entity;

public class Task {
         private int task_id;//老师下发任务的id
         private int t_id;//老师的id
         private String task_url;//任务链接
		public int getTask_id() {
			return task_id;
		}
		public void setTask_id(int task_id) {
			this.task_id = task_id;
		}
		public int getT_id() {
			return t_id;
		}
		public void setT_id(int t_id) {
			this.t_id = t_id;
		}
		public String getTask_url() {
			return task_url;
		}
		public void setTask_url(String task_url) {
			this.task_url = task_url;
		}
}
