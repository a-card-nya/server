package com.back.server.meta.domain;

public enum CardForm {
    MOBILE("모바일"),
    PHYSICAL("실물");

    private final String label;

    CardForm(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
