package com.sid.billservice.feignserviceinterface;

import com.sid.billservice.forgeinclasse.Product;
import lombok.Getter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@FeignClient(name="PRODUCT-SERVICE")

public interface ProductServiceInterface {
    @GetMapping(path="/product/{id}")
    Product findProductById(@PathVariable(name="id") Long id);
    @GetMapping(path="/allProduct")
    Collection<Product> FindAllProduct();
}
