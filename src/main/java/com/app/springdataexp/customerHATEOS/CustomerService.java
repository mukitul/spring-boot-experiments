package com.app.springdataexp.customerHATEOS;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


@Service
@RequiredArgsConstructor
public class CustomerService {
    private final static Logger logger = LogManager.getLogger(CustomerService.class);
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


    public CustomerDetailDto getAllCustomer(Pageable pageable) {
        CustomerDetailDto customerDetailDto = new CustomerDetailDto();
        Page<Customer> customer = customerRepository.findAll(pageable);
        PagedModel<CustomerInfo> collModel = pagedResourcesAssembler.toModel(customer, customerAssembler);
        customerDetailDto.setCustomerInfoList(collModel);
        return customerDetailDto;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public CustomerInfo getCustomerById(Long customerId) {
        Customer customer = null != customerId ? customerRepository.findById(customerId).orElse(null) : null;
        CustomerInfo customerInfo = new CustomerInfo();
        if (null != customer) {
            modelMapper.map(customer, customerInfo);
        }
        return customerInfo;
    }

    public void insertCustomer() {
        Random random = new Random();
        for (int i = 0; i < 5000000; i++) {
            try {
                Customer customer = new Customer();
                customer.setName("TEST_NAME" + random.nextInt(5000001) + 1);
                customer.setDob(new Date());
                customerRepository.save(customer);
                //logger.info("==========================> customerRepository.save END");
            } catch (Exception e) {
                logger.info(" EXCEPTION: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public void doDBTask() {
        Random random = new Random();
        try {
//            logger.info("==========================> customerRepository.findById");
            Customer customer = customerRepository.findById(1L).get();
            customer.setName("TEST_NAME_" + Math.random());
//            logger.info("==========================> SLEEP START");
            Thread.sleep(12000);
//            logger.info("==========================> SLEEP END");
//            logger.info("==========================> customerRepository.save START");
            customerRepository.save(customer);
//            logger.info("==========================> customerRepository.save END");
//            System.out.println(Thread.currentThread().getName() + " SAVED");
        } catch (Exception e) {
            logger.info(Thread.currentThread().getName() + " EXCEPTION: " + e.getMessage());
        }
    }

    public void pickRandomData() {
        //1731271
        //24877
        Random random = new Random();
        for (int i = 0; i < 1706395; i++) {
            try {
                Long customerId = (long) (random.nextInt((1731271 - 24877) + 1) + 24877);
                Customer customer = customerRepository.findById(customerId).get();
            } catch (Exception e) {
                logger.info(" EXCEPTION: " + e.getMessage());
                //e.printStackTrace();
            }
        }
    }
}
