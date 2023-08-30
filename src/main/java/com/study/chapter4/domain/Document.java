package com.study.chapter4.domain;

import java.util.Map;

public class Document {
    private final Map<String, String> attributes;

    public Document(final Map<String, String> attributes){
        this.attributes = attributes;
    }

    public String getAttribute(String attributeName){
        return attributes.get(attributeName);
    }
}
