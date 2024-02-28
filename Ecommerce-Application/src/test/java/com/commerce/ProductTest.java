package com.commerce;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.commerce.model.Product;

public class ProductTest {

    @Mock
    private Product productMock;

    @Test
    void testGettersAndSetters() {
        // Create a product
        Product product = new Product();
        product.setId(1L);
        product.setName("Test Product");
        product.setPrice(10.99);

        // Verify getters
        assertEquals(1L, product.getId());
        assertEquals("Test Product", product.getName());
        assertEquals(10.99, product.getPrice());
    }

    @Test
    void testConstructor() {
        // Create a product using constructor
        Product product = new Product(1L, "Test Product", 10.99);

        // Verify constructor
        assertEquals(1L, product.getId());
        assertEquals("Test Product", product.getName());
        assertEquals(10.99, product.getPrice());
    }

    @Test
    void testMock() {
        // Mocking a product
        Product product = new Product();
        product.setId(1L);
        product.setName("Test Product");
        product.setPrice(10.99);

        // Verify mock
        assertNotNull(productMock);
        assertEquals(1L, product.getId());
        assertEquals("Test Product", product.getName());
        assertEquals(10.99, product.getPrice());
    }
}