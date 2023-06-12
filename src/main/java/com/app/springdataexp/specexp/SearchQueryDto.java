package com.app.springdataexp.specexp;

import lombok.Data;

@Data
public class SearchQueryDto {
    private String productName;
    private ProductType productType;
    private Double minPrice;
    private Double maxPrice;
    private String sortedOrder = SortedOrder.ASC.name();

    // Inner enum representing the sorting order
    public enum SortedOrder {
        ASC,
        DESC
    }
}
