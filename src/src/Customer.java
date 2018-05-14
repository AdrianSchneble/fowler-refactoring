package src;

import java.util.ArrayList;
import java.util.List;

class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<>();

	public Customer(String newname) {
		name = newname;
	};

	public void addRental(Rental arg) {
		rentals.add(arg);
	};

	public String getName() {
		return name;
	};

	public String statement() {
		double totalRentingCost = 0;
		int frequentRenterPoints = 0;
		String result = "Rental Record for " + this.getName() + "\n";
		result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

		for (Rental each : rentals) {
			frequentRenterPoints += each.getFrequentRenterPoints();
			totalRentingCost += each.calculateRentingCost();
			result += each.getStatementEntry();
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalRentingCost) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return result;
	}

}