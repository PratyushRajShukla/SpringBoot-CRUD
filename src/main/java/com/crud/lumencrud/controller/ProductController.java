package com.crud.lumencrud.controller;

import com.crud.lumencrud.entity.Product;
import com.crud.lumencrud.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;



    Logger logger = LoggerFactory.getLogger(ProductController.class);


    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        logger.trace("Product Info Added");
        return service.saveProduct(product);

    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        logger.trace("Multiple Product Info Added");
        return service.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts(){
        logger.trace("Product Info Retrieved");
        return service.getProducts();
    }

    @GetMapping("/productid/{id}")
    public Product findProductbyId(@PathVariable int id){
        logger.trace("Product Info Retrieved");
        return service.getProductbyId(id);
    }


    @GetMapping("/product/{name}")
    public Product findProductByName(@PathVariable String name){
        logger.trace("Product Info Retrieved");
        return service.getProductbyName(name);
    }
    @PatchMapping("/update")
    public  Product updateProduct(@RequestBody Product product){
        logger.trace("Product Info Updated");
        return service.saveProduct(product);

    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return service.deleteProduct(id);
    }
}
