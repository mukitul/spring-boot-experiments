package com.app.springdataexp.specexp;

import lombok.Data;

@Data
public class SearchQueryDto {
    private String productName;
    private ProductType productType;
    private Double price;
}
