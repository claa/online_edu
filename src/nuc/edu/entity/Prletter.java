package nuc.edu.entity;


public class Prletter {
            private int prletter_id;//私信id
            private String prletter_content;//私信内容
            private String sender_Email;//发送者的邮箱
            private String receiver_Email;//接受者的邮箱
            private String prletter_time;//私信时间
            private int prletter_read;//是否已读标记 0是已读 1是未读
            private int prletter_title;//目标私信
            private String prletter_remove;
			public int getPrletter_id() {
				return prletter_id;
			}
			public void setPrletter_id(int prletter_id) {
				this.prletter_id = prletter_id;
			}
			public String getPrletter_content() {
				return prletter_content;
			}
			public void setPrletter_content(String prletter_content) {
				this.prletter_content = prletter_content;
			}
			public String getSender_Email() {
				return sender_Email;
			}
			public void setSender_Email(String sender_Email) {
				this.sender_Email = sender_Email;
			}
			public String getReceiver_Email() {
				return receiver_Email;
			}
			public void setReceiver_Email(String receiver_Email) {
				this.receiver_Email = receiver_Email;
			}
			public String getPrletter_time() {
				return prletter_time;
			}
			public void setPrletter_time(String prletter_time) {
				this.prletter_time = prletter_time;
			}
			public int getPrletter_read() {
				return prletter_read;
			}
			public void setPrletter_read(int prletter_read) {
				this.prletter_read = prletter_read;
			}
			public int getPrletter_title() {
				return prletter_title;
			}
			public void setPrletter_title(int prletter_title) {
				this.prletter_title = prletter_title;
			}
			public String getPrletter_remove() {
				return prletter_remove;
			}
			public void setPrletter_remove(String prletter_remove) {
				this.prletter_remove = prletter_remove;
			}
			
			
}
