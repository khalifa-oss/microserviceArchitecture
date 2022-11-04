package com.sid.billservice.model;

import org.springframework.data.rest.core.config.Projection;

import javax.persistence.ManyToOne;

@Projection( name="item",types = ProductItem.class)
public interface ItemProductProjection {
    public Long getId();
    public Long getProductId();
    public Double getPrice();
    public int getQuantity();
    public Bill getBill();
}
