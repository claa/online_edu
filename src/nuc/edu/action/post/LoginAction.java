package nuc.edu.action.post;

import nuc.edu.entity.Student;
import nuc.edu.entity.Teacher;
import nuc.edu.service.post.LoginService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private String no;
	private String password;
	private int type;
	private LoginService loginService = new LoginService();
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	@Override
	public String execute() throws Exception {
		if(type==0){
			Student student = new Student();
			student.setS_no(no);
			student.setS_password(password);
			Student st = loginService.studentLogin(student);
			if(st!=null){
				ActionContext.getContext().getSession().put("student", st);
				ActionContext.getContext().getSession().put("sender_id", st.getS_id());
				ActionContext.getContext().getSession().put("sender_sign", st.getS_sign());
				ActionContext.getContext().getSession().put("sno", st.getS_no());
				return "loginOK_0";
			}
		}else if(type==1){
			Teacher teacher = new Teacher();
			teacher.setT_no(no);
			teacher.setT_password(password);
			Teacher tec = loginService.teacherLogin(teacher);
			if(tec!=null){
				ActionContext.getContext().getSession().put("teacher", tec);
				ActionContext.getContext().getSession().put("sender_id", tec.getT_id());
				ActionContext.getContext().getSession().put("sender_sign", tec.getT_sign());
				ActionContext.getContext().getSession().put("sno", tec.getT_no());
				return "loginOK_1";
			}
		}
		return "loginFail";
	}
}
