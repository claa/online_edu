package nuc.edu.entity;

import java.sql.Timestamp;

public class Answer {
      private int answer_id;//ʦ�����۵Ļش�id
      private int answerer_id;//�ش��ߵ�id
      private Timestamp answer_time;//�ش��ʱ��
      private int answerer_type;//�ش��ߵ����� 0��ѧ�������� 1����ʦ������
      private  String answer_content;//�ش������
      private int answer_forum_id;//�ش�������������id
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
