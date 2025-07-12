package com.back.server.common.jpa.domain;

public enum TransportType {
    SUBWAY("지하철"),
    BUS("버스"),
    BIKE("따릉이");

    private final String label;

    TransportType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}