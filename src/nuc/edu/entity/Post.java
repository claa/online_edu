package nuc.edu.entity;

import java.sql.Timestamp;

public class Post {
        private int post_id;//帖子id
        private String post_title;//帖子标题
		private String post_content;//帖子内容
        private int sender_id;//发送者id
        private int sender_sign;//发送者标识 0是学生 1是老师
        private Timestamp post_time;//发送时间
        private String reply_id;//回复者的id
        private int like_num;//点赞次数
        private int watch_num;//观看次数
        private int reply_num;//回复次数
        private int major_id;//相关专业
        private int sign;
		public int getReply_num() {
			return reply_num;
		}
		public void setReply_num(int reply_num) {
			this.reply_num = reply_num;
		}
		public int getLike_num() {
			return like_num;
		}
		public void setLike_num(int like_num) {
			this.like_num = like_num;
		}
		public int getWatch_num() {
			return watch_num;
		}
		public void setWatch_num(int watch_num) {
			this.watch_num = watch_num;
		}
		public int getPost_id() {
			return post_id;
		}
		public void setPost_id(int post_id) {
			this.post_id = post_id;
		}
		public String getPost_title() {
			return post_title;
		}
		public void setPost_title(String post_title) {
			this.post_title = post_title;
		}
		public String getPost_content() {
			return post_content;
		}
		public void setPost_content(String post_content) {
			this.post_content = post_content;
		}
		public int getSender_id() {
			return sender_id;
		}
		public void setSender_id(int sender_id) {
			this.sender_id = sender_id;
		}
		public int getSender_sign() {
			return sender_sign;
		}
		public void setSender_sign(int sender_sign) {
			this.sender_sign = sender_sign;
		}
		public Timestamp getPost_time() {
			return post_time;
		}
		public void setPost_time(Timestamp post_time) {
			this.post_time = post_time;
		}
		public String getReply_id() {
			return reply_id;
		}
		public void setReply_id(String reply_id) {
			this.reply_id = reply_id;
		}
		public int getMajor_id() {
			return major_id;
		}
		public void setMajor_id(int major_id) {
			this.major_id = major_id;
		}
		public int getSign() {
			return sign;
		}
		public void setSign(int sign) {
			this.sign = sign;
		}
}
