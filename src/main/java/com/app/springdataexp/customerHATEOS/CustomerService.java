package com.app.springdataexp.customerHATEOS;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final PagedResourcesAssembler<Customer> pagedResourcesAssembler;
    private final CustomerAssembler customerAssembler;

    public CustomerDetailDto getAllCustomer() {
        CustomerDetailDto customerDetailDto = new CustomerDetailDto();
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerInfo> customerInfoList = new ArrayList<>();
        for (Customer customer : customerList) {
            Long customerId = customer.getId();
            Link selfLink = linkTo(CustomerController.class).slash(customerId).withSelfRel();
            CustomerInfo customerInfo = new CustomerInfo();
            modelMapper.map(customer, customerInfo);
            customerInfo.add(selfLink);
            customerInfoList.add(customerInfo);
        }
        Link link = linkTo(CustomerController.class).slash("all").withRel("All Customer");
        CollectionModel<CustomerInfo> result = CollectionModel.of(customerInfoList, link);
        customerDetailDto.setCustomerInfoList(result);
        return customerDetailDto;
    }

    public CustomerInfo getCustomerById(Long customerId) {
        Customer customer = null != customerId ? customerRepository.findById(customerId).orElse(null) : null;
        CustomerInfo customerInfo = new CustomerInfo();
        if (null != customer) {
            modelMapper.map(customer, customerInfo);
        }
        return customerInfo;
    }


    public CustomerDetailDto getAllCustomer(Pageable pageable) {
        CustomerDetailDto customerDetailDto = new CustomerDetailDto();
        Page<Customer> customer = customerRepository.findAll(pageable);
        PagedModel<CustomerInfo> collModel = pagedResourcesAssembler.toModel(customer, customerAssembler);
        customerDetailDto.setCustomerInfoList(collModel);
        return customerDetailDto;
    }
}
