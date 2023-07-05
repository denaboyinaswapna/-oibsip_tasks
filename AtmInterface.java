package com.java.atm;
import java.util.*;
public class AtmInterface {
	Scanner sc = new Scanner(System.in);
	int balance,withdraw,deposit,transfer;
	String thistory = "";
	public boolean LnR() {
		System.out.println("===================================================================");
		System.out.println("WELCOME TO THE ATM SERVICES");
		System.out.println("-->>>REGISTRATION<<<--");
		System.out.println("Please enter your fullname: ");
		String username = sc.nextLine();
		System.out.println("Please enter your UserId: ");
		String userid = sc.nextLine();
		System.out.println("Please enter your password: ");
		String password = sc.nextLine();
		System.out.println("Hey "+username+"!! You are Successfully registered :)");
		System.out.println("====================================================================");
		System.out.println("-->>>LOGIN<<<--");
		boolean b = false;
		while(!b) {
			System.out.println("Please enter your userid : ");
			String USERID = sc.nextLine();
			if(USERID.equals(userid)) {
				while(!b) {
					System.out.println("Please enter your password: ");
					String PASSWORD = sc.nextLine();
					if(PASSWORD.equals(password)) {
						System.out.println("Hey "+username+"!! You have successfully logged in");
						b = true;
					}
					else {
						System.out.println("Oops!! Wrong Password. Please enter valid password");
					}
				}
			}
			else {
				System.out.println("Oops!! Wrong id. Please enter valid userid");
			}
		}
		return b;
	}
	public void deposit() {
		System.out.println("Please enter amount to deposit: ");
		deposit = sc.nextInt();
		balance+=deposit;
		thistory+= deposit + " deposited ";
		System.out.println("You are successfully deposited Rs."+deposit);
	}
	public void withdrawl() {
		System.out.println("Please enter amount to withdraw: ");
		withdraw = sc.nextInt();
		if(withdraw>balance) {
			System.out.println("Not sufficient balance to withdraw\n");
		}
		else {
			balance-=withdraw;
			thistory+= withdraw + " withdrawed ";
			System.out.println("You are successfully withdrawed Rs."+withdraw);
		}
	}
	public void transfer() {
		System.out.println("Please enter amount to transfer: ");
		transfer = sc.nextInt();
		sc.nextLine();
		if(transfer>balance) {
			System.out.println("Oops!! Low balance !! cannot transfer :( \n");
		}
		else {
			System.out.println("Enter account number of person to transfer money: ");
			String accnum = sc.nextLine();
			balance-=transfer;
			thistory+= transfer + " transferred ";
			System.out.println("Successfully transferred amount to "+accnum+"\n");
		}
	}
	public void transactionhistory() {
		System.out.println("THE TRANSACTION HISTORY : "+thistory);
	}
	public void Balance() {
		System.out.println("The balance in your account is : Rs."+balance);
	}
	public void quit() {
		System.out.println("Thank You :) \n");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AtmInterface ai = new AtmInterface();
		System.out.println("Choose the option: \n1. Register and Login \n2.Exit \n");
		int option = sc.nextInt();
		if(option==1) {
			boolean t = ai.LnR();
			if(t) {
				while(true) {
					System.out.println("Allowable actions: \n1.Deposit \n2. Withdraw \n3.Transfer  \n4.Balance \n5.TransactionHistory \n6.Quit \n");
					System.out.println("Enter your action: ");
					int c = sc.nextInt();
					switch(c) {
					    case 1:
						    ai.deposit();
						    break;
						case 2:
							ai.withdrawl();
							break;
						case 3:
							ai.transfer();
							break;
						case 4:
							ai.Balance();
							break;
						case 5:
							ai.transactionhistory();
							break;
						case 6:
							System.out.println("Thank You :)");
							System.exit(0);
							break;
						default:
							System.out.println("Enter valid details");
					}
				}
			}
		}
		else {
			System.out.println("Thank You :)");
			System.exit(0);
		}
		sc.close();
	}
}
