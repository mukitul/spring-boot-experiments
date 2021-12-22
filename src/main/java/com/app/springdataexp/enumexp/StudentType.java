package com.app.springdataexp.enumexp;

public enum StudentType {
    REGULAR("REGULAR"),
    PARTTIMER("PARTTIMER");

    private final String stydentType;

    StudentType(String stydentType) {
        this.stydentType = stydentType;
    }

    public String getStydentType() {
        return stydentType;
    }
}
