package com.hsbc.currency;
import java.util.*;
import java.util.Map.Entry;

public class Payments {
	private static HashMap<String, Integer> payments = new HashMap<>();
	
	
	public static void addPayments(Payment payment) {
		String currency = payment.getCurrency();
		int amount = payment.getAmount();
		int currentAmount = getAmountByCurrency(currency);
		payments.put(currency, currentAmount + amount);
	}
	
	public static int getAmountByCurrency(String currency) {
		return payments.getOrDefault(currency, 0);
	}
	
	public static void printPayments() {
		for(Entry<String, Integer> entry : payments.entrySet()) {
			if(entry.getValue() != 0) {
				System.out.println(entry.getKey() + " " + entry.getValue());
			}
		}
	}
	
	
}
