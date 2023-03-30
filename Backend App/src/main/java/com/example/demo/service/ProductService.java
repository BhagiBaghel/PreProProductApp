package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface ProductService {

    public Product addProduct(Product product);
    public List<Product> getAllProducts();
    public List<Product> deleteProduct(int id);
    public Product updateProduct(int id, Product product);

}
