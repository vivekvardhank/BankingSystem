package com.Banksystem;

import java.util.*;
import java.io.*;

public class BankRunner {

	
		public static void main(String[] args) {
			
			 Bank bank=new Bank();
			
			
			System.out.println("Welcome to My Bank");
			int optionNumber;
			
			
		do {
			System.out.println("Choose the option");
			System.out.println("1. create an account");
			System.out.println("2. send money");
			System.out.println("3. check balance");
			System.out.println("4. add balance");
			System.out.println("5. withdraw amount");
			System.out.println("8. Exit1");
			
			Scanner sc=new Scanner(System.in);
			
			int id;
			String password;
			boolean loggedIn;
			double amount;
			
			optionNumber =sc.nextInt();
			
			switch(optionNumber) {
			case 1:
				System.out.print("Enter id:");
				id=sc.nextInt();
				System.out.print("Enter password:");
				password =sc.next();
				bank.addUser(id,password);
				break;
				
			case 2:
				System.out.print("Enter your id:");
				int senderId = sc.nextInt();
				System.out.print("Enter password: ");
				password= sc.next();
				loggedIn= bank.verifyCredentials(senderId,password);
				if(loggedIn) {
					System.out.print("Enter receiver id: ");
					int receiverId=sc.nextInt();
					System.out.print("Enter amount to transfer");
					double amountToTransfer=sc.nextDouble();
					bank.sendMoney(senderId, receiverId, amountToTransfer);
					
				}else {
					System.out.println("Bad Credentials :(");
				}
				break;
				
			case 3:
				System.out.print("Enter your id:");
				id = sc.nextInt();
				System.out.print("Enter password: ");
				password= sc.next();
				loggedIn= bank.verifyCredentials(id,password);
				if(loggedIn) {
					bank.checkBalance(id, password);
					
				}else {
					System.out.println("Bad Credentials :(");
				}
				break;
				
			case 4:
				System.out.print("Enter your id:");
				id = sc.nextInt();
				System.out.print("Enter password: ");
				password= sc.next();
				loggedIn= bank.verifyCredentials(id,password);
				if(loggedIn) {
					System.out.print("Enter amount to add: ");
					amount=sc.nextDouble();
					bank.addBalance(id, amount);
					
				}else {
					System.out.println("Bad Credentials :(");
				}
				break;
			case 5:
				System.out.print("Enter your id:");
				id = sc.nextInt();
				System.out.print("Enter password: ");
				password= sc.next();
				loggedIn= bank.verifyCredentials(id,password);
				if(loggedIn) {
					System.out.print("Enter withdraw amount: ");
					amount=sc.nextDouble();
					bank.withdrawAmount(id, amount);
					
				}else {
					System.out.println("Bad Credentials :(");
				}
				break;
				
			case 8:
				System.out.println("Bye:(");
			default:
				break;
			}
		}
		while(optionNumber!=8);
		
		
		
		
		

		}


	

}
