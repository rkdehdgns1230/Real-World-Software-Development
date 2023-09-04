package com.study.chapter5;

public class RuleBuilder {
    private Condition condition;
    private Action action;

    protected RuleBuilder(){}

    public RuleBuilder when(final Condition condition){
        this.condition = condition;
        return this;
    }

    public RuleBuilder then(final Action action){
        this.action = action;
        return this;
    }

    public Rule createRule(){
        return new DefaultRule(condition, action);
    }
}
