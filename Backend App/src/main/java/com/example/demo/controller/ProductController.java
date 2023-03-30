/*
 * Author : Bhagi Baghel
 * Date :
 * Created with : IntelliJ IDEA Community Edition
 */

package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1")
public class ProductController {
    ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestBody Product product)
    {
        Product newProduct = productService.addProduct(product);
        if (newProduct!=null)
        {
            return new ResponseEntity<Product>(newProduct, HttpStatus.CREATED);
        }
        else
        {
            return new ResponseEntity<String>("Error while adding", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts()
    {
        List<Product> allProducts = productService.getAllProducts();
        if (allProducts.size()>0)
        {
            return new ResponseEntity<List<Product>>(allProducts,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<String>("No product found",HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id)
    {
        List<Product> productList = productService.deleteProduct(id);
        if (productList.size()>0)
        {
            return new ResponseEntity<List<Product>>(productList,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<String>("No product found",HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestBody Product product)
    {
        Product updated = productService.updateProduct(id,product);
        if (updated != null)
        {
            return new ResponseEntity<Product>(updated,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<String>("Error while updating",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
