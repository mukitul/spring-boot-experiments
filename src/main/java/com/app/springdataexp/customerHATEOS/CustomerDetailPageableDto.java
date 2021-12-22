package com.app.springdataexp.customerHATEOS;

import lombok.Data;
import org.springframework.hateoas.PagedModel;

@Data
public class CustomerDetailPageableDto {
    private PagedModel<CustomerInfo> customerInfo;
}
