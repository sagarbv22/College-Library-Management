package in.ineuron.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import in.ineuron.dto.Book;
import in.ineuron.dto.Student;
import in.ineuron.service.IBookService;
import in.ineuron.service.IStudentService;
import in.ineuron.servicefactory.ServiceFactory;

@WebFilter("/stdtest/*")
public class StudentFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest hreq = (HttpServletRequest) request;
		String requestURI = hreq.getRequestURI();
		IStudentService studentService = ServiceFactory.getStudentService();

//		if (hreq.getRequestURI().endsWith("login")) {
//
//
//			String sid = request.getParameter("sid");
//			Student student = studentService.getStudent(sid);
//
//			if (student != null) {
//				String userid = student.getSid();
//				String password = student.getPassword();
//				if (userid.equalsIgnoreCase(request.getParameter("sid"))
//						&& password.equals(request.getParameter("password"))) {
//					chain.doFilter(request, response);
//				}
//
//				else
//					reqDispatch(request, response);
//
//			} else {
//				reqDispatch(request, response);
//			}
//
//		}

		// checking the book is available or not when student enter the book ID to borrow
		if (requestURI.endsWith("borrow")) {

			String bid = hreq.getParameter("bid");

			IBookService bookService = ServiceFactory.getBookService();
			Book book = bookService.searchBook(Integer.parseInt(bid));
			studentService = ServiceFactory.getStudentService();
			Student student = studentService.getStudent(hreq.getParameter("sid"));

			if (book != null && book.getQuantity() > 0) { //Book should be available with more than 0 quantity
				
				if(student!=null && student.getBooks()<3) { //student should be able to take books within the limit 3 books
						chain.doFilter(request, response);
				} else {
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/std-limit.jsp");
					requestDispatcher.forward(request, response);
				}

			} else {
				request.setAttribute("bid", bid);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/std-booknotavailable.jsp");
				requestDispatcher.forward(request, response);
			}

		} else
			chain.doFilter(request, response);

	}

//	private void reqDispatch(ServletRequest request, ServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/wrongcred.jsp");
//		requestDispatcher.forward(request, response);
//
//	}

}
