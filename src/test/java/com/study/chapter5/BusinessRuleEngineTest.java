package com.study.chapter5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BusinessRuleEngineTest {

    @Mock
    Action mockAction;
    @Mock
    Facts mockFacts;

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
        //given
        BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(new ArrayList<>());

        //when
        businessRuleEngine.addAction(mockAction);
        businessRuleEngine.run();

        //then
        verify(mockAction).execute();
    }

    @Test
    public void shouldPerformAnActionWithFacts(){
        BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(new ArrayList<>());

        businessRuleEngine.addAction(mockAction);
        businessRuleEngine.run();

        verify(mockAction).execute(mockFacts);
    }
}