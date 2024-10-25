package org.tiger;

import org.tiger.Currencies.Cryptos;

import java.text.NumberFormat;
import java.util.List;

public class InterviewApplication {
    public static void main(String[] args) {
        Integer userId = 1;
        Cryptos currency = Cryptos.BTC;
        List<Transaction<Integer, String, Double, Double, Cryptos>> transactionList = UserTransactionHistory.transactionHistory;

        double averageBuyPrice = UserTransactionHistory.getAverageBuyPrice(userId, currency, transactionList);

        String formattedAverageBuyPrice = NumberFormat.getCurrencyInstance().format(averageBuyPrice);
        String formattedOutput = "Average Buy Price for User `" + userId + "` for Currency `" + currency.getName() + "` for example transaction set `UserTransactionHistory.transactionHistory` is equal to: " + formattedAverageBuyPrice;

        System.out.println(formattedOutput);
    }
}