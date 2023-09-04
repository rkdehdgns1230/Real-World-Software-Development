package com.study.chapter5;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InspectorTest {

    @Test
    public void inspectOneConditionEvaluatesTrue(){
        final Facts facts = new Facts();
        facts.addFact("jobTitle", "CEO");

        ConditionalAction conditionalAction = new JobTitleCondition();
        Inspector inspector = new Inspector(conditionalAction);

        List<Report> reportList = inspector.inspect(facts);

        assertEquals(reportList.size(), 1);
        assertTrue(reportList.get(0).isPositive());
    }

    private static class JobTitleCondition implements ConditionalAction {
        @Override
        public void perform(Facts facts){
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean evaluate(Facts facts){
            return "CEO".equals(facts.getFact("jobTitle"));
        }
    }
}