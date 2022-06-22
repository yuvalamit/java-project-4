
public class Operator extends Thread {
	protected static String Name;
	protected BoundedQueue operationsQueue;
	protected static boolean endDay = false;
	protected Agency agency;

	// constructor:
	public Operator(String name, BoundedQueue operationsQueue, Agency agency) {
		this.Name = name;
		this.operationsQueue = operationsQueue;
		this.agency = agency;

	}

	public void run() {
		while (!endDay) {
			// TODO: add the part that operator take the strategy with the shortest time
			// TODO: add the part that the operator need to wait time we get as input from
			// gui.
			// sleep (input);
//		if (!operationsQueue.addToQueue(oper)) {
//			wait();
//		}
		}
	}

	private synchronized boolean openOperation() {
		Operation oper=new Operation(id, codeName, level, customerType, time)//*********from strategy
		while (oper.totalAgent()<oper.agentOnOperation.size()) {
			
		}
	}

	private synchronized boolean addMotorcycle(Operation oper) {
		Motorcycle moto = agency.getMotorcycle();
		if (moto != null) {
			oper.vehicleOnOperation.add(moto);
			moto.available = false;
			return true;
		}
		return false;
	}

	private synchronized boolean addCar(Operation oper) {
		Car c = agency.getCar();
		if (c != null) {
			oper.vehicleOnOperation.add(c);
			c.available = false;
			return true;
		}
		return false;
	}

	private synchronized boolean addDetective(Operation oper) {
		Detective dec = agency.getDetective();
		if (dec != null) {
			oper.agentOnOperation.add(dec);
			dec.available = false;
			return true;
		}
		return false;
	}

	private synchronized boolean addInvestigator(Operation oper) {
		Investigator inv = agency.getInvestigator();
		if (inv != null) {
			oper.agentOnOperation.add(inv);
			inv.available = false;
			return true;
		}
		return false;
	}
	// TODO:not finished!!!!
}
