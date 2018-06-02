/**
 * 
 */
package nuc.edu.dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import nuc.edu.coon.DBUtil;
import nuc.edu.entity.Post;

/**是实现管理员对帖子处理的方法
 * @author TaoXu
 *
 */
public class AdminDao implements AdminDaoImpl<Post> {
    private Connection coon = DBUtil.getCoon();    
    private PreparedStatement pst = null;
    String sql=null;
    Date time=new Date();   
    Timestamp timestamp=new Timestamp(time.getTime());
    
    //发表帖子
	public int Insert(Post obj) {
		// TODO Auto-generated method stub
		int rs=0;
		sql = " insert into post (post_title,post_content,post_time,sign) values (?,?,?,?)";
		try {
			pst = coon.prepareStatement(sql);
			pst.setString(1, obj.getPost_title());
			pst.setString(2, obj.getPost_content());
		    pst.setTimestamp(3,timestamp);
			pst.setInt(4, 0);        //默认为普通帖 为 0 
			rs = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
    
	//根据 id 删帖
	public int Delete(Post obj) {
		// TODO Auto-generated method stub
		int rs = 0;
		sql = "delete from post where post_id = ?";
		try {
			pst = coon.prepareStatement(sql);
			pst.setInt(1, obj.getPost_id());
			rs = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	//查询所有帖子，分页显示
	public List<Post> findAll(int start) {
		// TODO Auto-generated method stub
		List<Post> posts = new ArrayList<Post>();
		ResultSet rs = null;
		sql = " select * from post where post_title!='' limit ?,?";
		try {
			pst = coon.prepareStatement(sql);
			pst.setInt(1, (start-1)*10);
			pst.setInt(2, 10);
			rs = pst.executeQuery();
			Post postt = null;
			while(rs.next()) {
				postt = new Post();
				postt.setPost_id(rs.getInt(1));
				postt.setPost_title(rs.getString(2));
				postt.setPost_content(rs.getString(3));
				postt.setPost_time(rs.getTimestamp(6));
				posts.add(postt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return posts;
	}
    
	//根据 id 查帖
	public Post findById(Post obj) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		Post postt = null;
		sql = " select * from post where post_id = ?";
		try {
			pst = coon.prepareStatement(sql);
			pst.setInt(1, obj.getPost_id());
			rs = pst.executeQuery();
			if(rs.next())
		    postt = new Post();
			postt.setPost_title(rs.getString(2));
			postt.setPost_content(rs.getString(3));
			postt.setPost_time(rs.getTimestamp(6));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return postt;
	}
    
	
	//实现置顶帖子
	public Post Update(Post obj) {
		// TODO Auto-generated method stub
		int rs= 0;
		Post postt = null;
		sql = "update post set sign = 1 where post_id = ?";
		try {
			pst =coon.prepareStatement(sql);
			pst.setInt(1,obj.getPost_id());
			rs = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return postt;
	}

	//显示公告
	public List<Post> findOrder() {
		// TODO Auto-generated method stub
		List<Post> posts = new ArrayList<Post>();
		ResultSet rs = null;
		sql ="select * from post where post_title!='' order by post_id desc limit 0,5";
		try {
			pst = coon.prepareStatement(sql);
			rs = pst.executeQuery();
			Post postt = null;
			while(rs.next()) {
				postt = new Post();
				postt.setPost_id(rs.getInt(1));
				postt.setPost_title(rs.getString(2));
				postt.setPost_time(rs.getTimestamp(6));
				posts.add(postt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return posts;
	}
      
	//显示置顶帖
	  public List<Post> findTopPost(){
		  List<Post> posts = new ArrayList<Post>();
		  ResultSet rs = null;
		  Post postt = null;
		  sql = "select * from post where sign= 1";
		  try {
			pst = coon.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
			   postt = new Post();
			   postt.setPost_id(rs.getInt(1));	
			   postt.setPost_title(rs.getString(2));
			   postt.setPost_time(rs.getTimestamp(6));
			   posts.add(postt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return posts;
	  }
     
	
}
