package com.iglaz.astonbase.lesson5.homework;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 1
        System.out.println("1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей" +
                "к большей).");
        PuttingIntoStreamUtil.findAndSortTransactionsByValueFor2011(transactions);
        System.out.println("---------------------------------------------------");

        // 2
        System.out.println("2. Вывести список неповторяющихся городов, в которых работают трейдеры.");
        PuttingIntoStreamUtil.getUniqueTraderCities(transactions);
        System.out.println("---------------------------------------------------");

        // 3
        System.out.println("3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.");
        TreeSet<Transaction> cambridge = PuttingIntoStreamUtil.getTradersFromCityAndSortByName(transactions, "Cambridge");
        if(!cambridge.isEmpty()) // если не пустой
        { cambridge.forEach(System.out::println);}
        System.out.println("---------------------------------------------------");

        // 4
        System.out.println("4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном\n" +
                "порядке.");
        String tradersNameSortedByName = PuttingIntoStreamUtil.getTradersNameSortedByName(transactions);
        System.out.println(tradersNameSortedByName);
        System.out.println("---------------------------------------------------");

        // 5
        System.out.println("5. Выяснить, существует ли хоть один трейдер из Милана.");
        boolean milan = PuttingIntoStreamUtil.anyTraderLiveInCity(transactions, "Milan");
        System.out.println("В городе Milan есть трейдер? " + milan);
        System.out.println("---------------------------------------------------");

        // 6
        System.out.println("6. Вывести суммы всех транзакций трейдеров из Кембриджа.");
        double totalSum = PuttingIntoStreamUtil.getTotalTransactionsCountByCity(transactions, "Cambridge");
        System.out.println("Сумма всех транзакций трейдеров из Кембриджа " + totalSum);
        System.out.println("---------------------------------------------------");

        // 7
        System.out.println("7. Какова максимальная сумма среди всех транзакций?");
        Double maxSumOfTransactions = PuttingIntoStreamUtil.getMaxSumOfTransactions(transactions);
        System.out.println("Максимальная сумма среди всех транзакций " + maxSumOfTransactions );
        System.out.println("---------------------------------------------------");

        // 8
        System.out.println("8. Найти транзакцию с минимальной суммой");
        Double minSumOfTransactions = PuttingIntoStreamUtil.getMinSumOfTransactions(transactions);
        System.out.println("Минимальная сумма транзакции : " + minSumOfTransactions );
        System.out.println("---------------------------------------------------");
    }


}

