/*
 * Author : Bhagi Baghel
 * Date :
 * Created with : IntelliJ IDEA Community Edition
 */

package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    ProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public List<Product> deleteProduct(int id) {
        if (productRepo.findById(id).isPresent())
        {
            Product product = productRepo.findById(id).get();
            productRepo.delete(product);
            return productRepo.findAll();
        }
        return null;
    }

    @Override
    public Product updateProduct(int id, Product product) {
        Product existing = productRepo.findById(id).orElse(null);
        if (existing != null)
        {
                existing.setName(product.getName());
                existing.setDescription(product.getDescription());
                existing.setPrice(product.getPrice());
                existing.setQuantity(product.getQuantity());
                return productRepo.save(existing);
        }
        return null;
    }
}
