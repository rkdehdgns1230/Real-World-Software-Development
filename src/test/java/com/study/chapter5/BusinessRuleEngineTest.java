package com.study.chapter5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
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
        BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(mockFacts);

        //then
        assertEquals(0, businessRuleEngine.count());
    }

    @Test
    void shouldAddTwoAction(){
        //given
        BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(mockFacts);

        //when
        businessRuleEngine.addAction(facts -> {});
        businessRuleEngine.addAction(facts -> {});

        //then
        assertEquals(2, businessRuleEngine.count());
    }

    @Test
    void shouldExecuteOneAction(){
        //given
        BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(mockFacts);

        //when
        businessRuleEngine.addAction(mockAction);
        businessRuleEngine.run();

        //then
        verify(mockAction).execute(mockFacts);
    }

    @Test
    public void shouldPerformAnActionWithFacts(){
        BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(mockFacts);

        Facts mockedFacts = mock(Facts.class);

        businessRuleEngine.addAction(mockAction);
        businessRuleEngine.run();

        verify(mockAction).execute(mockedFacts);
    }

    @Test
    public void makeActionTest(){
        //given
        BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(mockFacts);

        businessRuleEngine.addAction(facts -> {
            var forecastedAmount = 0.0;
            var dealStage = Stage.valueOf(facts.getFact("stage"));
            var amount = Double.parseDouble(facts.getFact("amount"));

            if(dealStage == Stage.LEAD) {
                forecastedAmount = amount * 0.2;
            }
            else if(dealStage == Stage.EVALUATING) {
                forecastedAmount = amount * 0.5;
            }
            else if(dealStage == Stage.INTERESTED) {
                forecastedAmount = amount * 0.8;
            }
            else if(dealStage == Stage.CLOSED) {
                forecastedAmount = amount;
            }

            facts.addFact("forecastedAmount", String.valueOf(forecastedAmount));
        });

        //when
        //then
        assertEquals(businessRuleEngine.count(), 1);
    }
}