package org.example.account.accountInterface;

import java.time.LocalDateTime;
import java.util.Date;

public interface AccountService {
    void deposit(int amount);
    void withdraw(int amount);
    void printStatement();
}
