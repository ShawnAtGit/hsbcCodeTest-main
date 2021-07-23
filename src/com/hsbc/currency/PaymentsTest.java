package com.hsbc.currency;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PaymentsTest {

	Payment payment = new Payment("USD", 123);
	
	@Test
	void testGetAmountByCurrency() {
		Payments.addPayments(payment);
		int result = Payments.getAmountByCurrency("USD");
		assertEquals(result, 123);
	}

}
