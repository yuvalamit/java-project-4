import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	private Connection conn;
	private Statement stmt;
	ResultSet result = null;

	public Database() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "root");
			stmt = conn.createStatement();
			dropTable();
			addTable();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	private void addTable() {
		try {
			stmt.executeUpdate("CREATE TABLE Strategies (ID int, Code varchar(50), Client int, Severity int,Time int)");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void insert(int id, String code, int client, int severity, int time) {
		try {
			stmt.executeUpdate("INSERT INTO Strategies VALUES(" + id + ", " + code + "," + client + "," + severity + ","
					+ time + ")");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	private void dropTable() {
		try {
			stmt.executeUpdate("Drop TABLE IF EXISTS Strategies");
		} catch (SQLException ex) {
		}
	}

	public ResultSet getItem() {
		if (conn == null)
			return null;
		String query = "select * from Strategies where(select min(Time) from Strategies) ";
		try {
			return stmt.executeQuery(query);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public void print() {

		try {
			System.out.println("#  " + "AreaCode" + "\t" + " Description" + "\t");
			System.out.println("-  --------" + "\t" + " ------" + "\t");
			while (result.next()) {
				int AreaCode = result.getInt("AreaCode");
				String Description = result.getString("Description");
				System.out.println(result.getRow() + "     " + AreaCode + "\t  " + Description + "\t");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
