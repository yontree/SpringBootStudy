package com.springboot.hello.test.data.repository;

import com.querydsl.core.types.Predicate;
import com.springboot.hello.data.entity.Product;
import com.springboot.hello.data.entity.QProduct;
import com.springboot.hello.data.repository.ProductRepository;
import com.springboot.hello.data.repository.QProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class QProductRepositoryTest {

    @Autowired
    QProductRepository qProductRepository;

    @Test
    public void queryDSLTest1() {
        Predicate predicate = QProduct.product.name.containsIgnoreCase("펜")
                .and(QProduct.product.price.between(1000, 2500));

        Optional<Product> foundProduct = qProductRepository.findOne(predicate);

        if (foundProduct.isPresent()) {
            Product product = foundProduct.get();
        }

    }
}
