package in.ineuron.dto;

import java.util.Date;

public class Borrow {

	private String sid;
	private Integer bid;
	private Date dob;
	private Date dor;
	private boolean status;
	private Integer fine;

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDor() {
		return dor;
	}

	public void setDor(Date dor) {
		this.dor = dor;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Integer getFine() {
		return fine;
	}

	public void setFine(Integer fine) {
		this.fine = fine;
	}

	@Override
	public String toString() {
		return "Borrow [sid=" + sid + ", bid=" + bid + ", dob=" + dob + ", dor=" + dor + ", status=" + status
				+ ", fine=" + fine + "]";
	}
	
	
}
