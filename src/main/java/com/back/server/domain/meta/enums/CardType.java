package com.back.server.domain.meta.enums;

public enum CardType {
    CREDIT("신용카드"),
    DEBIT("체크카드"),
    TRANSIT("교통카드");

    private final String label;

    CardType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}