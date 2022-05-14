package com.Banksystem;
//import com.Banksystem.User;
import java.util.*;
import java.io.*;

/*
 *Create account
 *Send Money -> user, password, amount, destinationaccountnumber
 *Add balance -> user, password, amount
 *Check balance -> user, password,
 *Withdraw money -> user, password, amount
 */
public class Bank {
	
	private HashMap<Integer, User> users;
	Bank(){
	    users= new HashMap<Integer, User>();
	}
	public void addUser(int id, String password) {
		User newUser = new User(id,password);
		if(users.containsKey(id)) {
			System.out.println("User already exists");
		
		}
		else {
			users.put(id, newUser);
			System.out.println("Successfully created Account :)");
		
		}
		
	}
	
	public void sendMoney(int senderId, int receiverId, double amount) {
		User sender=users.get(senderId);
		if(sender.getBalance() >= amount) {
			System.out.println("Transfering the money... :)");
			User receiver= users.get(receiverId);
			sender.setBalance(sender.getBalance() - amount);
			receiver.setBalance(receiver.getBalance() + amount);
			
			System.out.println("Transferred money successfully");
			System.out.println("Your updated balance is : "+ sender.getBalance());
		}
		else {
			System.out.println("Bank balance low. Can't send money :(");
		}
		 
	}
	
	public boolean verifyCredentials(int id, String password) {
		User user=users.get(id);
		return user.verifyPasword(password);
	}
	public void checkBalance(int id,String password) {
		User user=users.get(id);
		System.out.println("Your Account balance is: "+user.getBalance());
		
	}
	public void addBalance(int id,double amount) {
		User user = users.get(id);
		double updateBalance=user.getBalance()+amount;
		user.setBalance(updateBalance);
		System.out.println("Added Successfully :)");
		System.out.println("Your update balance is: "+user.getBalance());
	
	}
	public void withdrawAmount(int id,double amount) {
		User user = users.get(id);
		double updateBalance=user.getBalance()-amount;
		user.setBalance(updateBalance);
		System.out.println("withdrawn Successfully :)");
		System.out.println("Your update balance is: "+user.getBalance());
	
	}


}
