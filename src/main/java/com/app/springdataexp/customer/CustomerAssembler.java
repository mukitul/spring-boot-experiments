package com.app.springdataexp.customer;


import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class CustomerAssembler extends RepresentationModelAssemblerSupport<Customer, CustomerInfo> {

    public CustomerAssembler() {
        super(CustomerService.class, CustomerInfo.class);
    }

    @Override
    public CustomerInfo toModel(Customer entity) {
        CustomerInfo customerInfo = instantiateModel(entity);
        customerInfo.setId(entity.getId());
        customerInfo.setDob(entity.getDob());
        customerInfo.setName(entity.getName());
        return customerInfo;
    }
}
