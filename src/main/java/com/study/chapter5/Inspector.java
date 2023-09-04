package com.study.chapter5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inspector {
    private final List<ConditionalAction> conditionalActionList;

    public Inspector(ConditionalAction...conditionalActions) {
        this.conditionalActionList = Arrays.asList(conditionalActions);
    }

    public List<Report> inspect(final Facts facts){
        final List<Report> reportList = new ArrayList<>();

        for(ConditionalAction conditionalAction : conditionalActionList){
            boolean conditionResult = conditionalAction.evaluate(facts);
            // evaluate method로 평가한 결과와 함께 report list에 추가
            reportList.add(new Report(conditionalAction, facts, conditionResult));
        }

        return reportList;
    }
}
