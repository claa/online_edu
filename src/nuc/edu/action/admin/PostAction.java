package nuc.edu.action.admin;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.edu.entity.Post;
import nuc.edu.service.admin.AdminService;

public class PostAction extends ActionSupport implements ModelDriven<Post> {
     private Post post = new Post();
     private AdminService adminser = new AdminService();
     List<Post> posts = new ArrayList<Post>();
     private Post posted;     
     int id;
     
     public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Post getPosted() {
		return posted;
	}

	public void setPost(Post posted) {
		this.posted = posted;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public String InsertPost() throws Exception {
    	 int a = adminser.Insert(post);
    	 if(a != 0) {
    		 
    	 return "insertOk";
    	 
    	 }else {
    		 return ERROR;
    	 }
     }
     
     public String DeletePost() throws Exception{
    	 int a = adminser.Delete(post);
    	 if(a != 0) {
    		 
    		 return "deleteOk";
    	 }else {
    		 return ERROR;
    	 }
     }
     
     public String findAllPost() throws Exception{
    	 if(id == 0){
    	 posts = adminser.findAll(1);
    	 }else{
    		 posts = adminser.findAll(id);
    	 }
    	 return "findAllOk";
    	 
     }
     
     public String findById() throws Exception{
    	posted = adminser.findById(post);
    	 
    	 return "findOk";
     }
     
     public String TopPost() throws Exception{
    	  adminser.Update(post);
    	  return "topOk";
    	 
     }
     
     public String findOrder() throws Exception{
    	 posts = adminser.findOrder();
    	 return "publishOk";
     }
     
     public String findTopPost() throws Exception{
    	 posts = adminser.findTopPost();
    	 return "findTopOk";
     }
	public Post getModel() {
		// TODO Auto-generated method stub
		return post;
	}

}
