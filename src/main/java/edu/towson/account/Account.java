package edu.towson.account;

public abstract class Account {

    public enum Type {
        BUSINESS, CHECKING, SAVINGS
    }

    private final String name;
    private final long accountNumber;

    protected double balance;

    public Account(String name, long accountNumber) {
        this(name, accountNumber, 0);
    }

    public Account(String name, long accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public abstract Type getAccountType();

    public abstract double rate();

    public String getName() {
        return name;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * Add interest to the current balance, assuming no other deposits made.
     *
     * @return amount added
     */
    public double addMonthlyInterest() {
        double oldValue = balance;
        balance *= (1 + rate());
        return balance - oldValue;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", accountNumber=" + accountNumber +
                ", balance=" + balance +
                '}';
    }
}
