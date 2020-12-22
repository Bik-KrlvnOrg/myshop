package com.cheise_proj.productsvc.domain.repository;

import com.cheise_proj.productsvc.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
