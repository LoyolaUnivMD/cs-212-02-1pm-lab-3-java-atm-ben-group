// Programmers:  Brendan and Ben
// Course:  CS 212
// Due Date: 2/11/24
// Lab Assignment: 3
// Problem Statement: Create a program to function as an ATM which can deposit, withdraw, and check your balance
// Data In: User's name, choice of ATM function, amount to withdraw/deposit, type of receipt
// Data Out: Asking user for their choice, balance, receipt
// Credits: N/A

import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.DecimalFormat;

class Lab3 {
    public static void main(String[] args) {

        double balance = 212.90;

        DecimalFormat df = new DecimalFormat("$0.00");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the bank, please enter your name: ");
        String name = scanner.nextLine();

        String choice = "";
        Double allDeposits = 0.0;
        Double allWithdraws = 0.0;
        while (!choice.equals("e")) {
            System.out.println("Welcome, " + name + ". Would you like to deposit (enter 'd'), withdraw (enter 'w'), check your balance (enter 'c'), or exit (enter 'e')");
            choice = scanner.nextLine().toLowerCase();
            while(!choice.equals("e") && !choice.equals("d") && !choice.equals("w") && !choice.equals("c")){
                System.out.println("Enter a letter from: d, w, c, e");
                choice = scanner.nextLine().toLowerCase();
            } if (choice.equals("d")) {
                System.out.println("How much would you like to deposit? ");
                Double deposit = null;
                boolean validDep = false;
                while (validDep == false) {
                    while (deposit == null) {
                        try {
                            deposit = scanner.nextDouble();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                            scanner.next();
                        }
                    }
                    if (deposit <= 0){
                        deposit = null;
                        System.out.println("Invalid input. Please enter a valid number.");
                    } else{
                        validDep = true;
                    }
                }
                allDeposits += deposit;
                balance += deposit;

            } else if (choice.equals("w")) {
                System.out.println("How much would you like to withdraw? ");
                Double withdraw = null;
                boolean validWith = false;
                while (validWith == false) {
                    while (withdraw == null) {
                        try {
                            withdraw = scanner.nextDouble();

                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                            scanner.next();
                        }
                    }
                    if (withdraw <= 0){
                        withdraw = null;
                        System.out.println("Invalid input. Please enter a valid number.");
                    } else{
                        validWith = true;
                    }
                }

                if (withdraw > balance) {
                    while (withdraw > balance) {
                        System.out.println("Please enter a valid withdraw amount. (Must be less than or equal to your current balance: " + balance + ") ");
                        withdraw = Double.parseDouble(scanner.nextLine());
                    }
                }
                allWithdraws += withdraw;
                balance -= withdraw;
            } else if (choice.equals("c")) {
                System.out.println(name + " has a current balance of " + df.format(balance));
            } else if (choice.equals("e")) {
                System.out.println("Would you like your receipt emailed or printed? (enter 'e' for email or 'p' for printed) ");
                String receiptChoice = scanner.nextLine();

                if(receiptChoice.equals("e"))
                {
                    if(balance > 212.90) {
                        System.out.println("You have deposited " + df.format((balance - 212.90)));
                    }
                    else if(balance < 212.90) {
                        System.out.println("You have withdrawn " + df.format((212.90 - balance)));
                    }
                    else {
                        System.out.println("There is no change to your balance.");
                    }
                    System.out.println("Make sure to check your email for your receipt. Thanks for banking with us!");
                } else {
                    if(balance > 212.90) {
                        System.out.println("You have deposited " + df.format((balance - 212.90)));
                    }
                    else if(balance < 212.90) {
                        System.out.println("You have withdrawn " + df.format((212.90 - balance)));
                    }
                    else {
                        System.out.println("There is no change to your balance.");
                    }
                    System.out.println("Make sure to take your receipt. Thank you for banking with us!");
                }
            }
        }
        System.out.println("Would you like a receipt printed or emailed? Enter 'print' or 'email' ");
        String receipt = scanner.nextLine().toLowerCase();
        while(!receipt.equals("print") && !receipt.equals("email")){
            System.out.println("Please enter 'print' or 'email'");
            System.out.println(receipt);
            receipt = scanner.nextLine().toLowerCase();
        }
        System.out.println("You deposited a total of " + df.format(allDeposits));
        System.out.println("You withdrew a total of " + df.format(allWithdraws));
        System.out.println("Thank you for banking with us today " + name);
        if (receipt.equals("print")){
            System.out.println("Please remember to take your receipt.");
        } else{
            System.out.println("Remember to check your email for your receipt.");
        }

    }
}
