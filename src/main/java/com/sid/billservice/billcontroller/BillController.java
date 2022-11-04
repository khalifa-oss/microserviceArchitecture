package com.sid.billservice.billcontroller;

import com.sid.billservice.forgeinclasse.Customer;
import com.sid.billservice.forgeinservice.CustomerService;
import com.sid.billservice.forgeinservice.ProductService;
import com.sid.billservice.model.Bill;
import com.sid.billservice.model.ProductItem;
import com.sid.billservice.repsitory.BillRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class BillController {
    private BillRepository billRepository;
    private CustomerService customerService;
    private ProductService productService;

    @GetMapping(path = "/bill/{id}")
    public Bill getBill(@PathVariable(name="id") Long id){
        Bill b1= billRepository.findById( id ).get();
        b1.setCustomer( customerService.findCustomer( b1.getCustomerId() ) );
        b1.getProductItems().forEach( productItem -> {
           productItem.setProduct(productService.findProduct( productItem.getProductId() )  );}  );

        return b1;
    }


}
