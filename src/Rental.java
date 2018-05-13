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

	double calculateRentingCost() {
		double thisAmount = 0;
		switch (getMovie().getPriceCode()) {
		case REGULAR:
			thisAmount += 2;
			if (daysRented > 2)
				thisAmount += (daysRented - 2) * 1.5;
			break;
		case NEW_RELEASE:
			thisAmount += daysRented * 3;
			break;
		case CHILDRENS:
			thisAmount += 1.5;
			if (daysRented > 3)
				thisAmount += (daysRented - 3) * 1.5;
			break;
		}
		return thisAmount;
	}
}