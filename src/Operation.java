import java.util.Vector;

public class Operation {
	protected int id;
	protected String codeName;
	protected String Level;
	protected String customerType;
	protected int Time;
	protected static int i = 0;
	protected Vector<Vehicle> vehicleOnOperation = new Vector<Vehicle>();
	protected Vector<Agent> agentOnOperation = new Vector<Agent>();
	protected int numOfInvestigators;
	protected int numOfDetectives;
	protected int numOfVehicles;

	public Operation(int id, String codeName, String level, String customerType, int time) {
		this.id = i++;
		this.codeName = codeName;
		Level = level;
		this.customerType = customerType;
		Time = time;
		setNumOfAgent();
	}

	private void setNumOfAgent() {
		switch (getLevel()) {
		case 1:
			numOfDetectives = 0;
			numOfInvestigators = 2;
			break;
		case 2:
			numOfDetectives = 2;
			numOfInvestigators = 2;
			break;
		case 3:
			numOfDetectives = 5;
			numOfInvestigators = 1;
			break;
		case 4:
			numOfDetectives = 6;
			numOfInvestigators = 4;
			break;
		case 5:
			numOfDetectives = 8;
			numOfInvestigators = 7;
			break;

		}
	}

	// sort by level.
	public int getLevel() {
		switch (this.Level) {
		case "inquiry":
			return 1;
		case "Background check":
			return 2;
		case "surveillance":
			return 3;
		case "fraud and illegal activity":
			return 4;
		case "missing people":
			return 5;
		}
		return 0;

	}

	public synchronized void endOperation() {
		while (!vehicleOnOperation.isEmpty()) {
			vehicleOnOperation.elementAt(0).available = true;
			vehicleOnOperation.remove(0);
		}
		while (!agentOnOperation.isEmpty()) {
			agentOnOperation.elementAt(0).available = true;
			agentOnOperation.remove(0);
		}
		notifyAll();
	}

	public int totalAgent() {
		return (numOfDetectives + numOfInvestigators);
	}
	// TODO:not finished!!!!

}
