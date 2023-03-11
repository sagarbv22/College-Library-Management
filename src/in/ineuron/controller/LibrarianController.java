package in.ineuron.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.ineuron.dto.Book;
import in.ineuron.dto.Borrow;
import in.ineuron.dto.Librarian;
import in.ineuron.dto.Student;
import in.ineuron.service.BookServiceImpl;
import in.ineuron.service.IBookService;
import in.ineuron.service.ILibrarianService;
import in.ineuron.service.IStudentService;
import in.ineuron.service.LibrarianServiceImpl;
import in.ineuron.servicefactory.ServiceFactory;

@WebServlet("/controller/*")
public class LibrarianController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ILibrarianService service = new LibrarianServiceImpl();
	RequestDispatcher dispatcher;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// authentication logic

		doProcess(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// authentication logic

		doProcess(request, response);

	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getRequestURI());
		IStudentService studentService = ServiceFactory.getStudentService();
		IBookService bookService = ServiceFactory.getBookService();

		// Staff login
		if (request.getRequestURI().endsWith("/controller")) {

			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			if (userName == null || userName == "") {
				request.setAttribute("status", "invalidUserName");
				dispatcher = request.getRequestDispatcher("./errorLogin.jsp");
				dispatcher.forward(request, response);
			}
			if (password == null || password == "") {
				request.setAttribute("status", "invalidPassword");
				dispatcher = request.getRequestDispatcher("./errorLogin.jsp");
				dispatcher.forward(request, response);
			}

			Librarian librarian = service.getLibrarian(userName);

			if (librarian != null && librarian.getUserName().equalsIgnoreCase(userName)) {
				if (password.equals(librarian.getPassword())) {
					request.setAttribute("status", "success");
					dispatcher = request.getRequestDispatcher("./homepage/homepage.jsp");
					dispatcher.forward(request, response);
				} else {
					request.setAttribute("status", "invalidPassword");
					dispatcher = request.getRequestDispatcher("./errorLogin.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				request.setAttribute("status", "invalidUserName");
				dispatcher = request.getRequestDispatcher("./errorLogin.jsp");
				dispatcher.forward(request, response);
			}
		}

		// Search a particular student
		if (request.getRequestURI().endsWith("search")) {

			Integer bid = Integer.parseInt(request.getParameter("bid"));
			if (bid != null) {
				Book book = bookService.searchBook(bid);

				request.setAttribute("book", book);
				RequestDispatcher dispatcher2 = request.getRequestDispatcher("/searchresult.jsp");
				dispatcher2.forward(request, response);

			} else {
				RequestDispatcher dispatcher3 = request.getRequestDispatcher("/searchresult.jsp");
				dispatcher3.forward(request, response);
			}

		}

		// add book
		if (request.getRequestURI().endsWith("add")) {
			Integer bid = Integer.parseInt(request.getParameter("bid"));
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			Integer quantity = Integer.parseInt(request.getParameter("quantity"));
			Book book = new Book();
			book.setBid(bid);
			book.setAuthor(author);
			book.setTitle(title);
			book.setQuantity(quantity);
			String addBook = bookService.addBook(book);
			request.setAttribute("result", addBook);
			RequestDispatcher dispatcher2 = request.getRequestDispatcher("/addresult.jsp");
			dispatcher2.forward(request, response);

		}
		// get a particular book
		if (request.getRequestURI().endsWith("get")) {
			Integer bid = Integer.parseInt(request.getParameter("bid"));
			Book book = bookService.searchBook(bid);

			request.setAttribute("book", book);
			request.setAttribute("id", bid);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/updatebook2.jsp");
			dispatcher.forward(request, response);

		}

		// update a particular books
		if (request.getRequestURI().endsWith("update")) {
			Integer bid = Integer.parseInt(request.getParameter("bid"));
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			Integer quantity = Integer.parseInt(request.getParameter("quantity"));
			Book book = new Book();
			book.setBid(bid);
			book.setAuthor(author);
			book.setTitle(title);
			book.setQuantity(quantity);
			String result = bookService.updateBook(book);
			request.setAttribute("result", result);
			RequestDispatcher dispatcher2 = request.getRequestDispatcher("/updateresult.jsp");
			dispatcher2.forward(request, response);

		}

		// Delete particular book
		if (request.getRequestURI().endsWith("/delete")) {
			Integer bid = Integer.parseInt(request.getParameter("bid"));
			String result = bookService.deleteBook(bid);
			request.setAttribute("result", result);
			request.setAttribute("id", bid);
			RequestDispatcher dispatcher2 = request.getRequestDispatcher("/deleteresult.jsp");
			dispatcher2.forward(request, response);
		}

		if (request.getRequestURI().endsWith("getrequests")) { // display the request when libr clicks on return
																// requests

			List<Borrow> returnRequest = service.selectReturnRequest();
			request.setAttribute("requests", returnRequest);

			dispatcher = request.getRequestDispatcher("/getrequests.jsp");
			dispatcher.forward(request, response);

		}

		if (request.getRequestURI().endsWith("accept")) { // libr accepts the request

			String sid = request.getParameter("sid");
			int bid = Integer.parseInt(request.getParameter("bid"));

			String msg = service.deleteReturnRequest(sid, bid);// record from request has to be deleted

			if ("success".equals(msg)) {
				// bookService = ServiceFactory.getBookService(); // increment the count(+)
				String autoUpdateBook = bookService.autoUpdateBook("+" + request.getParameter("bid"));
				String updtStdBooks = studentService.updateStudentBooks("-" + sid);// update book no in student
																					// account(decrease)
				String updtBorrow = studentService.updateBorrow(sid, bid);// update borrow details status true
				System.out.println(autoUpdateBook + " " + updtStdBooks + " " + updtBorrow);
				dispatcher = request.getRequestDispatcher("/lib-accepted.jsp");
				dispatcher.forward(request, response);
			} else
				System.out.println("Something went wrong");

		}

		// issue the books for student
		if (request.getRequestURI().endsWith("/issuebooks")) {

			int bid = Integer.parseInt(request.getParameter("bid"));
			String sid = request.getParameter("sid");
			Book searchBook = bookService.searchBook(bid);
			Student student = studentService.getStudent(sid);
			if (student != null) {
				if (student.getBooks() >= 3) {
					request.setAttribute("limit", "out");
				}
			}
			if(searchBook!=null) {
				if(searchBook.getQuantity()<1) {
					System.out.println(student.getBooks());
					request.setAttribute("quantity", "less");
				}
			}
			if (searchBook != null && searchBook.getQuantity() > 0 && student != null && student.getBooks() < 3) {
				Borrow borrow = new Borrow();
				borrow.setBid(bid);
				borrow.setSid(sid);
				String status = studentService.addBorrow(borrow);
				request.setAttribute("status", status);
				if ("success".equals(status)) { // if it is success then increment and decrement the books...
					String msg = studentService.updateStudentBooks("+" + sid);
					String autoUpdateBook = bookService.autoUpdateBook("-" + bid);
					System.out.println("book decremented-" + autoUpdateBook);
					dispatcher = request.getRequestDispatcher("/lib-issueresult.jsp");
					dispatcher.forward(request, response);
				} else {
					dispatcher = request.getRequestDispatcher("/lib-issueresult.jsp");
					dispatcher.forward(request, response);
				}

			}

			else {
				dispatcher = request.getRequestDispatcher("/lib-issueresult.jsp");
				dispatcher.forward(request, response);
			}
		}

		// logout from the session
		if (request.getRequestURI().endsWith("logout")) {
			HttpSession session = request.getSession(false);
			System.out.println("invalidating the session object...");
			session.invalidate();
			// RequestDispatcher dispatcher2 = request.getRequestDispatcher("/login.jsp");
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			// dispatcher2.forward(request, response);

		}

		// redirecting to home page
		if (request.getRequestURI().endsWith("homepage")) {
			dispatcher = request.getRequestDispatcher("../homepage/homepage.jsp");
			dispatcher.forward(request, response);
		}

		IStudentService studentService2 = ServiceFactory.getStudentService();

		// Add the student
		if (request.getRequestURI().endsWith("addstudent")) {
			String sid = (request.getParameter("sid"));
			String sname = request.getParameter("sname");
			String sbranch = request.getParameter("sbranch");
			String sphone = request.getParameter("sphone");
			Integer sbooks = Integer.parseInt(request.getParameter("sbooks"));

			Student student = new Student();
			student.setBooks(sbooks);
			student.setSname(sname);
			student.setSbranch(sbranch);
			student.setSphone(sphone);
			student.setSid(sid);

			String result = studentService2.addStudent(student);

			request.setAttribute("result", result);
			RequestDispatcher dispatcher2 = request.getRequestDispatcher("/studentaddresult.jsp");
			dispatcher2.forward(request, response);

		}

		// Get the particular student
		if (request.getRequestURI().endsWith("getstudent")) {
			String sid = request.getParameter("sid");
			Student student = studentService2.getStudent(sid);

			request.setAttribute("student", student);
			request.setAttribute("id", sid);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/updatestudent2.jsp");
			dispatcher.forward(request, response);

		}

		// Update a particular student
		if (request.getRequestURI().endsWith("updatestudent")) {

			String sid = request.getParameter("sid");
			String sname = request.getParameter("sname");
			String sbranch = request.getParameter("sbranch");
			String sphone = request.getParameter("sphone");
			String password = request.getParameter("password");
			Integer books = Integer.parseInt(request.getParameter("books"));
			Student student = new Student();
			student.setSphone(sphone);
			student.setBooks(books);
			student.setPassword(password);
			student.setSname(sname);
			student.setSid(sid);
			student.setSbranch(sbranch);
			String result = studentService2.updateStudent(student);
			request.setAttribute("result", result);
			RequestDispatcher dispatcher2 = request.getRequestDispatcher("/updatestudentresult.jsp");
			dispatcher2.forward(request, response);

		}

		// Delete a particular student
		if (request.getRequestURI().endsWith("/deletestudent")) {
			String sid = request.getParameter("sid");
			String result = studentService2.deleteStudent(sid);
			request.setAttribute("result", result);
			RequestDispatcher dispatcher2 = request.getRequestDispatcher("/deletestudentresult.jsp");
			dispatcher2.forward(request, response);
		}

		// Search a student
		if (request.getRequestURI().endsWith("/searchstudent")) {

			String sid = request.getParameter("sid");
			if (sid != null) {
				Student student = studentService2.getStudent(sid);

				request.setAttribute("student", student);
				RequestDispatcher dispatcher2 = request.getRequestDispatcher("/searchstudentresult.jsp");
				dispatcher2.forward(request, response);

			}
		}

	}

}
