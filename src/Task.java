
public class Task {

	protected int id;// number of task.
	protected String theSuspect;// the name of the interrogated.
	protected String Type;// inquiry/Background check/surveillance/fraud and illegal activity/missing
							// people.
	protected String customerType;// 1-private, 2-business, 3-governmental.
	protected static int i = 0;
	protected int arrival;

	// constructor:
	public Task(String suspect, String type, String customer, int arrival) {
		this.id = i++;
		this.theSuspect = suspect;
		this.Type = type;
		this.customerType = customer;
		this.arrival = arrival;
	}

}
