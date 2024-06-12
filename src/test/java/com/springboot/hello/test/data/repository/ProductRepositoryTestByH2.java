package com.springboot.hello.test.data.repository;

import com.springboot.hello.data.entity.Product;
import com.springboot.hello.data.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ProductRepositoryTestByH2 {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveTest() {
        //given
        Product product = new Product();
        product.setName("펜");
        product.setPrice(1000);
        product.setStock(1000);

        Product savedProduct = productRepository.saveAndFlush(product);

        //when
        //Product savedProduct = productRepository.save(product);
        Product foundProduct = productRepository.findById(savedProduct.getNumber()).get();

        //then
        assertEquals(product.getName(), savedProduct.getName());
        assertEquals(product.getPrice(), savedProduct.getPrice());
        assertEquals(product.getStock(), savedProduct.getStock());
    }
}
