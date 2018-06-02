package nuc.edu.dao.post;

import java.util.List;

import nuc.edu.entity.Post;
import nuc.edu.entity.PostCommenter;
import nuc.edu.entity.Student;
import nuc.edu.entity.Teacher;

public interface PostDao {

	//发布帖子
	public int post_send(Post post);
	//根据专业查找帖子
	public List<Post> post_findByMajor(int major_id);
	public Post showPostContent(int post_id);
	public Student getSenderStudent(int sender_id);
	public Teacher postgetSenderTeacher(int sender_id);
	public int commentPost(Post post, Post parentPost);
	public int getPostNum();
	public Post getPostByTitleAndTime(Post post);
	public List<Post> getAllCommentPost(String reply_id);
	public void updateWatch_num(int post_id);
	public List<PostCommenter> getAllPostCommenter(List<Post> postList);
}
