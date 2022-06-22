public class Strategy {

	protected int id;// number of task.
	protected String codeName;
	protected String Severity;// 1-5
	protected String customerType;// 1-private, 2-business, 3-governmental.
	protected int Time;// estimated time it will take for the operation.

	// constructor:
	public Strategy(int num, String codeN, String severity, String cType, int time) {
		this.id = num;
		this.codeName = codeN;
		this.Severity = severity;
		this.customerType = cType;
		this.Time = time;
	}

	// sort by Severity.
	public int getSeverity() {
		switch (Severity) {
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

	public int getCustomerType() {
		switch (this.customerType) {
		case "private":
			return 1;
		case "business":
			return 2;
		case "government":
			return 3;
		}
		return 0;
	}

	// TODO:not finished!!!!
}
