
public class AgencyManager {
	protected int endedOperations;
	protected int totalDurationTime;

	private synchronized void endDay() {
		TaskManager.endDay = true;
		Operator.endDay = true;
		notifyAll();
	}

	public void endOperation(Operation oper) {
		endedOperations++;
		totalDurationTime += oper.Time;
		if (checkIfEndDay())
			endDay();
	}

	private boolean checkIfEndDay() {
		// if (endedOperations == //num from gui)
		return true;
	}
	// TODO:not finished!!!!
}
