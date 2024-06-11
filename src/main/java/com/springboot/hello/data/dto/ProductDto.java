package com.springboot.hello.data.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDto {

    private String name;
    private int price;
    private int stock;
}
