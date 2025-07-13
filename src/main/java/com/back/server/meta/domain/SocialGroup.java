package com.back.server.meta.domain;

public enum SocialGroup {
    LOW_INCOME("저소득층"),
    MULTI_CHILDREN_2("다자녀 부모 (2자녀)"),
    MULTI_CHILDREN_3("다자녀 부모 (3자녀)");

    private final String label;

    SocialGroup(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}