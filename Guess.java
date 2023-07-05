package com.Manju.numberguess;
import java.util.*;
import javax.swing.*;
import java.util.Random;
public class Guess {
	public static void main(String[] args) {
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		int compunumber=random.nextInt(100)+1;
		int trails=0;
		boolean probs=false;
		int usernum;
		while(probs==false) {
			String num = JOptionPane.showInputDialog(null, "Enter number between 1 to 100", "Number Guessing Game", JOptionPane.INFORMATION_MESSAGE);
			usernum = Integer.parseInt(num);
			trails++; //first trail of user.
			
			//check for equality of computer and user guess
			if(usernum==compunumber) {
				probs=true;
			}
			//if the user guess is less than the computer number
			else if(usernum<compunumber)
				JOptionPane.showMessageDialog(null, "Your guess is low", "Number Guessing Game",  JOptionPane.INFORMATION_MESSAGE);
				//System.out.println("Your guess is low");
			//if the user guess is more than the computer number
			else
				JOptionPane.showMessageDialog(null, "Your guess is high", "Number Guessing Game",  JOptionPane.INFORMATION_MESSAGE);
				//System.out.println("Your guess is high");
		}
		JOptionPane.showMessageDialog(null, "You guessed it right in "+trails+"trails", "Number Guessing Game",  JOptionPane.INFORMATION_MESSAGE);
		System.out.println("You win.......");
		System.out.println("Thankyou!! Come again");
		sc.close();
	}
}
