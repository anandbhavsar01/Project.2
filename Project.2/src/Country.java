public class Country {
	private String name;
	private SubscriptionYear[] subscriptions;

	public Country(String name, int years) {
		this.name = name;
		subscriptions = new SubscriptionYear[years];
	}

	public void addSubscriptionYear(int year, double number) {
		for (int i = 0; i < subscriptions.length; i++) {
			if (subscriptions[i] == null) {
				subscriptions[i] = new SubscriptionYear(year, number);
				break;
			}
		}
	}

	public double getNumSubscriptionsForPeriod(int startYear, int endYear) {
		double sum = 0;
		if (startYear != 1983 && endYear != 1989) {
			System.out.println("Error: Requested period between " + startYear
					+ " and " + endYear + " is out of bounds");
			System.out.println("Valid years are 1983 and 1989");
			return -1.00;
		}
		for (int i = 0; i < endYear - startYear; i++) {
			sum += subscriptions[i].getNumberOfSubscriptions();
		}
		return sum;
	}

	public String toString() {
		String list = "";
		for (int i = 0; i < subscriptions.length; i++) {
			list += subscriptions[i].getNumberOfSubscriptions() + "\t";
		}
		return name + list;
	}
}
