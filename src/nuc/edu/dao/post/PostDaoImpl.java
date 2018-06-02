package nuc.edu.dao.post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import nuc.edu.conn.Conn;
import nuc.edu.entity.Post;
import nuc.edu.entity.PostCommenter;
import nuc.edu.entity.Student;
import nuc.edu.entity.Teacher;

public class PostDaoImpl implements PostDao {
	
	private Connection conn = Conn.getConn();

	public int post_send(Post post) {
		int rs = 0;
		String sql = "insert into post(post_title,post_content,sender_id,sender_sign,post_time,reply_num,reply_id,like_num,watch_num,major_id) " +
				"values(?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			Timestamp post_time = new java.sql.Timestamp(new java.util.Date().getTime());
			post.setPost_time(post_time);
			pst.setString(1, post.getPost_title());
			pst.setString(2, post.getPost_content());
			pst.setInt(3, post.getSender_id());
			pst.setInt(4, post.getSender_sign());
			pst.setTimestamp(5, post.getPost_time());
			pst.setInt(6, post.getReply_num());
			pst.setString(7, post.getReply_id());
			pst.setInt(8, post.getLike_num());
			pst.setInt(9, post.getWatch_num());
			pst.setInt(10, post.getMajor_id());
			rs = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public List<Post> post_findByMajor(int major_id) {
		// TODO Auto-generated method stub
		List<Post> postList = new ArrayList<Post>();
		String sql = "select * from post where major_id=? and post_title!=''";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, major_id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				Post post = new Post();
				post.setPost_id(rs.getInt("post_id"));
				post.setPost_title(rs.getString("post_title"));
				post.setPost_content(rs.getString("post_content"));
				post.setSender_id(rs.getInt("sender_id"));
				post.setSender_sign(rs.getInt("sender_sign"));
				post.setPost_time(rs.getTimestamp("post_time"));
				post.setReply_num(rs.getInt("reply_num"));
				post.setReply_id(rs.getString("reply_id"));
				post.setLike_num(rs.getInt("like_num"));
				post.setWatch_num(rs.getInt("watch_num"));
				post.setMajor_id(rs.getInt("major_id"));
				postList.add(post);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return postList;
	}

	public Post showPostContent(int post_id) {
		// TODO Auto-generated method stub
		Post post = new Post();
		String sql = "select * from post where post_id=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, post_id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				post.setPost_id(rs.getInt("post_id"));
				post.setPost_title(rs.getString("post_title"));
				post.setPost_content(rs.getString("post_content"));
				post.setSender_id(rs.getInt("sender_id"));
				post.setSender_sign(rs.getInt("sender_sign"));
				post.setPost_time(rs.getTimestamp("post_time"));
				post.setReply_num(rs.getInt("reply_num"));
				post.setReply_id(rs.getString("reply_id"));
				post.setLike_num(rs.getInt("like_num"));
				post.setWatch_num(rs.getInt("watch_num"));
				post.setMajor_id(rs.getInt("major_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return post;
	}

	public Student getSenderStudent(int sender_id) {
		// TODO Auto-generated method stub
		Student st = new Student();
		String sql = "select * from student where s_id=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, sender_id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				st.setS_id(rs.getInt("s_id"));
				st.setS_username(rs.getString("s_username"));
				st.setS_no(rs.getString("s_no"));
				st.setS_password(rs.getString("s_password"));
				st.setS_Email(rs.getString("s_Email"));
				st.setS_rank(rs.getString("s_rank"));
				st.setS_sign(rs.getInt("s_sign"));
				st.setS_major(rs.getInt("s_major"));
			}else{
				st= null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
	}

	public Teacher postgetSenderTeacher(int sender_id) {
		// TODO Auto-generated method stub
		Teacher tec = new Teacher();
		String sql = "select * from teacher where t_id=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, sender_id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				tec.setT_id(rs.getInt("t_id"));
				tec.setT_username(rs.getString("t_username"));
				tec.setT_no(rs.getString("t_no"));
				tec.setT_password(rs.getString("t_password"));
				tec.setT_Email(rs.getString("t_Email"));
				tec.setT_introduce(rs.getString("t_introduce"));
				tec.setT_sign(rs.getInt("t_sign"));
				tec.setT_major(rs.getInt("t_major"));
				tec.setCourse_id(rs.getShort("course_id"));
			}else{
				tec=null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tec;
	}

	public int commentPost(Post post,Post parentPost) {
		// TODO Auto-generated method stub
		int rs = 0;
		String sql = "update post set reply_num=reply_num+1,reply_id=? where post_id=?;";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, parentPost.getReply_id()+";"+post.getPost_id());
			pst.setInt(2, parentPost.getPost_id());
			rs = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public int getPostNum() {
		// TODO Auto-generated method stub
		int post_num = 0;
		String sql = "select count(*) from post";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			post_num = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(post_num);
		return post_num;
	}

	public Post getPostByTitleAndTime(Post post) {
		// TODO Auto-generated method stub
		String sql = "select * from post where post_title=? and post_time=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, post.getPost_title());
			pst.setTimestamp(2, post.getPost_time());
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				post.setPost_id(rs.getInt("post_id"));
				post.setPost_title(rs.getString("post_title"));
				post.setPost_content(rs.getString("post_content"));
				post.setSender_id(rs.getInt("sender_id"));
				post.setSender_sign(rs.getInt("sender_sign"));
				post.setPost_time(rs.getTimestamp("post_time"));
				post.setReply_num(rs.getInt("reply_num"));
				post.setReply_id(rs.getString("reply_id"));
				post.setLike_num(rs.getInt("like_num"));
				post.setWatch_num(rs.getInt("watch_num"));
				post.setMajor_id(rs.getInt("major_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return post;
	}

	public List<Post> getAllCommentPost(String reply_id) {
		// TODO Auto-generated method stub
		List<Post> postlist = new ArrayList<Post>();
		try {
			String[] string = reply_id.split(";");
			int length = string.length;
			int i = 0;
			while(length>0){
				String sql = "select * from post where post_id=?";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setInt(1, Integer.parseInt(string[i++]));
				ResultSet rs = pst.executeQuery();
				if(rs.next()){
					Post post = new Post();
					post.setPost_id(rs.getInt("post_id"));
					post.setPost_title(rs.getString("post_title"));
					post.setPost_content(rs.getString("post_content"));
					post.setSender_id(rs.getInt("sender_id"));
					post.setSender_sign(rs.getInt("sender_sign"));
					post.setPost_time(rs.getTimestamp("post_time"));
					post.setReply_num(rs.getInt("reply_num"));
					post.setReply_id(rs.getString("reply_id"));
					post.setLike_num(rs.getInt("like_num"));
					post.setWatch_num(rs.getInt("watch_num"));
					post.setMajor_id(rs.getInt("major_id"));
					postlist.add(post);
				}
				length--;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return postlist;
	}

	public void updateWatch_num(int post_id) {
		// TODO Auto-generated method stub
		String sql = "update post set watch_num=watch_num+1 where post_id=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, post_id);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<PostCommenter> getAllPostCommenter(List<Post> postList) {
		// TODO Auto-generated method stub
		List<PostCommenter> postCommenterList = new ArrayList<PostCommenter>();
		Iterator<Post> it = postList.iterator();
		while(it.hasNext()){
			Post post = it.next();
			PostCommenter postCommenter = new PostCommenter();
			try {
				if(post.getSender_sign()==0){
					String sql = "select * from student where s_id=?";
					PreparedStatement pst = conn.prepareStatement(sql);
					pst.setInt(1, post.getSender_id());
					ResultSet rs = pst.executeQuery();
					if(rs.next()){
						postCommenter.setS_id(rs.getInt("s_id"));
						postCommenter.setS_username(rs.getString("s_username"));
						postCommenter.setS_no(rs.getString("s_no"));
						postCommenter.setS_password(rs.getString("s_password"));
						postCommenter.setS_Email(rs.getString("s_Email"));
						postCommenter.setS_rank(rs.getString("s_rank"));
						postCommenter.setSign(rs.getInt("s_sign"));
						postCommenter.setS_major(rs.getInt("s_major"));
						postCommenterList.add(postCommenter);
					}else{
						postCommenter= null;
					}
				}else if(post.getSender_sign()==1){
					String sql = "select * from teacher where t_id=?";
					PreparedStatement pst = conn.prepareStatement(sql);
					pst.setInt(1, post.getSender_id());
					ResultSet rs = pst.executeQuery();
					if(rs.next()){
						postCommenter.setT_id(rs.getInt("t_id"));
						postCommenter.setT_username(rs.getString("t_username"));
						postCommenter.setT_no(rs.getString("t_no"));
						postCommenter.setT_password(rs.getString("t_password"));
						postCommenter.setT_Email(rs.getString("t_Email"));
						postCommenter.setT_introduce(rs.getString("t_introduce"));
						postCommenter.setSign(rs.getInt("t_sign"));
						postCommenter.setT_major(rs.getInt("t_major"));
						postCommenter.setCourse_id(rs.getShort("course_id"));
						postCommenterList.add(postCommenter);
					}else{
						postCommenter=null;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return postCommenterList;
	}
}


















