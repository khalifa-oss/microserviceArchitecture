package com.sid.billservice.repsitory;

import com.sid.billservice.model.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(path = "productItem")
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
    @RestResource(path="/findproductitem")
    List<ProductItem> findProductItemByBill_Id(@Param( value = "idBill") Long id);
}
