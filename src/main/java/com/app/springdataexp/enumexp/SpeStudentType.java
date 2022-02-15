package com.app.springdataexp.enumexp;

public enum SpeStudentType {
    REGULAR("regular"),
    SPECIAL("special"),
    PARTTIMER("part-timer");

    private final String studentType;

    SpeStudentType(String studentType) {
        this.studentType = studentType;
    }

    public String getStudentType() {
        return studentType;
    }
}
