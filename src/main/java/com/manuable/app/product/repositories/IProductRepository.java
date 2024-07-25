package com.manuable.app.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manuable.app.product.models.Product;

public interface IProductRepository extends JpaRepository<Product, Long> {

}
