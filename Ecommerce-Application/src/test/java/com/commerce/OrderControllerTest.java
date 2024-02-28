package com.commerce;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.commerce.controller.OrderController;
import com.commerce.model.Order;
import com.commerce.service.OrderService;

@SpringBootTest
public class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    public OrderControllerTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllOrders() {
        // Arrange
        Date currentDate = new Date();
        Order order1 = new Order(1L, currentDate, "Pending", 100.0);
        Order order2 = new Order(2L, currentDate, "Shipped", 200.0);
        List<Order> orders = Arrays.asList(order1, order2);
        when(orderService.getAllOrders()).thenReturn(orders);

        // Act
        ResponseEntity<List<Order>> responseEntity = orderController.getAllOrders();

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(orders, responseEntity.getBody());
    }

    @Test
    public void testGetOrderById_OrderFound() {
        // Arrange
        Date currentDate = new Date();
        Long orderId = 1L;
        Order order = new Order(orderId, currentDate, "Pending", 100.0);
        when(orderService.getOrderById(orderId)).thenReturn(order);

        // Act
        ResponseEntity<Order> responseEntity = orderController.getOrderById(orderId);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(order, responseEntity.getBody());
    }

    @Test
    public void testGetOrderById_OrderNotFound() {
        // Arrange
        Long orderId = 1L;
        when(orderService.getOrderById(orderId)).thenReturn(null);

        // Act
        ResponseEntity<Order> responseEntity = orderController.getOrderById(orderId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

}
