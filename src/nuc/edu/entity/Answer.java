package nuc.edu.entity;

import java.sql.Timestamp;

public class Answer {
      private int answer_id;//师生讨论的回答id
      private int answerer_id;//回答者的id
      private Timestamp answer_time;//回答的时间
      private int answerer_type;//回答者的类型 0是学生答疑区 1是老师答疑区
      private  String answer_content;//回答的内容
      private int answer_forum_id;//回答的是哪条问题的id
      private int answer_like_num;
      private String answer_like_id;
      public int getAnswer_forum_id() {
		return answer_forum_id;
	}
	public void setAnswer_forum_id(int answer_forum_id) {
		this.answer_forum_id = answer_forum_id;
	}
	public int getAnswer_like_num() {
		return answer_like_num;
	}
	public void setAnswer_like_num(int answer_like_num) {
		this.answer_like_num = answer_like_num;
	}
	public String getAnswer_like_id() {
		return answer_like_id;
	}
	public void setAnswer_like_id(String answer_like_id) {
		this.answer_like_id = answer_like_id;
	}
	public int getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(int answer_id) {
		this.answer_id = answer_id;
	}
	public int getAnswerer_id() {
		return answerer_id;
	}
	public void setAnswerer_id(int answerer_id) {
		this.answerer_id = answerer_id;
	}
	public Timestamp getAnswer_time() {
		return answer_time;
	}
	public void setAnswer_time(Timestamp answer_time) {
		this.answer_time = answer_time;
	}
	public int getAnswerer_type() {
		return answerer_type;
	}
	public void setAnswerer_type(int answerer_type) {
		this.answerer_type = answerer_type;
	}
	public String getAnswer_content() {
		return answer_content;
	}
	public void setAnswer_content(String answer_content) {
		this.answer_content = answer_content;
	}
	
}
