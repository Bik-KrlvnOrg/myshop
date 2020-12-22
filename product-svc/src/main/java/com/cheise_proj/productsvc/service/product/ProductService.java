package com.cheise_proj.productsvc.service.product;

import com.cheise_proj.productsvc.domain.model.Product;

import javax.transaction.Transactional;
import java.util.List;

public interface ProductService {
    @Transactional
    Product createProduct(Product product);

    List<Product> getProducts();
}
