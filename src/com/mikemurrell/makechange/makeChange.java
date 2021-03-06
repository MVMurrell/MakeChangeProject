package com.mikemurrell.makechange;

import java.util.Scanner;

public class makeChange {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double itemPrice;
		double amtTend;
		int amt20;
		int amt10;
		int amt5;
		int amt1;
		int amtQuarter;
		int amtDime;
		int amtNickel;
		double loPennies;
		double priceOriginal;
		double tendOriginal;
		double priceDiff;
		boolean goAhead;
		int [] denominations = new int[7];
		do {
			System.out.print("Enter the price of the item: ");
			priceOriginal = input.nextDouble();
			do {
				System.out.print("How much money was tendered by the customer?: ");
				tendOriginal = input.nextDouble();

				itemPrice = priceOriginal * 100;
				amtTend = tendOriginal * 100;
				priceDiff = itemPrice - amtTend;

				if (amtTend < itemPrice && amtTend != 0) {
					System.out.println("This is not enough. Please provide an additional $" + priceDiff / 100);
					goAhead = false;
				} else if (amtTend == itemPrice) {
					System.out.println("The customer has provided exact change. Proceed with next customer.");
					goAhead = true;
				} else if (amtTend == 0) {
					goAhead = true;
				} else {
					priceDiff = priceDiff * (-1);
					amt20 = (int) (priceDiff / 2000);
					loPennies = priceDiff % 2000;//loPennies carries the remainder of pennies from the last denomination.
					amt10 = (int) (loPennies / 1000);
					loPennies = loPennies % 1000;
					amt5 = (int) (loPennies / 500);
					loPennies = loPennies % 500;
					amt1 = (int) (loPennies / 100);
					loPennies = loPennies % 100;
					amtQuarter = (int) (loPennies / 25);
					loPennies = (loPennies % 25);
					amtDime = (int) (loPennies / 10);
					loPennies = (loPennies % 10);
					amtNickel = (int) (loPennies / 5);
					loPennies = (loPennies % 5);
					
					
					System.out.println("Return to the customer:");
					if(amt20 > 0) {
					System.out.println(amt20 + " 20 dollar bill ");
					}
					if(amt10 > 0) {
					System.out.println(amt10 + " 10 dollar bill ");
					}
					if(amt5 > 0) {
					System.out.println(amt5 + " 5 dollar bill ");
					}
					if(amt1 > 0) {
					System.out.println(amt1 + " 1 dollar bill ");
					}
					if(amtQuarter > 0) {
					System.out.println(amtQuarter + " Quarter ");
					}
					if(amtDime > 0) {
					System.out.println(amtDime + " Dime ");
					}
					if(amtNickel > 0) {
					System.out.println(amtNickel + " Nickel ");
					}
					if(loPennies > 0) {
					System.out.println((int) loPennies + " Pennie");
					}
					System.out.println(" Hand the custmomer their receipt and wish them a good day.");
					goAhead = true;

				}

			} while (goAhead == false);

			System.out.print("Would you like to Continue? (Y/N): ");
			String runAgain = input.next();
			if (runAgain.equals("Y")) {
				goAhead = true;
			} else {
				goAhead = false;
			}
		} while (goAhead == true);

		System.out.println("Goodbye.");

		input.close();

	}

}

