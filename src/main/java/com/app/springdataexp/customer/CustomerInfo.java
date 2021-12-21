package com.app.springdataexp.customer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerInfo extends RepresentationModel<CustomerInfo> {
    private Long id;
    private String name;
    private Date dob;
}
