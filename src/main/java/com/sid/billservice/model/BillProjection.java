package com.sid.billservice.model;

import com.sid.billservice.forgeinclasse.Customer;
import org.springframework.data.rest.core.config.Projection;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Projection( name = "fullbill",types = Bill.class)
public interface BillProjection {
    public  Long getId();
    public Date  getBillingDate();
    public Long getCustomerId();
    public Customer getCustomer();
    public Collection<ProductItem> getProductItems();
}
