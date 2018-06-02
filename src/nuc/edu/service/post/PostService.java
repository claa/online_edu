package nuc.edu.service.post;

import java.util.ArrayList;
import java.util.List;

import nuc.edu.dao.post.PostDao;
import nuc.edu.dao.post.PostDaoImpl;
import nuc.edu.entity.Post;
import nuc.edu.entity.PostCommenter;
import nuc.edu.entity.Student;
import nuc.edu.entity.Teacher;

public class PostService {
	
	private PostDao postDao = new PostDaoImpl();
	
	public int post_send(Post post) {
		// TODO Auto-generated method stub
		int rs = postDao.post_send(post);
		return rs;
	}

	public List<Post> post_findByMajor(int major_id) {
		// TODO Auto-generated method stub
		List<Post> postList = new ArrayList<Post>();
		postList = postDao.post_findByMajor(major_id);
		return postList;
	}

	public Post showPostContent(int post_id) {
		// TODO Auto-generated method stub
		Post post = postDao.showPostContent(post_id);
		return post;
	}

	public Student getSenderStudent(int sender_id) {
		// TODO Auto-generated method stub
		Student student = new Student();
		student = postDao.getSenderStudent(sender_id);
		return student;
	}

	public Teacher getSenderTeacher(int sender_id) {
		// TODO Auto-generated method stub
		Teacher teacher = new Teacher();
		teacher = postDao.postgetSenderTeacher(sender_id);
		return teacher;
	}

	public int commentPost(Post post, Post parentPost) {
		// TODO Auto-generated method stub
		int rs = postDao.commentPost(post,parentPost);
		return rs;
	}

	public int getPostNum() {
		// TODO Auto-generated method stub
		int post_num = postDao.getPostNum();
		return post_num;
	}

	public Post getPostByTitleAndTime(Post post) {
		// TODO Auto-generated method stub
		return postDao.getPostByTitleAndTime(post);
	}

	public Post getParentPost(int parent_id) {
		// TODO Auto-generated method stub
		Post post = postDao.showPostContent(parent_id);
		return post;
	}

	public List<Post> getAllCommentPost(String reply_id) {
		// TODO Auto-generated method stub
		return postDao.getAllCommentPost(reply_id);
	}

	public void updateWatch_num(int post_id) {
		// TODO Auto-generated method stub
		postDao.updateWatch_num(post_id);
	}

	public List<PostCommenter> getAllPostCommenter(List<Post> postList) {
		// TODO Auto-generated method stub
		List<PostCommenter> postCommenterList = postDao.getAllPostCommenter(postList);
		return postCommenterList;
	}

}
