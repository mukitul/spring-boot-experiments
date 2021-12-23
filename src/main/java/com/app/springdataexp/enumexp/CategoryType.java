package com.app.springdataexp.enumexp;

public enum CategoryType {
    CATEGORY_ONE(1),
    CATEGORY_B(2),
    CATEGORY_TWO(3);
    private final int category;

    CategoryType(int category) {
        this.category = category;
    }

    public int getCategory() {
        return category;
    }
}
