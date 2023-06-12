package com.app.springdataexp.specexp;

public enum ProductType {
    ELECTRONICS("ELECTRONICS"),
    FASHION("FASHION"),
    HOME_DECOR("HOME_DECOR");

    private final String productType;

    ProductType(String productType) {
        this.productType = productType;
    }

    public String getProductType() {
        return productType;
    }
}
