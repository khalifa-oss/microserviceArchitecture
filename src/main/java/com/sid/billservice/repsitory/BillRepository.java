package com.sid.billservice.repsitory;

import com.sid.billservice.model.Bill;
import com.sid.billservice.model.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(path="bill")
public interface BillRepository extends JpaRepository<Bill,Long> {


}
