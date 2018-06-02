package nuc.edu.action.post;

import java.util.ArrayList;
import java.util.List;


import nuc.edu.entity.Post;
import nuc.edu.entity.PostCommenter;
import nuc.edu.entity.Student;
import nuc.edu.entity.Teacher;
import nuc.edu.service.post.PostService;
import nuc.edu.service.prletter.PrletterService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PostAction extends ActionSupport implements ModelDriven<Post> {
	
	private Post post = new Post();
	private Post postContent = new Post();
	private PostService postService = new PostService();
	private List<Post> postList = new ArrayList<Post>();
	private List<Teacher> teacherList = new ArrayList<Teacher>();
	private List<PostCommenter> postCommenterList = new ArrayList<PostCommenter>();
	private Student student = new Student();
	private Teacher teacher = new Teacher();
	public List<Post> getPostList() {
		return postList;
	}
	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}
	public Post getPostContent() {
		return postContent;
	}
	public void setPostContent(Post postContent) {
		this.postContent = postContent;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public List<PostCommenter> getPostCommenterList() {
		return postCommenterList;
	}
	public void setPostCommenterList(List<PostCommenter> postCommenterList) {
		this.postCommenterList = postCommenterList;
	}
	public List<Teacher> getTeacherList() {
		return teacherList;
	}
	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}
	
	
	public String sendMethod(){
		int rs = postService.post_send(post);
		if(rs!=0){
			post = postService.getPostByTitleAndTime(post);
			return "post_sendOK";
		}else{
			return "post_sendFail";
		}
	}
	
	public String findByMajorMethod(){
		teacherList = PrletterService.queryTeacherInfoByMajorId(post.getMajor_id());
		postList = postService.post_findByMajor(post.getMajor_id());
		return "findByMajorOK";
	}
	
	public String showPostContentMethod(){
		postContent = postService.showPostContent(post.getPost_id());
		postService.updateWatch_num(postContent.getPost_id());
		postList = postService.getAllCommentPost(postContent.getReply_id());
		postCommenterList = postService.getAllPostCommenter(postList);
		if(postContent.getSender_sign()==0){
			student = postService.getSenderStudent(postContent.getSender_id());
		}else if(postContent.getSender_sign()==1){
			teacher = postService.getSenderTeacher(postContent.getSender_id());
		}
		return "showPostContentOK";
	}
	
	public String commentPostMethod(){
		int parent_id = post.getPost_id();
		int rs = postService.post_send(post);
		if(rs!=0){
			Post parentPost = postService.getParentPost(parent_id);
			post = postService.getPostByTitleAndTime(post);
			postService.commentPost(post,parentPost);
			post = postService.getParentPost(parent_id);
			postContent = postService.showPostContent(post.getPost_id());
			postList = postService.getAllCommentPost(postContent.getReply_id());
			postCommenterList = postService.getAllPostCommenter(postList);
			return "commentPostOK";
		}else{
			postContent = postService.showPostContent(post.getPost_id());
			postList = postService.getAllCommentPost(postContent.getReply_id());
			postCommenterList = postService.getAllPostCommenter(postList);
			return "commentPostFail";
		}
	}
	
	public Post getModel() {
		// TODO Auto-generated method stub
		return post;
	}
}
