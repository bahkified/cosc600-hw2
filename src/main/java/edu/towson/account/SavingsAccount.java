package edu.towson.account;

public class SavingsAccount extends Account {
    private final Type type = Type.SAVINGS;

    public SavingsAccount(String name, long accountNumber) {
        super(name, accountNumber);
    }

    public SavingsAccount(String name, long accountNumber, double balance) {
        super(name, accountNumber, balance);
    }

    @Override
    public Type getAccountType() {
        return type;
    }

    @Override
    public double rate() {
        return balance < 5000 ? 0.04 : 0.05;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                super.toString() +
                "type=" + type +
                '}';
    }
}
