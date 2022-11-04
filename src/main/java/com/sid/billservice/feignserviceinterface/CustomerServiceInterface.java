package com.sid.billservice.feignserviceinterface;

import com.sid.billservice.forgeinclasse.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerServiceInterface {
    @GetMapping(path = "/customer/{id}")
  Customer findCustomerById(@PathVariable(name="id") Long id);
    @GetMapping(path = "/customer")
    PagedModel<Customer> findALLCustomer();


}
