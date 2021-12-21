package com.app.springdataexp.customer;

import lombok.Data;
import org.springframework.hateoas.CollectionModel;

@Data
public class CustomerDetailDto {
    private CollectionModel<CustomerInfo> customerInfoList;
}
