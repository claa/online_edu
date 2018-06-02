package nuc.edu.action.forum;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.edu.entity.Answer;
import nuc.edu.entity.Student;
import nuc.edu.entity.Teacher;
import nuc.edu.service.forum.AnswerService;

public class AnswerAction extends ActionSupport implements ModelDriven<Answer>{
     private Answer answer=new Answer();
     private int forum_id;
     private int answer_id;
     public int getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(int answer_id) {
		this.answer_id = answer_id;
	}
	public int getForum_id() {
		return forum_id;
	}
	public void setForum_id(int forum_id) {
		this.forum_id = forum_id;
	}
	public String addAnswer(){
		  System.out.println(answer.getAnswerer_id());
	      answer.setAnswer_time(new java.sql.Timestamp(new java.util.Date().getTime()));
	      answer.setAnswerer_type((Integer) ServletActionContext.getRequest().getSession().getAttribute("sign"));
	      answer.setAnswer_forum_id(forum_id);
    	   AnswerService answerservice=new AnswerService();
    	   answerservice.addAnswer(answer);
    	   return "addAnswerOK";
     }
	public String addAnswer_Like_id(){
		answer_id=Integer.parseInt(ServletActionContext.getRequest().getParameter("answer_id"));
		forum_id=Integer.parseInt(ServletActionContext.getRequest().getParameter("forum_id"));
		System.out.println(answer_id);
		     AnswerService answerservice=new AnswerService();
		       String old_like_id=answerservice.selectAnswerForLikeId(answer_id).getAnswer_like_id();
		       String new_like_id;
		       Student s1=new Student();
		       Teacher t1=new Teacher();
		     
		      
		       int sign=(Integer)ServletActionContext.getRequest().getSession().getAttribute("sign");
		       int userid;
		       if(sign==0){
		    	   s1=(Student)ServletActionContext.getRequest().getSession().getAttribute("user");
		    	   userid=s1.getS_id();
		       }
		       else{
		    	   t1=(Teacher)ServletActionContext.getRequest().getSession().getAttribute("user");
		    	    userid=t1.getT_id();
		       }
		       if(old_like_id!=null){
		    	  
		    	      new_like_id=old_like_id+userid+","+sign+";";
		      }
		       else{
		    	  
		    	        new_like_id=userid+","+sign+";";
	         }
		       Answer answer2=new Answer();
		       answer2=answerservice.selectAnswerForLikeId(answer_id);
		       String str=answer2.getAnswer_like_id();
		      
		       String str3;
		       if(sign==0){
		                str3=s1.getS_id()+","+sign;
		       }
		       else{
		    	       str3=t1.getT_id()+","+sign;
		       }
		       int flag=0;
		       if(str!=null){
		       String str2[]=str.split(";");
		       for(int i=0;i<str2.length;i++){
		    	      if(str2[i].equals(str3)){
		    	    	    flag=1;
		    	      }
		       }
		       }
		       if(flag==0){
		    	     answerservice.addAnswer_Like_id(answer_id, new_like_id);
		       }
		       return "addAnswer_Like_idOK";
	}
	public Answer getModel() {
		// TODO Auto-generated method stub
		return answer;
	}

}
