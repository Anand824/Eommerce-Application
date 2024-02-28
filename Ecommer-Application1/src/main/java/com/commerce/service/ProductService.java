package com.commerce.service;

import java.util.List;

import com.commerce.request.ProductRequest;
import com.commerce.response.ProductResponse;

public interface ProductService {
    List<ProductResponse> getAllProducts();
    ProductResponse getProductById(Long id);
    ProductResponse createProduct(ProductRequest productRequest);
    ProductResponse updateProduct(Long id, ProductRequest productRequest);
    void deleteProduct(Long id);
}