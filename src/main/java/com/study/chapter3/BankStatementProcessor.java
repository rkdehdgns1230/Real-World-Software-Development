package com.study.chapter3;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactionList;

    public BankStatementProcessor(List<BankTransaction> bankTransactionList) {
        this.bankTransactionList = bankTransactionList;
    }

    public double summarizeTransactions(final BankTransactionSummarizer bankTransactionSummarizer) {
        double result = 0;
        for(final BankTransaction bankTransaction : bankTransactionList){
            result = bankTransactionSummarizer.summarize(result, bankTransaction);
        }
        return result;
    }

    public double calculateTotalAmount(){
        double total = 0;
        for(final BankTransaction bankTransaction : bankTransactionList){
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public double calculateTotalInMonth(final Month month){
        return summarizeTransactions((acc, bankTransaction) ->
                bankTransaction.getDate().getMonth().equals(month) ?
                        acc + bankTransaction.getAmount() : acc);
    }

    public double calculateTotalForCategory(final String category){
        return summarizeTransactions((acc, bankTransaction) ->
                bankTransaction.getDescription().equals(category) ?
                acc + bankTransaction.getAmount() : acc);
    }

    public List<BankTransaction> findTransactions(BankTransactionFilter bankTransactionFilter){
        final List<BankTransaction> result = new ArrayList<>();

        for(final BankTransaction bankTransaction : bankTransactionList){
            if(bankTransactionFilter.test(bankTransaction)){
                result.add(bankTransaction);
            }
        }
        return result;
    }

    public List<BankTransaction> findTransactionsGreaterThanEqual(final int amount){
        return findTransactions(bankTransaction ->
                bankTransaction.getAmount() >= amount);
    }
}
