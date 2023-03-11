package in.ineuron.daofactory;

import in.ineuron.dao.BookDaoImpl;
import in.ineuron.dao.IBookDao;
import in.ineuron.dao.IStudentDao;
import in.ineuron.dao.StudentDaoImpl;

public class DaoFactory {

	private DaoFactory() {

	}

	public static IStudentDao studentDao = null;
	public static IBookDao bookDao = null;

	public static IStudentDao getStudentDao() {

		if (studentDao == null) {
			studentDao = new StudentDaoImpl(); //StudentDaoImpl object
		}

		return studentDao;

	}

	public static IBookDao getBookDao() {

		if (bookDao == null) {
			bookDao = new BookDaoImpl(); //BookDaoImpl object
		}

		return bookDao;

	}
	

}
