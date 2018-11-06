package com.george.j8.lession1;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TransactionTest {

    public static void main(String[] args) {
        Random r = new Random();
        Stream.generate(() ->
                new Transaction(r.nextInt(200) + 901, Transaction.Currency.values()[r.nextInt(5)]))
                .limit(200)
                .filter(transaction -> transaction.price > 1000)
                .collect(Collectors.groupingBy(transaction -> transaction.currency))
                .entrySet()
                .stream().forEach(e -> {
                    System.out.println("Currency: " + e.getKey());
                    e.getValue().stream().forEach(v -> System.out.printf("\t" + v.price));
                    System.out.println();
                });
    }

    public static class Transaction {
        private double price;
        private Currency currency;

        enum Currency {
            USD, CNY, JPY, GBP, HKD
        }

        public Transaction(double price, Currency currency) {
            this.price = price;
            this.currency = currency;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "price=" + price +
                    ", currency=" + currency +
                    '}';
        }
    }
}


