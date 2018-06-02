package nuc.edu.entity;

import java.sql.Timestamp;

public class Comment {
       private int comment_id;//评论id
       private Timestamp com_time;//评论时间
       private int s_id;//学生id
       private int like_num;//点赞数
       private int unlike_num;//贬低数
       private String com_content;//评论内容
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public Timestamp getCom_time() {
		return com_time;
	}
	public void setCom_time(Timestamp com_time) {
		this.com_time = com_time;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public int getLike_num() {
		return like_num;
	}
	public void setLike_num(int like_num) {
		this.like_num = like_num;
	}
	public int getUnlike_num() {
		return unlike_num;
	}
	public void setUnlike_num(int unlike_num) {
		this.unlike_num = unlike_num;
	}
	public String getCom_content() {
		return com_content;
	}
	public void setCom_content(String com_content) {
		this.com_content = com_content;
	}
       
}
