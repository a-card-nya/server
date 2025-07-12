package com.back.server.common.domain;

public enum CardBenefit {
    TRANSPORT("교통"),
    TELECOM("통신"),
    SHOPPING("쇼핑"),
    LIVING("생활"),
    LEISURE("여가"),
    COFFEE("커피"),
    CONVENIENCE_STORE("편의점"),
    GENERAL_MERCHANDISE("잡화"),
    ONLINE_SHOPPING("온라인 쇼핑몰"),
    OTT("OTT"),
    DELIVERY_APP("배달앱"),
    BOOKS("도서"),
    DOMESTIC_DISCOUNT("국내가맹점 상시할인"),
    MOVIE("영화"),
    RESTAURANT("음식점"),
    OVERSEAS_DISCOUNT("해외할인"),
    TRAVEL("여행"),
    EDUCATION("교육");

    private final String label;

    CardBenefit(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
