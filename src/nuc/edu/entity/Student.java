package nuc.edu.entity;

public class Student {
       private int s_id;//学生id
       private String s_username;//学生姓名
       private String s_no;//学号
       private String s_password;//学生密码
       private String s_Email;//学生邮箱
       private String s_rank;//学生等级
       private int s_sign;//学生标识 学生为0
       private int s_major;//所属专业
       private String majorname;
       
		public String getMajorname() {
		return majorname;
	}
	public void setMajorname(String majorname) {
		this.majorname = majorname;
	}
		public int getS_id() {
			return s_id;
		}
		public void setS_id(int s_id) {
			this.s_id = s_id;
		}
		public String getS_username() {
			return s_username;
		}
		public void setS_username(String s_username) {
			this.s_username = s_username;
		}
		public String getS_no() {
			return s_no;
		}
		public void setS_no(String s_no) {
			this.s_no = s_no;
		}
		public String getS_password() {
			return s_password;
		}
		public void setS_password(String s_password) {
			this.s_password = s_password;
		}
		public String getS_Email() {
			return s_Email;
		}
		public void setS_Email(String s_Email) {
			this.s_Email = s_Email;
		}
		public String getS_rank() {
			return s_rank;
		}
		public void setS_rank(String s_rank) {
			this.s_rank = s_rank;
		}
		public int getS_sign() {
			return s_sign;
		}
		public void setS_sign(int s_sign) {
			this.s_sign = s_sign;
		}
		public int getS_major() {
			return s_major;
		}
		public void setS_major(int s_major) {
			this.s_major = s_major;
		}
}
