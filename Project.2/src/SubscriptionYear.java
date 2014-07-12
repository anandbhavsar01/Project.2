/**
 * One object of class SubscriptionYear stores the subscription data for one
 * year.
 */

public class SubscriptionYear {
	int year;
	double subscriptions;

	/**
	 * parameterized constructor for SubscriptionYear class object which assigns
	 * values for all class properties based on the values sent into the
	 * parameters.
	 */
	public SubscriptionYear(int year, double numSubscriptions) {
		this.year = year;
		this.subscriptions = numSubscriptions;
	}

	/**
	 * sets the value of year to "newYear"
	 */
	public void setYear(int newYear) {
		this.year = newYear;
	}

	/**
	 * returns the current value of year
	 * 
	 */
	public int getYear() {
		return year;
	}

	/**
	 * sets the value of subscriptions to "newSubscriptions"
	 */
	public void setNumberOfSubscriptions(double newSubscriptions) {
		this.subscriptions = newSubscriptions;
	}

	/**
	 * returns the current value of subscriptions
	 */
	public double getNumberOfSubscriptions() {
		return subscriptions;
	}

	/**
	 * Returns a String containing all the data stored in this object.
	 */
	public String toString() {
		return "" + subscriptions;
	}

}
