package nuc.edu.action.login;



import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.edu.entity.Student;
import nuc.edu.entity.Teacher;
import nuc.edu.entity.loginModel;
import nuc.edu.service.login.LoginService;


public class LoginAction extends ActionSupport implements ModelDriven<loginModel>{
	private static final long serialVersionUID = 1L;
	
	private loginModel login=new loginModel();
	private LoginService loginser = new LoginService();
	ResultSet rs =null;
	
	public String testLogin() throws Exception {
			String check=(String)ActionContext.getContext().getSession().get("Rand");
			rs = loginser.find(login.getNo(), login.getPassword(), login.getType());
        	if(login.getChecking().equals(check)&&rs.next()) {
        					
				ActionContext.getContext().getSession().put("name", rs.getString(2));
				if(login.getType().equals("��ʦ")) {
					Teacher tec = new Teacher();
					tec.setT_id(rs.getInt("t_id"));
					tec.setT_username(rs.getString("t_username"));
					tec.setT_no(rs.getString("t_no"));
					tec.setT_password(rs.getString("t_password"));
					tec.setT_Email(rs.getString("t_Email"));
					tec.setT_introduce(rs.getString("t_introduce"));
					tec.setT_sign(rs.getInt("t_sign"));
					tec.setT_major(rs.getInt("t_major"));
					tec.setCourse_id(rs.getShort("course_id"));
					ServletActionContext.getRequest().getSession().setAttribute("user",tec);
	            	ServletActionContext.getRequest().getSession().setAttribute("sign",tec.getT_sign() );
			        ActionContext.getContext().getSession().put( "sno" , tec.getT_no() );
					ActionContext.getContext().getSession().put("sender_id", tec.getT_id());
					ActionContext.getContext().getSession().put("sender_sign", tec.getT_sign());
	            	return "loginTeacher";
				}else if(login.getType().equals("ѧ��")) {
					Student st = new Student();
					st.setS_id(rs.getInt("s_id"));
					st.setS_username(rs.getString("s_username"));
					st.setS_no(rs.getString("s_no"));
					st.setS_password(rs.getString("s_password"));
					st.setS_Email(rs.getString("s_Email"));
					st.setS_rank(rs.getString("s_rank"));
					st.setS_sign(rs.getInt("s_sign"));
					st.setS_major(rs.getInt("s_major"));
					ServletActionContext.getRequest().getSession().setAttribute("user",st);
	            	ServletActionContext.getRequest().getSession().setAttribute("sign",st.getS_sign() );
					ActionContext.getContext().getSession().put("sender_id", st.getS_id());
					ActionContext.getContext().getSession().put("sender_sign", st.getS_sign());
					ActionContext.getContext().getSession().put( "sno" , st.getS_no() );
	            	return "loginStudent";
				}else if(login.getType().equals("����Ա")) {
					return "loginAdmin";
				}
				return "";
			}else {
        	ActionContext.getContext().put("error","�û������������֤�����");
        	return ERROR;
            }	
      }
		
		
	 public String getPass() throws Exception {
		 String check=(String)ActionContext.getContext().getSession().get("Rand");
		 rs = loginser.getPass(login.getNo(), login.getUsername(), login.getType(), login.getEmail());
		 
     	 if(login.getChecking().equals(check)&&rs.next()) {
			ActionContext.getContext().getSession().put("password", rs.getString(1));
        	return "getOk";
     	}else {
     		ActionContext.getContext().put("error","��Ǹ,û���ҵ��û�");
        	return ERROR;
     	}
	 }
	    
		//�������ݵ���ȷ��  equalsignoreCase�ڱȽ�ʱ���Դ�Сд
		/*
		 * null����һ���ն���û�з����ڴ�ռ䣬""����һ���ַ�Ϊ�յĶ����Ѿ��������ڴ�ռ�
		 * ��û��ʵ�������󣬶�����ܲ�Ϊ��
		 * 
		*/
	 
		@Override
		public void validate() {
			// TODO Auto-generated method stub
			if(login.getNo()==null||login.getNo().trim().equalsIgnoreCase("")) {
				this.addFieldError("no","ѧ�Ų���Ϊ��");
			}
			/*if(login.getPassword()==null||login.getPassword().trim().equals("")) {
				this.addFieldError("password","���벻��Ϊ��");
			}*/
			if(login.getChecking()==null||login.getChecking().trim().equals("")) {
				this.addFieldError("checking","��֤�벻��Ϊ��");
			}
			/*if(login.getEmail()==null||login.getEmail().trim().equalsIgnoreCase("")) {
				this.addFieldError("email","���䲻��Ϊ��");
			}*/
		} 
		public loginModel getModel() {
			// TODO Auto-generated method stub
			return login;
		}
}
