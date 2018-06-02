package nuc.edu.service.admin;

import java.util.List;

import nuc.edu.dao.admin.AdminDao;
import nuc.edu.entity.Post;
/**
 * 实现管理员的发帖，查帖，删帖，置顶帖以及查询数据等功能
 * @author TaoXu
 *
 */
public class AdminService {
	AdminDao adao = new AdminDao();
	
    public int Insert(Post post) {
    	return adao.Insert(post);
    }
    
    public int Delete(Post post) {
    	return adao.Delete(post);
    }
    
    public List<Post> findAll(int start){
    	return adao.findAll(start);
    }
    
    public Post findById(Post post) {
    	return adao.findById(post);
    }
    
    public Post Update(Post post) {
    	return adao.Update(post);
    	
    }
    
    public List<Post> findOrder(){
    	return adao.findOrder();
    }
    
    public List<Post> findTopPost(){
    	return adao.findTopPost();
    }
}
