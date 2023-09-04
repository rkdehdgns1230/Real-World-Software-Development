package com.study.chapter5;

@FunctionalInterface
public interface Rule {
    void perform(Facts facts);
}

class DefaultRule implements Rule {
    private final Condition condition;
    private final Action action;

    public DefaultRule(Condition condition, Action action) {
        this.condition = condition;
        this.action = action;
    }

    public static RuleBuilder builder(){
        return new RuleBuilder();
    }

    @Override
    public void perform(Facts facts) {
        if (condition.evaluate(facts)) {
            action.execute(facts);
        }
    }
}
