package com.study.chapter3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BankStatementAnalyzer {
    private static final String RESOURCES = "src/main/resources";
    private static final String FILE_TYPE = ".csv";

    public void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException {
        final Path path = Paths.get(RESOURCES + fileName + FILE_TYPE);
        final List<String> lines = Files.readAllLines(path);

        List<BankTransaction> bankTransactionList = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactionList);

        collectSummary(bankStatementProcessor);
    }

    private void collectSummary(BankStatementProcessor processor){
        System.out.println("The total amount of all is " + processor.calculateTotalAmount());
        //.. 월별, 카테고리별 통계
    }
}
