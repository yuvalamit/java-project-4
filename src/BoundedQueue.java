
import java.util.Vector;

public class BoundedQueue {
	protected Vector<Operation> queue;

	public BoundedQueue() {
		queue = new Vector<Operation>();
	}

	public boolean addToQueue(Operation oper) {
		if (queue.size() > 15)// checks if there is more than 15 operations in the queue.
			return false;
		queue.add(oper);
		return true;
	}

	// get and remove the item from the list
	public synchronized Operation getItem() {
		if (queue.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return queue.remove(0);

	}

	// checks if the list is empty
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	public synchronized void waitItem() {
		try {
			wait();
		} catch (InterruptedException e) {
			System.out.println("catch");
			e.printStackTrace();
		}
	}
	// TODO:not finished!!!!
}