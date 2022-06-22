import java.sql.ResultSet;
import java.sql.SQLException;

public class InformationSystem {
	protected Database db;

	public InformationSystem() {
		this.db = new Database();
	}

	public synchronized void insertStrategy(Strategy strategy) {
		db.insert(strategy.id, strategy.codeName, strategy.getCustomerType(), strategy.getSeverity(), strategy.Time);
	}

	public synchronized Strategy getStrategy() {
		ResultSet row = db.getItem();
		if (row != null) {
			try {
				return new Strategy(row.getInt("ID"), row.getString("Code"), getSeverity(row), getTypeCustomer(row),
						row.getInt("Time"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	private String getTypeCustomer(ResultSet row) {
		try {
			switch (row.getInt("Client")) {
			case 1:
				return "private";
			case 2:
				return "business";
			case 3:
				return "government";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private String getSeverity(ResultSet row) {
		try {
			switch (row.getInt("Severity")) {
			case 1:
				return "inquiry";
			case 2:
				return "Background check";
			case 3:
				return "surveillance";
			case 4:
				return "fraud and illegal activity";
			case 5:
				return "missing people";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
