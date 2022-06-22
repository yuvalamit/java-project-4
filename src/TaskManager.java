
public class TaskManager extends Thread {

	protected String name;
	protected Queue<Task> tasksList;
	protected static boolean endDay = false;

	// constructor:
	public TaskManager(String name, Queue<Task> tasksList) {
		this.name = name;
		this.tasksList = tasksList;
	}

	public void run() {
		while (!endDay) {
			if (tasksList.isEmpty())
				tasksList.waitItem();
			try {
				sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Strategy strategy = convertToStrategy(tasksList.getItem());
			// TODO: add the strategy to system information
			System.out.println("Task " + strategy.id + " converted and stored on the system");
		}
		// TODO: die by agency end the day
	}

	public Strategy convertToStrategy(Task task) {
		int id = task.id;
		String codeName = anagram(task);// convert to a code name.
		String Severity = task.Type;
		String customerType = task.customerType;
		int Time = (getLevel(task) * getTypeCustomer(task)) * 1000;
		return new Strategy(id, codeName, Severity, customerType, Time);
	}

	// function that mix up the letters of the suspect and creating a code name.
	public String anagram(Task T) {
		String temp = T.theSuspect;
		for (int i = 0; i < (temp.length() / 2); i++)
			for (int j = temp.length() - 1; j > (temp.length() / 2); j--)
				swap(temp, i, j);
		return temp;
	}

	// function that switch with 2 letters.
	static String swap(String str, int i, int j) {
		if (j == str.length() - 1)
			return str.substring(0, i) + str.charAt(j) + str.substring(i + 1, j) + str.charAt(i);

		return str.substring(0, i) + str.charAt(j) + str.substring(i + 1, j) + str.charAt(i)
				+ str.substring(j + 1, str.length());
	}

	// sort by level.
	public int getLevel(Task T) {
		switch (T.Type) {
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

	public int getTypeCustomer(Task t) {
		switch (t.customerType) {
		case "private":
			return 1;
		case "business":
			return 2;
		case "government":
			return 3;
		}
		return 0;

	}
}
