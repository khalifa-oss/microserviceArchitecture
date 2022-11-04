package com.sid.billservice.forgeinservice;

import com.sid.billservice.feignserviceinterface.CustomerServiceInterface;
import com.sid.billservice.forgeinclasse.Customer;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerServiceInterface customerServiceInterface;
     public Customer findCustomer( Long id ){
       return customerServiceInterface.findCustomerById( id );
     }
     public PagedModel<Customer> findAll(){
         return customerServiceInterface.findALLCustomer();
     }
}
