package lab01.example.model;

import lab01.example.model.utils.SimpleBankAccountUtils;

public class SimpleBankAccountWithAtm implements BankAccount {
    private static final int FEE = 1;
    private double balance;
    private final AccountHolder holder;
    public SimpleBankAccountWithAtm(final AccountHolder holder, final int balance) {
        this.holder = holder;
        this.balance = balance;
    }

    @Override
    public AccountHolder getHolder() {
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(int userID, double amount) {
        if (SimpleBankAccountUtils.checkUser(this.holder.getId(), userID)) {
            this.balance += amount - FEE;
        }
    }

    @Override
    public void withdraw(int userID, double amount) {
        if (SimpleBankAccountUtils.checkUser(this.holder.getId(), userID) && SimpleBankAccountUtils.isWithdrawAllowed(balance, amount, FEE)) {
            this.balance -= amount + FEE;
        }
    }
}
