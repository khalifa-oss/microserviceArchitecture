package com.sid.billservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sid.billservice.forgeinclasse.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bill implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date BillingDate;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
   private Long customerId;
    @Transient
//    @JsonIgnore
    private Customer customer;
    @OneToMany(targetEntity = ProductItem.class,mappedBy = "bill")
//    @JsonIgnore
    Collection<ProductItem> productItems;

}
