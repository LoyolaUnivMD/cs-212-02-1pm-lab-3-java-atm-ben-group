// Programmers:  [your names here]
// Course:  CS 212
// Due Date:
// Lab Assignment:
// Problem Statement:
// Data In:
// Data Out:
// Credits: [Is your code based on an example in the book, in class, or something else?
// Reminder: you should never take code from the Internet or another person

import java.util.Scanner;

class Lab3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the bank, please enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Welcome, " + name + ". Would you like to deposit (enter 'd'), withdraw (enter 'w'), check your balance (enter 'c'), or exit (enter 'e')");
        String choice = scanner.nextLine();

    }
}
