package src;

class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie newmovie, int newdaysRented) {
		movie = newmovie;
		daysRented = newdaysRented;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	public double calculateRentingCost() {
		return getMovie().getPriceCode().calculateRentingCost(daysRented);
	}

	public int getFrequentRenterPoints() {
		int frequentRenterPoints = 1;
		if (isEligibleForNewReleaseBonus()) {
			frequentRenterPoints++;
		}
		return frequentRenterPoints;
	}

	private boolean isEligibleForNewReleaseBonus() {
		return getMovie().getPriceCode() == PriceCode.NEW_RELEASE && getDaysRented() > 1;
	}

	public String getStatementEntry() {
		return "\t" //
				+ getMovie().getTitle() //
				+ "\t" + "\t" //
				+ getDaysRented() //
				+ "\t" //
				+ String.valueOf(calculateRentingCost()) //
				+ "\n";
	}
}