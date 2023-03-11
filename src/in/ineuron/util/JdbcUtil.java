package in.ineuron.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {

	static {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	//get the connection using this method
	public static Connection getConnection() throws IOException, SQLException {

		FileInputStream inputStream = new FileInputStream(
				new File("D:\\iNeuronProjects\\LibraryManagementSystem\\src\\in\\ineuron\\application\\Application.properties"));
		Properties properties = new Properties();
		properties.load(inputStream);

		String url = properties.getProperty("url");
		String user = properties.getProperty("userId");
		String password = properties.getProperty("passWord");

		Connection connection = DriverManager.getConnection(url, user, password);

		return connection;

	}

}
