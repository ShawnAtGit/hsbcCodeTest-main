package com.hsbc.currency;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PaymentTest {

	Payment payment = new Payment("USD", 123);
	
	@Test
	public void testGetAmount() {
		int amount = payment.getAmount();
		assertEquals(amount, 123) ;
	}

	@Test
	public void testGetCurrency() {
		String currency = payment.getCurrency();
		assertEquals(currency, "USD");
	}
	
	@Test
	public void testSetAmount() {
		int amount = 111;
		payment.setAmount(amount);
		int newAmount = payment.getAmount();
		assertEquals(newAmount, 111);
	}
	
	@Test
	public void testSetCurrency() {
		String currency = "HKD";
		payment.setCurrency(currency);
		String newCurrency = payment.getCurrency();
		assertEquals(newCurrency, "HKD");
	}
}
