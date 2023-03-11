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

import com.mysql.cj.Session;

import in.ineuron.dto.Book;
import in.ineuron.dto.Borrow;
import in.ineuron.dto.Student;
import in.ineuron.service.IBookService;
import in.ineuron.service.ILibrarianService;
import in.ineuron.service.IStudentService;
import in.ineuron.service.LibrarianServiceImpl;
import in.ineuron.servicefactory.ServiceFactory;

@WebServlet("/stdtest/*")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);

	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher requestDispatcher = null;

		IStudentService studentService = ServiceFactory.getStudentService();
		IBookService bookService = ServiceFactory.getBookService();
		
		//Student Registration
		if (request.getRequestURI().endsWith("reg")) {

			Student student = new Student();
			String id = request.getParameter("sid");
			student.setSid(id);
			student.setSname(request.getParameter("sname"));
			student.setSbranch(request.getParameter("sbranch"));
			student.setSphone(request.getParameter("sphone"));
			student.setPassword(request.getParameter("password"));

			String status = studentService.addStudent(student);

			if ("success".equals(status)) {
				HttpSession session = request.getSession();
				session.setAttribute("sid", id);
				requestDispatcher = request.getRequestDispatcher("/std-home.jsp");
				requestDispatcher.forward(request, response);
			} else {
				requestDispatcher = request.getRequestDispatcher("/std-regfailed.html");
				requestDispatcher.forward(request, response);

			}

		}
		
		//Student Login
		if (request.getRequestURI().endsWith("login")) {

			String sid = request.getParameter("sid");
			Student student = studentService.getStudent(sid);
			request.setAttribute("student", student);
			if (student != null) {
				String userid = student.getSid();
				String password = student.getPassword();
				System.out.println(userid + " " + password);
				if (userid.equalsIgnoreCase(request.getParameter("sid"))
						&& password.equals(request.getParameter("password"))) {

					HttpSession session = request.getSession();
					session.setAttribute("sid", sid);

					requestDispatcher = request.getRequestDispatcher("/std-home.jsp");
					requestDispatcher.forward(request, response);
				} else {
					System.out.println("entered password " + request.getParameter("password"));
					requestDispatcher = request.getRequestDispatcher("/std-loginfailed.jsp");
					requestDispatcher.forward(request, response);
				}

			} else {
				requestDispatcher = request.getRequestDispatcher("/std-loginfailed.jsp");
				requestDispatcher.forward(request, response);
			}

		}
		
		//Redirecting to student home page
		if (request.getRequestURI().endsWith("home")) {

			requestDispatcher = request.getRequestDispatcher("/std-home.jsp");
			requestDispatcher.forward(request, response);
		}
		
		//Borrowing the books
		if (request.getRequestURI().endsWith("borrow")) {
			int bid = Integer.parseInt(request.getParameter("bid"));
			String sid = request.getParameter("sid");
			Borrow borrow = new Borrow();
			borrow.setBid(bid);
			borrow.setSid(sid);
			String status = studentService.addBorrow(borrow);
			request.setAttribute("status", status);
			if ("success".equals(status)) {

				String msg = studentService.updateStudentBooks("+" + sid);
				String autoUpdateBook = bookService.autoUpdateBook("-" + bid);
				requestDispatcher = request.getRequestDispatcher("/std-borrowresult.jsp");
				requestDispatcher.forward(request, response);
			} else {
				requestDispatcher = request.getRequestDispatcher("/std-borrowresult.jsp");
				requestDispatcher.forward(request, response);
			}
		}

		//Histroy of borrowed books
		if (request.getRequestURI().endsWith("history")) {
			HttpSession session = request.getSession();
			String sid = session.getAttribute("sid").toString();
			List<Borrow> borrowHistory = studentService.getBorrowDetails(sid);

			

			request.setAttribute("borrowHistory", borrowHistory);
			requestDispatcher = request.getRequestDispatcher("/std-borrowhistory.jsp");
			requestDispatcher.forward(request, response);

		}
		
		
		//Books to returned
		if (request.getRequestURI().endsWith("return")) {
			HttpSession session = request.getSession();
			String sid = session.getAttribute("sid").toString();
			List<Borrow> returnPending = studentService.toBeReturned(sid);

			request.setAttribute("returnPending", returnPending);
			requestDispatcher = request.getRequestDispatcher("/std-returnresult.jsp");
			requestDispatcher.forward(request, response);

		}
		
		//logOut from the session
		if (request.getRequestURI().endsWith("logout")) {

			HttpSession session = request.getSession(false);
			if (session != null) {
				System.out.println("Logging out");
				session.invalidate();
			}
			response.sendRedirect(request.getContextPath() + "/std-login.html");

		}
		
		//Requesting to return the books
		if (request.getRequestURI().endsWith("returnrqst")) {

			String sid = request.getParameter("sid");
			Integer bid = Integer.parseInt(request.getParameter("bid"));

			Borrow borrow = new Borrow();
			borrow.setSid(sid);
			borrow.setBid(bid);
			borrow.setFine(Integer.parseInt(request.getParameter("fine")));
			request.setAttribute("request", borrow);
			ILibrarianService service = new LibrarianServiceImpl();
			String msg = service.addReturnRequest(borrow);
			
			if ("success".equals(msg)) {
				requestDispatcher = request.getRequestDispatcher("/std-requestsent.jsp");
				requestDispatcher.forward(request, response);
			}
			else
				System.out.println("Something went wrong");
		}
		
		// list of all the books
		if(request.getRequestURI().endsWith("getallbooks")) {
			List<Book> allBooks = bookService.getAllBooks();
			System.out.println(allBooks.size());
			request.setAttribute("allBooks", allBooks);
			 requestDispatcher = request.getRequestDispatcher("/std-allbooks.jsp");
			 requestDispatcher.forward(request, response);
			
		}
		
		//Search a particular book
		if(request.getRequestURI().endsWith("searchbook")) {
			
			String bid = request.getParameter("bid");
			Book searchBook = bookService.searchBook(Integer.parseInt(bid));
			
			request.setAttribute("book", searchBook);
			System.out.println(searchBook);
			
			requestDispatcher=request.getRequestDispatcher("/std-searchresult.jsp");
			requestDispatcher.forward(request, response);
			
			
		}
		


	}
}
