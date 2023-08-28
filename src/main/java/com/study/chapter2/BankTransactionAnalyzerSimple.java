package com.study.chapter2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BankTransactionAnalyzerSimple {
    private static final String RESOURCES = "src/main/resources/";
    private static final String FILE_TYPE = ".csv";

    public static void main(String[] args) throws IOException {
        final Path path = Paths.get(RESOURCES + args[0] + FILE_TYPE);
        final List<String> lines = Files.readAllLines(path);

        double total = 0d;

        for(String line : lines){
            final String[] columns = line.split(",");
            final double amount = Double.parseDouble(columns[1]);
            total += amount;
        }

        System.out.println("The total for all transactions is " + total);
    }
}
