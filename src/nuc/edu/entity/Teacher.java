package nuc.edu.entity;

public class Teacher {
          private int t_id;//老师id 
          private String t_username;//老师姓名
          private String t_no;//教师号
          private String t_password;//教师密码
          private String t_Email;//老师邮箱
          private String t_introduce;//教师简介
          private  int t_sign;//教师标识 为1 
          private int t_major;//所属专业
          private int course_id;
		public int getT_id() {
			return t_id;
		}
		public void setT_id(int t_id) {
			this.t_id = t_id;
		}
		public String getT_username() {
			return t_username;
		}
		public void setT_username(String t_username) {
			this.t_username = t_username;
		}
		public String getT_no() {
			return t_no;
		}
		public void setT_no(String t_no) {
			this.t_no = t_no;
		}
		public String getT_password() {
			return t_password;
		}
		public void setT_password(String t_password) {
			this.t_password = t_password;
		}
		public String getT_Email() {
			return t_Email;
		}
		public void setT_Email(String t_Email) {
			this.t_Email = t_Email;
		}
		public String getT_introduce() {
			return t_introduce;
		}
		public void setT_introduce(String t_introduce) {
			this.t_introduce = t_introduce;
		}
		public int getT_sign() {
			return t_sign;
		}
		public void setT_sign(int t_sign) {
			this.t_sign = t_sign;
		}
		public int getT_major() {
			return t_major;
		}
		public void setT_major(int t_major) {
			this.t_major = t_major;
		}
		public int getCourse_id() {
			return course_id;
		}
		public void setCourse_id(int course_id) {
			this.course_id = course_id;
		}
          
}
