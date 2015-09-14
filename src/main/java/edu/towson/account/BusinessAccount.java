package edu.towson.account;

public class BusinessAccount extends Account {
    private final Type type = Type.BUSINESS;

    public BusinessAccount(String name, long accountNumber) {
        super(name, accountNumber);
    }

    public BusinessAccount(String name, long accountNumber, double balance) {
        super(name, accountNumber, balance);
    }

    @Override
    public Type getAccountType() {
        return type;
    }

    @Override
    public double rate() {
        return 0;
    }

    @Override
    public String toString() {
        return "BusinessAccount{" +
                super.toString() +
                "type=" + type +
                '}';
    }
}
