package in.ineuron.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.ineuron.dto.Borrow;
import in.ineuron.dto.Librarian;
import in.ineuron.util.JdbcUtil;

public class LibrarianDaoImpl implements ILibrarianDao {

	private Librarian librarian;
	private Connection connection = null;
	private PreparedStatement pstmt = null;
	private ResultSet resultSet = null;
	private Borrow borrow = null;

	@Override
	public Librarian getLibrarian(String userName) {
		try {
			 connection = JdbcUtil.getConnection();

			 pstmt = connection.prepareStatement("select * from librarian where username=?");
			pstmt.setString(1, userName);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt(1);

				String user = rs.getString(2);
				String password = rs.getString(3);
				librarian = new Librarian(user, password);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return librarian;
	}

	@Override
	public String addReturnRequest(Borrow borrow) {

		String addQuery = "insert into request(sid,bid,fine) values(?,?,?)";

		try {
			 connection = JdbcUtil.getConnection();

			 pstmt = connection.prepareStatement(addQuery);

			pstmt.setString(1, borrow.getSid());
			pstmt.setInt(2, borrow.getBid());
			pstmt.setInt(3, borrow.getFine());

			int row = pstmt.executeUpdate();
			if (row == 1) {
				return "success";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "failed";
	}

	@Override
	public String deleteReturnRequest(String sid, Integer bid) {

		String deleteQuery = "delete from request where sid=? and bid=?";

		try {
			 connection = JdbcUtil.getConnection();

			 pstmt = connection.prepareStatement(deleteQuery);

			pstmt.setString(1, sid);
			pstmt.setInt(2, bid);

			int row = pstmt.executeUpdate();
			if (row > 0) {
				return "success";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "failed";
	}

	@Override
	public List<Borrow> selectReturnRequest() {
		
		String selectQuery = "select sid, bid, fine from request";
		List<Borrow> requests = new ArrayList<>();
		try {
			 connection = JdbcUtil.getConnection();
			if (connection != null)
				pstmt = connection.prepareStatement(selectQuery);
			
			if (pstmt != null)
				resultSet = pstmt.executeQuery();
			if (resultSet != null) {

				while (resultSet.next()) {

					borrow = new Borrow();
					borrow.setSid(resultSet.getString(1));
					borrow.setBid(resultSet.getInt(2));
					borrow.setFine(resultSet.getInt(3));

					requests.add(borrow);
				}

			}

		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return requests;
		
		
		
	}

}
