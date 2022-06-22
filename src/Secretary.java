
public class Secretary extends Thread {
	protected String name;
	protected Queue<Call> callsList;
	protected Queue<Call> waitingCallsList;
	protected Queue<Task> tasksList;

	public Secretary(String name, Queue<Call> callsList, Queue<Call> waitingCallsList, Queue<Task> tasksList) {
		this.name = name;
		this.callsList = callsList;
		this.waitingCallsList = waitingCallsList;
		this.tasksList = tasksList;
	}

	public void run() {
		while (!waitingCallsList.isEmpty()) {
			callsList.waitItem();
			Call call = callsList.getItem();
			System.out.println("sec got call" + name);
			try {
				sleep(call.getSecretaryProcessTime());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tasksList.addToQueue(
					new Task(call.nameOfInterrogated, call.typeOfLevel, call.typeOfCustomer, call.waitingTime));
			System.out.println("sec sleep done" + name);
			call.setIsDone();
			callsList.notifyItem();

		}
	}
}
