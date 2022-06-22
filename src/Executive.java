import java.util.Random;

public class Executive extends Thread {

	protected String Name;
	protected static boolean endDay = false;
	protected BoundedQueue operatiosQueue;
	protected AgencyManager manager;

	// constructor:
	public Executive(String name, AgencyManager manager) {
		this.Name = name;
		this.manager = manager;
	}

	// TODO:not finished!!!!
	public void run() {
		while (!endDay) {
			if (operatiosQueue.isEmpty())
				operatiosQueue.waitItem();
			Operation oper = operatiosQueue.getItem();
			try {
				Random rdNum = new Random();
				sleep((oper.numOfDetectives + oper.numOfInvestigators + oper.numOfVehicles + rdNum.nextInt(8 - 2) + 2)
						* 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			reportsAgentManager(oper);
			updatesInventory(oper);
		}
	}

	private void reportsAgentManager(Operation oper) {
		manager.endOperation(oper);
	}

	private void updatesInventory(Operation oper) {
		oper.endOperation();
	}
}