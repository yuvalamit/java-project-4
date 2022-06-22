
public class Agency {
	protected Detective[] detectivesOfAgency;
	protected Investigator[] investigatorsOfAgency;
	protected Motorcycle[] motorcycleOfAgency;
	protected Car[] carOfAgency;

	public Agency() {
		detectivesOfAgency = new Detective[60];
		initDetective();
		investigatorsOfAgency = new Investigator[40];
		initinvestigator();
		motorcycleOfAgency = new Motorcycle[50];
		initMotorcycle();
		carOfAgency = new Car[10];
		initCar();
	}

	private void initDetective() {
		for (int i = 0; i < detectivesOfAgency.length; i++) {
			detectivesOfAgency[i] = new Detective();
		}
	}

	private void initinvestigator() {
		for (int i = 0; i < investigatorsOfAgency.length; i++) {
			investigatorsOfAgency[i] = new Investigator();
		}
	}

	private void initMotorcycle() {
		for (int i = 0; i < motorcycleOfAgency.length; i++) {
			motorcycleOfAgency[i] = new Motorcycle();
		}
	}

	private void initCar() {
		for (int i = 0; i < carOfAgency.length; i++) {
			carOfAgency[i] = new Car();
		}
	}

	public Detective getDetective() {
		for (int i = 0; i < detectivesOfAgency.length; i++) {
			if (detectivesOfAgency[i].available)
				return detectivesOfAgency[i];
		}
		return null;
	}

	public Investigator getInvestigator() {
		for (int i = 0; i < investigatorsOfAgency.length; i++) {
			if (investigatorsOfAgency[i].available)
				return investigatorsOfAgency[i];
		}
		return null;
	}

	public Motorcycle getMotorcycle() {
		for (int i = 0; i < motorcycleOfAgency.length; i++) {
			if (motorcycleOfAgency[i].available)
				return motorcycleOfAgency[i];
		}
		return null;
	}

	public Car getCar() {
		for (int i = 0; i < carOfAgency.length; i++) {
			if (carOfAgency[i].available)
				return carOfAgency[i];
		}
		return null;
	}
}
