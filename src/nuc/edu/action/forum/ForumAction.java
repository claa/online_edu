package nuc.edu.action.forum;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.edu.entity.Answer;
import nuc.edu.entity.Forum;
import nuc.edu.entity.Student;
import nuc.edu.service.forum.AnswerService;
import nuc.edu.service.forum.ForumService;
import nuc.edu.service.forum.StudentService;
import nuc.edu.service.forum.TeacherService;

public class ForumAction extends ActionSupport implements ModelDriven<Forum>{
	        private Forum forum=new Forum();
	        private List<Forum> forumlist=new ArrayList<Forum>();
	        private List<Answer> answerlist=new ArrayList<Answer>();
	        private int course_id;
	        private int sign;
	        ForumService forumservice=new ForumService();
	        AnswerService answerservice=new AnswerService();
	        private String[] names=new String[forumservice.CountForum()+1];
	        private String[] names2=new String[answerservice.CountAnswer()+1];
	        public String[] getNames2() {
				return names2;
			}
			public void setNames2(String[] names2) {
				this.names2 = names2;
			}
			public String[] getNames() {
				return names;
			}
			public void setNames(String[] names) {
				this.names = names;
			}
			public int getSign() {
				return sign;
			}
			public void setSign(int sign) {
				this.sign = sign;
			}
			public List<Answer> getAnswerlist() {
				return answerlist;
			}
			public void setAnswerlist(List<Answer> answerlist) {
				this.answerlist = answerlist;
			}
			public int getCourse_id() {
				return course_id;
			}
			public void setCourse_id(int course_id) {
				this.course_id = course_id;
			}
				public List<Forum> getForumlist() {
				return forumlist;
			}
			public void setForumlist(List<Forum> forumlist) {
				this.forumlist = forumlist;
			}
				public String addTForum(){
                	return "addTFormOK";
                }
                public String addSForum(){
                	Student s=(Student)ServletActionContext.getRequest().getSession().getAttribute("user");
                	ForumService forumservice=new ForumService();
                	forum.setS_id(s.getS_id());
                	System.out.println(s.getS_id());
                	forum.setForum_type(sign);
                	forum.setForum_time(new java.sql.Timestamp(new java.util.Date().getTime()));
                	course_id=Integer.parseInt(ServletActionContext.getRequest().getParameter("course_id"));
               
                	forum.setCourse_id(course_id);
                	forum.setAnswer_num(0);
                	forum.setWatch_num(0);
                	forumservice.addForum(forum);
                	return "addSFormOK";
                }
               
				public String selectForum(){
                	course_id=Integer.parseInt(ServletActionContext.getRequest().getParameter("course_id"));
                     StudentService studentservice=new StudentService();
                	   ForumService forumservice=new ForumService();
                	   forumlist=forumservice.selectForum(course_id,sign);
                	   if(forumlist.size()>0){
                		   for(int i=0;i<forumlist.size();i++){
                		 names[i]=studentservice.selectStudentById(forumlist.get(i).getS_id()).getS_username();
                	   }
                	   }
                	   return "selectForumOK";
                }
                public String selectSForumById(){
                	ForumService forumservice=new ForumService();
                	AnswerService answerservice=new AnswerService();
                	  StudentService studentservice=new StudentService();
                	  TeacherService teacherservice=new TeacherService();
                	int forum_id=Integer.parseInt(ServletActionContext.getRequest().getParameter("forum_id"));
                    forum=forumservice.selectForumById(forum_id);
                    answerlist=answerservice.selectAnswer(forum_id);
                    forumservice.updateWatch_Num(forum_id);
                    for(int i=0;i<answerlist.size();i++){
                    	  if(answerlist.get(i).getAnswerer_type()==0){
                    		  names2[i]=studentservice.selectStudentById(answerlist.get(i).getAnswerer_id()).getS_username();
                    	  }
                    	  else{
                    		  names2[i]=teacherservice.selectTeacherById(answerlist.get(i).getAnswerer_id()).getT_username();
                    	  }
                    }
                	return "selectSForumByIdOK";
                }
            
				public Forum getModel() {
					// TODO Auto-generated method stub
					return forum;
				}
}
