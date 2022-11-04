package com.sid.billservice;

import com.sid.billservice.forgeinclasse.Customer;
import com.sid.billservice.forgeinclasse.Product;
import com.sid.billservice.forgeinservice.CustomerService;
import com.sid.billservice.forgeinservice.ProductService;
import com.sid.billservice.model.Bill;
import com.sid.billservice.model.ProductItem;
import com.sid.billservice.repsitory.BillRepository;
import com.sid.billservice.repsitory.ProductItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class BillServiceApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run( BillServiceApplication.class, args );
    }

    @Override
    public void run(String... args) throws Exception {



    }
    @Bean
    CommandLineRunner start(BillRepository billRepository, ProductItemRepository productItemRepository
            , CustomerService customerService, ProductService productService){


        return  args-> {
            Customer c1 = customerService.findCustomer( 1L );
            Customer c2 = customerService.findCustomer( 2L );
            //***************************************
            Product p1 = productService.findProduct( 1L );

            //  ----------------------------*******deserialization with Hateoas********-----------------------------
            customerService.findAll().getContent().forEach( c->{
                System.out.println(c);
            } );

            //*********************************************
            System.out.println( String.format( "the name of p1 was %s", p1.getName() ) );
            System.out.println( String.format( "the price of p1 was %s", p1.getPrice() ) );
            System.out.println( String.format( "the id of p1 was %s", p1.getId() ) );
            System.out.println( "***************************************" );
            System.out.println( String.format( "the name of c1 was %s", c1.getName() ) );
            System.out.println( String.format( "the email of c1 was %s", c1.getEmail() ) );
            System.out.println( String.format( "the id of c1 was %s", c1.getId() ) );
            //******************************************
            Bill bill1 = new Bill( null, new Date(), c1.getId(), null, null );
            Bill bill2 = new Bill( null, new Date(), c2.getId(), null, null );
            billRepository.save( bill1 );
            billRepository.save( bill2 );
            //*****************************************
            productService.findAll().forEach( p -> {

                productItemRepository.save( new ProductItem( null, p.getId(),null, p.getPrice(), 50, bill1 ) );
//                productItemRepository.save( new ProductItem( null, p2.getId(), p2.getPrice(), 20, bill1 ) );
//                productItemRepository.save( new ProductItem( null, p3.getId(), p3.getPrice(), 40, bill2 ) );
//                    productItemRepository.save( new ProductItem( null, 4L, 200.0, 70, bill2 ) );
//                    productItemRepository.save( new ProductItem( null, 5L, 100.0, 430, bill2 ) );
            } );
        };

    }

}
