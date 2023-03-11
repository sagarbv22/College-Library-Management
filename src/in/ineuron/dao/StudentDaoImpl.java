package in.ineuron.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.mysql.cj.xdevapi.Result;

import in.ineuron.dto.Borrow;
import in.ineuron.dto.Student;
import in.ineuron.util.JdbcUtil;

public class StudentDaoImpl implements IStudentDao {

	Connection connection = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt2 = null;
	ResultSet resultSet = null;
	Borrow borrow = null;

	@Override // Registering the student
	public String addStudent(Student student) {

		int row = 0;
		String addQuery = "insert into student(sid,sname,sbranch,sphone,password,books) values(?,?,?,?,?,?)";
		try {
			connection = JdbcUtil.getConnection();

			if (connection != null)
				pstmt = connection.prepareStatement(addQuery);

			if (pstmt != null) {
				pstmt.setString(1, student.getSid());
				pstmt.setString(2, student.getSname());
				pstmt.setString(3, student.getSbranch());
				pstmt.setString(4, student.getSphone());
				pstmt.setString(5, student.getPassword());
				pstmt.setInt(6, 0);

			}

			if (pstmt != null)
				row = pstmt.executeUpdate();

			if (row == 1)
				return "success";

		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "failed";
	}

	@Override // get 1 student using sid, used for login
	public Student getStudent(String sid) {

		String selectQuery = "select sid,sname,sbranch,sphone,password,books from student where sid=?";
		Student student = null;
		try {
			connection = JdbcUtil.getConnection();

			if (connection != null)
				pstmt = connection.prepareStatement(selectQuery);

			if (pstmt != null)
				pstmt.setString(1, sid);

			if (pstmt != null)
				resultSet = pstmt.executeQuery();

			if (resultSet != null)
				if (resultSet.next()) {
					student = new Student();
					student.setSid(resultSet.getString(1));
					student.setSname(resultSet.getString(2));
					student.setSbranch(resultSet.getString(3));
					student.setSphone(resultSet.getString(4));
					student.setPassword(resultSet.getString(5));
					student.setBooks(resultSet.getInt(6));
				}

		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;

	}

	@Override // this used when student borrow the book, the sid and bid will be added ...
	public String addBorrow(Borrow borrow) {
		String addQuery = "insert into borrow (bid,sid,dob,dor,status,fine) values(?,?,?,?,?,?)";
		int row = 0;
		try {
			connection = JdbcUtil.getConnection();

			if (connection != null)
				pstmt = connection.prepareStatement(addQuery);

			if (pstmt != null) {

				pstmt.setInt(1, borrow.getBid());
				pstmt.setString(2, borrow.getSid());
				pstmt.setDate(3, new java.sql.Date(new java.util.Date().getTime()));

				// creating the returning date..
				Calendar c1 = Calendar.getInstance();
				c1.setTime(new java.util.Date());
				c1.add(Calendar.DAY_OF_MONTH, 15);
				java.util.Date returnDate = new java.util.Date(c1.getTimeInMillis());
				pstmt.setDate(4, new java.sql.Date(returnDate.getTime()));
				pstmt.setBoolean(5, false);
				pstmt.setInt(6, 0);

			}

			if (pstmt != null)
				row = pstmt.executeUpdate();
			if (row == 1)
				return "success";

		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "failed";
	}

	@Override // history of borrow of particular student
	public List<Borrow> getBorrowDetails(String sid) {
		String getQuery = "select sid,bid,dob,dor,status,fine from borrow where sid=?";
		List<Borrow> history = new ArrayList<>();
		try {
			connection = JdbcUtil.getConnection();
			if (connection != null)
				pstmt = connection.prepareStatement(getQuery);
			if (pstmt != null)
				pstmt.setString(1, sid);

			if (pstmt != null)
				resultSet = pstmt.executeQuery();
			if (resultSet != null) {

				while (resultSet.next()) {

					borrow = new Borrow();
					borrow.setSid(resultSet.getString(1));
					borrow.setBid(resultSet.getInt(2));
					borrow.setDob(resultSet.getDate(3));
					borrow.setDor(resultSet.getDate(4));
					borrow.setStatus(resultSet.getBoolean(5));
					borrow.setFine(resultSet.getInt(6));

					history.add(borrow);
				}

			}

		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return history;
	}

	@Override // Books which are to be returned
	public List<Borrow> toBeReturned(String sid) {

		String returnQuery = "select sid,bid,dob,dor,status,fine from borrow where sid=? and status = ?";
		List<Borrow> history = new ArrayList<>();
		try {
			connection = JdbcUtil.getConnection();
			if (connection != null)
				pstmt = connection.prepareStatement(returnQuery);
			if (pstmt != null)
				pstmt.setString(1, sid);
			pstmt.setBoolean(2, false);

			if (pstmt != null)
				resultSet = pstmt.executeQuery();
			if (resultSet != null) {

				while (resultSet.next()) {

					borrow = new Borrow();
					borrow.setSid(resultSet.getString(1));
					borrow.setBid(resultSet.getInt(2));
					borrow.setDob(resultSet.getDate(3));
					borrow.setDor(resultSet.getDate(4));
					borrow.setStatus(resultSet.getBoolean(5));
					borrow.setFine(resultSet.getInt(6));

					history.add(borrow);
				}

			}

		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return history;
	}

	@Override // updating the student account books(student table), when he borrow and return.
	public String updateStudentBooks(String sid) {
		int row = 0;
		String choice = sid.substring(0, 1);
		System.out.println(choice);
		String id = sid.substring(1);
		System.out.println(id);
		String incrementQuery = "update student set books=books+1 where sid=?";
		String decrementQuery = "update student set books=books-1 where sid=?";

		try {
			connection = JdbcUtil.getConnection();

			if (connection != null) {
				pstmt = connection.prepareStatement(incrementQuery);
				pstmt2 = connection.prepareStatement(decrementQuery);
			}
			if (pstmt != null) {
				pstmt.setString(1, id);
				pstmt2.setString(1, id);
			}
			if (choice.equals("+")) {
				if (pstmt != null)
					row = pstmt.executeUpdate();
			} else if (choice.equals("-")) {
				row = pstmt2.executeUpdate();
			}
			if (row == 1)
				return "success";

		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "failed";
	}

	@Override
	public String updateBorrow(String sid, Integer bid) { //update isReturned to true when student return the book.

		String updateQuery = "update borrow set status=true where sid=? and bid=? ";
		int row = 0;
		try {
			connection = JdbcUtil.getConnection();

			if (connection != null)
				pstmt = connection.prepareStatement(updateQuery);
			if (pstmt != null) {

				pstmt.setString(1, sid);
				pstmt.setInt(2, bid);

			}
			if (pstmt != null)
				row = pstmt.executeUpdate();
			if (row > 0)
				return "success";

		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "failed";
	}

	@Override
	public String updateStudent(Student student) {
		
		PreparedStatement pstm = null;
		try {
			connection = JdbcUtil.getConnection();
			String query="UPDATE student SET sname=?,sbranch=?,sphone=?,password=?,books=? WHERE sid = ?;";
			pstm = connection.prepareStatement(query);

			if (pstm != null) {

				pstm.setString(6,student.getSid());
				pstm.setString(1,student.getSname());
				pstm.setString(2,student.getSbranch());
				pstm.setString(3, student.getSphone());
				pstm.setString(4, student.getPassword());
				pstm.setInt(5, student.getBooks());

				int rowAffected = pstm.executeUpdate();
				if (rowAffected == 1) {
					System.out.println("updated...");
					return "success";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "failure";
	
	}

	@Override
	public String deleteStudent(String sid) {
		
		PreparedStatement pstm = null;
		try {
			connection=JdbcUtil.getConnection();
			pstm = connection.prepareStatement("delete from student where sid=?");
			pstm.setString(1, sid);
			int rowCount = pstm.executeUpdate();
			if (rowCount == 1) {
				return "success";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
			
		}
		return "failure";
	}

}
