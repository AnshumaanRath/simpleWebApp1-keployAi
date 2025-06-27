package com.springproject.simpleWebApp.Integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springproject.simpleWebApp.model.Product;
import com.springproject.simpleWebApp.repository.productrepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private productrepo productRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        productRepository.deleteAll();
        productRepository.save(new Product(1, "Sample Product", 9999));
    }

    @Test
    void testGetProducts() throws Exception {
        mockMvc.perform(get("/get products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].prodname").value("Sample Product"));
    }

    @Test
    void testAddProduct() throws Exception {
        Product product = new Product(2, "Test Product", 1234);
        mockMvc.perform(post("/get products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isOk());
    }

    @Test
    void testGetProductById() throws Exception {
        mockMvc.perform(get("/get products/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.prodname").value("Sample Product"));
    }

    @Test
    void testUpdateProduct() throws Exception {
        Product updatedProduct = new Product(1, "Updated Product", 7777);
        mockMvc.perform(put("/update products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedProduct)))
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteProduct() throws Exception {
        mockMvc.perform(delete("/get products/delete/1"))
                .andExpect(status().isOk());
    }
}
