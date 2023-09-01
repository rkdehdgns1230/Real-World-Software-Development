package com.study.chapter5;

import java.util.ArrayList;
import java.util.List;

public class BusinessRuleEngine {
    private final List<Action> actions;

    public BusinessRuleEngine(List<Action> actions) {
        this.actions = actions;
    }

    public void addAction(final Action action){
        actions.add(action);
    }

    public int count(){
        return actions.size();
    }

    public void run(){
        actions.forEach(Action::execute);
    }
}
