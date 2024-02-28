package com.commerce.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ProductRequest {

    @NotBlank(message = "Product name cannot be blank")
    private String name;

    @NotNull(message = "Product price cannot be null")
    private Double price;

  
}