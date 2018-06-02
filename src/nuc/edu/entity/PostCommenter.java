package nuc.edu.entity;

public class PostCommenter {
	private int s_id;//学生id
    private String s_username;//学生姓名
    private String s_no;//学号
    private String s_password;//学生密码
    private String s_Email;//学生邮箱
    private String s_rank;//学生等级
    private int sign;//学生标识 学生为0老师为1
    private int s_major;//所属专业
    private int t_id;//老师id 
    private String t_username;//老师姓名
    private String t_no;//教师号
    private String t_password;//教师密码
    private String t_Email;//老师邮箱
    private String t_introduce;//教师简介
    private int t_major;//所属专业
    private int course_id;
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
	public int getSign() {
		return sign;
	}
	public void setSign(int sign) {
		this.sign = sign;
	}
	public int getS_major() {
		return s_major;
	}
	public void setS_major(int s_major) {
		this.s_major = s_major;
	}
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
