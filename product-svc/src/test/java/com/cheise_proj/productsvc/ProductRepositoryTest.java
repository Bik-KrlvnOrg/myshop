package com.cheise_proj.productsvc;

import com.cheise_proj.productsvc.domain.model.Product;
import com.cheise_proj.productsvc.domain.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ProductRepositoryTest {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private ProductRepository productRepository;


    @Test
   public void injectedComponentsAreNotNull() {
        assertThat(dataSource).isNotNull();
        assertThat(jdbcTemplate).isNotNull();
        assertThat(entityManager).isNotNull();
        assertThat(productRepository).isNotNull();
    }

    @Test
    public void when_saved_id_is_greater_than_zero() {
        Product product = new Product();
        product.setCategory("A");
        product.setName("item a");
        product.setPrice("100");
        Product save = productRepository.save(product);
        assertThat(save.getId()).isGreaterThan(0);
    }

    @Test
   public void get_all_product_after_saved_product() {
        Product product = new Product();
        product.setCategory("A");
        product.setName("item a");
        product.setPrice("100");
        productRepository.save(product);
        List<Product> products = productRepository.findAll();
        assertThat(products.size()).isGreaterThan(0);
    }
}
