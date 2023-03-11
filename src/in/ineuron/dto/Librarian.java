package in.ineuron.dto;

public class Librarian {
	private String id;
	private String userName;
	private String password;
	public Librarian(String userName, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Librarian [id=" + id + ", userName=" + userName + ", password=" + password + "]";
	}
	
	

}
