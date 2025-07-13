package com.back.server.meta.domain;

public enum AgeGroup {
    UNDER_18("만18세 이하"),
    AGE_19_34("만19~34세"),
    AGE_35_39("만35~39세"),
    AGE_40_64("만40~64세"),
    AGE_65_74("만65~74세"),
    OVER_75("만75세 이상");

    private final String label;

    AgeGroup(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}