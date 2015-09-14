package edu.towson;

import edu.towson.account.Account;
import edu.towson.account.BusinessAccount;
import edu.towson.account.CheckingAccount;
import edu.towson.account.SavingsAccount;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataSerializer {

    public static List<AccountHolder> readDate(String filepath) throws IOException {
        return toAccountHolderList(
                Files.readAllLines(Paths.get(filepath), Charset.forName("UTF-8"))
        );
    }

    // TODO commented code does not work, see comments.
    /*
        Code below is trying to read the included data file, inside the JAR.
        This cannot be read in the way below, as the data is compressed.
     */
//    public static List<AccountHolder> readData() throws IOException {
//        try {
//            URL fileUrl = DataSerializer.class.getClassLoader().getResource(FILE);
//            if (fileUrl == null) {
//                return null;
//            }
//            List<String> lines = Files.readAllLines(Paths.get(fileUrl.toURI()));   // Can throw IOException
//            return toAccountHolderList(lines);
//
//        } catch (URISyntaxException | NullPointerException e) {
//            System.err.println("");
//            return null;
//        }
//
//    }

    private static List<AccountHolder> toAccountHolderList(List<String> lines) {
        Map<String, AccountHolder> accountHolderMap = new HashMap<>();

        // First line contains headers. Skip
        for (int i = 1; i < lines.size(); i++) {
            String[] cols = lines.get(i).split("\\s+");

            if (cols.length != 6) {
                System.err.println("Bad number of columns found. [" + lines.get(i) + "]");
                continue;
            }

            // Get the account holder.
            // If holder already exists, update that entry, otherwise, create a new one.
            String key = cols[3];       // Use SSN as key, not name

            AccountHolder holder;
            if (accountHolderMap.containsKey(key)) {
                holder = accountHolderMap.get(key);
            } else {
                holder = new AccountHolder(cols[0], cols[2], cols[3]);
            }

            // Add account into to account holder
            Account fromData = readAccount(cols);
            if (fromData != null) {
                // TODO handle the case of duplicate account numbers?
                holder.addAccounts(fromData);
            }

            // Update account holder data in map
            accountHolderMap.put(key, holder);
        }

        return mapToList(accountHolderMap);
    }

    private static List<AccountHolder> mapToList(Map<String, AccountHolder> map) {
        return map.entrySet().stream()
                .map(Map.Entry::getValue)
                .sorted(((o1, o2) -> o1.name.compareTo(o2.name)))
                .collect(Collectors.toList());
    }

    private static Account readAccount(String[] cols) {
        try {
            switch (cols[5]) {
                default:
                    return null;
                case "B":       // Business
                    return new BusinessAccount(
                            cols[0], Long.parseLong(cols[1]), Double.parseDouble(cols[4]));
                case "S":       // Savings
                    return new SavingsAccount(
                            cols[0], Long.parseLong(cols[1]), Double.parseDouble(cols[4]));
                case "C":       // Checking
                    return new CheckingAccount(
                            cols[0], Long.parseLong(cols[1]), Double.parseDouble(cols[4]));
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid format: Account number or balance.");
            return null;
        }
    }

}
