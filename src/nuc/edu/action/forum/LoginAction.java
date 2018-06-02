package nuc.edu.action.forum;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;


import nuc.edu.entity.Student;
import nuc.edu.entity.Teacher;

public class LoginAction extends ActionSupport {
             public String execute(){
            	 Student s=new Student();
            	 s.setS_id(4);
            	 s.setS_username("¡ıŒ¿Œ¿");
            	 s.setS_sign(0);
//            	 Teacher t=new Teacher();
//            	 t.setT_id(3);
//            	 t.setT_username("¡ıŒ¿Œ¿");
//            	  t.setT_sign(1);
//            	   ServletActionContext.getRequest().getSession().setAttribute("user",t);
//            	   ServletActionContext.getRequest().getSession().setAttribute("sign",t.getT_sign() );
            	   ServletActionContext.getRequest().getSession().setAttribute("user",s);
            	   ServletActionContext.getRequest().getSession().setAttribute("sign",s.getS_sign() );
            	   return SUCCESS;
             }
}
