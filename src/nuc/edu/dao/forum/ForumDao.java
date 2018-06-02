package nuc.edu.dao.forum;

import java.util.List;

import nuc.edu.entity.Forum;

public interface ForumDao {
	public int addForum(Forum forum);
	public List<Forum> selectForum(int course_id,int sign);
	public Forum selectForumById(int forum_id);
	public int CountForum();
	public int updateWatch_Num(int forum_id);
}
