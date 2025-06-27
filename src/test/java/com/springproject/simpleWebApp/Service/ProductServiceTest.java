package com.springproject.simpleWebApp.Service;

import com.springproject.simpleWebApp.model.Product;
import com.springproject.simpleWebApp.repository.productrepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private productrepo productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void testGetAllProducts() {
        List<Product> mockProducts = Arrays.asList(
                new Product(1, "iPhone", 50000),
                new Product(2, "Camera", 30000)
        );
        when(productRepository.findAll()).thenReturn(mockProducts);

        List<Product> result = productService.getProducts();

        assertEquals(2, result.size());
        assertEquals("iPhone", result.get(0).getProdname());
    }

    @Test
    void testGetProductById() {
        Product product = new Product(1, "Laptop", 70000);
        when(productRepository.findById(1)).thenReturn(Optional.of(product));

        Product result = productService.getProductbyid(1);

        assertEquals("Laptop", result.getProdname());
    }

    @Test
    void testAddProduct() {
        Product product = new Product(3, "Watch", 5000);
        productService.addproduct(product);
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void testUpdateProduct() {
        Product product = new Product(4, "Tablet", 15000);
        productService.update(product);
        verify(productRepository).save(product);
    }

    @Test
    void testDeleteProduct() {
        productService.deleteid(5);
        verify(productRepository).deleteById(5);
    }
}
