package nuc.edu.dao.forum;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import nuc.edu.conn.Conn;
import nuc.edu.entity.Forum;

public class ForumDaoImpl implements ForumDao{
	  public static Connection conn=Conn.getConn();

	public int addForum(Forum forum) {
		String sql="insert into forum(s_id,forum_content,forum_type,forum_time,forum_title,course_id,answer_num)values(?,?,?,?,?,?,?)";
		int rs=0;
		try{
	         PreparedStatement pst=conn.prepareStatement(sql);
	         pst.setInt(1, forum.getS_id());
	         pst.setString(2, forum.getForum_content());
	         pst.setInt(3, forum.getForum_type());
	         pst.setTimestamp(4, forum.getForum_time());
	         pst.setString(5, forum.getForum_title());
	         pst.setInt(6, forum.getCourse_id());
	         pst.setInt(7, forum.getAnswer_num());
	         rs=pst.executeUpdate();
		}catch(Exception e){
			  e.printStackTrace();
		}
		return rs;
	}

	public List<Forum> selectForum(int course_id,int sign) {
		List<Forum> list=new ArrayList<Forum>();
		ResultSet rs=null;
		String sql="select * from forum where course_id=? and forum_type=?";
		try{
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, course_id);
			pst.setInt(2, sign);
			rs=pst.executeQuery();
			while(rs.next()){
				Forum forum=new Forum();
				forum.setAnswer_id(rs.getString("answer_id"));
				forum.setAnswer_num(rs.getInt("answer_num"));
				forum.setCourse_id(course_id);
				forum.setForum_content(rs.getString("forum_content"));
				forum.setForum_id(rs.getInt("forum_id"));
				forum.setForum_time(rs.getTimestamp("forum_time"));
				forum.setForum_title(rs.getString("forum_title"));
				forum.setForum_type(rs.getInt("forum_type"));
				forum.setLike_num(rs.getInt("like_num"));
				forum.setS_id(rs.getInt("s_id"));
				forum.setWatch_num(rs.getInt("watch_num"));
			   list.add(forum);
				}
			
		}catch(Exception e){
			 e.printStackTrace();
		}
		return list;
	}

	public Forum selectForumById(int forum_id) {
           ResultSet rs=null;
           String sql="select * from forum where forum_id=?";
           Forum forum=new Forum();
           try{
        	   PreparedStatement pst=conn.prepareStatement(sql);
   			pst.setInt(1, forum_id);
   			rs=pst.executeQuery();
   		   if(rs.next()){
				
				forum.setAnswer_id(rs.getString("answer_id"));
				forum.setAnswer_num(rs.getInt("answer_num"));
				forum.setCourse_id(forum_id);
				forum.setForum_content(rs.getString("forum_content"));
				forum.setForum_id(rs.getInt("forum_id"));
				forum.setForum_time(rs.getTimestamp("forum_time"));
				forum.setForum_title(rs.getString("forum_title"));
				forum.setForum_type(rs.getInt("forum_type"));
				forum.setLike_num(rs.getInt("like_num"));
				forum.setS_id(rs.getInt("s_id"));
				forum.setWatch_num(rs.getInt("watch_num"));
			
				}
           }catch(Exception e){
        	    e.printStackTrace();
           }
		return forum;
	}

	public int CountForum() {
		ResultSet rs=null;
		int count=0;
		 String sql="select count(*) from forum";
		 try{
			   PreparedStatement pst=conn.prepareStatement(sql);
			  rs= pst.executeQuery();
			  if(rs.next()){
			  count=rs.getInt(1);
			  }
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		return count;
	}

	public int updateWatch_Num(int forum_id) {
		String sql="update forum set watch_num=watch_num+1 where forum_id=?";
		int rs=0;
		try{
			 PreparedStatement pst=conn.prepareStatement(sql);
			 pst.setInt(1, forum_id);
			 pst.executeUpdate();
		}catch(Exception e){
			 e.printStackTrace();
		}
		return rs;
	}

	
	

	

}
