package com.meta.restApi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.meta.restApi.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    int i;
    List<Product> products = new ArrayList<>(
            Arrays.asList(new Product(123, "camera", 100), new Product(124, "phone", 700),
                    new Product(128, "watch", 1000)));

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(int prodId) {
        return products.stream().filter(prod -> prod.getId() == prodId).findFirst().orElse(null);
    }

    public List<Product> addProduct(Product newProduct) {
        products.add(newProduct);
        return products;
    }

    public List<Product> modifyProduct(Product newProduct) {
        // List<Product> ab = products.stream().map((Product p) -> {
        // if (p.getId() == newProduct.getId()) {
        // p.setName(newProduct.getName());
        // p.setPrice(newProduct.getPrice());
        // }
        // return p;
        // }).asList();
        // int i;
        for (int j = 0; j < products.size(); j++) {
            if (products.get(j).getId() == newProduct.getId()) {
                i = j;
                break;
            }
        }
        products.set(i, newProduct);
        return products;
    }

    public List<Product> deleteProduct(Product newProduct) {
        for (int j = 0; j < products.size(); j++) {
            if (products.get(j).getId() == newProduct.getId()) {
                i = j;
                break;
            }
        }
        products.remove(i);
        return products;
    }

    public List<Product> deleteProductWithId(int productId) {
        int i = -1;
        for (int j = 0; j < products.size(); j++) {
            if (products.get(j).getId() == productId) {
                i = j;
                break;
            }
        }
        if (i > 0) {
            // because if the product not in the list then it will delete 1st product in the
            // list always by default
            products.remove(i);
            return products;
        }
        return products;
    }
}
