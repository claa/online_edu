package nuc.edu.service.forum;

import java.util.List;

import nuc.edu.dao.forum.ForumDao;
import nuc.edu.dao.forum.ForumDaoImpl;
import nuc.edu.entity.Answer;
import nuc.edu.entity.Forum;

public class ForumService {
             ForumDao forumdao=new ForumDaoImpl();
         	public int addForum(Forum forum) {
         		return forumdao.addForum(forum);
         	}
         	public List<Forum> selectForum(int course_id,int sign){
         		return forumdao.selectForum(course_id,sign); 
         	}
         	public Forum selectForumById(int forum_id) {
         		return forumdao.selectForumById(forum_id);
         	}
         	public int CountForum() {
         		 return forumdao.CountForum();
         	}
         	public int updateWatch_Num(int forum_id) {
         		return forumdao.updateWatch_Num(forum_id);
         	}
         
}
