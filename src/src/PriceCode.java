package src;

public enum PriceCode {
	NEW_RELEASE(0, 0, 3), REGULAR(2, 2, 1.5), CHILDRENS(1.5, 3, 1.5);

	private double basePrice;
	private int basePriceDuration;
	private double pricePerDayAfterBase;

	private PriceCode(double basePrice, int basePriceDuration, double pricePerDayAfterBase) {
		this.basePrice = basePrice;
		this.basePriceDuration = basePriceDuration;
		this.pricePerDayAfterBase = pricePerDayAfterBase;
	}

	public double calculateRentingCost(int daysRented) {
		double thisAmount = 0;
		thisAmount += basePrice;
		if (daysRented > basePriceDuration) {
			thisAmount += (daysRented - basePriceDuration) * pricePerDayAfterBase;
		}
		return thisAmount;
	}
}
