package com.study.chapter2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BankStatementCSVParserTest {
    private final BankStatementParser bankStatementParser = new BankStatementCSVParser();

    @Test
    void should_parse_one_correct_line() throws Exception{
        //given
        final String line = "30-12-1998,1230,Kang";

        //when
        final BankTransaction result = bankStatementParser.parseFrom(line);

        //then
        final BankTransaction expectedResult = new BankTransaction(LocalDate.of(1998, 12, 30), 1230, "Kang");
        assertEquals(expectedResult, result);
        assertEquals(expectedResult.getDate(), result.getDate());
        assertEquals(expectedResult.getAmount(), result.getAmount());
        assertEquals(expectedResult.getDescription(), result.getDescription());
    }
}