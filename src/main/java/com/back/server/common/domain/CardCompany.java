package com.back.server.common.domain;

public enum CardCompany {
    KB("KB국민카드"),
    SHINHAN("신한카드"),
    LOTTE("롯데카드"),
    BC("BC카드"),
    NH("NH농협카드"),
    SAMSUNG("삼성카드"),
    HYUNDAI("현대카드"),
    HANA("하나카드"),
    WOORI("우리카드"),
    BUSAN_BANK("부산은행"),
    KORAIL("코레일"),
    KAKAO_BANK("카카오뱅크"),
    KAKAO_PAY("카카오페이"),
    JOY_OF_MOVEMENT("이동의즐거움"),
    IBK("IBK카드"),
    GWANGJU_BANK("광주은행"),
    IM_BANK("iM뱅크"),
    IM_UPAY("iM유페이"),
    K_BANK("케이뱅크"),
    NAVER_PAY("네이버페이");

    private final String label;

    CardCompany(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
