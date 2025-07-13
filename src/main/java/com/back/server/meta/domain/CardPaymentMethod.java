package com.back.server.meta.domain;

public enum CardPaymentMethod {
    POSTPAID("후불"),
    PREPAID("선불");

    private final String label;

    CardPaymentMethod(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
