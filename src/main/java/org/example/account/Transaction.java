package org.example.account;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Transaction {
    private int amount;
    private LocalDateTime date;
    public Transaction(){}
    public Transaction(int amount, LocalDateTime date) {
        this.amount = amount;
        this.date = date;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}
