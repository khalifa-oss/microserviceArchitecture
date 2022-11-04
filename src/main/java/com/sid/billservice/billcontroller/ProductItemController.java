package com.sid.billservice.billcontroller;

import com.sid.billservice.forgeinservice.ProductService;
import com.sid.billservice.model.ProductItem;
import com.sid.billservice.repsitory.ProductItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProductItemController {
   private ProductItemRepository productItemRepository;
   private ProductService productService;
    @GetMapping(path="/items/{id}")
    public ProductItem getProduct(@PathVariable(name="id") Long id){
        ProductItem pI1= productItemRepository.findById( id ).get();
        pI1.setProduct( productService.findProduct( pI1.getProductId() ) );

        return pI1;
    }


}
