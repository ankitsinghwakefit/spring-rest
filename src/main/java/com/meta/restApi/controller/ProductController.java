package com.meta.restApi.controller;

import com.meta.restApi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meta.restApi.model.Product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ProductController {
    @Autowired
    ProductService ps;

    @RequestMapping("/products")
    public List<Product> getProducts() {
        return ps.getProducts();
    }

    // Jakson library is responsible for converting objects to json and json to
    // objects
    // @PathVariable is used to map query parameters with parameters of method
    @GetMapping("/products/{prodId}")
    public Product getProductById(@PathVariable int prodId) {
        return ps.getProductById(prodId);
    }

    // @RequestBody if we are passing the post data in body of the request

    @PostMapping("/products")
    public List<Product> addProduct(@RequestBody Product newProduct) {
        return ps.addProduct(newProduct);
    }

    @PutMapping("/products")
    public List<Product> modifyProduct(@RequestBody Product newProduct) {
        return ps.modifyProduct(newProduct);
    }

    @DeleteMapping("/products")
    public List<Product> deleteProduct(@RequestBody Product newProduct) {
        return ps.deleteProduct(newProduct);
    }

    @DeleteMapping("/products/{prodId}")
    public List<Product> deleteProductWithId(@PathVariable int prodId) {
        return ps.deleteProductWithId(prodId);
    }

}
