package com.manuable.app.product.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manuable.app.product.models.Product;
import com.manuable.app.product.repositories.IProductRepository;

@Service
public class ProductService {

    @Autowired
    IProductRepository productRepository;

    public ArrayList<Product> getProducts() {
        return (ArrayList<Product>) productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }

    public Product updateById(Product request, Long id) {
        Product product = productRepository.findById(id).get();

        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setSku(request.getSku());
        product.setSeasonal(request.isSeasonal());
        product.setImage(request.getImage());
        product.setQuantity(request.getQuantity());
        product.setCategory(request.getCategory());

        return product;
    }

    public Boolean deleteProduct(Long id) {
        try {
            productRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
