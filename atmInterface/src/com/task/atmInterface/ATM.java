package com.task.atmInterface;

import java.util.Scanner;

public class ATM {

    private BankAccount account;
    private Scanner sc;

    public ATM(BankAccount account) {
        this.account = account;
        this.sc = new Scanner(System.in);
    }

    public void showMenu() {

        int choice;

        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter numbers only.");
                sc.next();
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    System.out.println("Thank you for using ATM!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);
    }

    private void checkBalance() {
        System.out.println("Current Balance: ₹" + account.getBalance());
    }

    private void depositMoney() {
        System.out.print("Enter amount to deposit: ₹");

        double amount = sc.nextDouble();

        if (account.deposit(amount)) {
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    private void withdrawMoney() {
        System.out.print("Enter amount to withdraw: ₹");

        double amount = sc.nextDouble();

        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== WELCOME TO ATM =====");
        System.out.print("Enter initial account balance: ₹");

        double initialBalance = sc.nextDouble();

        BankAccount account = new BankAccount(initialBalance);

        ATM atm = new ATM(account);
        atm.showMenu();

        sc.close();
    }
}

