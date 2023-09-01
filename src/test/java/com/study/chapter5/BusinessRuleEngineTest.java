package com.study.chapter5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class BusinessRuleEngineTest {

    @Test
    void shouldHaveNoRulesInitially(){
        //given
        BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(new ArrayList<>());

        //then
        assertEquals(0, businessRuleEngine.count());
    }

    @Test
    void shouldAddTwoAction(){
        //given
        BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(new ArrayList<>());

        //when
        businessRuleEngine.addAction(() -> {});
        businessRuleEngine.addAction(() -> {});

        //then
        assertEquals(2, businessRuleEngine.count());
    }

    @Test
    void shouldExecuteOneAction(){
        BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(new ArrayList<>());
        Action mockAction;
    }
}