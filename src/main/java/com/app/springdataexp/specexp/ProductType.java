package com.app.springdataexp.specexp;

public enum ProductType {
    FRAGILE("Fragile"),
    NONFRAZILE("Non-Frazile");

    private final String productType;

    ProductType(String productType) {
        this.productType = productType;
    }

    public String getProductType() {
        return productType;
    }
}
