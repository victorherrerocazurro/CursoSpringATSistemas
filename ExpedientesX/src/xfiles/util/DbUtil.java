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
		System.out.println("DbUtil.initialize() *************************************** ");
		DataSource dataSource = getDataSource();
		try {
			Connection connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			//statement.executeUpdate("DROP TABLE USER_AUTHENTICATION IF EXISTS");
			statement.executeUpdate(
					"CREATE TABLE USER_AUTHENTICATION (USER_ID INTEGER, USERNAME VARCHAR(50), PASSWORD VARCHAR(50), ENABLED BOOLEAN)");
			statement.executeUpdate(
					"INSERT INTO USER_AUTHENTICATION VALUES(1,'Fernando','94c0a821ece1959c48dbc789bcf024b9',TRUE)");
			statement.executeUpdate(
					"INSERT INTO USER_AUTHENTICATION VALUES(2,'Mulder','cd2adcfcfae70a64c5870b7f79ae4945',TRUE)");
			statement.executeUpdate(
					"INSERT INTO USER_AUTHENTICATION VALUES(3,'Skinner','829679019772c945c70602096268737c',TRUE)");
			statement.executeUpdate(
					"INSERT INTO USER_AUTHENTICATION VALUES(4,'Scully','4fb2b097cb9690d77cf7f2246b782fc3',TRUE)");

			//statement.executeUpdate("DROP TABLE USER_AUTHORIZATION IF EXISTS");
			statement.executeUpdate(
					"CREATE TABLE USER_AUTHORIZATION (USER_ROLE_ID INTEGER,USER_ID INTEGER, ROLE VARCHAR(50))");
			statement.executeUpdate("INSERT INTO USER_AUTHORIZATION VALUES(1,1,'ROLE_AGENT')");
			statement.executeUpdate("INSERT INTO USER_AUTHORIZATION VALUES(2,2,'ROLE_SPECIAL_AGENT')");
			statement.executeUpdate("INSERT INTO USER_AUTHORIZATION VALUES(2,4,'ROLE_SPECIAL_AGENT')");
			statement.executeUpdate("INSERT INTO USER_AUTHORIZATION VALUES(3,3,'ROLE_ASSISTANT_DIRECTOR')");

			statement.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}