package tests;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Test;

import src.PriceCode;

public class PriceCodeTest {

	@Test
	public void regularCosts2for1Day() throws Exception {
		double rentingCost = PriceCode.REGULAR.calculateRentingCost(1);
		Assert.assertThat(rentingCost, is(2.0));
	}

	@Test
	public void regularCosts2for2Days() throws Exception {
		double rentingCost = PriceCode.REGULAR.calculateRentingCost(2);
		Assert.assertThat(rentingCost, is(2.0));
	}

	@Test
	public void regularCosts3point5for3Days() throws Exception {
		double rentingCost = PriceCode.REGULAR.calculateRentingCost(3);
		Assert.assertThat(rentingCost, is(3.5));
	}

	@Test
	public void regularCosts5for4Days() throws Exception {
		double rentingCost = PriceCode.REGULAR.calculateRentingCost(4);
		Assert.assertThat(rentingCost, is(5.0));
	}

	@Test
	public void newReleaseCosts3perDay() throws Exception {
		for (int day = 1; day <= 4; day++) {
			double rentingCost = PriceCode.NEW_RELEASE.calculateRentingCost(day);
			Assert.assertThat(rentingCost, is(3.0 * day));
		}
	}

	@Test
	public void childrensCosts1point5forTheFirstThreeDays() throws Exception {
		for (int day = 1; day <= 3; day++) {
			double rentingCost = PriceCode.CHILDRENS.calculateRentingCost(day);
			Assert.assertThat(rentingCost, is(1.5));
		}
	}

	@Test
	public void childrensCosts1point5perDayStartingAtDay4() throws Exception {
		double rentingCost = PriceCode.CHILDRENS.calculateRentingCost(4);
		Assert.assertThat(rentingCost, is(3.0));
	}

}
