package edu.towson.account;

public class CheckingAccount extends Account {
    private final Type type = Type.CHECKING;

    public CheckingAccount(String name, long accountNumber) {
        super(name, accountNumber);
    }

    public CheckingAccount(String name, long accountNumber, double balance) {
        super(name, accountNumber, balance);
    }

    @Override
    public Type getAccountType() {
        return type;
    }

    @Override
    public double rate() {
        return 0.025;
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                super.toString() +
                "type=" + type +
                '}';
    }
}
