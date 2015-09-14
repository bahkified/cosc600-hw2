package edu.towson;

import edu.towson.account.Account;

import java.text.NumberFormat;
import java.util.List;

public class Main {
    private static final NumberFormat formatter = NumberFormat.getCurrencyInstance();
    private static final String DELIMITER = "\t";

    public static void main(String[] args) throws Exception {
        // Reading data file
        List<AccountHolder> accountHolders;
        if (args == null || args.length == 0) {
            accountHolders = DataSerializer.readData();
        } else {
            accountHolders = DataSerializer.readDate(args[0]);
        }

        printOutputHeader();
        printNextMonth(accountHolders);
    }

    private static void printOutputHeader() {
        System.out.println(
                "Name\tSSN\taccount number\tphone number\topen balance\tclose balance"
        );
    }

    private static void printNextMonth(List<AccountHolder> allPeople) {
        /*
            At the end of each month, the bank issues a statement for each bank account
            containing the following information: name, SSN, account_number, phone_number, open
            balance, and close balance.
         */
        for (AccountHolder holder : allPeople) {
            StringBuilder out_line = new StringBuilder();

            // For each account this account holder has
            for (Account acc : holder) {
                out_line.append(holder.name);
                out_line.append(DELIMITER);
                out_line.append(holder.ssn);
                out_line.append(DELIMITER);
                out_line.append(String.valueOf(acc.getAccountNumber()));
                out_line.append(DELIMITER);
                out_line.append(holder.phone);
                out_line.append(DELIMITER);

                out_line.append(formatter.format(acc.getBalance()));
                out_line.append(DELIMITER);

                // Add interest for the month
                acc.addMonthlyInterest();

                out_line.append(formatter.format(acc.getBalance()));

                System.out.println(out_line.toString());
            }
        }
    }

}
