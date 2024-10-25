package org.tiger;

import org.tiger.Currencies.Cryptos;
import java.util.Arrays;
import java.util.List;

class UserTransactionHistory {
    // User1: $2,390.48
    public static final List<Transaction<Integer, String, Double, Double, Cryptos>> transactionHistoryTest = Arrays.asList(
            new Transaction<>(1, "BUY", 10.00, 1.00, Currencies.Cryptos.BTC),
            new Transaction<>(1, "BUY", 1.00, 1.10, Currencies.Cryptos.ETH),
            new Transaction<>(1, "BUY", 50000.00, 0.05, Cryptos.BTC),
            new Transaction<>(2, "BUY", 34.02, 2.00100101, Cryptos.ETH),
            new Transaction<>(3, "BUY", 0.0032, 136.00, Cryptos.XLM),
            new Transaction<>(1, "SELL", 10000.00, 2.102, Cryptos.BTC)
    );

    // User1: $1,609.96
    public static final List<Transaction<Integer, String, Double, Double, Cryptos>> transactionHistory = Arrays.asList(
            new Transaction<>(1, "BUY", 10.00, 1.00, Cryptos.BTC),
            new Transaction<>(1, "BUY", 12.00, 5.00030622, Cryptos.BTC),
            new Transaction<>(2, "BUY", 34.02, 2.00100101, Cryptos.ETH),
            new Transaction<>(1, "SELL", 10000.00, 2.102, Cryptos.BTC),
            new Transaction<>(1, "BUY", 1.00, 1.10, Cryptos.ETH),
            new Transaction<>(3, "BUY", 0.0032, 136.00, Cryptos.XLM),
            new Transaction<>(1, "SELL", 10000.00, 2.004, Cryptos.BTC),
            new Transaction<>(1, "BUY", 3021.732134, 6.7930622, Cryptos.BTC),
            new Transaction<>(3, "BUY", 0.0502, 396.847, Cryptos.XLM),
            new Transaction<>(3, "SELL", 1.16, 532.847, Cryptos.XLM),
            new Transaction<>(2, "BUY", 11.0234321, 31.27, Cryptos.ETH),
            new Transaction<>(3, "SELL", 2.20954, 17.85345345, Cryptos.XLM),
            new Transaction<>(3, "SELL", 18.5768, 26.00, Cryptos.XLM),
            new Transaction<>(1, "SELL", 8129.00, 1.00, Cryptos.ETH)
    );

    public static double getAverageBuyPrice(Integer userId, Cryptos currency, List<Transaction<Integer, String, Double, Double, Cryptos>> transactionList) {
        // define set of valid currencies as mentioned in instructions document
        List<Cryptos> validCurrencies = List.of(Cryptos.BTC, Cryptos.ETH, Cryptos.XLM, Cryptos.LTC);
        String BUY_SIDE_INDICATOR = "BUY";

        // enforce required currency constraint as mentioned in instructions document
        if (!validCurrencies.contains(currency)) {
            throw new RuntimeException("Currency " + currency.getName() + " is invalid");
        }

        List<Transaction<Integer, String, Double, Double, Cryptos>> buyTransactionsForCurrency = transactionList.stream()
                .filter(transaction -> {
                    return transaction.getUser().equals(userId) &&              // filter by user
                            transaction.getTradingPair().equals(currency) &&    // filter by currency
                            transaction.getSide().equals(BUY_SIDE_INDICATOR);   // filter by side
                }).toList();

        double totalCurrencyQuantity = 0.0;
        double averageBuyPrice = 0.0;
        for (Transaction<Integer, String, Double, Double, Cryptos> transaction : buyTransactionsForCurrency) {
            totalCurrencyQuantity += transaction.getQuantity();                         // accumulate sum of currency quantities
            averageBuyPrice += (transaction.getPrice() * transaction.getQuantity());    // accumulate sum of currency purchase prices
        }

        // apply ABP formula as mentioned in instructions document
        return (averageBuyPrice / totalCurrencyQuantity);
    }
}
