package in.ineuron.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import in.ineuron.dao.IStudentDao;
import in.ineuron.daofactory.DaoFactory;
import in.ineuron.dto.Borrow;
import in.ineuron.dto.Student;

public class StudentServiceImpl implements IStudentService {

	@Override
	public String addStudent(Student student) {
		IStudentDao studentDao = DaoFactory.getStudentDao();
		return studentDao.addStudent(student);
	}

	@Override
	public Student getStudent(String sid) {
		IStudentDao studentDao = DaoFactory.getStudentDao();
		return studentDao.getStudent(sid);
	}

	@Override
	public String addBorrow(Borrow borrow) {
		IStudentDao studentDao = DaoFactory.getStudentDao();
		return studentDao.addBorrow(borrow);
	}

	@Override
	public List<Borrow> getBorrowDetails(String sid) {
		IStudentDao studentDao = DaoFactory.getStudentDao();
		return studentDao.getBorrowDetails(sid);
	}

	@Override
	public List<Borrow> toBeReturned(String sid) {
		IStudentDao studentDao = DaoFactory.getStudentDao();
		List<Borrow> returnPending = studentDao.toBeReturned(sid);

		for (Borrow borrow : returnPending) {

			Date dob = borrow.getDob();
			DateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");

			// Get the current date and time
			Date currentDate = new Date();

			// Format the current date as a string in the yyyy-MM-dd format
			String formattedDate = outputDateFormat.format(currentDate);

			// Parse the formatted date string to create a Date object representing the current date
			Date current = null;
			try {
			    current = outputDateFormat.parse(formattedDate);
			} catch (ParseException e) {
			    e.printStackTrace();
			}
			

			 long differenceInDays = Math.abs((dob.getTime() - current.getTime()) / (1000 * 60 * 60 * 24));
			
			int fine = 0;

			if (differenceInDays > 15) {
				fine = (int) (10 * (differenceInDays - 15));
				System.out.println(fine);
				borrow.setFine(fine);
			}

		}

		return returnPending;
	}

	@Override
	public String updateStudentBooks(String sid) {
		IStudentDao studentDao = DaoFactory.getStudentDao();
		return studentDao.updateStudentBooks(sid);
	}

	@Override
	public String updateBorrow(String sid, Integer bid) {
		IStudentDao studentDao = DaoFactory.getStudentDao();
		return studentDao.updateBorrow(sid, bid);
	}

	@Override
	public String updateStudent(Student student) {
		IStudentDao studentDao = DaoFactory.getStudentDao();
		return studentDao.updateStudent(student);
	}

	@Override
	public String deleteStudent(String sid) {
		IStudentDao studentDao = DaoFactory.getStudentDao();
		return studentDao.deleteStudent(sid);
	}

}
