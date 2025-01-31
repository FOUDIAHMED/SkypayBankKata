package org.example.account.accountImplementation;

import org.example.account.accountInterface.AccountService;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Account implements AccountService {
    private int balance;
    private List<Transaction> transactions;

    public Account() {
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    @Override
    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        this.balance += amount;
        this.transactions.add(new Transaction(LocalDate.now(), amount, this.balance));
    }

    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > this.balance) {
            throw new IllegalStateException("Insufficient funds");
        }
        this.balance -= amount;
        this.transactions.add(new Transaction(LocalDate.now(), -amount, this.balance));
    }

    public void printStatement() {
        System.out.println("Date || Amount || Balance");
        for (int i = this.transactions.size() - 1; i >= 0; i--) {
            System.out.println(this.transactions.get(i));
        }
    }

    private static class Transaction {
        private final LocalDate date;
        private final int amount;
        private final int balance;
        private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        public Transaction(LocalDate date, int amount, int balance) {
            this.date = date;
            this.amount = amount;
            this.balance = balance;
        }

        @Override
        public String toString() {
            return String.format("%s || %d || %d", date.format(DATE_FORMATTER), amount, balance);
        }
    }
    public static void main(String[] args) {
        Account account = new Account();

        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);

        account.printStatement();
    }
}