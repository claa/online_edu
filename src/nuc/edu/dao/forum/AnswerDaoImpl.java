package nuc.edu.dao.forum;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import nuc.edu.conn.Conn;
import nuc.edu.entity.Answer;

public class AnswerDaoImpl implements AnswerDao{
	 public static Connection conn=Conn.getConn();
	public int addAnswer(Answer answer) {
		  int rs=0;
		  String sql="insert into answer(answerer_id,answer_time,answerer_type,answer_content,answer_forum_id,answer_like_num)values(?,?,?,?,?,?)";
	    try{
	    	 PreparedStatement pst=conn.prepareStatement(sql);
	    	 pst.setInt(1, answer.getAnswerer_id());
	    	 pst.setTimestamp(2, answer.getAnswer_time());
	    	 pst.setInt(3, answer.getAnswerer_type());
	    	 pst.setString(4, answer.getAnswer_content());
	    	 pst.setInt(5, answer.getAnswer_forum_id());
	    	 pst.setInt(6, 0);
	    	 rs=pst.executeUpdate();
	    }catch(Exception e){
	    	    e.printStackTrace();
	    }
		  return rs;
	}
	public List<Answer> selectAnswer(int forum_id) {
		List<Answer> list=new ArrayList<Answer>();
		ResultSet rs=null;
		String sql="select * from answer where answer_forum_id=?";
		try{
			 PreparedStatement pst=conn.prepareStatement(sql);
			 pst.setInt(1, forum_id);
			 rs=pst.executeQuery();
			 while(rs.next()){
				    Answer answer=new Answer();
				    answer.setAnswer_content(rs.getString("answer_content"));
				    answer.setAnswer_forum_id(rs.getInt("answer_forum_id"));
				    answer.setAnswer_id(rs.getInt("answer_id"));
				    answer.setAnswer_time(rs.getTimestamp("answer_time"));
				    answer.setAnswerer_id(rs.getInt("answerer_id"));
				     answer.setAnswerer_type(rs.getInt("answerer_type"));
				     answer.setAnswer_like_num(rs.getInt("answer_like_num"));
				     list.add(answer);
			 }
		}catch(Exception e){
			   e.printStackTrace();
		}
		return list;
	}
	public int CountAnswer() {
		ResultSet rs=null;
		int count=0;
		 String sql="select count(*) from answer";
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
	public int addAnswer_Like_id(int answer_id,String new_like_id) {
		int rs=0;
		String sql="update answer  set answer_like_id=? where answer_id=?";
		try{
			   PreparedStatement pst=conn.prepareStatement(sql);
			   pst.setString(1, new_like_id);
			   pst.setInt(2, answer_id);
			  rs= pst.executeUpdate();
			  
		}catch(Exception e){
			 e.printStackTrace();
		}
		return rs;
	}
	public Answer selectAnswerForLikeId(int answer_id) {
	       ResultSet rs=null;
	       String sql="select * from answer where answer_id=?";
	       Answer answer=new Answer();
	       try{
	    	   PreparedStatement pst=conn.prepareStatement(sql); 
	    	    pst.setInt(1, answer_id);
	    	    rs=pst.executeQuery();
	    	    if(rs.next()){
	    	    	  answer.setAnswer_like_id(rs.getString("answer_like_id"));
	    	    }
	       }catch(Exception e){
	    	      e.printStackTrace();
	       }
		return answer;
	}
}
