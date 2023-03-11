package in.ineuron.servicefactory;

import in.ineuron.service.BookServiceImpl;
import in.ineuron.service.IBookService;
import in.ineuron.service.IStudentService;
import in.ineuron.service.StudentServiceImpl;

public class ServiceFactory {

	private ServiceFactory() {
		// TODO Auto-generated constructor stub
	}

	public static IStudentService studentService = null;
	public static IBookService bookService = null;

	public static IBookService getBookService() {

		if (bookService == null) {
			bookService = new BookServiceImpl();
		}

		return bookService;

	}

	public static IStudentService getStudentService() {

		if (studentService == null)
			studentService = new StudentServiceImpl();

		return studentService;
	}

}
