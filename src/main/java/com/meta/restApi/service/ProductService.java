package com.meta.restApi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.meta.restApi.model.Product;
import com.meta.restApi.repo.ProductRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    int i;
    @Autowired
    ProductRepo repo;
    List<Product> products = new ArrayList<>(
            Arrays.asList(new Product(123, "camera", 100), new Product(124, "phone", 700),
                    new Product(128, "watch", 1000)));

    public List<Product> getProducts() {
        // return products;
        return repo.findAll();
    }

    public Product getProductById(int prodId) {
        // return products.stream().filter(prod -> prod.getId() ==
        // prodId).findFirst().orElse(null);
        return repo.findById(prodId).orElse(new Product());
    }

    public List<Product> addProduct(Product newProduct) {
        // products.add(newProduct);
        // return products;
        repo.save(newProduct);
        return repo.findAll();
    }

    public List<Product> modifyProduct(Product newProduct) {
        // for (int j = 0; j < products.size(); j++) {
        // if (products.get(j).getId() == newProduct.getId()) {
        // i = j;
        // break;
        // }
        // }
        // products.set(i, newProduct);
        // return products;
        repo.save(newProduct);
        return repo.findAll();
        // save will check if product is already in the repository if not then add and
        // if it is already in the repository it will update
    }

    public List<Product> deleteProduct(Product newProduct) {
        // for (int j = 0; j < products.size(); j++) {
        // if (products.get(j).getId() == newProduct.getId()) {
        // i = j;
        // break;
        // }
        // }
        // products.remove(i);
        // return products;
        repo.delete(newProduct);
        return repo.findAll();
        // delete will delete the product from the repository if it exists
    }

    public List<Product> deleteProductWithId(int productId) {
        // int i = -1;
        // for (int j = 0; j < products.size(); j++) {
        // if (products.get(j).getId() == productId) {
        // i = j;
        // break;
        // }
        // }
        // if (i > 0) {
        // // because if the product not in the list then it will delete 1st product in
        // the
        // // list always by default
        // products.remove(i);
        // return products;
        // }
        // return products;
        repo.deleteById(productId);
        return repo.findAll();
        // deleteById will delete the product from the repository if it exists by id.
        // if the product not in the repository then it will do nothing.
    }
}
