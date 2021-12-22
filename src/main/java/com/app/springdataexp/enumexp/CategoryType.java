package com.app.springdataexp.enumexp;

public enum CategoryType {
    CATEGORY_ONE(1),
    CATEGORY_TWO(2);
    private final int category;

    CategoryType(int category) {
        this.category = category;
    }

    public int getCategory() {
        return category;
    }
}
