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

    public CategoryType getStudentCategory() {
        if (this.studentType.equals(REGULAR.studentType)) {
            return CategoryType.CATEGORY_ONE;
        } else if (this.studentType.equals(SPECIAL.studentType)) {
            return CategoryType.CATEGORY_TWO;
        } else if (this.studentType.equals(PARTTIMER.studentType)) {
            return CategoryType.CATEGORY_B;
        } else {
            return null;
        }
    }
}
