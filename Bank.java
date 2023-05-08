package com.application;
import java.util.*;


public class Bank {
	private final List<Account> bankAccounts;
	private final Scanner sc;

	public Bank() {
	    bankAccounts = new ArrayList<>();
	    sc = new Scanner(System.in);
	}

	public Account isAccountExist(int accountID, String phoneNumber) {
	    for (Account account : bankAccounts) {
	        if (account.getID() == accountID && account.getPhoneNumber().equals(phoneNumber)) {
	            return account;
	        }
	    }
	    System.out.println("One of the details is incorrect");
	    return null;
	}

	//overload method -
	public Account isAccountExist(String phoneNumber) {
	    for (Account account : bankAccounts) {
	        if (account.getPhoneNumber().equals(phoneNumber)) {
	            return account;
	        }
	    }
	    System.out.println("One of the details is incorrect");
	    return null;
	}

	public void registerAccount() {
	    System.out.println("First name?");
	    String firstName = sc.next();
	    System.out.println("Last name?");
	    String lastName = sc.next();
	    System.out.println("Phone number?");
	    String phoneNumber = sc.next();
	    if (isPhoneNumberCorrect(phoneNumber)) {
	        bankAccounts.add(new Account(firstName, lastName, phoneNumber));
	        System.out.println("You have created account successfully!" + "\n" +
	                "Your account ID is: " + bankAccounts.get(bankAccounts.size() - 1).getID());

	    }
	}

	public void loginAccount() {
	    System.out.println("Please enter your ID:");
	    int accountID = sc.nextInt();
	    System.out.println("Please enter your phone number:");
	    String phoneNumber = sc.next();
	    if (isPhoneNumberCorrect(phoneNumber)) {
	        Account selectedAccount = isAccountExist(accountID, phoneNumber);
	        boolean exitRequested = false;
	        while (!exitRequested) {
	            PrintService.existAccountMenu();
	            int choice = Integer.parseInt(sc.next());
	            switch (choice) {
	                case 1:
	                    System.out.println(selectedAccount.toString());
	                    break;
	                case 2:
	                    System.out.println("Please enter deposit amount:");
	                    double depositAmount = sc.nextDouble();
	                    selectedAccount.depositMoney(depositAmount);
	                    break;
	                case 3:
	                    System.out.println("Please enter withdrawal amount:");
	                    double withdrawalAmount = sc.nextDouble();
	                    selectedAccount.withdrawal(withdrawalAmount);
	                    break;
	                case 4:
	                    System.out.println("Please enter the phone number of the account you want to transfer to: ");
	                    String accountPhoneNumber = sc.next();
	                    if (isPhoneNumberCorrect(accountPhoneNumber)) {
	                        Account accountToTransfer = isAccountExist(accountPhoneNumber);
	                        System.out.println("Enter the amount of money you would like to transfer:");
	                        double moneyToTransfer = sc.nextDouble();
	                        selectedAccount.moneyTransfer(selectedAccount, accountToTransfer, moneyToTransfer);
	                        break;
	                    }
	                        case 5:
	                            exitRequested = true;
	                            break;
	                        default:
	                            System.out.println("Wrong input");
	                            break;
	                    }
	            }
	        }
	    }

	public static boolean isPhoneNumberCorrect(String phoneNumber){
	    if(phoneNumber.length() != 10){
	        System.out.println("Phone number must be 10 digits.");
	        return false;

	} else {
	        return true;
	    }
	}


}
