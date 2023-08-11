package com.white.springdatajpacourse.repository;

import com.white.springdatajpacourse.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class QueryMethodsTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod() {
        Product product = productRepository.findByName("product 1");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());

    }

    @Test
    void findByIdMethod() {
        Product product = productRepository.findById(1L).get();
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByNameOrDescription() {
        List<Product> products = productRepository.findByNameOrDescription("product 1",
                "product 1 description");
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findByNameAndDescription() {
        List<Product> products = productRepository.findByNameAndDescription("product 1",
                "product 1 description");
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findDistinctByNameMethod() {
        Product product = productRepository.findDistinctByName("product 1");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByPriceGreaterThan() {
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(100));
        products.forEach((p) ->
        {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findByPriceLessThan() {
        List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(200));
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findByNameLike() {
        List<Product> products = productRepository.findByNameLike("product 1");
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }
    @Test
    void findByPriceBetween(){
        List<Product> products = productRepository.findByPriceBetween(
                new BigDecimal(100),new BigDecimal(300)
        );
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }
    @Test
    void findByDateCreatedBetween(){
        LocalDateTime startDate = LocalDateTime.of(2023,8,9,11,14,54);
        LocalDateTime endDate = LocalDateTime.of(2023,8,9,13,29,31);
        List<Product> products= productRepository.findByDateCreatedBetween(startDate, endDate);
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }
    @Test
    void findByNameIn(){
        List<Product> products = productRepository.findByNameIn(List.of("product 1","product 2","product 3"));
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }
    @Test
    void findFirst2ByOrderByNameAsc(){
        List<Product> products = productRepository.findFirst2ByOrderByNameAsc();
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }
    @Test
    void findTop3ByOrderByNameDesc(){
        List<Product> products = productRepository.findTop3ByOrderByNameDesc();
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }
}