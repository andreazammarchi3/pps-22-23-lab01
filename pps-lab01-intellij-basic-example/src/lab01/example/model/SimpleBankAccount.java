package lab01.example.model;

import lab01.example.model.utils.SimpleBankAccountUtils;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount
 */
public class SimpleBankAccount implements BankAccount {


    private double balance;
    private final AccountHolder holder;

    public SimpleBankAccount(final AccountHolder holder, final double balance) {
        this.holder = holder;
        this.balance = balance;
    }
    @Override
    public AccountHolder getHolder(){
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(final int userID, final double amount) {
        if (SimpleBankAccountUtils.checkUser(this.holder.getId(), userID)) {
            this.balance += amount;
        }
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        if (SimpleBankAccountUtils.checkUser(this.holder.getId(), userID) && SimpleBankAccountUtils.isWithdrawAllowed(balance, amount, 0)) {
            this.balance -= amount;
        }
    }
}
