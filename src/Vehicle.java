import java.util.Vector;

abstract public class Vehicle {
	protected int capacity;
	protected boolean available;
	protected Vector<Investigator> investigatorInVehicle;
	protected Vector<Detective> detectiveInVehicle;

	public Vehicle() {
		available = true;
		investigatorInVehicle = new Vector<Investigator>();
		detectiveInVehicle = new Vector<Detective>();
	}

}
