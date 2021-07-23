package com.hsbc.currency;

public class Payment {
	private int amount;
	private String currency;
	
	public Payment(String cur, int amt) {
		currency = cur.toUpperCase();
		amount = amt;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amt) {
		amount = amt;
	}
	
	
	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String cur) {
		currency = cur;
	}
	
	public String getData() {
		return currency + " " + amount;
	}
	
	

}
