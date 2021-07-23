package com.hsbc.currency;
import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TradeCenter {

	public static void main(String[] args) {
		System.out.println("Type quit anytime if you want to quit the program");
		System.out.println("**********************************************************************");
	    System.out.println("********************Welcome to the trade center!**********************");
	    System.out.println("**********************************************************************");
	    System.out.println("Do you want to read file for initialization? (yes/no)");

	    String pattern = "^[a-zA-Z]{3}\\s\\-{0,1}\\d+$";
	    Pattern r = Pattern.compile(pattern);
	    Matcher matcher=null;
	    
	    Scanner inputScanner = new Scanner(System.in);
	    String nextLine = inputScanner.nextLine();
	    int stage=0;
	    while(!nextLine.equalsIgnoreCase("quit")){ 	
	    	switch(stage) {
	    		case 0:{
    		    	if(nextLine.toLowerCase().equals("yes")) {
	    		    	try {
	    		    		 File file = new File("trade.txt");
	    		    	     Scanner myReader = new Scanner(file);
	    		    	     
	    		    	     System.out.println("Initial payment inputs: ");
	    		    	     
	    		    	     while (myReader.hasNextLine()) {
	    		    	    	 
	    		    	        String data = myReader.nextLine();  
	    		    	        System.out.println(data);
	    		    	        
	    		    	        String currency = data.split(" ")[0];
	    		    	        int amount = Integer.parseInt(data.split(" ")[1]);
	    		    	        
	    		    	        Payment payment = new Payment(currency, amount);
	    		    	        Payments.addPayments(payment);
	    		    	      }
	    		    	     
	    		    	      myReader.close();
	    		    	    
	    		    	} catch (FileNotFoundException e) {
	    		    		System.out.println("An error occurred.");
	    		    		
	    		    	}
    		    		stage=1;
    		    		System.out.println("Please input more payments if needed (Ex: USD 123), please enter no if you don't want to input more payments: ");
    		    	}else if(nextLine.toLowerCase().equals("no")) {
    		    		stage=1;
    		    		System.out.println("Please input more payments if needed (Ex: USD 123), please enter no if you don't want to input more payments: ");
    		    	}else {
	    		    	System.out.println("Please input correct value (yes/no)");
    		    	}
    		    	nextLine = inputScanner.nextLine();
    		    	break;
	    		}
	    		case 1:{
	    			matcher = r.matcher(nextLine);
	    			if(!nextLine.equalsIgnoreCase("no") && matcher.matches()) {
			    		String currency = nextLine.split(" ")[0];
				        int amount = Integer.parseInt(nextLine.split(" ")[1]);
				         
				        Payment payment = new Payment(currency, amount);
				        Payments.addPayments(payment);
	    			}else {
			            Payments.printPayments();
		    			stage=2;
	    			}
	    			nextLine = inputScanner.nextLine();
	    			break;
	    		}
	    		case 2:
	    			nextLine = inputScanner.nextLine();
	    			break;
	    	}
	    	
	    }
	    System.out.println("Bye bye!");
	    System.exit(0);
	}
}
