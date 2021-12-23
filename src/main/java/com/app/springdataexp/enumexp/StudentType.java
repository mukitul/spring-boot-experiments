package com.app.springdataexp.enumexp;

public enum StudentType {
    REGULAR("regular"),
    SPECIAL("special"),
    PARTTIMER("part-timer");

    private final String stydentType;

    StudentType(String stydentType) {
        this.stydentType = stydentType;
    }

    public String getStydentType() {
        return stydentType;
    }
}
