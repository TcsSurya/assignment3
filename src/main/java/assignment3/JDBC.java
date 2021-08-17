package assignment3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
	public static void main(String[] args) {
		String DB_URL = "jdbc:mysql://localhost/bankaccount";
		String DB_USER = "root";
		String DB_PASSWORD = "Nuvelabs123$";

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				Statement statement = connection.createStatement();) {
//			 create(statement);//create operation
//			update(statement);
			
			 delete(statement);
//			List<String> reg = retrieveWithCondittion(statement, "A");
//			logger.debug(reg.toString());
//			sort(statement);
			 retrieve(statement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		;
	}
	
	private static void create(Statement statement) throws SQLException {
		statement.execute("INSERT INTO ACCOUNT VALUES(2,'Pradeep','Dadar west','2021-07-15','active','current')");
		statement.execute("INSERT INTO account values(3,'Amit','virar east','2021-08-08','active','saving')");
	}
	private static void retrieve(Statement statement) throws SQLException {
		ResultSet resultSet = statement.executeQuery("SELECT * FROM account");

		while (resultSet.next()) {
		System.out.println(resultSet.getInt(1) + " | "+ resultSet.getNString("name") + " | " + resultSet.getNString("address") + " | " + resultSet.getDate("dateCreated")+ resultSet.getNString("status") + " | " + resultSet.getNString("accountType") );
		}
		System.out.println("");
	}
	
	private static void update(Statement statement) throws SQLException {
		statement.execute("UPDATE account SET name='Stupid' WHERE idaccount=1");
	}
	
	private static void delete(Statement statement) throws SQLException {
		statement.execute("DELETE FROM account WHERE idaccount=1");
	}
}
