package com.sid.billservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sid.billservice.forgeinclasse.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long productId;
    @Transient
    private Product product;
    private Double price;
    private int quantity;
    //we use when we don't want to read and  write this attribute
//    @JsonIgnore
    //we use when we don't want to read or write this attribute
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
//    @JoinColumn(name= "idBill")
    private Bill bill;
}
