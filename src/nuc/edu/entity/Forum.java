package nuc.edu.entity;

import java.sql.Timestamp;

public class Forum {
        private int forum_id;//ʦ������id
        private int s_id;//ѧ��id
        private String forum_content;//��������
        private int forum_type;//��������
        private Timestamp forum_time;//�������۵�ʱ��
        private int like_num;//������
        private String answer_id;//�ش��ߵ�id
        private int answer_num;//�ش���
        private int watch_num;//�ۿ���
        private int course_id;
        private String forum_title;//���۱���
        public String getForum_title() {
			return forum_title;
		}
		public void setForum_title(String forum_title) {
			this.forum_title = forum_title;
		}
		public int getForum_id() {
			return forum_id;
		}
		public void setForum_id(int forum_id) {
			this.forum_id = forum_id;
		}
		public int getS_id() {
			return s_id;
		}
		public void setS_id(int s_id) {
			this.s_id = s_id;
		}
		public String getForum_content() {
			return forum_content;
		}
		public void setForum_content(String forum_content) {
			this.forum_content = forum_content;
		}
		public int getForum_type() {
			return forum_type;
		}
		public void setForum_type(int forum_type) {
			this.forum_type = forum_type;
		}
		public Timestamp getForum_time() {
			return forum_time;
		}
		public void setForum_time(Timestamp forum_time) {
			this.forum_time = forum_time;
		}
		public int getLike_num() {
			return like_num;
		}
		public void setLike_num(int like_num) {
			this.like_num = like_num;
		}
		public String getAnswer_id() {
			return answer_id;
		}
		public void setAnswer_id(String answer_id) {
			this.answer_id = answer_id;
		}
		public int getAnswer_num() {
			return answer_num;
		}
		public void setAnswer_num(int answer_num) {
			this.answer_num = answer_num;
		}
		public int getWatch_num() {
			return watch_num;
		}
		public void setWatch_num(int watch_num) {
			this.watch_num = watch_num;
		}
		public int getCourse_id() {
			return course_id;
		}
		public void setCourse_id(int course_id) {
			this.course_id = course_id;
		}
}
