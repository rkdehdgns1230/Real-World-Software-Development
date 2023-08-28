package com.study.chapter2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankTransactionAnalyzerSRP {
    private static final String RESOURCES = "src/main/resources/";
    private static final String FILE_TYPE = ".csv";
    private static final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();

    public static void main(String[] args) throws IOException {
        final Path path = Paths.get(RESOURCES + args[0] + FILE_TYPE);
        final List<String> lines = Files.readAllLines(path);


        List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFromCSV(lines);

        System.out.println("The total for all transactions is " + calculateTotalAmount(bankTransactions));
        System.out.println("Transactions in January " + selectInMonth(bankTransactions, Month.JANUARY));
    }

    public static double calculateTotalAmount(final List<BankTransaction> bankTransactions){
        double total = 0d;
        for(BankTransaction bankTransaction : bankTransactions){
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions, final Month month){
        final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();

        for (final BankTransaction bankTransaction : bankTransactions){
            if(bankTransaction.getDate().getMonth().equals(month)){
                bankTransactionsInMonth.add(bankTransaction);
            }
        }
        return bankTransactionsInMonth;
    }
}
