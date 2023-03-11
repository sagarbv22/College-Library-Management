package in.ineuron.dto;

public class Student {
	
		private String sid;
		private String sname;
		private String sbranch;
		private String sphone;
		private String password;
		private Integer books;
		
		public Integer getBooks() {
			return books;
		}
		public void setBooks(Integer books) {
			this.books = books;
		}
		public String getSid() {
			return sid;
		}
		public void setSid(String sid) {
			this.sid = sid;
		}
		public String getSname() {
			return sname;
		}
		public void setSname(String sname) {
			this.sname = sname;
		}
		public String getSbranch() {
			return sbranch;
		}
		public void setSbranch(String sbranch) {
			this.sbranch = sbranch;
		}
		public String getSphone() {
			return sphone;
		}
		public void setSphone(String sphone) {
			this.sphone = sphone;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		@Override
		public String toString() {
			return "Student [sid=" + sid + ", sname=" + sname + ", sbranch=" + sbranch + ", sphone=" + sphone
					+ ", password=" + password + ", books=" + books + "]";
		}
		
		
}
