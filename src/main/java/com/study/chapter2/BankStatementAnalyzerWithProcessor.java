package com.study.chapter2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzerWithProcessor {
    private static final String RESOURCES = "src/main/resources/";
    private static final String FILE_TYPE = ".csv";
    private static final BankStatementParser bankStatementParser = new BankStatementCSVParser();


    public static void main(String[] args) throws IOException {
        final Path path = Paths.get(RESOURCES + args[0] + FILE_TYPE);
        final List<String> lines = Files.readAllLines(path);

        List<BankTransaction> bankTransactionList = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactionList);


        System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total for all transactions in January is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total for all transactions in February is " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }
}
