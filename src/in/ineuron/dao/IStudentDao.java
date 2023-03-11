package in.ineuron.dao;

import java.util.List;

import in.ineuron.dto.Borrow;
import in.ineuron.dto.Student;

public interface IStudentDao {
	
	public String addStudent(Student student);//Registering the student
	
	public Student getStudent(String sid);//get 1 student using sid, used for login
	
	public String addBorrow(Borrow borrow);//record inserted when student borrow the book,(sid,bid,dob,dor..)

	public List<Borrow> getBorrowDetails(String sid);//history of borrow of particular student
	
	public String updateBorrow(String sid, Integer bid);//update isReturned to true when student return the book.
	
	public List<Borrow> toBeReturned(String sid);//Books which are to be returned(isReturned=true)
	
	public String updateStudentBooks(String sid);//updating the student account books(student table), when he borrow and return.
	
	public String updateStudent(Student student); // update a student using ID
	
	public String deleteStudent(String sid);// Delete a student using ID

	
}
