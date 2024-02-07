// Programmers:  [your names here]
// Course:  CS 212
// Due Date:
// Lab Assignment:
// Problem Statement:
// Data In:
// Data Out:
// Credits: [Is your code based on an example in the book, in class, or something else?
//            Reminder: you should never take code from the Internet or another person

import java.util.Scanner;

class Lab3 {
    public static void main(String[] args) {

        double balance = 212.90;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the bank, please enter your name: ");
        String name = scanner.nextLine();

        String choice = "";

        while(!choice.equals("e")) {

            System.out.println("Welcome, " + name + ". Would you like to deposit (enter 'd'), withdraw (enter 'w'), check your balance (enter 'c'), or exit (enter 'e')");
            choice = scanner.nextLine();

            if (choice.equals("D")) {
                System.out.println("How much would you like to deposit? ");
                double deposit = Double.parseDouble(scanner.nextLine());
                balance += deposit;
            } else if (choice.equals("W")) {
                System.out.println("How much would you like to withdraw? ");
                double withdraw = Double.parseDouble(scanner.nextLine());
                if (withdraw > balance) {
                    while (withdraw > balance) {
                        System.out.println("Please enter a valid withdraw amount. (Must be less than or equal to your current balance: " + balance + ") ");
                        withdraw = Double.parseDouble(scanner.nextLine());
                    }
                }
                balance -= withdraw;
            }
        }
    }
}
