package com.sid.billservice.forgeinservice;

import com.sid.billservice.feignserviceinterface.ProductServiceInterface;
import com.sid.billservice.forgeinclasse.Product;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductServiceInterface productServiceInterface;
    public Product findProduct(Long id ){
        return productServiceInterface.findProductById( id );
    }
    public Collection<Product> findAll(){
        return productServiceInterface.FindAllProduct();
    }
}

