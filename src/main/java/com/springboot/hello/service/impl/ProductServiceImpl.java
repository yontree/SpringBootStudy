package com.springboot.hello.service.impl;

import com.springboot.hello.data.dao.ProductDAO;
import com.springboot.hello.data.dto.ProductDto;
import com.springboot.hello.data.dto.ProductResponseDto;
import com.springboot.hello.data.entity.Product;
import com.springboot.hello.data.repository.ProductRepository;
import com.springboot.hello.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
    //Repository로 바로 접근
    //private final ProductDAO productDAO;
    private final ProductRepository productRepository;

    //응답Dto에 DB조회한 엔티티 값 세팅하여 리턴
    @Override
    public ProductResponseDto getProduct(Long number){
        LOGGER.info("[getProduct] input number : {}", number);
        //Product product = productDAO.selectProduct(number);
        Product product = productRepository.findById(number).get();

        LOGGER.info("[getProduct] input number : {}, name : {}", product.getNumber(), product.getName());
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(product.getNumber());
        productResponseDto.setName(product.getName());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setStock(product.getStock());

        return productResponseDto;
    }
    
    //Product 엔티티에 요청 정보 저장 후 dao를 통해 리포지토리를 이용해 db에 저장 후 저장정보 응답
    @Override
    public ProductResponseDto saveProduct(ProductDto productDto){
        LOGGER.info("[saveProduct] productDTO : {}", productDto.toString());
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        
        //Product savedProduct = productDAO.insertProduct(product);
        Product savedProduct = productRepository.save(product);
        LOGGER.info("[saveProduct] savedProduct : {}", savedProduct);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(savedProduct.getNumber());
        productResponseDto.setName(savedProduct.getName());
        productResponseDto.setPrice(savedProduct.getPrice());
        productResponseDto.setStock(savedProduct.getStock());
        
        return productResponseDto;
    }
    @Override
    public ProductResponseDto changeProductName(Long number, String name) throws Exception{
        //Product changedProduct = productDAO.updateProductName(number, name);
        Product foundProduct = productRepository.findById(number).get();
        foundProduct.setName(name);
        Product changedProduct = productRepository.save(foundProduct);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(changedProduct.getNumber());
        productResponseDto.setName(changedProduct.getName());
        productResponseDto.setPrice(changedProduct.getPrice());
        productResponseDto.setStock(changedProduct.getStock());

        return productResponseDto;
    }

    @Override
    public void deleteProduct(Long number) throws Exception{
        productDAO.deleteProduct(number);
    }
}
