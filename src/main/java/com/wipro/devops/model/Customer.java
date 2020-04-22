package com.wipro.devops.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Customer {

	@Id
	@GeneratedValue
	private int accountNumber;	

    private String userName;
    private String passWord;
    
	private String firstName;
	private String lastName;

	private int currentBalance;
	private int creditAmount;
	private int debitAmount;
	private int transactionAmount;
	
	private String message;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int accountNumber, String userName, String passWord,
			String firstName, String lastName, int currentBalance,
			int creditAmount, int debitAmount, int transactionAmount) {
		super();
		this.accountNumber = accountNumber;
		this.userName = userName;
		this.passWord = passWord;
		this.firstName = firstName;
		this.lastName = lastName;
		this.currentBalance = currentBalance;
		this.creditAmount = creditAmount;
		this.debitAmount = debitAmount;
		this.transactionAmount = transactionAmount;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(int currentBalance) {
		this.currentBalance = currentBalance;
	}
	public int getCreditAmount() {
		return creditAmount;
	}
	public void setCreditAmount(int creditAmount) {
		this.creditAmount = creditAmount;
	}
	public int getDebitAmount() {
		return debitAmount;
	}
	public void setDebitAmount(int debitAmount) {
		this.debitAmount = debitAmount;
	}
	
	public int getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Customer [accountNumber=" + accountNumber + ", userName="
				+ userName + ", passWord=" + passWord + ", firstName="
				+ firstName + ", lastName=" + lastName + ", currentBalance="
				+ currentBalance + ", creditAmount=" + creditAmount
				+ ", debitAmount=" + debitAmount + ", transactionAmount="
				+ transactionAmount + ", message=" + message + "]";
	}

	

	
       
	

    

    

    
     

}
