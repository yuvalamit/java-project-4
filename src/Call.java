import java.util.Random;

public class Call extends Thread {
	protected String nameOfInterrogated;
	protected String typeOfLevel;
	protected String typeOfCustomer;
	protected int waitingTime;
	protected int durationTime;
	protected Queue<Call> callsList;
	protected boolean isDone;
	protected Queue<Call> waitingCallsList;

	public Call(String nameOfInterrogated, String typeOfLevel, String typeOfCustomer, int waitingTime, int durationTime,
			Queue<Call> callsList, Queue<Call> waitingCallsList) {
		this.nameOfInterrogated = nameOfInterrogated;
		this.typeOfLevel = typeOfLevel;
		this.typeOfCustomer = typeOfCustomer;
		this.waitingTime = waitingTime;
		this.durationTime = durationTime;
		this.callsList = callsList;
		isDone = false;
		this.waitingCallsList = waitingCallsList;
	}

	public long getSecretaryProcessTime() {
		Random rdNum = new Random();
		int num = 0;
		switch (this.typeOfCustomer) {
		case "private":
			num = rdNum.nextInt(1000 - 500) + 500;
			break;
		case "business":
			num = rdNum.nextInt(2000 - 1000) + 1000;
			break;
		case "government":
			num = rdNum.nextInt(3000 - 2000) + 2000;
			break;
		}
		return num + durationTime * 1000;
	}

	public void run() {
		waitingCallsList.addToQueue(this);
		try {
			sleep(waitingTime * 1000);// sleep before insert to calls list
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("sleep over" + this.nameOfInterrogated);
		callsList.addToQueue(this);
		waitingCallsList.getItem();// remove the call from waiting list
		System.out.println("add to queue" + nameOfInterrogated);
		while (!isDone) {// wait call to done
			System.out.println("waiting call to done " + nameOfInterrogated);
			callsList.waitItem();
		}
		System.out.println("call" + nameOfInterrogated + "is done");
	}

	public void setIsDone() {
		System.out.println("call done " + nameOfInterrogated);
		this.isDone = true;

	}
}
