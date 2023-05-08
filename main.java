package com.application;
import java.util.*;

public class main {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    Bank bank = new Bank();
	    boolean exitRequested = false;
	    while(!exitRequested) {
	        PrintService.printMenu();
	        int choice = Integer.parseInt(sc.next());
	        switch (choice) {
	            case 1:
	                bank.registerAccount();
	                break;
	            case 2:
	                bank.loginAccount();
	                break;
	            case 3:
	                exitRequested = true;
	                break;
	            default:
	                System.out.println("Wrong input");
	                break;
	        }
	    }
	}

}
