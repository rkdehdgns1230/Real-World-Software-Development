package com.study.chapter5;

public class Main {

    public static void main(String[] args) {
        Facts defaultFacts = new Facts();
        BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(defaultFacts);

        // builder pattern을 이용한 DefaultRule 객체 생성 가능
        DefaultRule.builder()
                .when(facts -> "CEO".equals(facts.getFact("jobTitle")))
                .then(facts -> {
                    var name = facts.getFact("name");
                    // send mail to relevant customer!!
                })
                .createRule();
    }
}
