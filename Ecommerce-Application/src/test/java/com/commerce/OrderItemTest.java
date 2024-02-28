package com.commerce;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.commerce.model.OrderItem;
import com.commerce.model.Product;

public class OrderItemTest {

    @Test
    void testGettersAndSetters() {
        // Create a product mock
        Product productMock = mock(Product.class);
        
        // Create an order item
        OrderItem orderItem = new OrderItem();
        orderItem.setId(1L);
        orderItem.setQuantity(5);
        orderItem.setProduct(productMock);
        
        // Verify getters
        assertEquals(1L, orderItem.getId());
        assertEquals(5, orderItem.getQuantity());
        assertEquals(productMock, orderItem.getProduct());
    }
    
    @Test
    void testConstructor() {
        // Create a product mock
        Product productMock = mock(Product.class);
        
        // Create an order item using constructor
        OrderItem orderItem = new OrderItem(1L, 5, productMock);
        
        // Verify constructor
        assertEquals(1L, orderItem.getId());
        assertEquals(5, orderItem.getQuantity());
        assertEquals(productMock, orderItem.getProduct());
    }
    
    @Test
    void testToString() {
        // Create a product mock
        Product productMock = mock(Product.class);
        when(productMock.getName()).thenReturn("Test Product");
        
        // Create an order item
        OrderItem orderItem = new OrderItem(1L, 5, productMock);
        
        // Verify toString method
        assertEquals("OrderItem{id=1, quantity=5, product=Test Product}", orderItem.toString());
    }
}
