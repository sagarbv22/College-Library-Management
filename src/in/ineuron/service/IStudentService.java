package in.ineuron.service;

import java.util.List;

import in.ineuron.dto.Borrow;
import in.ineuron.dto.Student;

public interface IStudentService {
	
	public String addStudent(Student student); //add student
	
	public Student getStudent(String sid); //get student using id

	public String addBorrow(Borrow borrow); // add the borrow record 

	public List<Borrow> getBorrowDetails(String sid); //get the history of the borrow
	
	public List<Borrow> toBeReturned(String sid); //get the book which has to be returned
	
	public String updateStudentBooks(String sid); //update books in student table which is used to set the limit
	
	public String updateBorrow(String sid, Integer bid); //update the borrow details to true
	
	public String updateStudent(Student student); // update a student record
	public String deleteStudent(String sid);// delete the student record
	
}
