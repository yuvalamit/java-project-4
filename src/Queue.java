import java.util.Vector;

public class Queue<T> {
	protected Vector<T> list;

	public Queue() {
		this.list = new Vector<T>();
	}

//add to queue and notify all 
	public synchronized void addToQueue(T item) {
		list.add(item);
		notifyAll();
	}

//get and remove the item from the list
	public synchronized T getItem() {
		if (list.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return list.remove(0);

	}

//checks if the list is empty
	public boolean isEmpty() {
		return list.isEmpty();
	}

	public synchronized void waitItem() {
		try {
			wait();
		} catch (InterruptedException e) {
			System.out.println("catch");
			e.printStackTrace();
		}
	}

	public synchronized void notifyItem() {
		notifyAll();
	}

	public Vector<T> getQueue() {
		return list;
	}

}
