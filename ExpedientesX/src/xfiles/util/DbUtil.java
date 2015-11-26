package xfiles.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class DbUtil {

	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void initialize() {
		System.out
				.println("DbUtil.initialize() *************************************** ");
		DataSource dataSource = getDataSource();
		try {
			Connection connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate("DROP TABLE USER_AUTHENTICATION IF EXISTS");
			statement
					.executeUpdate("CREATE TABLE USER_AUTHENTICATION (USER_ID INTEGER, USERNAME VARCHAR(50), PASSWORD VARCHAR(50), ENABLED BOOLEAN);");
			statement
					.executeUpdate("INSERT INTO USER_AUTHENTICATION VALUES(1,'alpha','pass1',TRUE);");
			statement.executeUpdate("DROP TABLE USER_AUTHORIZATION IF EXISTS");
			statement
					.executeUpdate("CREATE TABLE USER_AUTHORIZATION (USER_ROLE_ID INTEGER,USER_ID INTEGER, ROLE VARCHAR(50));");
			statement
					.executeUpdate("INSERT INTO USER_AUTHORIZATION VALUES(1,1,'ROLE_ADMIN');");

			statement.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}