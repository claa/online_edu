package nuc.edu.entity;

public class Major {
           private int major_id;//רҵid
           private String major_name;//רҵ����
           private int academy_id;//����ѧԺid
           private String academy;
           
		public String getAcademy() {
			return academy;
		}
		public void setAcademy(String academy) {
			this.academy = academy;
		}
		public int getMajor_id() {
			return major_id;
		}
		public void setMajor_id(int major_id) {
			this.major_id = major_id;
		}
		public String getMajor_name() {
			return major_name;
		}
		public void setMajor_name(String major_name) {
			this.major_name = major_name;
		}
		public int getAcademy_id() {
			return academy_id;
		}
		public void setAcademy_id(int academy_id) {
			this.academy_id = academy_id;
		}
           
}
