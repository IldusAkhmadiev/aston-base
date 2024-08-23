package com.iglaz.astonbase.lesson5.homework;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class PuttingIntoStreamUtil {
    private static int counter = 1;

    /***
     * 1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей
     * к большей).
     * @param transactions список транзакций
     ***/
    public static void findAndSortTransactionsByValueFor2011(List<Transaction> transactions) {
        transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted((o1, o2) -> Math.min(o1.getValue(),o2.getValue()))
                .forEach(System.out::println);
    }

    /***
     * 2. Вывести список неповторяющихся городов, в которых работают трейдеры.
     * @param transactions список транзакций
     ***/
    public static void getUniqueTraderCities(List<Transaction> transactions) {
        transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
    }

    /***
     * 3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.
     ***/
    public static TreeSet<Transaction> getTradersFromCityAndSortByName(List<Transaction> transactions, String cityToFind) {
        Comparator<Transaction> comparator = Comparator.comparing(transaction -> transaction.getTrader().getName());
        TreeSet<Transaction> collect = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals(cityToFind))
                .sorted(Comparator.comparing(transaction -> transaction.getTrader().getName()))
                .collect(Collectors.toCollection(() -> new TreeSet<>(comparator)));
        return collect;
    }

    /***
     * 4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном
     * порядке.
     ***/
    public static String getTradersNameSortedByName(List<Transaction> transactions) {
        String string = transactions.stream()
                .sorted(Comparator.comparing(transaction -> transaction.getTrader().getName()))
                .map(transaction -> transaction.getTrader().getName() + " ")
                .collect(Collectors.joining());
        return string;
    }

    /***
     * 5. Выяснить, существует ли хоть один трейдер из Милана.
     ***/
    public static boolean anyTraderLiveInCity(List<Transaction> transactions,String cityToFind) {
        return transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals(cityToFind));

    }

    /***
     * 6. Вывести суммы всех транзакций трейдеров из Кембриджа.
     */
    public static double getTotalTransactionsCountByCity(List<Transaction> transactions, String cityToFind) {
        return transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals(cityToFind))
                .mapToDouble(transaction -> transaction.getValue())
                .sum();
    }

    /***
     * 7. Какова максимальная сумма среди всех транзакций?
     */
    public static Double getMaxSumOfTransactions(List<Transaction> transactions) {
        OptionalDouble max = transactions.stream()
                .mapToDouble(value -> value.getValue())
                .max();
        if(max.isPresent()) {
            return max.getAsDouble();
        }
        new RuntimeException("Не смог найти максимальную сумму  " + PuttingIntoStreamUtil.class.getSimpleName() +
        " метод getMaxSumOfTransactions");
        return 0D;
    }

    /***
     * 8. Найти транзакцию с минимальной суммой
     ***/
    public static Double getMinSumOfTransactions(List<Transaction> transactions) {
        OptionalDouble min = transactions.stream()
                .mapToDouble(value -> value.getValue())
                .min();
        if(min.isPresent()) {
            return min.getAsDouble();
        }
        new RuntimeException("Не смог найти минимальную сумму  " + PuttingIntoStreamUtil.class.getSimpleName() +
                " метод getMinSumOfTransactions");
        return 0D;
    }

}
