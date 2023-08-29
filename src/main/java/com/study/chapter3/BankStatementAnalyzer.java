package com.study.chapter3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BankStatementAnalyzer {
    private static final String RESOURCES = "src/main/resources/";
    private static final String FILE_TYPE = ".csv";

    public void analyze(final String fileName, final BankStatementParser bankStatementParser) {
        final Path path = Paths.get(RESOURCES + fileName + FILE_TYPE);
        final List<String> lines;
        try{
            lines = Files.readAllLines(path);
        }
        catch(IOException e){
            throw new IllegalStateException(e);
        }

        List<BankTransaction> bankTransactionList = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactionList);

        final Exporter exporter = new HtmlExporter();
        System.out.println(exporter.export(new SummaryStatistics(
                bankStatementProcessor.calculateTotalAmount(),
                bankStatementProcessor.calculateTotalAmount(),
                bankStatementProcessor.calculateTotalAmount(),
                bankStatementProcessor.calculateTotalAmount()
        )));
    }

    private void collectSummary(BankStatementProcessor processor){
        System.out.println("The total amount of all is " + processor.calculateTotalAmount());
        //.. 월별, 카테고리별 통계
    }
}
