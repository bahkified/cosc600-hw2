package edu.towson;

import edu.towson.account.Account;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class AccountHolder implements Iterable<Account> {
    public final String name;
    public final String phone;
    public final String ssn;

    private final List<Account> accounts;

    public AccountHolder(String name, String phone, String ssn) {
        this.name = name;
        this.phone = phone;
        this.ssn = ssn;
        this.accounts = new ArrayList<>();
    }

    public void addAccounts(Account ... accounts) {
        if (accounts != null && accounts.length > 0) {
            this.accounts.addAll(Arrays.asList(accounts));
        }
    }

    // Probably don't need for this assignment
//    public Account getAccount(long accountNumber) {
//        for (Account acc : accounts) {
//            if (acc.getAccountNumber() == accountNumber) {
//                return acc;
//            }
//        }
//
//        return null;
//    }

    @Override
    public Iterator<Account> iterator() {
        return accounts.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountHolder accounts1 = (AccountHolder) o;

        if (name != null ? !name.equals(accounts1.name) : accounts1.name != null) return false;
        if (phone != null ? !phone.equals(accounts1.phone) : accounts1.phone != null) return false;
        if (ssn != null ? !ssn.equals(accounts1.ssn) : accounts1.ssn != null) return false;
        return !(accounts != null ? !accounts.equals(accounts1.accounts) : accounts1.accounts != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (ssn != null ? ssn.hashCode() : 0);
        result = 31 * result + (accounts != null ? accounts.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AccountHolder{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", ssn='" + ssn + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
