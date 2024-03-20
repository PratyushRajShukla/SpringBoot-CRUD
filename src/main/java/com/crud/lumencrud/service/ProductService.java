package com.crud.lumencrud.service;

import com.crud.lumencrud.controller.ProductController;
import com.crud.lumencrud.entity.Product;
import com.crud.lumencrud.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product){
        return repository.save(product);

    }
    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);

    }
    public List<Product> getProducts(){
        return repository.findAll();
    }
    public Product getProductbyId(int id){
        if(repository.existsById(id)){
            return repository.findById(id).orElse(null);
        }else{
            return null;
        }

    }
    public Product getProductbyName(String name){
        return repository.findByName(name);
    }
    public String deleteProduct(int id){
        if(repository.existsById(id)){
            logger.trace("Product Info Deleted");
            repository.deleteById(id);
            return "product removed ||" + id;
        }else{
            logger.trace("Product Info Not Available to Delete");
            return "product not available";
        }
    }//loggger how to add log
    public  Product updateProduct(Product product){
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }
}
